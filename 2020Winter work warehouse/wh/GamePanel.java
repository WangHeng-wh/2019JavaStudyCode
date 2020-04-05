package com.wang.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length;
    int score;
    int[] snakeX = new int[400];
    int[] snakeY = new int[250];
    String fx;
    int foodx;
    int foody;
    Random random = new Random();
    boolean isStart = false;
    boolean isfail = false;
    Timer timer = new Timer(150,this);

    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    public void init(){

        length = 3;
        fx = "R";
        snakeX[0] = 175;snakeY[0] = 75;
        snakeX[1] = 150;snakeY[1] = 75;
        snakeX[2] = 125;snakeY[2] = 75;
        foodx = 25 + 25*random.nextInt(28);
        foody = 25 + 25*random.nextInt(18);
        score = 0;
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.BLACK);//画静态面板
        g.fillRect(0,0,1000,625);
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,30));
        g.drawString("分数"+score,820,75);
        g.drawString("长度"+length,820,120);
        g.setColor(Color.red);
        g.fillOval(foodx,foody,20,20);//画食物
        if (fx.equals("R"))//控制蛇的移动方向
        {
            Date.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("L")){
            Date.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Date.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")){
            Date.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for(int i = 1;i < length;i++)//画蛇身体
        {
            Date.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        if(isStart == false)
        {
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",350,270);
        }
        if (isfail){
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.setColor(Color.WHITE);
            g.drawString("游戏结束，按下空格重试",300,270);
            init();
        }
        /*

        */
    }



    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();

        if(keycode == KeyEvent.VK_SPACE)
        {
            if (isfail)
            {
                isfail = !isfail;
            }else{
                isStart = !isStart;
            }
            repaint();
        }
        if(keycode==KeyEvent.VK_UP){
            fx="U";
        }else if(keycode==KeyEvent.VK_DOWN){
            fx="D";
        } else if(keycode==KeyEvent.VK_RIGHT){
            fx="R";
        }else if(keycode==KeyEvent.VK_LEFT){
            fx="L";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart&&isfail==false)
        {
            if (snakeX[0]==foodx&&snakeY[0]==foody)
            {
                length++;
                score = score + length/2;
                foodx = 25 + 25*random.nextInt(30);
                foody = 25 + 25*random.nextInt(20);
            }
            for(int i=length-1;i>0;i--)//后一节移动到前一节得位置{
            {
                snakeX[i]=snakeX[i-1];//向前移动一节
                snakeY[i]=snakeY[i-1];
            }
            if(fx.equals("R"))
            {
                snakeX[0] = snakeX[0] + 25;
                if (snakeX[0] > 975)
                {
                    snakeX[0] = 25;
                }
            }
            else if(fx.equals("L"))
            {
                snakeX[0] = snakeX[0] - 25;
                if(snakeX[0] < 25){
                    snakeX[0] = 1000;
                }
            }
            else if(fx.equals("U"))
            {
                snakeY[0] = snakeY[0] - 25;
                if(snakeY[0] < 25){
                    snakeY[0] = 625;
                }
            }
            else if(fx.equals("D"))
            {
                snakeY[0] = snakeY[0] + 25;
                if(snakeY[0] > 600){
                    snakeY[0] = 0;
                }
            }
            for(int i = 1;i < length;i++)
            {
                if(snakeX[0] == snakeX[i]&&snakeY[0] == snakeY[i])
                {
                    isfail = true;
                }
            }
            repaint();
        }



        }
    }

