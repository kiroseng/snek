package snek;

import java.awt.Color;
import java.awt.Graphics;

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
		g.setColor(Color.red); // "omenan" v�ri
		g.fillRect(x, y, 20, 20);
	}// draw

	public boolean snekCollision() { // tarkistaa saako snek syötyä "omenan"
		int snekX = snek.getX() + 5;
		int snekY = snek.getY() + 5;
		if (snekX >= (x - 1) && snekX <= (x + 25)) // snek eat area size
			if (snekY >= (y - 1) && snekY <= (y + 25)) {
				changePosition();
				score += 10;
				snek.setElongate(true);
				return true;
			} // if
		return false;
	}// snekCollision

}
