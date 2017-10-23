import java.awt.Color;
import java.util.Random;

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

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    public void boxBounce()
    {
        
        
        int lowX = 50; // top
        int highX = 550; // bottom
        int lowY = 50; // left
        int highY = 450; // right
        
        myCanvas.setVisible(true);
        
        myCanvas.drawLine(lowX, highY, highX, highY); // bottom line
        myCanvas.drawLine(lowX, lowY, lowX, highY); // left line
        myCanvas.drawLine(lowX, lowY, highX, lowY); // top line
        myCanvas.drawLine(highX, highY, highX, lowY); // right line
        
        boxBall ball = new boxBall(lowY, highY, lowX, highX, Color.BLUE, myCanvas);
        ball.draw();
        
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            // stop if a ball exits the box
            if(ball.getXPosition() == (lowX - 1) || ball.getXPosition() == (highX - ball.getDiameter() + 1)) {
                finished = true;
            }
            if(ball.getYPosition() == (lowY - 1) || ball.getYPosition() == (highY - ball.getDiameter() + 1)) {
                finished = true;
            }
        }
    }
    
    private static int generateRandom(int min, int max)
    {
        Random speed = new Random();
        return speed.nextInt((max-min) + 1) + min;
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
