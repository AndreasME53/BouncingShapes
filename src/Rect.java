/**
 * Rect.java
 * @version 2.0.0
 * @author Andreas Eleftheriades, Student ID: 1906277
 * <p>Creation Date: 13/02/2020</p>
 * <p>Last Modified: 13/02/2020</p>
 * Originally written by Bette Bultena but heavily modified for the purposes of CS-115 (Andreas Eleftheriades)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Rect is a rectangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rectangle's bounding rectangle
 */
public class Rect extends ClosedShape {
    //The width and height of the rectangle (major and minor axis)
    private int width, height;

    /**
     * Creates a rectangle.
     * @param insertionTime The time the rectangle enters the window
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle (in pixels).
     * @param height The height of the rectangle (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rectangle is filled with colour, false if opaque.
     * @param flash True if the rectangle has a second colour, false if does not.
     * @param sColour The secondary colour to possibly switch to.
     */
    public Rect(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled,boolean flash, Color sColour) {
        super(insertionTime, x, y, vx, vy, colour, isFilled,flash,sColour);
        this.width = width;
        this.height = height;
    }


    /**
     * Method to convert a rectangle to a string.
     */
    public String toString () {
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }


    /**
     * Draw the rectangle.
     * @param g The graphics object of the drawable component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.strokeRect( x, y, width, height );
        }
    }

    /**
     * Get the width of the rectangle
     * @return the width of the shape
     */
    @Override
    public int getWidth() {return width;}

    /**
     * Get the height of the rectangle
     * @return the height of the shape
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }


}
