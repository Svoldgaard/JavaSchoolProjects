package gui;

import javax.swing.*;

public class GameWindow {

    public GameWindow(GamePanel gamePanel) {


        JFrame jframe = new JFrame();
        jframe.setSize(400,400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setVisible(true);



    }
}
