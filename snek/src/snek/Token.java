package snek;

import java.awt.Color;
import java.awt.Graphics;

/**
 * The <code>Token</code> class implements the token player must acquire to score points.
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

public class Token {

	private int x, y, score;
	private snek snek;

	public Token(snek s) {
		x = (int) (Math.random() * 1400);
		y = (int) (Math.random() * 800);
		snek = s;
	}// token

	public void changePosition() {
		x = (int) (Math.random() * 1380);
		y = (int) (Math.random() * 780);
	}// changePosition

	public int getScore() {
		return score;
	}// getScore

	public void draw(Graphics g) {
		g.setColor(Color.red); // apple color
		g.fillRect(x, y, 20, 20);
	}// draw

	public boolean snekCollision() { // Checks collision with apple and snake
		int snekX = snek.getX() + 19;
		int snekY = snek.getY() + 19;
		if (snekX >= (x - 1) && snekX <= (x + 30)) // snek eat area size
			if (snekY >= (y - 1) && snekY <= (y + 30)) {
				changePosition();
				score += 10;
				snek.setElongate(true);
				return true;
			} // if
		return false;
	}// snekCollision

}
