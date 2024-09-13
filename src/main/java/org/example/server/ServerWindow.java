package org.example.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 200;
    private static final int WINDOW_WIDTH = 300;
    JPanel butPanel = new JPanel(new GridLayout(1,2));
    JButton butStart = new JButton("Start");
    JButton butStop = new JButton("Stop");
    public boolean workServer = false;

    public ServerWindow(){
        setTitle("Server");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        add(butPanel);
        butPanel.add(butStart);
        butPanel.add(butStop);


        butStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workServer = true;
                setTitle("Server-ON");
            }
        });

        butStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workServer = false;
                setTitle("Server-OFF");

            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String readChat() throws IOException {
        String arrChat = "";
        try {
            String str;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("chat.txt"));
            while ((str = bufferedReader.readLine()) != null ) {
                arrChat = arrChat + str + "#";
            }
            bufferedReader.close();
            return arrChat;
        } catch (FileNotFoundException fileNot){
            FileWriter fileWriter = new FileWriter("chat.txt");
            return null;
        }
    }

    public void writerChat(String text) throws IOException {
        FileWriter fileWriter = new FileWriter("chat.txt", true);
        fileWriter.append(text);
        fileWriter.append("\n");
        fileWriter.flush();
    }
}
