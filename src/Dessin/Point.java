package Dessin;

import java.lang.Math;

public class Point {

	private int x;
	private int y;

	public Point(int abs, int ord) {
		this.x = abs;
		this.y = ord;
	}

	public double distance(Point p2) {
		int x1 = this.x;
		int y1 = this.y;
		int x2 = p2.x;
		int y2 = p2.y;
		int distance = (((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
		double distance2 = Math.sqrt(distance);
		return distance2;
	}

	public int rendreX() {
		return this.x;
	}

	public int rendreY() {
		return this.y;
	}

	public void translation(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
}
