package snek;

import java.awt.Color;
import java.awt.Graphics;

public class Token {

	private int x, y, score;
	private snek snek;

	public Token(snek s) {
		x = (int) (Math.random() * 395);
		y = (int) (Math.random() * 395);
		snek = s;
	}// token

	public void changePosition() {
		x = (int) (Math.random() * 395);
		y = (int) (Math.random() * 395);
	}// changePosition

	public int getScore() {
		return score;
	}// getScore

	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 6, 6);
	}// draw

	public boolean snekCollision() { // tarkistaa saako snek syötyä "omenan"
		int snekX = snek.getX() + 2;
		int snekY = snek.getY() + 2;
		if (snekX >= (x - 1) && snekX <= (x + 7))
			if (snekY >= (y - 1) && snekY <= (y + 7)) {
				changePosition();
				score++;
				snek.setElongate(true);
				return true;
			} // if
		return false;
	}// snekCollision

}
