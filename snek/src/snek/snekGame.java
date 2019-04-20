package snek;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;

/**
 * The <code>snekGame</code> class implements the game screen and controls, runs the game.
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

public class snekGame extends Applet implements Runnable, KeyListener {
	
	Graphics gfx;
	Image img;
	Thread thread;
	snek snek;
	boolean gameOver;
	Token token;
	
	
	/**
	 * Defines the initial settings of the game such as windows size and title. It also initializes values for several variables.
	 * 
	 */
	
	public void init() {
		this.resize(1400, 800); // defines window size
		gameOver = false; // defines gameOver variable false
		img = createImage(1400, 800); // defines image size to match window size
		gfx = img.getGraphics();
		this.addKeyListener(this); // adds key listener
		snek = new snek(); // defines snek.java to snek, that it can be used inside this snekGame.java
		token = new Token(snek); // defines token.java to token, that it can be used inside this snekGame.java
		thread = new Thread(this);
		thread.start();
		Frame title = (Frame) this.getParent().getParent(); // defines window title
		title.setTitle("SnekGame"); // defines window title
		
	}// init
	
	/**
	 * Implements changes to the screen such as colour, text and the position of the snek and token.
	 * 
	 *@param g the specified graphics window
	 */

	public void paint(Graphics g) {
		gfx.setColor(Color.darkGray); // defines window bgcolor to darkgray
		gfx.fillRect(0, 0, 1400, 800); // fills rectangle 1400x800 to darkgray

		if (!snek.isMoving && !gameOver) {
			printRules();
		} // if snek is not moving print game rules

		if (!gameOver) {
			snek.draw(gfx);
			gfx.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));// score font and font-size
			gfx.drawString("Score:" + token.getScore(), 20, 50); // draws string points
			token.draw(gfx);

		} // if not game over Game is ON!

		else {
			gfx.setColor(Color.red); // defines font-color to red
			gfx.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));// Game Over font and font-size
			gfx.drawString("Game Over!", 620, 350); // Game Over position
			gfx.setColor(Color.green); // defines font-color to green
			gfx.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 30)); // final Score font and font-size
			gfx.drawString("Score: " + token.getScore(), 620, 400); // final Score and position
		} // else

		g.drawImage(img, 0, 0, null); // draws image inside screen

	}// paint
	
	/**
	 * Updates the game screen by starting method <code>paint</code>.
	 * 
	 *@param g the specified Graphics window
	 */

	public void update(Graphics g) { // method update starts method paint
		paint(g);

	}// update
	
	/**
	 * Updates the game screen by starting method <code>paint</code>
	 * 
	 * @param g the specified Graphics window
	 */

	public void repaint(Graphics g) { // method repaint starts method paint
		paint(g);
	}// repaint

	public void run() { // starts runnable program
		for (;;) { // never-ending loop

			if (!gameOver) { // if not game over game is on and snek is moving
				snek.move(); // snek moves
				this.checkGameOver(); // check for game over
				token.snekCollision(); // check for apple collision
			} // if not game over
			this.repaint(); // repaint image inside the screen
			try { // thread.sleep must be inside try and catch, because it can cause an error
				Thread.sleep(15); // snake speed (smaller is faster)
			} catch (InterruptedException e) { // this catches the error if it occurs
				e.printStackTrace();
			} // catch

		}

	}// run

	public void checkGameOver() { // this method checks if snek makes collision with wall, and sets boolean
									// gameOver to true if it happens

		if (snek.getX() < 0 || snek.getX() > 1400 - 20) { // if snek runs to wall in X position
			gameOver = true;
		} // if snek runs wall in X position

		if (snek.getY() < 0 || snek.getY() > 800 - 20) { // if snek runs to wall in Y position
			gameOver = true;
		} // if snek runs wall in Y position

		if (snek.snekCollision()) { // this starts method snekCollision method inside snek.java class, and if there
									// is collision with snek,
			gameOver = true; // gameOver boolean is true
		} // if

	}// checkGameOver

	public void keyPressed(KeyEvent e) { // method that listens if keys up, down, left, right or spacebar is pressed

		if (!snek.isMoving) { // if not snek is moving it starts to move when pressed up, down left or right
			if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN
					|| e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				snek.setIsMoving(true);
			} // if player presses up,down, left or right
		} // if

		if (e.getKeyCode() == KeyEvent.VK_UP) { // if arrowkey up is pressed down, snek starts to go north
			if (snek.getYDirection() != 1) { // if snek is not going south
				snek.setYDirection(-1); // this sets snek to go negative direction in Y cordinates
				snek.setXDirection(0); // this stops snek to move in X direction
			} // if
		} // if arrow key up is pressed down

		if (e.getKeyCode() == KeyEvent.VK_DOWN) { // if arrow key down is pressed down, snek starts to go south
			if (snek.getYDirection() != -1) { // if snek is not going north
				snek.setYDirection(1); // this sets snek to go positive direction in Y cordinates
				snek.setXDirection(0); // // this stops snek to move in X direction
			} // if
		} // if arrow key down is pressed down

		if (e.getKeyCode() == KeyEvent.VK_LEFT) { // if arrow key left is pressed down, snek starts to go west
			if (snek.getXDirection() != 1) { // if snek is not going east
				snek.setXDirection(-1); // this sets snek to go negative direction in X cordinates
				snek.setYDirection(0); // // this stops snek to move in Y direction
			}
		} // if arrow key left is pressed down

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (snek.getXDirection() != -1) { // if snek is not going west
				snek.setXDirection(1); // this sets snek to go positive direction in X cordinates
				snek.setYDirection(0); // // this stops snek to move in Y direction

			} // if
		} // if arrow key right is pressed down

		if (e.getKeyCode() == KeyEvent.VK_SPACE) { // if space bar is pressed down
			if (snek.isMoving) // if snek is moving
				snek.setIsMoving(false); // this is set to false
		} // if 
	} // if space bar is pressed down

	public void keyReleased(KeyEvent e) { // does not do anything yet
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent e) { // does not do anything yet 
		// TODO Auto-generated method stub
	}

	public void printRules() { // prints out the rules to the screen from file: snekRules.txt

		String line = " "; // defines variable line. Scanner uses this inside try and catch
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
			scanner.close(); // closes file snekRules.txt
		} catch (Exception e) { // prints out to console error message if scanner can't find right file
			System.out.println("Couldn't open file."); 
		}

	}

}
