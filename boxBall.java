import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class boxBall - a graphical ball that just bounces around. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will move in a direction and only change direction upon hitting a wall.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * basis for the code is a copy/pasted BouncingBall, with removals and additions where necessary.
 * 
 * @author Coriander M. Laidlaw
 *
 * @version 2017.10.23
 */

public class boxBall
{
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int topWall;      // y position of ground
    private final int bottomWall;      // y position of ground
    private final int leftWall;      // y position of ground
    private final int rightWall;      // y position of ground
    private Canvas canvas;
    private int ySpeed;                // initial downward speed
    private int xSpeed;                // initial downward speed

    /**
     * Constructor for objects of class boxBall
     *
     * @param top  the coordinate for the top wall to bounce off of
     * @param bottom  the coordinate for the bottom wall to bounce off of
     * @param left  the coordinate for the left wall to bounce off of
     * @param right the coordinate for the right wall to bounce off of
     * @param ballColor  the color of the ball
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public boxBall(int top, int bottom, int left, int right, Color ballColor, Canvas drawingCanvas)
    {
        Random speed = new Random();
        
        diameter = generateRandom(10, 20);
        xPosition = generateRandom(60, (540 - diameter));
        yPosition = generateRandom(60, (440 - diameter));
        color = ballColor;
        topWall = top;
        bottomWall = bottom;
        leftWall = left;
        rightWall = right;
        canvas = drawingCanvas;
        ySpeed = generateRandom(0, 15) - 7;
        if(ySpeed == 0)
            ySpeed = generateRandom(0, 15) - 7;
        xSpeed = generateRandom(0, 15) - 7;
        if(xSpeed == 0)
            xSpeed = generateRandom(0, 15) - 7;
    }
    
    /**
     * Random number generator.
     **/
    private static int generateRandom(int min, int max)
    {
        Random speed = new Random();
        return speed.nextInt((max-min) + 1) + min;
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
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit a wall
        if(yPosition >= (bottomWall - diameter)) {
            yPosition = (int)(bottomWall - diameter);
            ySpeed = -ySpeed;
        }
        if(yPosition <= (topWall)) {
            yPosition = (int)(topWall);
            ySpeed = -ySpeed;
        }
        if(xPosition >= (rightWall - diameter)) {
            xPosition = (int)(rightWall - diameter);
            xSpeed = -xSpeed;
        }
        if(xPosition <= (leftWall)) {
            xPosition = (int)(leftWall);
            xSpeed = -xSpeed;
        }

        // draw again at new position
        draw();
    }    
    
    /**
     * return the diameter of this ball
     */
    public int getDiameter()
    {
        return diameter;
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
