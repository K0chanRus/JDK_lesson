package org.example.Sem_2.common;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainConvas convas, Graphics g, float deltaTime);
}
