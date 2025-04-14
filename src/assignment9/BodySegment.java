package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private final Color color;
	private static final Random RAND = new Random();
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
        this.y = y;
        this.size = size;
        this.color = generateConsistentColor(x, y);
		
	}
	
	private static Color generateConsistentColor(double x, double y) {
        // Create a pseudo-random but consistent color based on position
        int r = (int)((Math.abs(x) * 255) % 256);
        int g = (int)((Math.abs(y) * 255) % 256);
        int b = (int)(((x + y) * 255) % 256);
        return new Color(r, g, b);
    }
    
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
