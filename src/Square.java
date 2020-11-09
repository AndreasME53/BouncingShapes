/**
 * Square.java
 * @version 2.0.0
 * @author Andreas Eleftheriades, Student ID: 1906277
 * <p>Creation Date: 13/02/2020</p>
 * <p>Last Modified: 13/02/2020</p>
 * Originally written by Bette Bultena but heavily modified for the purposes of CS-115 (Andreas Eleftheriades)
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape {
    private int side;


    /**
     * Creates a square.
     * @param insertionTime The time the square enters the window
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The side of the square.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     * @param flash True if the square has a second colour, false if does not.
     * @param sColour The secondary colour to possibly switch to.
     */
    protected Square(int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled,boolean flash, Color sColour) {
        super(insertionTime, x, y, vx, vy, colour, isFilled,flash, sColour);
        this.side = side;
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }


    /**
     * Draw the square.
     * @param g The graphics object of the scene component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill( colour );
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }

    /**
     * Get the width of the square
     * @return the width of the shape
     */
    @Override
    public int getWidth() {
        return side;
    }

    /**
     * Get the height of the square
     * @return the height of the shape
     */
    @Override
    public int getHeight() {
        return side;
    }


    /**
     * @param side Resets the side.
     */
    public void setSide (int side) {
        this.side = side;
    }

    /**
     * @return The side of the square.
     */
    public int getSide() {
        return side;
    }
}
