package com.shootGame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.util.Vector;

public class Player extends GameObject
{	
	private Handler handler;
	
	protected int radius;
	protected double speed;
	protected Vector headingVector;
	protected Vector velocityVector;
	protected Vector body;
	protected double speedGuage;
	protected double angle;
	protected double vel;
	protected double maxVel;
	protected double velXGoal;
	protected double velYGoal;
	protected double velGoal;
	protected int turnDirection;
	protected double velTurn;
	protected double velTurnGoal;
	protected double velTurnMax;
	protected double turnSensitivity;
	protected double angleChange;
	protected double acceleration;
	protected double direction;
	
	protected int shooting;
	
	protected double delta;
	
	protected double bulletCoolDown;
	
	private int VHX, VHY;
	private int VAX, VAY;
	//private int VBX, VBY;
	private int VCX, VCY;
	//private int VDX, VDY;
	private int VFX, VFY;
	private int VEX, VEY;
	private Color color;
	
	int[] xArray = new int[6];
	int[] yArray = new int[6];
	
	
	
	
	public Player(int x, int y, GameObjectID id, int size, double speed, Handler handler, String color)
	{
		super(x, y, id, size, speed);
		
		radius = (int) Math.sqrt(((0) * (0)) + ((size - 0) * (size - 0)));
		apothom = Math.cos(Math.toRadians(45));
		angle = 0;
		
		delta = 1;
		
		vel = 0;
		velX = 0;
		velY = 0;
		
		velTurn = 0;
		velTurnMax = 0.8;
		
		maxVel = 100;
		acceleration = 10;
		angleChange = 0.2;
		
		this.color = Color.blue;
		
		
		shooting = 0;
		
		speedGuage = 0.75;
		turnSensitivity = 0.2;
		
		buildBody();
		
		this.handler = handler;
		
		
		//System.out.println("X: " + x + " Y: " + y);
		
		
	}
	
	public void tick(double delta)
	{	
		this.delta = delta;
		
		if(!(turnDirection == 1 || turnDirection == -1))
			turnVel *= 0.99;
		
		velTurn = approach(velTurnGoal, velTurn, delta );
		
		angle += velTurn * delta * turnSensitivity;
		
		if((angle > 2*Math.PI))
			angle -= 2*Math.PI;
		else if((angle < 2*Math.PI))
			angle += 2*Math.PI;
		
		if(!(direction == 1 || direction == -1))
			vel *= 0.99;
		
		vel = approach(velGoal, vel, delta);
		
		velX = vel * Math.cos(angle);
		velY = vel * Math.sin(angle);
		
		if(x + velX * delta - radius> 0)
		{
			if(x + velX * delta * speedGuage + radius < Game.WIDTH)
			{
				x += velX * delta * speedGuage;
			}
		}
		if(y + velY * delta - radius> 0)
		{
			if(y + velY * delta * speedGuage + radius< Game.HEIGHT)
			{
				y += velY * delta * speedGuage;
			}
			
		}                                                      
		
		buildBody();
		
		if(bulletCoolDown > 0)
		{
			bulletCoolDown -= delta;
			this.color = Color.red;
		}
		else
		{
			bulletCoolDown = 0;
			this.color = Color.blue;
			
			if(shooting == 1)
			{
				makeProjectile(x, y, angle);
				bulletCoolDown = 30;
				//System.out.println(angle);
			}
		}
	}
	
	public void render(Graphics g)
	{
		
		if((handler.objects.size() > 1) && (id == GameObjectID.Player))
		{
			Polygon tempShape = new Polygon(xArray, yArray, 6 );
			g.setColor(Color.CYAN);
			// System.out.print(color);
			g.drawPolygon(tempShape);
			g.fillPolygon(tempShape);
		}
		
	}
	
	public double approach(double goal, double current, double deltaTime)
	{
		double difference = goal - current;
		
		if(difference > deltaTime)
			return current + deltaTime;
		else if(difference < -deltaTime)
			return current - deltaTime;
		else
			return goal;
	}
	
	public void accelerate(int direction)
	{
		if(direction == 1)
		{
			this.direction = 1;
			velGoal = acceleration;
			if(vel > maxVel)
				vel = maxVel;
		}
		else if(direction == -1)
		{
			this.direction = -1;
			velGoal = -acceleration;
			if(vel < -maxVel)
				vel = -maxVel;
		}
		else if(direction == 0)
		{
			this.direction = 0;
			velGoal = 0;
		}
	}
	
	public void angle(int direction)
	{
		if(direction == 1)
		{
			this.turnDirection = 1;
			velTurnGoal += angleChange;
			if(velTurnGoal > velTurnMax)
				velTurnGoal = velTurnMax;
		}
		else if(direction == -1)
		{
			this.turnDirection = -1;
			velTurnGoal -= angleChange;
			if(velTurnGoal < -velTurnMax)
				velTurnGoal = -velTurnMax;
		}
		else if(direction == 0)
		{
			this.turnDirection = 0;
			velTurnGoal = 0;
		}
	}
	
	public void buildBody()
	{
		VHX = (int) (x + radius * Math.cos(angle));
		VHY = (int) (y + radius * Math.sin(angle));
		
		VHX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[0];                         
		VHY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[1];
		
		VAX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -135)[0];
		VAY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -135)[1];
		
		VCX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -90)[0];
		VCY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -90)[1];
		
		//VBX = arcRotation(VHX, VHY, x, y, -45)[0];
		//VBY = arcRotation(VHX, VHY, x, y, -45)[1];
		
		//VDX = arcRotation(VHX, VHY, x, y, 45)[0];
		//VDY = arcRotation(VHX, VHY, x, y, 45)[1];
		
		VFX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 90)[0];
		VFY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 90)[1];
		
		VEX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 135)[0];
		VEY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 135)[1];
		
		VHX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[0];
		VHY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[1];
		
		xArray[0] = (int) VHX; xArray[1] = (int) VCX; xArray[2] =  (int) VAX; xArray[3] = (int) VEX; xArray[4] = (int) VFX; xArray[5] = VHX;
		yArray[0] = (int) VHY; yArray[1] = (int) VCY; yArray[2] =  (int) VAY; yArray[3] = (int) VEY; yArray[4] = (int) VFY; yArray[5] = VHY;
	}
	
	public void shoot(int val)
	{
		if(val == 1)
		{
			shooting = 1;
		}
		else
		{
			shooting = 0;
		}
	}
	
	public void makeProjectile(int x, int y, double angle)
	{
		this.handler.addObject(new Projectile((int) (x + radius * Math.cos(angle)) + 2, (int) (y + radius * Math.sin(angle)) + 2, GameObjectID.Projectile, 4, 5.0, angle, this.handler, "white", GameObjectID.Player));
	}

	@Override
	public void setColor(String color) {
		this.color = Color.getColor(color);
		
	}
}
