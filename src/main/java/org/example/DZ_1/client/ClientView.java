package org.example.DZ_1.client;

import java.io.IOException;

public interface ClientView {

    void showMessage(String message);

    void setClientController(ClientController clientController);
}
