/**
 * <h3>This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt</h3>
 * ReadShapefile.jav
 * @version 2.0.0
 * @author Andreas Eleftheriades, Student ID: 1906277
 * <p>Creation Date: 09/02/2020</p>
 * <p>Last Modified: 10/03/2020</p>
 */

import java.io.*;
import java.util.Scanner;
import javafx.scene.paint.Color;
public class ReadShapeFile {


	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

		//read in the shape files and place them on the Queue
		while (in.hasNext()) {
			String name = in.next();
			switch (name) {
				case "circle":
					shapeQueue.enqueue(shapeCircle(in));
					break;
				case "oval":
					shapeQueue.enqueue(shapeOval(in));
					break;
				case "square":
					shapeQueue.enqueue(shapeSquare(in));
					break;
				case "rect":
					shapeQueue.enqueue(shapeRect(in));
					break;
				case "pacman":
					shapeQueue.enqueue(shapePacman(in));
					break;
				default:
					System.out.println("shape no exist");
					break;
			}

		}
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // opens a file here.
		Scanner in = null;
		try {
			in = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	    return ReadShapeFile.readDataFile(in);
	    
	}

	/**
	 * Method to read in the file and return a Circle object from the pasted in Scanner object
	 *
	 * @param in the scanner of the file
	 * @return the Circle object from the file
	 */
	public static Circle shapeCircle(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int diameter = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertion = in.nextInt();
		boolean flash = in.nextBoolean();
		int r1 = in.nextInt();
		int g1 = in.nextInt();
		int b1 = in.nextInt();
        Color secondryColour = Color.rgb(r1,g1,b1);
		Color colour = Color.rgb(r, g, b);
		Circle c = new Circle(insertion, px, py, vx, vy, diameter, colour, filled,flash,secondryColour);
		return c;
	}

	/**
	 * Method to read in the file and return a Oval object from the pasted in Scanner object
	 *
	 * @param in the scanner of the file
	 * @return the Oval object from the file
	 */
	private static Oval shapeOval(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertion = in.nextInt();
        boolean flash = in.nextBoolean();
        int r1 = in.nextInt();
        int g1 = in.nextInt();
        int b1 = in.nextInt();
        Color secondryColour = Color.rgb(r1,g1,b1);
		Color colour = Color.rgb(r, g, b);

		Oval o = new Oval(insertion, px, py, vx, vy, height, width, colour, filled,flash,secondryColour);
		return o;
	}

	/**
	 * Method to read in the file and return a Square object from the pasted in Scanner object
	 *
	 * @param in the scanner of the file
	 * @return the Square object from the file
	 */
	private static Square shapeSquare(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int side = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertion = in.nextInt();
        boolean flash = in.nextBoolean();
        int r1 = in.nextInt();
        int g1 = in.nextInt();
        int b1 = in.nextInt();
        Color secondryColour = Color.rgb(r1,g1,b1);
		Color colour = Color.rgb(r, g, b);
		Square c = new Square(insertion, px, py, vx, vy, side, colour, filled,flash,secondryColour);
		return c;
	}

	/**
	 * Method to read in the file and return a Pacman object from the pasted in Scanner object
	 *
	 * @param in the scanner of the file
	 * @return the Square object from the file
	 */
	private static Pacman shapePacman(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int size = in.nextInt();
		int position = in.nextInt();
		int sizeOfMouth = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertion = in.nextInt();
        boolean flash = in.nextBoolean();
        int r1 = in.nextInt();
        int g1 = in.nextInt();
        int b1 = in.nextInt();
        Color secondryColour = Color.rgb(r1,g1,b1);
		Color colour = Color.rgb(r, g, b);

		Pacman a = new Pacman(insertion, px, py, vx, vy, size, position, sizeOfMouth, colour, filled,flash,secondryColour);
		return a;
	}

	/**
	 * Method to read in a Scanner and return a Rectangle object from the pasted in Scanner object
	 *
	 * @param in the scanner of the file
	 * @return the Rect object from the file
	 */
	private static Rect shapeRect(Scanner in) {
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean filled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		int insertion = in.nextInt();
        boolean flash = in.nextBoolean();
        int r1 = in.nextInt();
        int g1 = in.nextInt();
        int b1 = in.nextInt();
        Color secondryColour = Color.rgb(r1,g1,b1);
		Color colour = Color.rgb(r, g, b);

		Rect t = new Rect(insertion, px, py, vx, vy, height, width, colour, filled,flash,secondryColour);
		return t;
	}

}
