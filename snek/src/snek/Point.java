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
	
	public Point() {
		x = 0;
		y = 0;
	}//Point
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}//Point
	
	public void setX(int x) {
		this.x = x;
	}//setX
	
	public void setY(int y) {
		this.y = y;
	}//setY
	
	public int getX() {
		return x;
	}//getX
	
	public int getY() {
		return y;
	}//getY
}//Point
