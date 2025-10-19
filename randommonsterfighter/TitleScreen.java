package randommonsterfighter;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class TitleScreen {

    int continueButtonXPosition = 500;
    int continueButtonYPosition = 300;

    int newgameButtonXPosition = 500;
    int newgameButtonYPosition = 400;

    int optionsButtonXPosition = 500;
    int optionsButtonYPosition = 500;

    int cursorXPositionCon = 500;
    int cursorYPositionCon = 300;

    int cursorXPositionNG = 500;
    int cursorYPositionNG = 400;

    int cursorXPositionOpt = 500;
    int cursorYPositionOpt = 500;
    
    public void drawTitleScreen(Graphics g){
        Graphics g2 = (Graphics2D)g;
        String text = "Random Monster Fighter";
        //int x = getXforCenteredText(text);
        //int y = myGamePanel.tileSize*3;

        //g2.setColor(Color.white);
        g2.drawString(text,100,100);
        g2.drawString("Continue", continueButtonXPosition, continueButtonYPosition);
        g2.drawString("New Game", newgameButtonXPosition, newgameButtonYPosition);
        g2.drawString("options",optionsButtonXPosition, optionsButtonYPosition);
        g2.dispose();
    }
}
