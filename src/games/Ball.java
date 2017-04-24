package games;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private final int NORTHWEST = 7;
	private final int SOUTHWEST = 1;
	private final int NORTHEAST = 9;
	private final int SOUTHEAST = 3;
	private static int xVel = 0;
	private static int yVel = 0;
	private int xPos = 250;
	private int yPos = 300;
	private int radius = 10;
	private int direction = 7;
	private int speed = 5;

	
	public void update(GameWindow window){
		xPos += xVel;
		yPos += yVel;
	}
	
	public void paint(Graphics ball){
		ball.setColor(Color.BLUE);
		ball.fillOval(xPos, yPos, radius, radius);
	}
	
	public void moveBall(GameWindow window, Paddle paddle){
			switch(direction){
				case SOUTHEAST:{
					resetXY();
					xVel += speed;
					yVel += speed;
					if(xPos >= 390){
						direction = SOUTHWEST;
						break;
					}
					else if(yPos == paddle.getY() - 15 && 
							xPos >= paddle.getX() &&
							xPos <= paddle.getX() + paddle.getWidth()){
						direction = NORTHEAST;
					}
					break;
				}
				case SOUTHWEST:{
					resetXY();
					xVel -= speed;
					yVel += speed;
					if(xPos <= 10){
						direction = SOUTHEAST;
						break;
					}
					else if(yPos == paddle.getY() - 15 && 
							xPos >= paddle.getX() &&
							xPos <= paddle.getX() + paddle.getWidth()){
						direction = NORTHWEST;
						break;
					}
					else break;
				}
				case NORTHEAST:{
					resetXY();
					xVel += speed;
					yVel -= speed;
					if(xPos >= 390){
						direction = NORTHWEST;
						break;
					}
					else if(yPos <= 10){
						direction = SOUTHEAST;
					}
					break;
				}
				case NORTHWEST:{
					resetXY();
					xVel -= speed;
					yVel -= speed;
					if(xPos <= 10){
						direction = NORTHEAST;
						break;
					}
					else if(yPos <= 10){
						direction = SOUTHWEST;
					}
					break;
				}
			}
	}
	
	public void changeDirection(int xBrick, int yBrick, int direction, Ball ball){
		switch(direction){
		case NORTHWEST:{
			if(ball.getX() == xBrick + 50 &&
				ball.getY() >= yBrick &&
				ball.getY() <= yBrick + 30){
				//direction = NORTHEAST;
				ball.setDirection(NORTHEAST);
				break;
			}
			else if(ball.getY() == yBrick + 30 &&
					ball.getX() >= xBrick &&
					ball.getX() <= xBrick + 50){
				//direction = SOUTHWEST;
				ball.setDirection(SOUTHWEST);
				break;
			}
			break;
		}
		case NORTHEAST:{
			if(ball.getX() == xBrick - 10 &&
				ball.getY() >= yBrick &&
				ball.getY() <= yBrick + 30){
				ball.setDirection(NORTHWEST);
				break;
			}
			else if(ball.getY() == yBrick + 30 &&
					ball.getX() >= xBrick &&
					ball.getX() <= xBrick + 45){
					ball.setDirection(SOUTHEAST);
					break;
			}
			break;
		}
		case SOUTHWEST:{
			if(ball.getY() == yBrick &&
				ball.getX() >= xBrick &&
				ball.getX() <= xBrick + 50){
				ball.setDirection(NORTHWEST);
				break;
			}
			else if(ball.getX() == xBrick + 45 &&
					 ball.getY() >= yBrick &&
					 ball.getY() <= yBrick + 30){
				ball.setDirection(SOUTHEAST);
				break;
			}
			break;
		}
		case SOUTHEAST:{
			if(ball.getY() == yBrick - 10 &&
				ball.getX() >= xBrick &&
				ball.getX() <= xBrick + 50){
				ball.setDirection(NORTHEAST);
			}
			else if(ball.getX() == xBrick - 5 &&
					ball.getY() >= yBrick &&
					ball.getY() <= yBrick + 30){
				ball.setDirection(SOUTHWEST);
			}
		}
		}
	}
	
	public int getDirection(){
		return direction;
	}
	
	public void setDirection(int direction){
		this.direction = direction;
	}
	
	public int getX(){
		return xPos;
	}
	
	public void setX(int x){
		x = this.xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	public void setY(int y){
		y = this.yPos;
	}
	
	public void resetXY(){
		xVel = 0;
		yVel = 0;
	}

}
