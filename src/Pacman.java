/**
 * Arc.java
 * @version 2.0.0
 * @author Andreas Eleftheriades, Student ID: 1906277
 * <p>Creation Date: 13/02/2020</p>
 * <p>Last Modified: 12/02/2020</p>
 * Originally written by Bette Bultena but heavily modified for the purposes of CS-115 (Andreas Eleftheriades)
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

/**
 *
 * Pacman is a pacman shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * pacman's bounding pacman
 */
public class Pacman extends ClosedShape {
    //The size of the pacman
    private int size;
    //The position is the directions that the pacman is facing, The sizeOfTheMouth is the angle size of
    //the pacman's mputh
    private int position,sizeOfMouth;
    //The originalSize is the original angle size of the pacman's mputh
    private int originalSize;
    //The mouthChange is the change from closing the mouth to opening the mouth
    private boolean mouthChange;

    /**
     * Creates a Pacman.
     * @param insertionTime The time the pacman enters the window
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param size The size of the Pacman.
     * @param position The direction of the Pacman.
     * @param sizeOfMouth The size of the Pacman's mouth.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the Pacman is filled with colour, false if opaque.
     * @param flash True if the Pacman has a second colour, false if does not.
     * @param sColour The secondary colour to possibly switch to.
     */
    public Pacman(int insertionTime, int x, int y, int vx, int vy, int size, int position, int sizeOfMouth, Color colour, boolean isFilled, boolean flash, Color sColour) {
        super(insertionTime, x, y, vx, vy, colour, isFilled,flash,sColour);
        this.size = size;
        this.position = position;
        this.sizeOfMouth = sizeOfMouth;
        originalSize = sizeOfMouth;
    }


    /**
     * Method to convert a Pacman to a string.
     */
    public String toString () {
        String result = "This is a Pacman\n";
        result += super.toString ();
        result += "The size is " + this.size + "\n";
        return result;
    }


    /**
     * Draw the pacman.
     * @param g The graphics object of the drawable component.
     */
    @Override
    public void draw(GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        // every 100 millis seconds the mouth closes or opens
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ae -> mouth()));
        timeline.play();
        if (isFilled) {
            g.fillArc( x, y, size, size, position, sizeOfMouth, ArcType.ROUND );
        }
        else {
            g.strokeArc( x, y, size, size, position, sizeOfMouth, ArcType.ROUND);
        }
    }

    /**
     * Puts the shape back in bounds and makes the pacman face inwards
     */
    @Override
    public boolean outOfBoundsY (double winY) {
        if(super.outOfBoundsY(winY)){
            position +=180;
        }
        return super.outOfBoundsY(winY);}


    /**
     * Puts the shape back in bounds in X and makes the pacman face inwards
     */
    @Override
    public boolean outOfBoundsX (double winX) {
        if(super.outOfBoundsX(winX)){
        position +=180;
        }
        return super.outOfBoundsX(winX);}

    /**
     * Method that lets the mouth of the pacman open and close
     */
    public void mouth(){

        if(!mouthChange){
            sizeOfMouth+=1;
        }else{
            sizeOfMouth-=1;
        }

        if(sizeOfMouth ==360){
            mouthChange =true;
        }else if( sizeOfMouth == originalSize){
            mouthChange = false;
        }
    }


    /**
     * Get the width of the pacman
     * @return the width of the shape
     */
    @Override
    public int getWidth() {return size;}

    /**
     * Get the height of the pacman
     * @return the height of the shape
     */
    @Override
    public int getHeight() {
        return size;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.size = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.size = height;
    }


}
