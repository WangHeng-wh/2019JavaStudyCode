package com.wang.snake;

import javax.swing.*;
import java.net.URL;

public class Date {

    public static URL upURL = Date.class.getResource("statics/up.png");
    public static URL downURL = Date.class.getResource("statics/down.png");
    public static URL leftURL = Date.class.getResource("statics/right.png");
    public static URL rightURL = Date.class.getResource("statics/left.png");

    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    public static URL bodyURL = Date.class.getResource("statics/body.png");

    public static ImageIcon body = new ImageIcon(bodyURL);
}
