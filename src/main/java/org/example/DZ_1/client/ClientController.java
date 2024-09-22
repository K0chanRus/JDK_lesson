package org.example.DZ_1.client;

import org.example.DZ_1.server.ServerController;

public class ClientController {
    private ClientView clientView;
    private ServerController serverController;
    private String name;


    public ClientController(ClientView clientView) {
        this.clientView = clientView;
        clientView.setClientController(this);
    }

    public void connectToServer(String name){
        this.name = name;


    }

    public void message(String text){
        if (serverController.workServer && !text.isEmpty()){
            serverController.writerChat(name + "::"+ text);
        } else {
            showMessWin("Сообщение не отправлено! Нет подключения к серверу!");
        }
    }
    public void showMessWin(String text){
        clientView.showMessage(text + "\n");
    }
}
