package com.shootGame.main;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject
{
	private Handler handler;
	
	protected int x, y;
	protected int size;
	protected double speed;
	protected double angle;
	protected Color color;
	protected GameObjectID parentID;
	protected int timer;

	
	public Projectile(int x, int y, GameObjectID id, int size, double speed, double angle, Handler handler, String color, GameObjectID parentID)
	{
		super(x, y, id, size, speed);
		
		this.x = x;
		this.y = y;
		this.size = size;
		this.speed = speed;
		this.angle = angle;
		velX = speed * Math.cos(angle);
		velY = speed * Math.sin(angle);
		timer = 600;
		
		this.parentID = parentID;
		
		if(parentID == GameObjectID.Player)
			this.color = Color.white;
		else
			this.color = Color.red;
		
		this.handler = handler;
		//System.out.println(this.angle);
		
	}

	public void tick(double delta)
	{
		if((x + velX > 0) && (x + velX < Game.WIDTH))
		{
			if((y + velY > 0) && (y + velY < Game.HEIGHT))
			{
				x += velX;
				y += velY;
			}
			else if(y + velY < 0)
			{
				angle = -1 * angle;
				if((angle > 2*Math.PI))
					angle -= 2*Math.PI;
				else if((angle < 2*Math.PI))
					angle += 2*Math.PI;
				
				velX = speed * Math.cos(angle);
				velY = speed * Math.sin(angle);
				x += velX;
				y += velY;
			}
			else if(y + velY > Game.HEIGHT)
			{
				angle = -1 * angle;
				if((angle > 2*Math.PI))
					angle -= 2*Math.PI;
				else if((angle < 2*Math.PI))
					angle += 2*Math.PI;
				
				velX = speed * Math.cos(angle);
				velY = speed * Math.sin(angle);
				x += velX;
				y += velY;
				
				
			}
		}
		else if(x + velX < 0)
		{
			angle = -1 * (angle - Math.toRadians(180));
			if((angle > 2*Math.PI))
				angle -= 2*Math.PI;
			else if((angle < 2*Math.PI))
				angle += 2*Math.PI;
			
			velX = speed * Math.cos(angle);
			velY = speed * Math.sin(angle);
			x += velX;
			y += velY;
		}
		else if(x + velX > Game.WIDTH)
		{
			angle = -1 * (angle - Math.toRadians(180));
			if((angle > 2*Math.PI))
				angle -= 2*Math.PI;
			else if((angle < 2*Math.PI))
				angle += 2*Math.PI;
			
			velX = speed * Math.cos(angle);
			velY = speed * Math.sin(angle);
			x += velX;
			y += velY;
		}
		
		checkTimer();
		checkCollision();
		
		x += velX;
		y += velY;
		
		
	}
	
	public void checkCollision()
	{
		
		for(int i = 0; i < handler.objects.size(); i++)
		{
			GameObject tempObject = handler.objects.get(i);
			if(tempObject.getID() == GameObjectID.Player)
			{
				
				if(((Math.hypot(this.x - tempObject.getX(), this.y - tempObject.getY()) < tempObject.getRadius() - 5)))
				{
					handler.clearBoard();
				}
				else
				{
					
				}
				// System.out.println(Math.hypot(this.x - tempObject.getX(), this.y - tempObject.getY()));
				
			}
			if(tempObject.getID() == GameObjectID.enemySentry)
			{
				if(this.parentID == GameObjectID.Player)
				{
					if(((Math.hypot(this.x - tempObject.getX(), this.y - tempObject.getY()) < tempObject.getRadius() - 5)))
					{
						
						handler.removeObject(tempObject);
						handler.removeObject(this);
						
					}
				}
			}
		}
		
	}
	
	public void checkTimer()
	{
		if(timer > 0)
		{
			timer--;
		}
		else
		{
			handler.removeObject(this);
		}
	}
	public void render(Graphics g) 
	{
		g.setColor(color);
		g.drawArc(x, y, size, size, 0, 360);
		g.fillArc(x, y, size, size, 0, 360);
		// System.out.println("this happens");
	}

	public void angle(int direction) 
	{
		// TODO Auto-generated method stub
		
	}

	public void shoot(int val) {
		// TODO Auto-generated method stub
		
	}

	public void accelerate(int direction) {
		// TODO Auto-generated method stub
		
	}


	public void setColor(String color) 
	{
		this.color = Color.getColor(color);
		
	}

}
