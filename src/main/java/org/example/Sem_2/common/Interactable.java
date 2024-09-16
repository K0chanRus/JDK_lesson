package org.example.Sem_2.common;

import org.example.Sem_2.common.MainConvas;

import java.awt.*;

public interface Interactable {
    void update(MainConvas convas, float deltaTime);

    void render(MainConvas convas, Graphics g);
}
