package games;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle implements KeyListener {

	private final int HEIGHT = 10;
	private final int WIDTH = 60;
	private final int SPEED = 6;
	private int xPos = 170;
	private int yPos = 380;
	private int xVel = 0;
	
	public void update(GameWindow window){
		window.addKeyListener(this);
		xPos += xVel;
	}
	
	public void paint(Graphics paddle){
		paddle.setColor(Color.CYAN);
		paddle.fillRect(xPos, yPos, WIDTH, HEIGHT);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:{
					resetX();
					if(xPos >= 340){
						break;
					}
					else {
						xVel += SPEED;
					}
				break;
			}
			case KeyEvent.VK_D:{
					resetX();
					if(xPos >= 340){
						break;
					}
					else {
					xVel += SPEED;
					}
				break;
			}
			case KeyEvent.VK_LEFT:{
					resetX();
					if(xPos <= 0){
						break;
					}
					else {
					xVel -= SPEED;
					}
				break;
			}
			case KeyEvent.VK_A:{
					resetX();
					if(xPos <= 0){
						break;
					}
					else {
					xVel -= SPEED;
					}
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_RIGHT:{
				xVel = 0;
				break;
			}
			case KeyEvent.VK_D:{
				xVel = 0;
				break;
			}
			case KeyEvent.VK_LEFT:{
				xVel = 0;
				break;
			}
			case KeyEvent.VK_A:{
				xVel = 0;
				break;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
}
	
	public int getX(){
		return xPos;
	}
	
	public int getY(){
		return yPos;
	}
	
	public void resetX(){
		xVel = 0;
	}
	
	public int getWidth(){
		return WIDTH;
	}
	
	public int getHeight(){
		return HEIGHT;
	}
}