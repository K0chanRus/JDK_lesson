package org.example.Sem_2.circles;

import org.example.Sem_2.common.Interactable;
import org.example.Sem_2.common.MainConvas;

import java.awt.*;

public class Backgraund implements Interactable {
    private float time;
    private static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    public void update(MainConvas convas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(MainConvas convas, Graphics g){
        convas.setBackground(color);
    }
}
