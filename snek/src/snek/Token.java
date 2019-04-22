package snek;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The <code>Token</code> class implements the token "apple" player must acquire to score points.
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

public class Token {

	private int x, y, score; //defines variables x,y score
	private snek snek;

	/**
	 * This constructor creates the apple in a random location on the game screen.
	 * 
	 * @param s sets the snek value.
	 */
	
	public Token(snek s) { // constructor Token
		x = (int) (Math.random() * 1380); // randomized value from 0 - 1400
		y = (int) (Math.random() * 780); // randomized value from 0 - 800
		snek = s; //sets snek value to s
	}// token

	
	/**
	 * Changes the apple location to random position after colliding with snek.
	 * 
	 */
	
	public void changePosition() { //method changes the apple position after apple gets eaten
		x = (int) (Math.random() * 1380);
		y = (int) (Math.random() * 780);
	}// changePosition

	/**
	 * Returns game score.
	 *  
	 * @return score
	 */
	
	public int getScore() { // method returns score
		return score;
	}// getScore

	/**
	 * Draws apple to the screen.
	 * 
	 * @param g the specified graphics window.
	 */
	
	public void draw(Graphics g) { // method draws apple to the screen
		g.setColor(Color.red); // sets apple color to red
		g.fillRect(x, y, 20, 20); //fills rectangle 20x20, to place in x, y position
	}// draw
	
	/**
	 * Checks the collision of snek and the apple.
	 * 
	 * @return boolean value to determine if collision happened.
	 */

	public boolean snekCollision() { // Checks collision with apple and snake
		int snekX = snek.getX() + 19; // snek head position in X
		int snekY = snek.getY() + 19; // snek head position in Y
		if (snekX >= (x - 1) && snekX <= (x + 30)) // snek eat area size. If snek head is between these values 
			if (snekY >= (y - 1) && snekY <= (y + 30)) { // and these values, apple gets eated
				changePosition(); // changes apple position
				score += 10; // adds +10 score
				snek.setElongate(true); // sets elongate to true, and snek grows 
				return true; // returns true if apple is eated
			} // if
		return false; // otherwise returns false
	}// snekCollision

}
