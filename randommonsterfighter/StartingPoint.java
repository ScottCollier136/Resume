package randommonsterfighter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;


public class StartingPoint {

    static JFrame myWindow;
    Container myContainer;
    JPanel tsNamePanel;
    JLabel tsNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 28);

    JPanel tsMenuPanel;
    JLabel tsMenuLabel;

    GamePanel myGamePanel;
    Graphics2D g2;



    public static void main(String[] args){
        createGameWindow();

        //new StartingScreen();
    }

/* 
    public StartingScreen(){

        myWindow = new JFrame();
        myWindow.setSize(800,600);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.getContentPane().setBackground(Color.black);
        myWindow.setLayout(null);
        myWindow.setVisible(true);

        myContainer = myWindow.getContentPane();
        JPanel tsNamePanel = new JPanel(new BorderLayout());

        tsNamePanel.setBounds(100,100,600,150);
        tsNamePanel.setBackground(Color.blue);
        tsNameLabel = new JLabel("<html>Random <br/> Monster <br/> Fighter</html>");
        tsNameLabel.setForeground(Color.white);
        tsNameLabel.setFont(titleFont);

        tsNamePanel.add(tsNameLabel, BorderLayout.CENTER);
        myContainer.add(tsNamePanel);
    }
*/

    public static void createGameWindow(){

        JFrame gameWindow = new JFrame();
        Container myContainer = new Container();

        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);
        gameWindow.setTitle("Random Monster Fighter");

        GamePanel myGamePanel = new GamePanel();
        gameWindow.add(myGamePanel);

        gameWindow.pack();

        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

        //drawTitleScreen();

        myGamePanel.startGameThread();

    }


    public static void drawTitleScreen(Graphics g){


        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        //g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Random Monsyer Fighter";
        //int x = getXforCenteredText(text);
        //int y = myGamePanel.tileSize*3;

        //g2.setColor(Color.white);
        g2.drawString(text,100,100);
    }


}