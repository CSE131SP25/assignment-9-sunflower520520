package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
	    segments = new LinkedList<>();
	    segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE)); // Start snake in the center
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		  double newX = segments.getFirst().getX() + deltaX;
	      double newY = segments.getFirst().getY() + deltaY;

	        // Add a new head at the new position
	        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));

	        if (segments.size() > 1) {
	            segments.removeLast();
	        }
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
	
		        for (BodySegment segment : segments) {
		            segment.draw();
		        }
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		 double headX = segments.getFirst().getX();
	        double headY = segments.getFirst().getY();
	        double foodX = f.getX();
	        double foodY = f.getY();
	        
	        // Check if the head overlaps the food
	        if (Math.hypot(headX - foodX, headY - foodY) < SEGMENT_SIZE + Food.FOOD_SIZE) {
	            // Grow the snake
	            segments.addFirst(new BodySegment(headX, headY, SEGMENT_SIZE));
	            return true;
	        }

	        return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		 double headX = segments.getFirst().getX();
	     double headY = segments.getFirst().getY();
	     return headX >= 0 && headX <= 1 && headY >= 0 && headY <= 1;
	}

	
}
