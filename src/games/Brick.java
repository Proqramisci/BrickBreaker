package games;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	
	private final int WIDTH = 50;
	private final int HEIGHT = 30;
	private int bricks[][];
	private int bricksAmount = 25;
	
	//setting value = 1 for every brick
	public Brick(int row, int col){
		bricks = new int[row][col];
		for(int i=0; i<bricks.length; i++){
			for(int j=0; j<bricks[0].length; j++){
				bricks[i][j] = 1;
			}
		}
	}
	
	//drawing bricks with 3 point stroke between bricks
	public void draw(Graphics2D brick){
		for(int i=0; i<bricks.length; i++){
			for(int j=0; j<bricks[0].length; j++){
				if(bricks[i][j] > 0){
					brick.setColor(Color.ORANGE);
					brick.fillRect(j * WIDTH + 80, i * HEIGHT + 50, WIDTH, HEIGHT);
					
					brick.setStroke(new BasicStroke(3));
					brick.setColor(Color.BLACK);
					brick.drawRect(j * WIDTH + 80, i * HEIGHT + 50, WIDTH, HEIGHT);
				}
			}
		}
	}
	
	//setting given value to specific brick
	public void setBrickValue(int value, int row, int col){
		bricks[row][col] = value;
	}
	
	//ckecking if ball is collides with brick
	public void checkBallCollision(Brick brik, Ball ball, int row, int col){
		for(int i=0; i<brik.bricks.length; i++){
			for(int j=0; j<brik.bricks[0].length; j++){
				if(bricks[i][j] > 0){				
					//setting brick positions
					int brickXPos = j * WIDTH + 80;
					int brickYPos = i * HEIGHT + 50;
					
					/*every brick is set as new recangle
					ball is set as rectangle for intersects() function**/
					Rectangle rect = new Rectangle(brickXPos, brickYPos, WIDTH, HEIGHT);
					Rectangle rectBall = new Rectangle(ball.getX(), ball.getY(),10,10);
					Rectangle brick = rect;
					
					/*if ball collides with brick value of brick is set to 0
					and brick with 0 value is not painted*/
					if(rectBall.intersects(brick)){
						brik.setBrickValue(0,i ,j);		 
						brik.setBricksAmount(--bricksAmount);
					}
					
					//if ball colides with brick the ball is changing direction
					ball.changeDirection(brickXPos, brickYPos, ball.getDirection(), ball);
				}
			}
		}
	}
	
	public int getBricksAmount(){
		return bricksAmount;
	}
	
	public void setBricksAmount(int actualBricks){
		this.bricksAmount = actualBricks;
	}

	public void update(GameWindow window){
		
	}
	
	public void paint(Graphics brick){
		
	}
}
