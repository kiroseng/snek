package snek;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * The <code>snek</code> class implements the movable character that player
 * controls.
 * 
 * @author Essi Varjonen
 * @author Kim Rosengren
 * @author Miikka Wirtanen
 * @author Siiri Yl�nen
 * @author Viljami Ruokonen
 * 
 * @version 1.0
 *
 */

public class snek {
	List<Point> snekPoints; // defines list snekPoints
	int xDirection, yDirection; // defines int variables xDirection and yDirextion
	boolean isMoving, elongate; // defines boolean variables isMoving and elongate
	final int STARTSIZE = 80, STARTX = 200, STARTY = 200; // snek length and starting point

	/**
	 * This constructor creates the movable snek character.
	 * 
	 */
	
	public snek() {
		snekPoints = new ArrayList<Point>(); // makes new arraylist
		xDirection = 0; // sets xDirection to 0
		yDirection = 0; // sets yDirection to 0
		isMoving = false; // sets isMoving to false. This keeps track is snek moving
		elongate = false; // sets elongate to false. This keeps track is snek growing
		snekPoints.add(new Point(STARTX, STARTY)); // adds new cordinate to list snekPoints
		for (int i = 1; i < STARTSIZE; i++) { // this for loop creates snek, and adds new snek cordinates to arraylist
			snekPoints.add(new Point(STARTX - i * 4, STARTY));
		} // for
	}// Snek
	
	/**
	 * Draws the snek to the screen.
	 * 
	 * @param g the specified Graphics window.
	 */

	public void draw(Graphics g) { // this method draws snek to the screen
		g.setColor(Color.green); // sets snek color to green
		for (Point p : snekPoints) { // for loop go through entire snekpoin array list and fills every cordinate it
										// gets
			g.fillRect(p.getX(), p.getY(), 20, 20); // with 20x20 green rectangle
		} // for
	}// draw
	
	/**
	 * Moves the snek in the game screen if conditions are met.
	 * 
	 */

	public void move() { // this method moves snek inside screen if snek is moving
		if (isMoving) { // if snek is movin move snek
			Point temp = snekPoints.get(0); // adds index 0 cordinates from snekPoint list to temp variable
			Point last = snekPoints.get(snekPoints.size() - 1); // adds snekPoints last index to variable last
			Point newStart = new Point(temp.getX() + xDirection * 4, temp.getY() + yDirection * 4); // creates new start
																									// point to array
																									// list
			for (int i = snekPoints.size() - 1; i >= 1; i--) { // for loop that go through entire snekPoint list
				snekPoints.set(i, snekPoints.get(i - 1)); // and sets the point in index i to previous index place
			} // for
			snekPoints.set(0, newStart); // adds new cordinate to snekPoint list from variable newStart
			if (elongate) {
				snekPoints.add(last); // snek grows after eating apple
				snekPoints.add(last); // and adds last point of the snekPoint list to list x 3
				snekPoints.add(last);
				elongate = false;
			} // if elongate
		} // if isMoving
	}// move
	
	/**
	 * Checks if the snek collides with itself.
	 * 
	 * @return boolean true or false depending on whether the conditions for collision are met.
	 */

	public boolean snekCollision() { // method that checks if snek has a collision with itself
		int x = this.getX();
		int y = this.getY();
		for (int i = 1; i < snekPoints.size(); i++) { // loop that go through entire snekPoint list and check if snek
														// cordinates
			if (snekPoints.get(i).getX() == x && snekPoints.get(i).getY() == y) // is same where snek is heading
				return true; // if there is collision method returns true
		} // for
		return false; // and if there is no collision method returns false
	}// snekCollision
	
	/**
	 * Returns variable to check if snek is moving.
	 * 
	 * @return isMoving boolean variable to check whether the snek is moving or not.
	 */

	public boolean isMoving() { // method that returns boolean value is snek moving
		return isMoving;
	}// isMoving
	
	/**
	 * Sets value to variable that checks if snek is moving.
	 * 
	 * @param b boolean variable that sets the value of snek movement.
	 */

	public void setIsMoving(boolean b) { // method that sets boolean variable is snek moving
		isMoving = b;
	}
	
	/**
	 * Returns variable to get snek direction in x axis.
	 * 
	 * @return xDirextion to get snek direction in x axis.
	 */

	public int getXDirection() { // method that returns snek xDirection
		return xDirection;
	}// getXDirection
	
	/**
	 * Returns variable to get snek direction in y axis.
	 * 
	 * @return yDirection to get snek direction in y axis.
	 */

	public int getYDirection() { // method that returns snek yDirection
		return yDirection;
	}// getYDirection
	
	/**
	 * Sets value to snek direction in x axis.
	 * 
	 * @param x sets value for snek direction.
	 */

	public void setXDirection(int x) { // method that sets snek xDirection
		xDirection = x;
	}// setXDirection
	
	/**
	 * Sets value to snek direction in y axis.
	 * 
	 * @param y sets value for snek direction.
	 */

	public void setYDirection(int y) { // method that sets snek yDirection
		yDirection = y;
	}// setYDirection
	
	/**
	 * Returns the position of the snek in x axis.
	 * 
	 * @return list snekPoints to get the position of the snek.
	 */

	public int getX() { // method that returns sneks X position
		return snekPoints.get(0).getX();
	}// getX

	public int getY() { // method that returns sneks Y position
		return snekPoints.get(0).getY();
	}// getY

	public void setElongate(boolean b) { // method that sets boolean value to variable elongate
		elongate = b;
	}

	public int getKeyCode() {
		// TODO Auto-generated method stub
		return 0;
	}
}// class
