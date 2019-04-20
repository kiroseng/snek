package snek;

/**
 * The <code>Point</code> class implements the coordination system for the game.
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

	public Point() { // Constructor Point
		x = 0;
		y = 0;
	}// Point 

	public Point(int x, int y) { // Constructor witch you can give attribkuts int x and int y
		this.x = x;
		this.y = y;
	}// Point 

	public void setX(int x) { // this method sets snek X cordinate to variable x that are given to it
		this.x = x;
	}// setX

	public void setY(int y) { // this method sets snek Y cordinate to variable y that are given to it
		this.y = y;
	}// setY

	public int getX() { // this method returns snek X cordinate
		return x;
	}// getX

	public int getY() { // this method returns snek Y cordinate
		return y;
	}// getY
}// Point
