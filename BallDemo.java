import java.awt.Color;
import java.util.Random;


/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 * 
 * @author Olive Tamondong
 * @version 2017.10.22
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

  public class BallDemo 
  {
    private Canvas myCanvas;
    
    //dimensions of the canvas
    private int height = 600;
    private int width = 600;
  
    

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", height, width);
        
        
    }

    /**
     * BoxBounce method specifies how many balls are in the box.
     */
    public void boxBounce(int totalBalls)
    {
        int ground = 550;  // position of the ground line
        int ceiling = 50;  // position of the ceiling(top line)
        int leftWall = 50; 
        int rightWall = 550;
        
     
        myCanvas.setVisible(true);

        // draw the box
        myCanvas.drawLine(leftWall, ground, rightWall, ground);
        myCanvas.drawLine(leftWall, ceiling, rightWall, ceiling);
        myCanvas.drawLine(leftWall, ceiling, leftWall, ground);
        myCanvas.drawLine(rightWall, ceiling, rightWall, ground);
        
        //create an array of balls 
        BoxBall balls[] = new BoxBall[totalBalls];
        
        for( int index = 0; index<totalBalls; index++)
        {
            balls[index] = new BoxBall(rightWall, leftWall, ceiling, ground, myCanvas);
            balls[index].draw();
        }
        
      
        /* create and show the balls using the BoxBall class created
        BoxBall ball = new BoxBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BoxBall ball2 = new BoxBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();*/

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            
            for( int index = 0; index<totalBalls; index++)
            {
                
                balls[index].move();
            }
            
            myCanvas.drawLine(leftWall, ground, rightWall, ground);
            myCanvas.drawLine(leftWall, ceiling, rightWall, ceiling);
            myCanvas.drawLine(leftWall, ceiling, leftWall, ground);
            myCanvas.drawLine(rightWall, ceiling, rightWall, ground);
            // stop once ball has travelled a certain distance on x axis
            //if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
            //    finished = true;
            }
            
        }
    }

