package snek;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class snekGame extends Applet implements Runnable, KeyListener {

	Graphics gfx;
	Image img;
	Thread thread;
	snek snek;
	boolean gameOver;
	Token token;

	public void init() {
		this.resize(400, 400);
		gameOver = false;
		img = createImage(400, 400);
		gfx = img.getGraphics();
		this.addKeyListener(this);
		snek = new snek();
		token = new Token(snek);
		thread = new Thread(this);
		thread.start();
	}// init

	public void paint(Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, 400, 400);
		if (!gameOver) {
			snek.draw(gfx);
			gfx.drawString("Points:" + token.getScore(), 5, 13); // draws string points
			token.draw(gfx);
		} else {
			gfx.setColor(Color.RED);
			gfx.drawString("Game Over", 180, 150);
			gfx.drawString("Score: " + token.getScore(), 180, 170);
		} // else

		g.drawImage(img, 0, 0, null); // draws image inside screen
	}// paint

	public void update(Graphics g) {
		paint(g);
	}// update

	public void repaint(Graphics g) {
		paint(g);
	}// repaint

	public void run() {
		for (;;) {

			if (!gameOver) {
				snek.move();
				this.checkGameOver();
				token.snekCollision();

			} // if not game over
			this.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // catch
		}
	}// run

	public void checkGameOver() {
		if (snek.getX() < 0 || snek.getX() > 396) { // if snek runs to wall in X position
			gameOver = true;
		} // if snek runs wall in X position
		if (snek.getY() < 0 || snek.getY() > 396) { // if snek runs to wall in Y position
			gameOver = true;
		} // if snek runs wall in Y position
		if (snek.snekCollision()) {
			gameOver = true;
		} // if

	}// checkGameOver

	public void keyPressed(KeyEvent e) {

		if (!snek.isMoving) {
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
					|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				snek.setIsMoving(true);
			} // if player presses up,down, left or right
		} // if

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (snek.getYDirection() != 1) { // if snek is not going down
				snek.setYDirection(-1);
				snek.setXDirection(0); // snek can't go left or right if it is going up or down
			} // if
		} // if
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (snek.getYDirection() != -1) { // if snek is not going down
				snek.setYDirection(1);
				snek.setXDirection(0); // snek can't go left or right if it is going up or down
			} // if
		} // if
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (snek.getXDirection() != 1) { // if snek is not going down
				snek.setXDirection(-1);
				snek.setYDirection(0); // snek can't go up or down if it is going left or right

			}
		} // if
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (snek.getXDirection() != -1) { // if snek is not going down
				snek.setXDirection(1);
				snek.setYDirection(0); // snek can't go up or down if it is going left or right
			} // if
		} // if
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
