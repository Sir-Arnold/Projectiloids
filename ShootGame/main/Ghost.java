package com.shootGame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;

public class Ghost extends GameObject
{
	Handler handler;
	
	private int x = 0;
	private int y = 0;
	private GameObjectID id = GameObjectID.Ghost;
	private int radius = 1;
	private double SPEED = 1;
	
	protected static float redVal;
	protected int redMult;
	protected static float greenVal;
	protected int greenMult;
	protected static float blueVal;
	protected int blueMult;
	
	public Ghost(int x, int y, GameObjectID id, int size, double SPEED, Handler handler)
	{
		super(x, y, id, size, SPEED);
		x = 0;
		y = 0;
		id = GameObjectID.Ghost;
		radius = 1;
		SPEED = 1;
		
		redVal = (float) 0.010;
		redMult = 1;
		greenVal = (float) 0.050;
		greenMult = 1;
		blueVal = (float) 0.07;
		blueMult = 1;
		
		this.handler = handler;
		
	}

	@Override
	public void tick(double delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		
		// TODO Auto-generated method stub
		redVal = (float) (redVal + (0.001 * redMult));
		if(redVal > 0.995)
			redMult = -1;
		else if(redVal < 0.005)
			redMult = 1;
		
		greenVal = (float) (greenVal + (0.002 * greenMult));
		if(greenVal > 0.995)
			greenMult = -1;
		else if(greenVal < 0.005)
			greenMult = 1;
		
		blueVal = (float) (blueVal + (0.003 * blueMult));
		if(blueVal > 0.995)
			blueMult = -1;
		else if(blueVal < 0.005)
			blueMult = 1;
		
		String[] differentFonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
		        .getAvailableFontFamilyNames();
		String comicSans = differentFonts[5];
	    Font font = new Font(comicSans, Font.PLAIN, 30);
	    g.setFont(font);
		
	    
	    Color color = new Color(redVal, greenVal, blueVal);
	    
		g.setColor(color);
		g.drawString("" + Game.time, Game.WIDTH / 2 - 15, 30);
		
		if((!(handler.objects.size() > 2)))
		{
			if((handler.objects.size() > 1))
			{
				if((handler.objects.get(1).getID() != GameObjectID.Player))
				{
					g.drawString("Press \"R\" to restart", Game.WIDTH / 2 - 100, Game.HEIGHT / 2);
					Game.timeTimer = 0;
				}
					
			}
			else
			{
				g.drawString("Press \"R\" to restart", Game.WIDTH / 2 - 100, Game.HEIGHT / 2);
				Game.timeTimer = 0;
			}
			
		}
		else
		{
			if((handler.objects.get(1).getID() != GameObjectID.Player))
			{
				g.drawString("Press \"R\" to restart", Game.WIDTH / 2 - 100, Game.HEIGHT / 2);
				Game.timeTimer = 0;
			}
		}
		/*else if((handler.objects.get(1).getID() != GameObjectID.Player))
		{
			g.setColor(Color.white);
			g.drawString("Press \"R\" to restart", Game.WIDTH / 2 - 100, Game.HEIGHT / 2);
			Game.timeTimer = 0;
		}*/
	}

	public static float getRedVal()
	{
		return redVal;
	}
	
	public static float getGreenVal()
	{
		return greenVal;
	}
	
	public static float getBlueVal()
	{
		return blueVal;
	}
	
	@Override
	public void accelerate(int direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void angle(int direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot(int val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub
		
	}

}
