import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Graphic displayed as a ball created to bounce between boundaries. Balls
 * will be contained in a square area drawn initially. Balls change direction 
 * upon coming in contact with a boundary.
 *
 * @author Sam Thornton
 * @version 2017.10.23
 */

public class BoxBall
{
    private Ellipse2D.Double circle;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int topWall;
    private final int bottomWall;
    private final int leftWall;
    private final int rightWall;
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;
    private Random rand = new Random();
    private Color color;
    
    /**
     * Constructor for objects of class boxBall.
     *
     * @param top  coordinate for the ceiling
     * @param bottom  coordinate for the floor
     * @param left  coordinate for the left wall
     * @param right coordinate for the right wall
     * @param drawingCanvas  the canvas to draw on
     */
    
    public BoxBall(int top, int bottom, int left, int right, Canvas drawingCanvas)
    {
        Random speed = new Random();
        
        diameter = generateRandom(10, 50);
        xPosition = generateRandom((left + 10), (right - diameter));
        yPosition = generateRandom((top + 10), (bottom - diameter));
        topWall = top;
        bottomWall = bottom;
        leftWall = left;
        rightWall = right;
        canvas = drawingCanvas;
        ySpeed = generateRandomSpeed(0, 15) - 7;
        xSpeed = generateRandomSpeed(0, 15) - 7;
        Color randomColor = new Color((rand.nextInt(255)+1), (rand.nextInt(255)+1), (rand.nextInt(255)+1));
        color = randomColor;
        
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
     * Random number generator for speed.
     **/
     
    private static int generateRandomSpeed(int min, int max)
    {
        Random speed = new Random();
        int s = speed.nextInt((max-min) + 1) + min;
        if(s == 7){
            s = generateRandomSpeed(0, 15);
        }
        return s;
    }

    /**
     * Initial draw of ball at current position.
     **/
     
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erases this ball at its current position.
     **/
     
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Moves ball according to its position and speed and redraw.
     **/
     
    public void move()
    {
        // Removes from current position.
        erase();
            
        // Creates new position.
        yPosition += ySpeed;
        xPosition += xSpeed;

        // Checks if ball has made contact with wall. Redirects if it has.
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
            xPosition = (int)(leftWall + 1);
            xSpeed = -xSpeed;
        }

        // Drawn again at the new position, displaying movement.
        draw();
    }    
    
    /**
     * Returns horizontal position of a ball.
     */
    
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * Returns vertical position of a ball.
     */
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    /**
     * Returns diameter of a ball.
     */
    
    public int getDiameter()
    {
        return diameter;
    }
}