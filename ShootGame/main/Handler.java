package com.shootGame.main; 
  
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.GraphicsEnvironment; 
import java.util.LinkedList; 
  
 
public class Handler 
{ 
	private String menuState;         // "mainMenu", "game", "gameMenu", "dead"
	Game game;
	MyMenu menu;
	LinkedList<GameObject> objects = new LinkedList<GameObject>(); 
   
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
   public static double handlerTime; 
   public double pauseTime;
   public int size;
    
   public Handler(Game game) 
   {
      System.out.println("Handler constructed.");
	  menuState = "mainMenu";
	  this.game = game;
	  menu = new MyMenu(this.game, this, "mainMenu");
   } 
    
   public void tick(double delta)  
   {  
      if(menuState.equals("game"))
	  {
	     size = objects.size(); 
		 for (int i = 0; i < objects.size(); i++) 
	     { 
            GameObject tempObject = (GameObject)objects.get(i); 
	        
			tempObject.tick(delta); 
			handlerTime = Game.time;
	     } 
	      
	 
	 
	     if ((handlerTime >= 7.0D) && (eventSeven)) 
	     { 
	  
	        eventSeven = false; 
	        
	        addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	        System.out.println("Event Seven Initiated. Codes: " + GameInfo.getWidthCodes()[5] + ", " + GameInfo.getHeightCodes()[3]); 
	     } 
	     if ((handlerTime >= 15.0D) && (eventFifteen)) 
	     { 
	        eventFifteen = false; 
	        
	        addObject(new enemySentry(GameInfo.getWidthCodes()[5], GameInfo.getHeightCodes()[5], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	        System.out.println("Event Fifteen Initiated."); 
	     } 
	     if ((handlerTime >= 20.0D) && (eventTwenty)) 
	     { 
	        eventTwenty = false; 
	        
	        addObject(new enemySentry(GameInfo.getWidthCodes()[5], GameInfo.getHeightCodes()[27], GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
	        addObject(new enemySentry(GameInfo.getWidthCodes()[5], GameInfo.getHeightCodes()[27], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	        System.out.println("Event Twenty Initiated."); 
	     } 
	     if ((handlerTime >= 26.0D) && (eventTwentySeven)) 
	     { 
	       eventTwentySeven = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[48], GameInfo.getHeightCodes()[27], GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[36], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[24], GameInfo.getHeightCodes()[9], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	       System.out.println("Event Twenty-Six Initiated."); 
	     } 
	     if ((handlerTime >= 35.0D) && (eventThirtyFive)) 
	     { 
	       eventThirtyFive = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[8], GameInfo.getHeightCodes()[32], GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[16], GameInfo.getHeightCodes()[32], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[48], GameInfo.getHeightCodes()[32], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[56], GameInfo.getHeightCodes()[32], GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
	       System.out.println("Event Thirty-Five Initiated."); 
	     } 
	     if ((handlerTime >= 45.0D) && (eventFortyFive)) 
	     { 
	       eventFortyFive = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[10], GameInfo.getHeightCodes()[10], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[10], GameInfo.getHeightCodes()[15], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[58], GameInfo.getHeightCodes()[10], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[58], GameInfo.getHeightCodes()[15], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       System.out.println("Event Forty-Five Initiated."); 
	     } 
	     if ((handlerTime >= 55.0D) && (eventFiftyFive)) 
	     { 
	       eventFiftyFive = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[5], GameInfo.getHeightCodes()[3], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[15], GameInfo.getHeightCodes()[9], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[25], GameInfo.getHeightCodes()[15], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[35], GameInfo.getHeightCodes()[21], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[45], GameInfo.getHeightCodes()[27], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[55], GameInfo.getHeightCodes()[33], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       System.out.println("Event Fifty-Five Initiated."); 
	     } 
	     if ((handlerTime >= 65.0D) && (eventSixtyFive)) 
	     { 
	       eventSixtyFive = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 70, 1.0D, this, "orange")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 50, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 35, 1.0D, this, "orange")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 25, 1.0D, this, "orange")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[32], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
	       System.out.println("Event Sixty-Five Initiated."); 
	     } 
	     if ((handlerTime >= 75.0D) && (eventSeventyFive)) 
	     { 
	       eventSeventyFive = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[40], GameInfo.getHeightCodes()[20], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[16], GameInfo.getHeightCodes()[10], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[25], GameInfo.getHeightCodes()[17], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[8], GameInfo.getHeightCodes()[28], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[33], GameInfo.getHeightCodes()[5], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[60], GameInfo.getHeightCodes()[12], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[60], GameInfo.getHeightCodes()[27], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[51], GameInfo.getHeightCodes()[5], GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       System.out.println("Event Seventy-Five Initiated."); 
	     } 
	     if ((handlerTime >= 85.0D) && (eventEightyFive)) 
	     { 
	       eventEightyFive = false; 
	        
	       addObject(new enemySentry(GameInfo.getWidthCodes()[2], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[6], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[10], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[14], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[18], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[22], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[26], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[30], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[34], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[38], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[42], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
	       addObject(new enemySentry(GameInfo.getWidthCodes()[46], GameInfo.getHeightCodes()[18], GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
	       System.out.println("Event Eighty-five Initiated."); 
	     } 
	     if ((handlerTime >= 95.0D) && (eventNinetyFive)) 
	     { 
	       eventNinetyFive = false; 
	       for(int i = 0; i < 9; i++)
	       {
	    	   int randomX = 3 + (int)(Math.random() * 58);
	    	   int randomY = 2 + (int)(Math.random() * 34);
	    	   addObject(new enemySentry(GameInfo.getWidthCodes()[randomX], GameInfo.getHeightCodes()[randomY], GameObjectID.enemySentry, 40, 1.0D, this, "red"));
	       }
	    	   
	       
	       System.out.println("Event Ninety-Five Initiated."); 
	     } 
	     if ((handlerTime >= 105.0D) && (eventHundredFive)) 
	     { 
	       eventHundredFive = false; 
	        
	       addObject(new enemySentry(1001, 100, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(1001, 200, GameObjectID.enemySentry, 25, 1.0D, this, "white")); 
	       addObject(new enemySentry(1002, 300, GameObjectID.enemySentry, 25, 1.0D, this, "blue")); 
	       addObject(new enemySentry(1002, 400, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(1003, 500, GameObjectID.enemySentry, 25, 1.0D, this, "white")); 
	       addObject(new enemySentry(1003, 550, GameObjectID.enemySentry, 25, 1.0D, this, "blue")); 
	       addObject(new enemySentry(104, 600, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(104, 650, GameObjectID.enemySentry, 25, 1.0D, this, "white")); 
	       addObject(new enemySentry(105, 700, GameObjectID.enemySentry, 25, 1.0D, this, "blue")); 
	       addObject(new enemySentry(105, 800, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
	       addObject(new enemySentry(106, 900, GameObjectID.enemySentry, 25, 1.0D, this, "white")); 
	       addObject(new enemySentry(106, 1000, GameObjectID.enemySentry, 25, 1.0D, this, "blue")); 
	       System.out.println("Event One Hundred Five Initiated."); 
	     } 
	     if ((handlerTime >= 120.0D) && (eventHundredTwenty)) 
	     { 
	  
	 
	       addObject(new enemySentry(800, 450, GameObjectID.enemySentry, 50, 1.0D, this, "red")); 
	       addObject(new enemySentry(800, 450, GameObjectID.enemySentry, 30, 1.0D, this, "white")); 
	       addObject(new enemySentry(800, 450, GameObjectID.enemySentry, 20, 1.0D, this, "blue")); 
	       System.out.println("Event One Hundred Twenty Initiated."); 
	     } 
	 }
	  
	 
   } 
    
 
   public void render(Graphics g) 
   { 
     
      if(menuState.equals("mainMenu"))
	  {
	     menu.render(g);
	  }
	  else
	  {
	     for (int i = 0; i < objects.size(); i++) 
	     { 
	        GameObject tempObject = (GameObject)objects.get(i); 
	        
	        tempObject.render(g); 
	     } 
	      
	     if (objects.size() == 1) 
	     { 
	        String[] differentFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	        String comicSans = differentFonts[6]; 
	        Font font = new Font(comicSans, 0, 30); 
	        g.setColor(new Color(Ghost.redVal, Ghost.greenVal, Ghost.blueVal)); 
	        g.setFont(font); 
	        g.drawString("Your time was:    " + handlerTime + " seconds", 640, 400); 
	     } 
	 }
	 
   } 
    
 
 
   public void restart() 
   { 
      size = 1;
 
      while (objects.size() > 1) 
      { 
         GameObject tempObject = (GameObject)objects.get(objects.size() - 1); 
         removeObject(tempObject); 
      } 
      
      Game.startTime = System.currentTimeMillis(); 
      Game.time = 0; 
      handlerTime = 0.0; 
      Game.pauseRunningTime = 0.0;
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
      addObject(new Player(800, 450, GameObjectID.Player, 25, 2.0D, this, "blue")); 
      this.unpause();
   } 
    
   public void clearBoard() 
   { 
      while (objects.size() > 1)                                                // each iteration of this loop removes the last game object in the linkedlist "objects" until there is only the first object of the linkedlist remaining, which is always the "ghost" object 
      { 
         GameObject tempObject = (GameObject)objects.get(objects.size() - 1); 
         removeObject(tempObject); 
      } 
     
      size = objects.size(); 
      this.pause();
   } 
    
   public void addObject(GameObject object) 
   { 
      objects.add(object); 
   } 
    
   public void removeObject(GameObject object) 
   { 
      objects.remove(object); 
   } 
  
   public void pause()
   {
	  pauseTime = handlerTime;
	  if(!playerIsDead())
	     menuState = "gameMenu";
	  else if(playerIsDead())
		 menuState = "dead";
		  
   }
   public void unpause()
   {
	  pauseTime = 0;
	  menuState = "game";
  }
  
  public boolean playerIsDead() 
  {
	  if (size == 1)
		  return true;
	  else
		  return false;
  }
  public int getSize()
  {
	  return objects.size();
  }
  public void setMenuState(String state)
  {
	  menuState = state;
  }
  public String getMenuState()
  {
	  return menuState;
  }
  public void setMenu(MyMenu menu)
  {
	  this.menu = menu;
  }
} 
  