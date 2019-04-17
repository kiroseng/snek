package snek;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
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
		if (!gameOver) {
			snek.draw(gfx);
			gfx.drawString("Score:" + token.getScore(), 20, 50); // draws string points
			token.draw(gfx);
			gfx.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 35));// score font and font-size
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

		if (snek.getX() < 0 || snek.getX() > 1400-20) { // if snek runs to wall in X position
			gameOver = true;
		} // if snek runs wall in X position

		if (snek.getY() < 0 || snek.getY() > 800-20) { // if snek runs to wall in Y position
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
			if(snek.isMoving)
				snek.setIsMoving(false);
			} // if
		} // if




	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}

