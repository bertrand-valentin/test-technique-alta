package fr.altaprofits.exercice;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString () {
		return "(" + x + "," + y + ")";
	}
}
