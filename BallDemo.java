import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

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
    private ArrayList<boxBall> balls;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo(int height, int width)
    {
        if(height < 100){
            height = 100;
        }
        if(width < 100){
            height = 100;
        }
        
        myCanvas = new Canvas("Ball Demo", width, height);
    }
    
    /**
     * Simulate a whole bunch of bouncing balls.
     */
    public void boxBounce(int offset, int amount)
    {
        if(amount < 5 && amount > 30){
            amount = generateRandom(5, 31);
        }
        balls = new ArrayList<boxBall>();
        
        int lowX = offset; // top
        int highX = 600 - offset; // bottom
        int lowY = offset; // left
        int highY = 500 - offset; // right
        
        myCanvas.setVisible(true);
        
        myCanvas.drawLine(lowX, highY, highX, highY); // bottom line
        myCanvas.drawLine(lowX, lowY, lowX, highY); // left line
        myCanvas.drawLine(lowX, lowY, highX, lowY); // top line
        myCanvas.drawLine(highX, highY, highX, lowY); // right line
        
        boolean finished =  false;
        while(!finished) {
            while(amount > 0){
            boxBall ball = new boxBall(lowY, highY, lowX, highX, generateRandomColor(), myCanvas);
            ball.draw();
            balls.add(ball);
            amount = amount - 1;
        }
            myCanvas.wait(50);           // small delay
            for(boxBall balls : balls) {
                balls.move();
            }
        }
    }
    
    /**
     * Random colour generator.
     **/
    private static Color generateRandomColor()
    {
        Random value = new Random();
        int red = value.nextInt(206) + 50;
        int green = value.nextInt(206) + 50;
        int blue = value.nextInt(206) + 50;
        
        Color randomColor = new Color(red, green, blue);
        return randomColor;
    }
    
    /**
     * Random number generator.
     **/
    private static int generateRandom(int min, int max)
    {
        Random number = new Random();
        return number.nextInt((max-min) + 1) + min;
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
