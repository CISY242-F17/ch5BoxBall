import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 *@author Sam Thornton
 *@version 2017.10.23
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
    private ArrayList<BoxBall> balls;

    /**
     * Creates a BallDemo object. Creates a canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 500, 500);
    }
    
    /**
     * Simulates a number of bouncing balls.
     *
     * @param number of balls to simulate
     */
    public void boxBounce(int amount)
    {
        balls = new ArrayList<BoxBall>();
        
        // Creates square based on canvas size.
        int lowX = 10;
        int highX = myCanvas.getWidth() - 10;
        int lowY = 10;
        int highY = myCanvas.getHeight() - 10;
              
        myCanvas.setVisible(true);
        
        myCanvas.drawLine(lowX, highY, highX, highY);
        myCanvas.drawLine(lowX, lowY, lowX, highY);
        myCanvas.drawLine(lowX, lowY, highX, lowY);
        myCanvas.drawLine(highX, highY, highX, lowY);
        
        // Loop to create desired number of balls.
        boolean finished =  false;
        while(!finished) {
            while(amount > 0){
            BoxBall ball = new BoxBall(lowY, highY, lowX, highX, myCanvas);
            ball.draw();
            balls.add(ball);
            amount = amount - 1;
            }
            myCanvas.wait(50);
            for(BoxBall balls : balls) {
                balls.move();
            }
        }
    }
    
    
    /**
     * Random number generator.
     **/
    
    private static int generateRandom(int min, int max)
    {
        Random number = new Random();
        return number.nextInt((max-min) + 1) + min;
    }

}