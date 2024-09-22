package org.example.Sem_2.circles;

import org.example.Sem_2.common.MainConvas;
import org.example.Sem_2.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Ball extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    Ball(int x, int y){
        super(x, y);
        halfHeight = 20 + rnd.nextFloat(50);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100 + rnd.nextFloat(200);
        vY = 100 + rnd.nextFloat(200);
    }
    @Override
    public void update(MainConvas convas, float deltaTime){
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < convas.getLeft()){
            setLeft(convas.getLeft());
            vX = -vX;
        }
        if (getRight() > convas.getRight()){
            setRight(convas.getRight());
            vX = -vX;
        }
        if (getTop() < convas.getTop()){
            setTop(convas.getTop());
            vY = -vY;
        }
        if (getBottom() > convas.getButtom()){
            setBottom(convas.getButtom());
            vY = -vY;
        }
    }

    @Override
    public void render(MainConvas convas, Graphics g){
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
