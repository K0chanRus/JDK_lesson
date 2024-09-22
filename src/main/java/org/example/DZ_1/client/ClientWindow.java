package org.example.DZ_1.client;

import org.example.DZ_1.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClientWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 500;
    JPanel setingsPanel = new JPanel(new GridLayout(2,3));
    JTextField IPField = new JTextField("192.168.0.0");
    JTextField portField = new JTextField("8800");
    JTextField loginField = new JTextField("login");
    JPasswordField passField = new JPasswordField("123456");
    JButton btnLogin = new JButton("Login");
    JTextArea chatArea = new JTextArea();
    JPanel chatPanel = new JPanel(new GridBagLayout());
    GridBagConstraints contenerChat = new GridBagConstraints();
    JTextField chatField = new JTextField();
    JButton btnChat = new JButton("Send");

    private boolean connectServer;
    ServerWindow serverWindow;
    public ClientWindow(ServerWindow serverWindow){
        setTitle("Client");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        add(setingsPanel, BorderLayout.NORTH);
        setingsPanel.add(IPField);
        setingsPanel.add(portField);
        setingsPanel.add(loginField);
        setingsPanel.add(passField);
        setingsPanel.add(btnLogin);
        chatArea.setEnabled(false);
        add(chatArea, BorderLayout.CENTER);
        add(chatPanel, BorderLayout.SOUTH);
        contenerChat.fill = GridBagConstraints.BOTH;
        contenerChat.weightx = 1;
        contenerChat.gridx = 0;
        chatPanel.add(chatField, contenerChat);
        contenerChat.weightx = 0;
        contenerChat.gridx = 1;
        chatPanel.add(btnChat, contenerChat);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (serverWindow.workServer){
                    setTitle("Client-conneсt");
                    connectServer = true;
                    try {
                        updateChat(serverWindow);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    setTitle("Client-disconnect");
                    connectServer = false;
                }
            }
        });

        btnChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    keySend(serverWindow);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        chatField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    try {
                        keySend(serverWindow);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        if(connectServer == true){
            do {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    updateChat(serverWindow);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } while (connectServer == true);
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateChat(ServerWindow serverWindow) throws IOException {
        chatArea.setText("");
        String strings = serverWindow.readChat();
        System.out.println(strings);
        String[] chat = strings.split("#");
        for (String s : chat){
            chatArea.append(s + "\n");
        }
    }

    private void keySend(ServerWindow serverWindow) throws IOException {
        if (serverWindow.workServer){
            String login = loginField.getText();
            String messeng = chatField.getText();
            serverWindow.writerChat(login + "::" + messeng);
            updateChat(serverWindow);
        }
        chatField.setText("");
    }
}