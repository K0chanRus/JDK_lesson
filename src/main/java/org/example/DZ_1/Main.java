package org.example.DZ_1;

import org.example.DZ_1.client.ClientWindow;
import org.example.DZ_1.server.ServerWindow;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
        new ClientWindow(serverWindow);
    }
}