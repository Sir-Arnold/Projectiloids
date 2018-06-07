package com.shootGame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
	private Handler handler;
	private Game game;
	private Window window;
	
	public KeyInput(Handler handler, Game game, Window window)
	{
		this.handler = handler;
		this.game = game;
		this.window = window;
	}
	
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.objects.size(); i++)
		{
			GameObject tempObject = handler.objects.get(i);
			
			if(tempObject.getID() == GameObjectID.Player)
			{
				// key events for player 1
				if(key == KeyEvent.VK_W)
				{
					tempObject.accelerate(1);
					//tempObject.addMomentum()
				}
				if(key == KeyEvent.VK_D)
					tempObject.angle(1);
				
				if(key == KeyEvent.VK_A)
					tempObject.angle(-1);
				
				if(key == KeyEvent.VK_S)
					tempObject.accelerate(-1);
				if(key == KeyEvent.VK_SPACE)
					tempObject.shoot(1);
				// System.out.println("Momentum: " + tempObject.getMotionSpeed() + " - Velosity of X: " + tempObject.getVelX() + ", Velosity for Y: " + tempObject.getVelY());	
			}
			
			
				
		
				
			
			
			if(key == KeyEvent.VK_G)
			{	
				//System.out.println(tempObject.getID() + ":   " + " Heading: " + tempObject.getHeading() + " - Momentum: " + tempObject.getMotionSpeed() + " - Velocity of X: " + tempObject.getVelX() + ", Velocity for Y: " + tempObject.getVelY());
				
				if(tempObject.getID() == GameObjectID.Player)
				{
					System.out.println(tempObject.getID() + ":  " + " Heading: " + tempObject.getHeading() + " - Going: " + tempObject.getGoing() + " - Velocity of X: " + tempObject.getVelX() + ", Velosity for Y: " + tempObject.getVelY() + " X: " + tempObject.getX() + " Y: " + tempObject.getY());
				}
			}
			
			if(key == KeyEvent.VK_R)
			{	
				//System.out.println(tempObject.getID() + ":   " + " Heading: " + tempObject.getHeading() + " - Momentum: " + tempObject.getMotionSpeed() + " - Velocity of X: " + tempObject.getVelX() + ", Velocity for Y: " + tempObject.getVelY());
				handler.restart();
			}
			
			if(key == KeyEvent.VK_F)
			{
				for(int j = 0; j < handler.objects.size(); j++)
				{
					GameObject thisObject = handler.objects.get(j);
					System.out.println(thisObject.getID());
				}
			}
		}
	}

		
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.objects.size(); i++)
		{
			GameObject tempObject = handler.objects.get(i);
			
			if(tempObject.getID() == GameObjectID.Player)
			{
				// key events for player 1
				if(key == KeyEvent.VK_W)
				{
					tempObject.accelerate(0);
					//tempObject.addMomentum()
				}
				if(key == KeyEvent.VK_D)
					tempObject.angle(0);
				
				if(key == KeyEvent.VK_A)
					tempObject.angle(0);
				
				if(key == KeyEvent.VK_S)
					tempObject.accelerate(0);
				if(key == KeyEvent.VK_SPACE)
					tempObject.shoot(0);
			}
			
			
		}
	}
}
