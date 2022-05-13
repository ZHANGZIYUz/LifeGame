package com.whut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameListener extends MouseAdapter implements ActionListener {
    private JFrame frame;
    private Graphics2D g;

    public void setFrame(JFrame frame) {
        this.frame = frame;
        g = (Graphics2D) frame.getGraphics();
    }

    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if ("随机生成生命方块".equals(str)) {
            for (int i = 0; i < Game.background.length; i++) {
                Arrays.fill(Game.background[i], 0);
            }
            ArrayList<PointLocation> point = new ArrayList<>();
            int x, y;
            Random r1 = new Random();
            Random r2 = new Random();
            for (int i = 0; i < 100; i++) {
                x = r1.nextInt(15);
                y = r2.nextInt(20);
                if (Game.background[x][y] == 0) {
                    Game.background[x][y] = 1;
                    PointLocation p = new PointLocation(x, y);
                    point.add(p);
                }
            }
            for (int i = 0; i < Game.background.length; i++) {
                for (int j = 0; j < Game.background[0].length; j++) {
                    System.out.print(Game.background[i][j] + " ");
                }
                System.out.println();
            }
            frame.repaint();
            frame.addMouseListener(this);
        } else if ("演化一步".equals(str)) {

        }
    }
}
