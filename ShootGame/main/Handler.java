package com.shootGame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.util.LinkedList;

public class Handler 
{
	LinkedList<GameObject> objects = new LinkedList<GameObject>();                   // could be an ArrayList but that would be slower
	
	private boolean eventSeven = true;
	private boolean eventFifteen = true;
	private boolean eventTwenty = true;
	private boolean eventTwentySeven = true;
	private boolean eventThirtyFive = true;
	private boolean eventFortyFive = true;
	private boolean eventFiftyFive = true;
	private boolean eventSixtyFive = true;
	private boolean eventSeventyFive = true;
	private boolean eventEightyFive = true;
	private boolean eventNinetyFive = true;
	private boolean eventHundredFive = true;
	private boolean eventHundredTwenty = true;
	
	public void tick(double delta)
	{	
		for(int i = 0; i < objects.size(); i++)
		{
			GameObject tempObject = objects.get(i);
			
			tempObject.tick(delta);
			// System.out.println("yes");
			
		}
		
		if(Game.time == 7 && eventSeven)
		{
			//System.out.println("7");
			eventSeven = false;
			
			addObject(new enemySentry(800, 800, GameObjectID.enemySentry, 30, 1, this, "red"));
		}
		if(Game.time == 15 && eventFifteen)
		{
			eventFifteen = false;
			
			addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 30, 1, this, "red"));
		}
		if(Game.time == 20 && eventTwenty)
		{
			eventTwenty = false;
			
			addObject(new enemySentry(400, 800, GameObjectID.enemySentry, 40, 1, this, "orange"));
			addObject(new enemySentry(400, 800, GameObjectID.enemySentry, 30, 1, this, "red"));
		}
		if(Game.time == 26 && eventTwentySeven)
		{
			eventTwentySeven = false;
			
			addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 40, 1, this, "orange"));
			addObject(new enemySentry(1200, 200, GameObjectID.enemySentry, 30, 1, this, "red"));
			addObject(new enemySentry(800, 800, GameObjectID.enemySentry, 30, 1, this, "red"));
		}
		if(Game.time == 35 && eventThirtyFive)
		{
			eventThirtyFive = false;
			
			addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 40, 1, this, "orange"));
			addObject(new enemySentry(200, 700, GameObjectID.enemySentry, 30, 1, this, "red"));
			addObject(new enemySentry(800, 200, GameObjectID.enemySentry, 30, 1, this, "red"));
			addObject(new enemySentry(800, 700, GameObjectID.enemySentry, 40, 1, this, "orange"));
		}
		if(Game.time == 45 && eventFortyFive)
		{
			eventFortyFive = false;
			
			addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(200, 700, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(300, 500, GameObjectID.enemySentry, 20, 1, this, "red"));
			addObject(new enemySentry(341, 900, GameObjectID.enemySentry, 20, 1, this, "red"));
		}
		if(Game.time == 55 && eventFiftyFive)
		{
			eventFiftyFive = false;
			
			addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(200, 400, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(200, 600, GameObjectID.enemySentry, 20, 1, this, "red"));
			addObject(new enemySentry(1000, 200, GameObjectID.enemySentry, 20, 1, this, "red"));
			addObject(new enemySentry(1000, 400, GameObjectID.enemySentry, 20, 1, this, "red"));
			addObject(new enemySentry(1000, 600, GameObjectID.enemySentry, 20, 1, this, "red"));
		}
		if(Game.time == 65 && eventSixtyFive)
		{
			eventSixtyFive = false;
			
			addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 50, 1, this, "orange"));
			addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 35, 1, this, "orange"));
			addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 30, 1, this, "red"));
			addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 25, 1, this, "orange"));
			addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 20, 1, this, "red"));
		}
		if(Game.time == 75 && eventSeventyFive)
		{
			eventSeventyFive = false;
			
			addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(300, 200, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(400, 200, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(500, 200, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(200, 900, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(300, 900, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(400, 900, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(500, 900, GameObjectID.enemySentry, 25, 1, this, "red"));
		}
		if(Game.time == 85 && eventEightyFive)
		{
			eventEightyFive = false;
			
			addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1, this, "green"));
			addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1, this, "white"));
			addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1, this, "yellow"));
			addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1, this, "green"));
			addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1, this, "white"));
			addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1, this, "yellow"));
			addObject(new enemySentry(1004, 1004, GameObjectID.enemySentry, 40, 1, this, "green"));
			addObject(new enemySentry(1004, 1004, GameObjectID.enemySentry, 40, 1, this, "white"));
			addObject(new enemySentry(1005, 1005, GameObjectID.enemySentry, 40, 1, this, "yellow"));
			addObject(new enemySentry(1005, 1005, GameObjectID.enemySentry, 40, 1, this, "green"));
			addObject(new enemySentry(1006, 1006, GameObjectID.enemySentry, 40, 1, this, "white"));
			addObject(new enemySentry(1006, 1006, GameObjectID.enemySentry, 40, 1, this, "yellow"));
		}
		if(Game.time == 95 && eventNinetyFive)
		{
			eventNinetyFive = false;
			
			addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1, this, "red"));
			addObject(new enemySentry(104, 104, GameObjectID.enemySentry, 40, 1, this, "blue"));
			addObject(new enemySentry(104, 104, GameObjectID.enemySentry, 40, 1, this, "blue"));
			addObject(new enemySentry(105, 105, GameObjectID.enemySentry, 40, 1, this, "blue"));
			addObject(new enemySentry(105, 105, GameObjectID.enemySentry, 40, 1, this, "blue"));
			addObject(new enemySentry(106, 106, GameObjectID.enemySentry, 40, 1, this, "blue"));
			addObject(new enemySentry(106, 106, GameObjectID.enemySentry, 40, 1, this, "blue"));
		}
		if(Game.time == 105 && eventHundredFive)
		{
			eventHundredFive = false;
			
			addObject(new enemySentry(1001, 100, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(1001, 200, GameObjectID.enemySentry, 25, 1, this, "white"));
			addObject(new enemySentry(1002, 300, GameObjectID.enemySentry, 25, 1, this, "blue"));
			addObject(new enemySentry(1002, 400, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(1003, 500, GameObjectID.enemySentry, 25, 1, this, "white"));
			addObject(new enemySentry(1003, 550, GameObjectID.enemySentry, 25, 1, this, "blue"));
			addObject(new enemySentry(104, 600, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(104, 650, GameObjectID.enemySentry, 25, 1, this, "white"));
			addObject(new enemySentry(105, 700, GameObjectID.enemySentry, 25, 1, this, "blue"));
			addObject(new enemySentry(105, 800, GameObjectID.enemySentry, 25, 1, this, "red"));
			addObject(new enemySentry(106, 900, GameObjectID.enemySentry, 25, 1, this, "white"));
			addObject(new enemySentry(106, 1000, GameObjectID.enemySentry, 25, 1, this, "blue"));
		}
		if(Game.time == 120 && eventHundredTwenty)
		{
			// purposely left this without the check
			
			addObject(new enemySentry(Game.WIDTH / 2, Game.HEIGHT / 2, GameObjectID.enemySentry, 50, 1, this, "red"));
			addObject(new enemySentry(Game.WIDTH / 2, Game.HEIGHT / 2, GameObjectID.enemySentry, 30, 1, this, "white"));
			addObject(new enemySentry(Game.WIDTH / 2, Game.HEIGHT / 2, GameObjectID.enemySentry, 20, 1, this, "blue"));
			
		}
	}
	
	public void render(Graphics g)
	{
		for(int i = 0; i < objects.size(); i++)
		{
			GameObject tempObject = objects.get(i);
			
			tempObject.render(g);
		}
		
		if(objects.size() == 1)
		{
			String[] differentFonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
			        .getAvailableFontFamilyNames();
			String comicSans = differentFonts[6];
		    Font font = new Font(comicSans, Font.PLAIN, 30);
		    g.setColor(new Color(Ghost.redVal, Ghost.greenVal, Ghost.blueVal));
		    g.setFont(font);
		    g.drawString("Your time was:    " + Game.time + " seconds", Game.WIDTH / 2 - 160, Game.HEIGHT / 2 - 50);
		}
	}
	
	
	public void restart()
	   {
		   
		   int size = objects.size();
		   /*
		   for(int i = size; i > 0; i--)
		   {
			   handler.removeObject(handler.objects.get(i));
		   }
		   */
		   
		   while(objects.size() > 1)
		   {
			   GameObject tempObject = (objects.get(objects.size() - 1));
			   removeObject(tempObject);
		   }
		   
		   Game.time = 0;
		   Game.timeTimer = 1;
		   eventSeven = true;
		   eventFifteen = true;
		   eventTwenty = true;
		   eventTwentySeven = true;
		   eventThirtyFive = true;
		   eventFortyFive = true;
			eventFiftyFive = true;
			eventSixtyFive = true;
			eventSeventyFive = true;
			eventEightyFive = true;
			eventNinetyFive = true;
			eventHundredFive = true;
			eventHundredTwenty = true;
		   addObject(new Player(Game.WIDTH / 2, Game.HEIGHT / 2, GameObjectID.Player, 25, 2, this, "blue"));
	   }
	
	public void clearBoard()
	{
		while(objects.size() > 1)
		   {
			   GameObject tempObject = (objects.get(objects.size() - 1));
			   removeObject(tempObject);
		   }
	}
	
	public void addObject(GameObject object)
	{
		this.objects.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.objects.remove(object);
	}
}
