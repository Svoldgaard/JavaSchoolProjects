package gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(100,100,200,50);
        g.setColor(Color.BLACK);

    }
}
