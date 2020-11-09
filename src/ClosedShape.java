

/**
 * ClosedShape.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 * Modified by: Andreas Eleftheriades
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A ClosedShape is any shape that can be drawn without
 * taking a pencil off a piece of paper.
 * It's representation on computer has a line colour
 * and a position on the drawable screen component.
 * It can be filled in with colour or opaque.
 * This class is a super class for all shapes.
 */

public abstract class ClosedShape {
	
	/**
	 *  The x position of the Shape.
	 */
	protected int x;
 	/**
 	 * The y position of the Shape.
 	 */
 	protected int y;

	/**
	 *  The x position of the Shape.
	 */
	protected int xVec;
	
	/**
	 * The y position of the Shape.
	 */
	protected int yVec;

	/**
	 * The line colour of the shape, or the filled in
	 * colour if the Shape has fill.
	 */
	protected Color colour;

	/**
	 * Determines if the Shape has a fill colour or not.
	 */
	protected boolean isFilled;

	/**
	 * Encodes the insertion time into the scene
	 */
	private int insertionTime;

	/**
	 * Determines if the Shape changers colour or not.
	 */
	private boolean flash;

	/**
	 * The secondary colour for the line colour of the shape, or the filled in
	 * colour if the Shape has fill.
	 */
	private Color sColour;

	/**
	 * The duplicate of colour variable.
	 */
	private Color tempColour;
	
	/**
	 * Creates a closed shape object.
	 * @param x The x position.
	 * @param y the y position.
	 * @param colour The line or fill colour.
	 * @param isFilled True if the shape is filled, false if not.
	 * @param flash True if the shape changers colour, false if not.
	 * @param sColour The secondary colour.
	 */
	protected ClosedShape (int insertionTime, int x, int y, int vx, int vy, Color colour, boolean isFilled,boolean flash, Color sColour) {
		this.x = x;
		this.y = y;
		this.xVec = vx;
		this.yVec = vy;
		this.colour = colour;
		this.sColour = sColour;
		this.tempColour = colour;
		this.flash = flash;
		this.isFilled = isFilled;
		this.insertionTime = insertionTime;
	}

	/**
	 * The method returns a string suitable for printing.
	 * @return string to print out shape.
	 */
	public String toString () {
		String result = "";
		result += "Its position is " + x + " " + y + "\n";
		result += "Its velocity is " + xVec + " " + yVec + "\n";
		result += "Its colour is " + colour + "\n";
		if (isFilled)
			result += "It is filled" + "\n";
		else
			result += "It is not filled" + "\n";
		result += "It should be inserted at " + insertionTime + "\n";
		return result;
	}

	/**
	 * Resets the x position.
	 */
 	public void setX (int x) {
		this.x = x;
	}

 	/**
 	 * Resets the y position.
 	 */
 	public void setY (int y) {
		this.y = y;
	}

	/**
	 * Resets the x vector
	 */
	 public void setVecX (int x) {
		this.xVec = x;
	 }//end setVecX

	/**
	 * Resets the y position.
	 */
	 public void setVecY (int y) {
		this.yVec = y;
	}//end setVecY

	 /**
	  * Resets the colour.
	  */
	 public void setColour (Color colour) {
	 	this.colour = colour;
	 }

	 /**
	  * Sets the shape to filled.
	  */
	 public void setFilled () {
		 isFilled = true;
	 }

	 /**
	  * Sets the shape to unfilled.
	  */
	 public void unsetFilled () {
	 	isFilled = false;
	 }
	 
	 /**
	  * Sets the insertion time.
	  */
	 public void setInsertionTime (int time) {
		 insertionTime = time;
	 }

	 /**
	  * @return The x position value.
	  */
	 public int getX() {
	 	return x;
	 }

	 /**
	  * @return The y position value.
	  */
	 public int getY() {
	 	return y;
	 }

	 /**
	  * @return The colour.
	  */
	 public Color getColour() {
	 	return colour;
	 }

	 /**
	  * @return True if the shape is filled, false if not.
	  */
	 public boolean isFilled() {
	 	return isFilled;
	 }
	 
	 /**
	  * @return the insertion time.
	  */
	 public int getInsertionTime () {
		 return insertionTime;
	 }
    
	 /**
	  * Puts the shape back in bounds in X
	  */
	 public void putInBoundsX (double winX) {
	 	if (x < 0) x = 0;
	 	if (x + this.getWidth() > winX) {
	 		x = (int) (winX - Math.ceil (this.getWidth ()));
	 	}
	 }//end inBoundsX;
    
	 /**
	  * Puts the shape back in bounds
	  */
	 public void putInBoundsY (double winY) {
	 	if (y < 0) y = 0;
	 	if (y + this.getHeight() > winY) {
	 		y = (int) (winY - Math.ceil (this.getHeight ()));
	 	}
	 }//end inBoundsY;

	 /**
	  * Bounces the shape off a vertical wall
	  */
	 public void bounceX () {
	 	xVec = -xVec;
	 }

	 /**
	  * Bounces the shape off a horizontal wall
	  */
	 public void bounceY () {
	 	yVec = -yVec;
	 }

	 /**
	  * Returns true if the shapes have gone out of bounds in X
	  */
	 public boolean outOfBoundsX (double winX) {
	 	return (x + this.getWidth()> winX) || (x < 0);
	 }

	 /**
	  * Returns true if the shapes have gone out of bounds in Y
	  */
	 public boolean outOfBoundsY (double winY) {
	 	return (y + this.getHeight() > winY) || (y < 0);
	 }

	 /**
	  * Takes in a direction and a velocity and moves the shape
	  * in that direction on unit
	  */
	 public void move () {
	 	x += xVec;
	 	y += yVec;
	 }

	 /**
	  * Draws the object to the current component.  Abstract method.
	  * @param g The graphics object associated with the drawing component.
	  */
         public abstract void draw (GraphicsContext g);

	 /**
	  * Get the width of the current component
          * @return the width of the shape
	  */
          public abstract int getWidth ();

	 /**
	  * Get the height of the current component
          * @return the height of the shape
	  */
          public abstract int getHeight ();

	/**
	 * Allows the shape object to change from one colour to another.
 	 */
	public void SwitchColor(){

		if(colour  != sColour){
			this.colour =sColour;
		}else{
			this.colour = tempColour;
		}
      }

	/**
	 * Determines if the Shape changers colour or not.
	 */
	public boolean isFlash() {
		return flash;
	}

	/**
	 * @return The secondary colour.
	 */
	public Color getsColour() {
		return sColour;
	}

	/**
	 * Resets the secondary colour.
	 */
	public void setsColour(Color sColour) {
		this.sColour = sColour;
	}
}
