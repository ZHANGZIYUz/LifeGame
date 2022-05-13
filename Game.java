package com.whut;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Game extends JFrame {

    public JFrame frame;
    public static int[][] background;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game window = new Game();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Game() {
        initialize();
    }

    private void initialize() {
        background = new int[15][20];
        for (int i = 0; i < background.length; i++) {
            Arrays.fill(background[0], 0);
        }
        frame = new JFrame();
        frame.setBounds(100,100,600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        GameListener gl = new GameListener();
        gl.setFrame(this.frame);

        JButton SuiJi = new JButton("随机生成生命方块");
        SuiJi.setBounds(95, 300, 140, 23);
        SuiJi.setBorderPainted(false);
        frame.getContentPane().add(SuiJi);
        SuiJi.addActionListener(gl);

        JButton YanHua = new JButton("演化一步");
        YanHua.setBounds(370, 300, 97, 23);
        YanHua.setBorderPainted(false);
        frame.getContentPane().add(YanHua);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.draw3DRect(0,0,20,20,true);
        g.fill3DRect(0,0,20,20,false);
    }

    public void buffpaint(Graphics g){
        ImageIcon i = new ImageIcon("D:\\compiler\\idea\\ideaworkplace\\LIfeGame\\src\\com\\whut\\1.png");
        Image image = i.getImage();
        for (int m = 0; m < 15; m++) {
            for (int n = 0; n < 20; n++) {
                if (background[m][n] == 1) {
                    g.drawImage(image, 100 + m * 20 + 2, 100 + n * 20 + 2, null);
                }
            }
        }
    }
}
