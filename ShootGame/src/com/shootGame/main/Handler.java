package com.shootGame.main; 
  
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.GraphicsEnvironment; 
import java.util.LinkedList; 
  
 
public class Handler 
{ 
   LinkedList<GameObject> objects = new LinkedList(); 
    
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
    
  public Handler() {System.out.println("Handler constructed.");} 
    
  public void tick(double delta)  
  {  
    for (int i = 0; i < objects.size(); i++) 
     { 
       GameObject tempObject = (GameObject)objects.get(i); 
       if(objects.size() > 1) 
       { 
          handlerTime = Game.time; 
          Game.timeTimer = 1.0; 
       } 
        
      tempObject.tick(delta); 
  
    } 
      
 
 
    if ((handlerTime >= 7.0D) && (eventSeven)) 
     { 
  
      eventSeven = false; 
        
      addObject(new enemySentry(800, 800, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       System.out.println("Event Seven Initiated."); 
     } 
     if ((handlerTime >= 15.0D) && (eventFifteen)) 
     { 
       eventFifteen = false; 
        
      addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       System.out.println("Event Fifteen Initiated."); 
     } 
     if ((handlerTime >= 20.0D) && (eventTwenty)) 
     { 
       eventTwenty = false; 
        
      addObject(new enemySentry(400, 800, GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
       addObject(new enemySentry(400, 800, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       System.out.println("Event Twenty Initiated."); 
     } 
     if ((handlerTime >= 26.0D) && (eventTwentySeven)) 
     { 
       eventTwentySeven = false; 
        
      addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
       addObject(new enemySentry(1200, 200, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       addObject(new enemySentry(800, 800, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       System.out.println("Event Twenty-Six Initiated."); 
     } 
     if ((handlerTime >= 35.0D) && (eventThirtyFive)) 
     { 
       eventThirtyFive = false; 
        
      addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
       addObject(new enemySentry(200, 700, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       addObject(new enemySentry(800, 200, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       addObject(new enemySentry(800, 700, GameObjectID.enemySentry, 40, 1.0D, this, "orange")); 
       System.out.println("Event Thirty-Five Initiated."); 
     } 
     if ((handlerTime >= 45.0D) && (eventFortyFive)) 
     { 
       eventFortyFive = false; 
        
      addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(200, 700, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(300, 500, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       addObject(new enemySentry(341, 900, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       System.out.println("Event Forty-Five Initiated."); 
     } 
     if ((handlerTime >= 55.0D) && (eventFiftyFive)) 
     { 
       eventFiftyFive = false; 
        
      addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(200, 400, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(200, 600, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       addObject(new enemySentry(1000, 200, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       addObject(new enemySentry(1000, 400, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       addObject(new enemySentry(1000, 600, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       System.out.println("Event Fifty-Five Initiated."); 
     } 
     if ((handlerTime >= 65.0D) && (eventSixtyFive)) 
     { 
       eventSixtyFive = false; 
        
      addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 50, 1.0D, this, "orange")); 
       addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 35, 1.0D, this, "orange")); 
       addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 30, 1.0D, this, "red")); 
       addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 25, 1.0D, this, "orange")); 
       addObject(new enemySentry(1000, 500, GameObjectID.enemySentry, 20, 1.0D, this, "red")); 
       System.out.println("Event Sixty-Five Initiated."); 
     } 
     if ((handlerTime >= 75.0D) && (eventSeventyFive)) 
     { 
       eventSeventyFive = false; 
        
      addObject(new enemySentry(200, 200, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(300, 200, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(400, 200, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(500, 200, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(200, 900, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(300, 900, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(400, 900, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       addObject(new enemySentry(500, 900, GameObjectID.enemySentry, 25, 1.0D, this, "red")); 
       System.out.println("Event Seventy-Five Initiated."); 
     } 
     if ((handlerTime >= 85.0D) && (eventEightyFive)) 
     { 
       eventEightyFive = false; 
        
      addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
       addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
       addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
       addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
       addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
       addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
       addObject(new enemySentry(1004, 1004, GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
       addObject(new enemySentry(1004, 1004, GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
       addObject(new enemySentry(1005, 1005, GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
       addObject(new enemySentry(1005, 1005, GameObjectID.enemySentry, 40, 1.0D, this, "green")); 
       addObject(new enemySentry(1006, 1006, GameObjectID.enemySentry, 40, 1.0D, this, "white")); 
       addObject(new enemySentry(1006, 1006, GameObjectID.enemySentry, 40, 1.0D, this, "yellow")); 
       System.out.println("Event Eighty-five Initiated."); 
     } 
     if ((handlerTime >= 95.0D) && (eventNinetyFive)) 
     { 
       eventNinetyFive = false; 
        
      addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(1001, 1001, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(1002, 1002, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(1003, 1003, GameObjectID.enemySentry, 40, 1.0D, this, "red")); 
       addObject(new enemySentry(104, 104, GameObjectID.enemySentry, 40, 1.0D, this, "blue")); 
       addObject(new enemySentry(104, 104, GameObjectID.enemySentry, 40, 1.0D, this, "blue")); 
       addObject(new enemySentry(105, 105, GameObjectID.enemySentry, 40, 1.0D, this, "blue")); 
       addObject(new enemySentry(105, 105, GameObjectID.enemySentry, 40, 1.0D, this, "blue")); 
       addObject(new enemySentry(106, 106, GameObjectID.enemySentry, 40, 1.0D, this, "blue")); 
       addObject(new enemySentry(106, 106, GameObjectID.enemySentry, 40, 1.0D, this, "blue")); 
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
    
 
  public void render(Graphics g) 
   { 
     for (int i = 0; i < objects.size(); i++) 
     { 
       GameObject tempObject = (GameObject)objects.get(i); 
        
      tempObject.render(g); 
     } 
      
    if (objects.size() == 1) 
     { 
       String[] differentFonts = GraphicsEnvironment.getLocalGraphicsEnvironment() 
         .getAvailableFontFamilyNames(); 
       String comicSans = differentFonts[6]; 
       Font font = new Font(comicSans, 0, 30); 
       g.setColor(new Color(Ghost.redVal, Ghost.greenVal, Ghost.blueVal)); 
       g.setFont(font); 
       g.drawString("Your time was:    " + handlerTime + " seconds", 640, 400); 
     } 
   } 
    
 
 
  public void restart() 
   { 
     int size = objects.size(); 
      
 
 
 
 
 
 
    while (objects.size() > 1) 
     { 
       GameObject tempObject = (GameObject)objects.get(objects.size() - 1); 
       removeObject(tempObject); 
     } 
      
    Game.startTime = System.currentTimeMillis(); 
     Game.time = 0; 
     handlerTime = 0.0; 
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
   } 
    
  public void clearBoard() 
   { 
     while (objects.size() > 1)                                                // each iteration of this loop removes the last game object in the linkedlist "objects" until there is only the first object of the linkedlist remaining, which is always the "ghost" object 
     { 
       GameObject tempObject = (GameObject)objects.get(objects.size() - 1); 
       removeObject(tempObject); 
     } 
   } 
    
  public void addObject(GameObject object) 
   { 
     objects.add(object); 
   } 
    
  public void removeObject(GameObject object) 
   { 
     objects.remove(object); 
   } 
} 
  