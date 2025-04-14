package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
    private Snake snake;
    private Food food;
    private int score;
    
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake(); // Construct new Snake
        food = new Food();   // Construct new Food;
        score = 0;  
		
		//FIXME - construct new Snake and Food objects
	}
	
	public void play() {
		
		int pauseDuration = 50;
        while (snake.isInbounds()) { // Check if snake is in bounds
            int dir = getKeypress();

            // Pass direction to the snake
            if (dir != -1) {
                snake.changeDirection(dir);
            }

            snake.move();

            // Check if the snake eats the food
            if (snake.eatFood(food)) {
                food.relocate();
                score++;
            }

            // Update the drawing
            updateDrawing();
            
            StdDraw.pause(pauseDuration);
        }

        System.out.println("Game Over!");
    }
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		
	
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		  StdDraw.clear();
	        snake.draw();
	        food.draw();
	        
	        // Display the score
	        StdDraw.setPenColor(StdDraw.BLACK);
	        StdDraw.text(0.1, 0.95, "Score: " + score);
	        
	        StdDraw.pause(50); // Pause for smooth movement
	        StdDraw.show();
	    }
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
