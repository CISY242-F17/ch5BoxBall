import java.awt.Color;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rand = new Random();

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    public void boxBounce()
    {
        // call randomize to place random location of ball
        Random randomize = new Random(350);
        int ground = 400;
        int roof= 50;
        
        // gets the size of the canvas by calling the Dimension java class 
        Dimension size = myCanvas.getSize();
        int xPos;
        int yPos;
        int randX = size.width;
        int randY = size.height;
        
        xPos = randomize.nextInt(randX);
        yPos = randomize.nextInt(randY);

        //create the balls
        BoxBall ball = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball.draw();

        BoxBall ball2 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball2.draw();
        
        BoxBall ball3 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball3.draw();
        
        BoxBall ball4 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball4.draw();
        
        BoxBall ball5 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball5.draw();
        
        BoxBall ball6 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball5.draw();
        
        BoxBall ball7 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball5.draw();
        
        BoxBall ball8 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball5.draw();
        
        BoxBall ball9 = new BoxBall(xPos, yPos, 10, 50, 550, ground, roof, myCanvas);
        ball5.draw();
        
            boolean done = false;
            while(!done)
            {
                myCanvas.wait(20); // account for delay
                ball.move();
                ball2.move();
                ball3.move();
                ball4.move();
                ball5.move();
                ball6.move();
                ball7.move();
                ball8.move();
                ball9.move();
                // draws the rectangle box
                // note that bechse its in the while loop, it won't get chipped awway
                myCanvas.setVisible(true);
                myCanvas.drawLine(50, ground, 550, ground);
                myCanvas.drawLine(50, roof, 550, roof);
                myCanvas.drawLine(50, roof, 50, ground);
                myCanvas.drawLine(550, roof, 550, ground);
            }
    }
}
