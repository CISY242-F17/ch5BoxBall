import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Creates a ball that moves at a consistent rate and bounces of the walls that are set 
 *
 * @author Alberto Pacheco
 * @version (a version number or a date)
 */

public class BoxBall
{
    //private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private static final int Momentum = 4; // old version 
    private int ySpeed;
    private int xSpeed;
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Canvas myCanvas;
    private final int groundPosition;       
    private final int tPosition;          
    private final int lPosition;        
    private final int rPosition;       
    private Color color;
    // create random color 
    Random randomize = new Random();
    Color randomColor = new Color((randomize.nextInt(255)), (randomize.nextInt(255)), (randomize.nextInt(255)));

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter,
                    int leftPos, int rightPos, int bottomPos, int topPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        ySpeed = randomize.nextInt(10); 
        xSpeed = randomize.nextInt(10);
        color = randomColor;
        diameter = ballDiameter;
        myCanvas = drawingCanvas;
        lPosition = leftPos;
        rPosition = rightPos;
        tPosition = topPos;
        groundPosition = bottomPos; 
        
    }
    

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
       myCanvas.setForegroundColor(color);
      myCanvas.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        myCanvas.eraseCircle(xPosition, yPosition, diameter);
    }    


    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        //erase the current position of the ball in order to prepare for the new position 
        erase();
        // compute new position 
        yPosition += ySpeed; // y position +1 
        xPosition += xSpeed;
        
        if (yPosition >= (groundPosition - diameter ) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed;
        }
        
        if (xPosition <= lPosition) {
            xPosition = lPosition;
            xSpeed = -xSpeed;
        }
        
        if (yPosition <= tPosition) {
            yPosition = tPosition;
            ySpeed = -ySpeed;
        }
        
        
        if (xPosition >= (rPosition - diameter)) {
            xPosition = (int)(rPosition - diameter);
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
