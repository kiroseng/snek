package snek;

/**
 * The <code>Point</code> class implements the coordinates of the snek character.
 * 
 * @author Essi Varjonen
 * @author Kim Rosengren
 * @author Miikka Wirtanen
 * @author Siiri Ylönen
 * @author Viljami Ruokonen
 * 
 * @version 1.0
 *
 */

public class Point {
	private int x, y;

	/**
	 * This constructor creates a frame of reference for coordination system.
	 * 
	 */
	
	public Point() { // Constructor Point
		x = 0;
		y = 0;
	}// Point 
	
	/**
	 * This constructor creates the coordinates of the snek movement.
	 * 
	 * @param x sets the snek coordinates in x axis.
	 * @param y sets the snek coordiantes in y axis.
	 */

	public Point(int x, int y) { // Constructor witch you can give attributes int x and int y
		this.x = x;
		this.y = y;
	}// Point 
	
	/**
	 * Sets snek coordinates in x axis.
	 * 
	 * @param x sets value of snek coordinates.
	 */

	public void setX(int x) { // this method sets snek X cordinate to variable x that are given to it
		this.x = x;
	}// setX
	
	/**
	 * Sets snek coordinates in y axis.
	 * 
	 * @param y sets value of snek coordinates.
	 */

	public void setY(int y) { // this method sets snek Y cordinate to variable y that are given to it
		this.y = y;
	}// setY
	
	/**
	 * Returns coordinates of the snek in x axis.
	 * 
	 * @return x to get coordinates of the snek.
	 */

	public int getX() { // this method returns snek X cordinate
		return x;
	}// getX
	
	/**
	 * Returns coordinates of the snek in y axis.
	 * 
	 * @return y to get coordinates of the snek.
	 */

	public int getY() { // this method returns snek Y cordinate
		return y;
	}// getY
}// Point
