package snek;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The <code>Token</code> class implements the token player must acquire to score points.
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

	public Token(snek s) { // constructor Token
		x = (int) (Math.random() * 1400); // randomized value from 0 - 1400
		y = (int) (Math.random() * 800); // randomized value from 0 - 800
		snek = s; //sets snek value to s
	}// token

	public void changePosition() { //method changes the apple position after apple gets eated
		x = (int) (Math.random() * 1380);
		y = (int) (Math.random() * 780);
	}// changePosition

	public int getScore() { // method returns score
		return score;
	}// getScore

	public void draw(Graphics g) { // method draws apple to the screen
		g.setColor(Color.red); // sets apple color to red
		g.fillRect(x, y, 20, 20); //fills rectangle 20x20, to place in x, y position
	}// draw

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
