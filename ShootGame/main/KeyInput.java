package com.shootGame.main; 
  
import java.awt.event.KeyEvent; 
import java.util.LinkedList; 
  
public class KeyInput extends java.awt.event.KeyAdapter 
{ 
   private Handler handler; 
   private Game game; 
   private Window window; 
   public boolean checkingPress; 
   public boolean checkingRelease; 
    
  private int leftIsDown; 
   private int rightIsDown; 
   private int upIsDown; 
   private int downIsDown; 
   private int shootIsDown; 
    
  private int moveSum; 
   private int turnSum; 
    
  public KeyInput(Handler handler, Game game, Window window) 
   { 
     System.out.println("Key Input Constructing..."); 
     this.handler = handler; 
     this.game = game; 
     this.window = window; 
     System.out.println("Key Input Constructed."); 
     checkingPress = true; 
     checkingRelease = false; 
   } 
    
 
  public void keyPressed(KeyEvent e) 
   { 
     int key = e.getKeyCode(); 
        for (int i = 0; i < handler.objects.size(); i++) 
        { 
          GameObject tempObject = (GameObject)handler.objects.get(i); 
          if(tempObject.getID() == GameObjectID.Player) 
          { 
            if(key == KeyEvent.VK_W) 
            { 
              upIsDown = 1; 
            } 
            else if(!(key != KeyEvent.VK_W || key != KeyEvent.VK_S || key != KeyEvent.VK_A || key != KeyEvent.VK_D)) 
            { 
              upIsDown = 0; 
            } 
            if(key == KeyEvent.VK_D)  
           { 
              rightIsDown = 1; 
            } 
            if (key == KeyEvent.VK_A)  
           { 
              leftIsDown = 1; 
            } 
            if (key == KeyEvent.VK_S) 
            { 
              downIsDown = 1; 
            } 
            if (key == KeyEvent.VK_SPACE)  
           { 
              shootIsDown = 1; 
            } 
            if (key == KeyEvent.VK_F) 
            { 
               System.out.println(tempObject.getID() + ":  " + " Heading: " + tempObject.getHeading() + " - Going: " + tempObject.getGoing() + " - Velocity of X: " + tempObject.getVelX() + ", Velosity for Y: " + tempObject.getVelY() + " X: " + tempObject.getX() + " Y: " + tempObject.getY()); 
            } 
            
          } 
          if (key == KeyEvent.VK_R) 
          { 
            handler.restart(); 
          } 
        
         if (key == KeyEvent.VK_G) 
          { 
            System.out.print("\n"); 
            System.out.println("Game Objects: "); 
            for (int j = 0; j < handler.objects.size(); j++) 
            { 
              GameObject thisObject = (GameObject)handler.objects.get(j); 
              System.out.println(thisObject.getID()); 
            } 
            System.out.print("\n"); 
          } 
           
         keyInterpret(tempObject); 
        } 
    } 
  
 
  public void keyReleased(KeyEvent e) 
   { 
     int key = e.getKeyCode(); 
         
       for (int i = 0; i < handler.objects.size(); i++) 
        { 
          GameObject tempObject = (GameObject)handler.objects.get(i); 
        
         if (tempObject.getID() == GameObjectID.Player) 
          { 
  
           if(key == KeyEvent.VK_W) 
            { 
               upIsDown = 0; 
            } 
            if(key == KeyEvent.VK_D) 
            { 
              rightIsDown = 0; 
            } 
            if(key == KeyEvent.VK_A)  
           { 
              leftIsDown = 0; 
            } 
            if (key == KeyEvent.VK_S) 
            { 
              downIsDown = 0; 
            } 
            if (key == KeyEvent.VK_SPACE)  
           { 
              shootIsDown = 0; 
            } 
          } 
           
         keyInterpret(tempObject); 
        } 
    } 
     
   public void keyInterpret(GameObject tempObject) 
    { 
       moveSum = upIsDown - downIsDown; 
       turnSum = rightIsDown - leftIsDown; 
        
      tempObject.accelerate(moveSum); 
       tempObject.angle(turnSum); 
       tempObject.shoot(shootIsDown); 
    } 
  } 
  
