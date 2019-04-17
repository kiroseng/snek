package snek;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class snekGame extends Applet implements Runnable, KeyListener {

	Graphics gfx;
	Image img;
	Thread thread;
	snek snek;
	boolean gameOver;
	Token token;

	public void init() {
		this.resize(1400, 800);
		gameOver = false;
		img = createImage(1400, 800);
		gfx = img.getGraphics();
		this.addKeyListener(this);
		snek = new snek();
		token = new Token(snek);
		thread = new Thread(this);
		thread.start();
		String TITLE = "lskflskf";

	}// init

	public void paint(Graphics g) {
		gfx.setColor(Color.darkGray);
		gfx.fillRect(0, 0, 1400, 800);

		if (!snek.isMoving && !gameOver) {
			printRules();
		} // if snek is not moving show game rules

		if (!gameOver) {
			snek.draw(gfx);
			gfx.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));// score font and font-size
			gfx.drawString("Score:" + token.getScore(), 20, 50); // draws string points
			token.draw(gfx);

		}

		else {
			gfx.setColor(Color.red);
			gfx.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));// Game Over font and font-size
			gfx.drawString("Game Over!", 620, 350); // Game Over position
			gfx.setColor(Color.green);
			gfx.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 30)); // Final Score font and font-size
			gfx.drawString("Score: " + token.getScore(), 620, 400); // Final Score and position
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
				Thread.sleep(15); // snake speed (smaller is faster)
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // catch

		}

	}// run

	public void checkGameOver() {

		if (snek.getX() < 0 || snek.getX() > 1400 - 20) { // if snek runs to wall in X position
			gameOver = true;
		} // if snek runs wall in X position

		if (snek.getY() < 0 || snek.getY() > 800 - 20) { // if snek runs to wall in Y position
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

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (snek.isMoving)
				snek.setIsMoving(false);
		} // if
	} // if

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void printRules() {

		String line = " ";
		int linePositionX = 300; // print position X
		int linePositionY = 200;// print position Y

		try {
			final Scanner scanner = new Scanner(new File("snekRules.txt")); // opens snekRules.txt files
			while (scanner.hasNext()) { // while snekRules.txt file has next line scanner reads it in
				line = scanner.nextLine(); // scanner saves new line in line named variable
				gfx.setColor(Color.white); // sets text color to white
				gfx.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));// score font and font-size
				gfx.drawString(line, linePositionX, linePositionY); // draws string what is inside the line variable
				linePositionY += 50; // adds +50 to linePositionY, so next line comes under previous line
			} // while
			scanner.close();
		} catch (Exception e) { // prints out to console error message if scanner can't find right file
			System.out.println("Couldn't open file.");
		}

	}

}
