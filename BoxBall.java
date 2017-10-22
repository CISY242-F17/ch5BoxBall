import java.awt.Color;
import java.awt.geom.*;
import java.util.Random; 

/**
 * BoxBall moves the balls inside the box
 * gives random initial positon and speed for the balls 
 * boxBounce method specifies how many balls are in the box.
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
    private int diameter = 50;
    private int xPosition;
    private int yPosition;
    
    private final int groundPosition;      // y position of ground
    private final int ceiling;
    private final int rightWall;
    private final int leftWall;
    
    private Canvas canvas;
    
    private int ySpeed = 1;                // initial downward speed
    private int xSpeed = 1;

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
        xPosition = random.nextInt(rightWall - leftWall) + leftWall; 
        yPosition = random.nextInt(groundPosition - ceiling) + ceiling;
        
        //randomize speed
        xSpeed = random.nextInt(xSpeed) + 1; 
        ySpeed = random.nextInt(ySpeed) + 1; 
        
        diameter = random.nextInt(diameter); 
        
        //random colors
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        
        Color randomColor = new Color(r, g, b);
        
        
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
        ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }
        
        // check if it has hit the ceiling
        if(yPosition <= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(ceiling - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }
        
        // check if it has hit the left wall
        if(xPosition >= (rightWall - diameter) && xSpeed > 0) {
            xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed + ballDegradation; 
        }
        
        // check if it has hit the right wall
        if(xPosition <= (leftWall - diameter) && xSpeed > 0) {
            xPosition = (int)(leftWall - diameter);
            xSpeed = -xSpeed + ballDegradation; 
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