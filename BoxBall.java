import java.awt.Color;
import java.awt.geom.*;
import java.util.Random; 

/**
 * BoxBall moves the balls inside the box.
 * Gives random initial positon and speed for the balls 
 * 
 *
 * @author Olive Tamondong
 * @version 2017.10.22
 */
public class BoxBall
{
    private static final int GRAVITY = 1;  // effect of gravity
    
    private int ballDegradation = 1;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter = 16;
    private int xPosition;
    private int yPosition;
    
    private final int groundPosition;      // y position of ground
    private final int ceiling;
    private final int rightWall;
    private final int leftWall;
    
    private Canvas canvas;
    
    private int ySpeed = 25;                // initial downward speed
    private int xSpeed = 25;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    
    
    public BoxBall(int rWall, int lWall, int ceil, int groundPos, Canvas drawingCanvas)
    {
        //make the balls to always stay inside the box
        rightWall = rWall;
        leftWall = lWall;
        ceiling = ceil;
        groundPosition = groundPos;
        
        canvas = drawingCanvas;
       
        Random random = new Random();
        
        //randomize position
        xPosition = random.nextInt(rightWall - leftWall); 
        yPosition = random.nextInt(groundPosition  - ceiling);
        
        //randomize speed
        Random xSpd = new Random();
        xSpeed = xSpd.nextInt(xSpeed) + 1; 
        
        Random ySpd = new Random();
        ySpeed = ySpd.nextInt(ySpeed) + 1; 
        
        
        //random colors
        Random r = new Random(); 
        int red = r.nextInt(250) + 2;
        Random g = new Random();
        int green = g.nextInt(250) + 2;
        Random b = new Random();
        int blue = b.nextInt(250) + 2;
        
        color = new Color(red ,green , blue);

       
       

        
        
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        //ySpeed += GRAVITY;
        //xSpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed ; 
        }
        
        
        // check if it has hit the ceiling
        if(yPosition <= ceiling) {
            yPosition = (int)(ceiling );
            ySpeed = -ySpeed; 
        }
        
        // check if it has hit the right wall
        if(xPosition >= (rightWall - diameter)) {
            xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed; 
        }
        
        // check if it has hit the left wall
        if(xPosition <= leftWall) {
            xPosition = (int)(leftWall);
            xSpeed = -xSpeed; 
        }
        

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}