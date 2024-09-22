package org.example.DZ_1.client;

import org.example.DZ_1.server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ClientGUI extends JFrame implements ClientView{
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

    private ClientController clientController;
    ServerWindow serverWindow;

    public ClientGUI() {
        setTitle("Client");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
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

        /**
         * Кнопки подключения и отправки сообщения
         */
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { message(); }
        });

        chatField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){ message();}
            }
        });
    }

    public void message(){
        clientController.message(chatField.getText());
        chatField.setText("");
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }
}