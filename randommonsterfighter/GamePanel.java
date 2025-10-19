package randommonsterfighter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import randommonsterfighter.TitleScreen;

public class GamePanel extends JPanel implements Runnable{

    //Screen Settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3; // scales for resolution
    final int tileSize =  originalTileSize * scale; //48x48 tile

    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;

    Thread gameThread;
    InputReader inputReader = new InputReader();

    int gameState = 1;
    int cursorPosition = 1;

    int FPS = 60;

    int cursorXPosition = 100;
    int cursorYPosition = 100;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(inputReader);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        while(gameThread != null) {

            double drawInterval = 1000000000/FPS;
            double nextDrawTime = System.nanoTime() + drawInterval;
            double remainingTime = 0;

            while (gameThread != null){

                update();
                repaint();

                try {
                    remainingTime = (nextDrawTime - System.nanoTime()) / 1000000;

                    if(remainingTime < 0){
                        remainingTime = 0;
                    }

                    Thread.sleep((long) remainingTime);

                    nextDrawTime = nextDrawTime + drawInterval;
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }
    }

    public void update(){
        if(inputReader.upPressed == true){
            calcCusorDestination("up");
            userInputDelay();
            //cursorYPosition = cursorYPosition - 4;
        }
        if(inputReader.downPressed == true){
            calcCusorDestination("down");
            userInputDelay();
            //cursorYPosition = cursorYPosition + 4;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(cursorXPosition,cursorYPosition,tileSize,tileSize);

        //String text = "Random Monsyer Fighter";
        //int x = getXforCenteredText(text);
        //int y = myGamePanel.tileSize*3;

        TitleScreen myTS = new TitleScreen();
        myTS.drawTitleScreen(g);

        //g2.setColor(Color.white);
        //g2.drawString(text,100,100);
        g2.dispose();
    }


    public void calcCusorDestination(String direction){

        TitleScreen myTS = new TitleScreen();

        if(gameState == 1){
            if(direction.equals("up")){
                if(cursorPosition == 1){
                    cursorPosition = 3;
                    cursorYPosition = myTS.optionsButtonYPosition;
                    System.out.println("At Options");
                }
                else if(cursorPosition == 2){
                    cursorPosition = 1;
                    cursorYPosition = myTS.continueButtonYPosition;
                    System.out.println("At Continue");
                }
                else if(cursorPosition == 3){
                    cursorPosition = 2;
                    cursorYPosition = myTS.newgameButtonYPosition;
                    System.out.println("at New Game");
                }                
            }
            else if(direction.equals("down")){
                if(cursorPosition == 1){
                    cursorPosition = 2;
                    cursorYPosition = myTS.newgameButtonYPosition;
                    System.out.println("at New Game");
                }
                else if(cursorPosition == 2){
                    cursorPosition = 3;
                    cursorYPosition = myTS.optionsButtonYPosition;
                    System.out.println("At Options");
                }
                else if(cursorPosition == 3){
                    cursorPosition = 1;
                    cursorYPosition = myTS.continueButtonYPosition;
                    System.out.println("At Continue");
                }                
            }

        }
    }


    public void userInputDelay(){
        try {
                    // Introduce a delay of 2 seconds (2000 milliseconds)
            System.out.println("Pausing for 0.5 seconds...");
            Thread.sleep(500); 
        } catch (InterruptedException e) {
                    // Handle the case where the thread is interrupted while sleeping
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.err.println("Thread was interrupted during sleep.");
        }
    }

    
}
