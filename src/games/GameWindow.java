package games;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class GameWindow extends Applet implements Runnable{

	private static final long serialVersionUID = 1L;
	Thread thread = new Thread(this);
	boolean running = true;
	Paddle paddle;
	Ball ball;
	Brick brick;
	Image dbImage;
	Graphics dbGraphics;
	
	/*when changed, must also change
	 bricksAmount in Brick.class*/
	private int brickRows = 5;
	private int brickColumns = 5; 
	
	public void init(){
		setBackground(Color.BLACK);
		setSize(400,400);
		paddle = new Paddle();
		ball = new Ball();
		brick = new Brick(brickRows, brickColumns);
	}
	
	public void start(){
		thread.start();
	}
	
	public void destroy(){
		running = false;
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		while(running){
			repaint();
			paddle.update(this);
			ball.update(this);
			ball.moveBall(this,paddle);
			brick.checkBallCollision(brick, ball, brickRows, brickColumns);
			try{
				Thread.sleep(100);
				
			}catch(InterruptedException exception){
				System.out.println("Oops! Something went wrong.");
			}
		}
	}
	
	public void update(Graphics graphics){
		dbImage = createImage(getWidth(), getHeight()); //creating copy of the screen
		dbGraphics = dbImage.getGraphics();				//creating copy of the graphics
		paint(dbGraphics);								//paint graphics when repaint is not going
		graphics.drawImage(dbImage, 0, 0, this);		//paint background
	}
	
	public void paint(Graphics graphics){
		paddle.paint(graphics);
		ball.paint(graphics);
		brick.draw((Graphics2D)graphics);
		checkGameStatus(ball, brick.getBricksAmount(), graphics);
	}
	
	public void checkGameStatus(Ball ball, int bricksNumber, Graphics string){
		if(brick.getBricksAmount() == 0){
			string.setColor(Color.GREEN);
			string.setFont(new Font("Arial", Font.PLAIN, 20));
			string.drawString("GAME COMPLETE!", 100, 200);
			stop();
		}
		else if (ball.getY() > 400){
			string.setColor(Color.RED);
			string.setFont(new Font("TimesRoman", Font.BOLD, 20));
			string.drawString("GAME OVER", 140, 250);
			stop();
		}
	}
}