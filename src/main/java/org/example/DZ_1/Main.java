package org.example.DZ_1;


import org.example.DZ_1.client.ClientController;
import org.example.DZ_1.client.ClientGUI;
import org.example.DZ_1.client.ClientView;
import org.example.DZ_1.client.ClientWindow;
import org.example.DZ_1.server.ServerController;
import org.example.DZ_1.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        //new ClientWindow(serverWindow);
        new ClientController(new ClientGUI());
    }
}