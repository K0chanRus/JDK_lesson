package org.example.Sem_2.circles;

import org.example.Sem_2.common.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X=400;
    private static final int POS_Y=200;
    private static final int WINDOW_WIDTH=400;
    private static final int WINDOW_HEIGHT=400;
    private static final int MAX_COUNT_SPRITES = 15;
    private static final int DEFAULT_COUNT_SPRITES = 10;
    private static final Random random = new Random();

    private Interactable[] sprites;
    private int countS;

    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        initSprites();

        MainConvas convas = new MainConvas(this);
        add(convas);
        addMouseListener(new MouseListener(this) {
        });

        setVisible(true);
    }
    private void initSprites(){
        sprites = new Interactable[MAX_COUNT_SPRITES];
        sprites[0] = new Backgraund();
        countS = 1;
        for (int i = 0; i < DEFAULT_COUNT_SPRITES; i++){
            addSprite(random.nextInt(WINDOW_WIDTH), random.nextInt(WINDOW_HEIGHT));
        }
    }
    public void onDrawFrame(MainConvas convas, Graphics g, float deltaTime){
        update(convas, deltaTime);
        render(convas, g);
    }
    private void update(MainConvas convas, float deltaTime){
        for (int i = 0; i < countS; i++){
            sprites[i].update(convas, deltaTime);
        }
    }
    private void render(MainConvas convas, Graphics g){
        for (int i = 0; i < countS; i++){
            sprites[i].render(convas, g);
        }
    }

    public void addSprite(int x, int y){
        if (countS >= MAX_COUNT_SPRITES){
            throw new BallsOverflowException();
        }
        sprites[countS++] = new Ball(x, y);
    }

    public void removeSprite(){
        if (countS <= 1){
            return;
        }
        countS --;
    }

    public static void main(String[] args){
        new MainWindow();
    }
}
