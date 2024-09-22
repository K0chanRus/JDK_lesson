package org.example.Sem_2.common;


import org.example.Sem_2.common.Interactable;
import org.example.Sem_2.common.MainConvas;

import java.awt.*;

public class Sprite implements Interactable {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected float getLeft(){return  x - halfWidth;}
    protected  void setLeft(float left){x = left + halfWidth;}
    protected float getRight(){return  x + halfWidth;}
    protected  void setRight(float right){x = right - halfWidth;}
    protected float getTop(){return  y - halfHeight;}
    protected  void setTop(float top){y = top + halfHeight;}
    protected float getBottom(){return  y + halfHeight;}
    protected  void setBottom(float bottom){y = bottom - halfHeight;}

    protected float getWidth(){return 2f * halfWidth;}
    protected float getHeight(){return 2f * halfHeight;}

    public void update(MainConvas convas, float deltaTime){}

    public void render(MainConvas convas, Graphics g){}
}
