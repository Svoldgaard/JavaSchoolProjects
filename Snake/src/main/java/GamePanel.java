import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.swing.JPanel;


public class GamePanel extends JPanel implements ActionsListerner{
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int appelsEaten;
    int appelX;
    int appelY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackGround(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdepter());
        startGame();
    }
    public void startGame(){
        newAppel();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {

            /*
            //can be removed is one to show grid
            for (int i = 0 i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                g.drawline(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
            }*/
            g.setColor(Color.red);
            g.fillOval(appelX, appelY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    //g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + appelsEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + appelsEaten)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);

        }

        }
    }

    public void newAppel(){
        appelX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appelY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;

    }

    public void move(){
        for(int i = bodyParts-1;i>=0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction){
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;

        }
    }

    public void checkApple(){
        if((x[0]==appelX) && (y[0]==appelY)){
            bodyParts++;
            appelsEaten++;
            newAppel();

        }
    }

    public void checkCollisions(){
        //this checks if head collides with body
        for(int i = bodyParts;i>=0;i--){
            if((x[0] == x[i]) && (y[0] == y[i])){
                running = false;
            }
        }
        // this check if head touches left boreder
        if(x[o] < 0){
            running = false;
        }
        // this check if head is touches right norder
        if(x[0] > SCREEN_WIDTH){
            running = false;
        }
        // this checks if head is touches top border
        if(y[0] > SCREEN_HEIGHT){
            running = false;
        }
        // this checks if head is touches buttom border
        if(y[0] < 0){
            running = false;
        }

        if(!running){
            timer.stop();
        }


    }

    public void gameOver(Graphics g){
        //Score
        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.BOLD,30));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " +appelsEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+appelsEaten)) / 2, g.getFont().getSize());
    }

        //game Over Text
        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.BOLD,50));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT/2);
    }

    public void actionPerformed(ActionEvent e){

        if(running){
            move();
            checkApple();
            checkCollisions();

        }
        repaint();

    }

    public class MyKeyAdepter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT;
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT;
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP;
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK.DOWN;
                    if(direction != 'U'){
                        direction = 'L';
                    }
                    break;
            }
        }
    }
}
