package com.shootGame.main;

import java.awt.Color;
import java.awt.Graphics;

public abstract class GameObject 
{
	protected int x, y;
	protected GameObjectID id;
	protected double velX, velY;
	protected int turnVel;
	protected double heading;                                      
	protected double going;                                        // the direction which the object as a whole is moving
	protected int size;
	protected int radius;
	protected final double SPEED;
	protected double apothom;
	
	public GameObject(int x, int y, GameObjectID id, int size, double speed)
	{
		this.x = x;
		this.y = y;
		this.id = id;
		this.radius = size;
		this.size = size;
		this.SPEED = speed;
		
	}
	
	public abstract void tick(double delta);
	public abstract void render(Graphics g);
	//public abstract void move();
	
	//public abstract void moveOnSlope();
	//public abstract void moveBackSlope();
	//public abstract void changeHeading(double val);
	
	//public abstract void rotateCounterClockwise();
	//public abstract void rotateClockwise();
	//public abstract void rotate();
	//public abstract double getRotationSpeed();
	
	//public abstract void moveBack();
	
	//public abstract void setSpeed(double speed);
	//public abstract double getSpeed();
	
	
	//public abstract void changeMomentum();
	//public abstract void changeTurnMomentum(double val);
	
	//public abstract void setTurnSpeed(double speed);
	//public abstract void setPositiveTurnSpeed(double speed);
	//public abstract void setNegativeTurnSpeed(double speed);
	
	//public abstract void setAcceleration(int direction);
	//public abstract double getMomentumDirectionality();
	//public abstract double getMomentum();
	
	
	public abstract void accelerate(int direction);
	public abstract void angle(int direction);
	public abstract void shoot(int val);
	public abstract void setColor(String color);
	
	
	public int getX()
	{
		return x;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public double getApothom()
	{
		return apothom;
	}
	
	public int getY()
	{
		return y;
	}
	
	public GameObjectID getID()
	{
		return id;
	}
	
	public double getHeading()
	{
		return heading;
	}
	
	public double getVelX()
	{
		return velX;
	}
	
	public double getVelY()
	{
		return velY;
	}
	
	public double getGoing()
	{
		return going;
	}
	
	
	public void setVelX(int velX)
	{
		this.velX = velX;
	}
	
	public void setVelY(int velY)
	{
		this.velY = velY;
	}
	
	public void setHeading(int heading)
	{
		this.heading = heading;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setID(GameObjectID id)
	{
		this.id = id;
	}
	
	public void setGoing(double going)
	{
		this.going = going;
	}
}
