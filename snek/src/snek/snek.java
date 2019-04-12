package snek;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class snek {
	List<Point> snekPoints;
	int xDirection, yDirection;
	boolean isMoving, elongate;
	final int STARTSIZE = 80, STARTX = 200, STARTY = 200; // snek length and starting point

	public snek() {
		snekPoints = new ArrayList<Point>();
		xDirection = 0;
		yDirection = 0;
		isMoving = false;
		elongate = false;
		snekPoints.add(new Point(STARTX, STARTY));
		for (int i = 1; i < STARTSIZE; i++) {
			snekPoints.add(new Point(STARTX - i * 4, STARTY));
		} // for
	}// Snek

	public void draw(Graphics g) {
		g.setColor(Color.green); // snek color
		for (Point p : snekPoints) {
			g.fillRect(p.getX(), p.getY(), 20, 20); // snek thickness
		} // for
	}// draw

	public void move() {
		if (isMoving) {
			Point temp = snekPoints.get(0);
			Point last = snekPoints.get(snekPoints.size() - 1);
			Point newStart = new Point(temp.getX() + xDirection * 4, temp.getY() + yDirection * 4);
			for (int i = snekPoints.size() - 1; i >= 1; i--) {
				snekPoints.set(i, snekPoints.get(i - 1));
			} // for
			snekPoints.set(0, newStart);
			if(elongate) {
				snekPoints.add(last); // snek grows after eating apple
				snekPoints.add(last);
				snekPoints.add(last);
				elongate = false;
			}//if elongate
		} // if isMoving
	}// move

	public boolean snekCollision() {
		int x = this.getX();
		int y = this.getY();
		for (int i = 1; i < snekPoints.size(); i++) {
			if(snekPoints.get(i).getX() ==x && snekPoints.get(i).getY() == y)
				return true;
		} // for
		return false;
	}// snekCollision

	public boolean isMoving() {
		return isMoving;
	}// isMoving

	public void setIsMoving(boolean b) {
		isMoving = b;
	}

	public int getXDirection() {
		return xDirection;
	}// getXDirection

	public int getYDirection() {
		return yDirection;
	}// getYDirection

	public void setXDirection(int x) {
		xDirection = x;
	}// setXDirection

	public void setYDirection(int y) {
		yDirection = y;
	}// setYDirection

	// X position of snek head
	public int getX() {
		return snekPoints.get(0).getX();
	}// getX

	public int getY() {
		return snekPoints.get(0).getY();
	}//getY

	public void setElongate(boolean b) {
		elongate = b;
	}
}// class
