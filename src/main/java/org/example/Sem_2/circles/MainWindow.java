package org.example.Sem_2.circles;

import org.example.Sem_2.common.CanvasRepaintListener;
import org.example.Sem_2.common.MainConvas;
import org.example.Sem_2.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X=400;
    private static final int POS_Y=200;
    private static final int WINDOW_WIDTH=400;
    private static final int WINDOW_HEIGHT=400;
    private Sprite[] sprites = new Sprite[10];

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initSprites();

        MainConvas convas = new MainConvas(this);
        add(convas);

        setVisible(true);
    }
    private void initSprites(){
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
    }
    public void onDrawFrame(MainConvas convas, Graphics g, float deltaTime){
        update(convas, deltaTime);
        render(convas, g);
    }
    private void update(MainConvas convas, float deltaTime){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].update(convas, deltaTime);
        }
    }
    private void render(MainConvas convas, Graphics g){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(convas, g);
        }
    }

    public static void main(String[] args){
        new MainWindow();
    }
}
