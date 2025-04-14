package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		this.x = Math.random(); 
        this.y = Math.random(); 
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		 StdDraw.setPenColor(Color.RED);
	        StdDraw.filledCircle(this.x, this.y, FOOD_SIZE);
	}
	
	 public double getX() {
	        return x;
	    }

	 public double getY() {
	        return y;
	    }

	    /**
	     * Sets a new random location for the Food.
	     */
	 
	    public void relocate() {
	    	 this.x = FOOD_SIZE + Math.random() * (1 - 2 * FOOD_SIZE);
	         this.y = FOOD_SIZE + Math.random() * (1 - 2 * FOOD_SIZE);
	    }
	}
	

