package com.shootGame.main; 
  
import java.awt.Color; 
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.GraphicsEnvironment; 
import java.util.LinkedList; 
  
 
public class Ghost 
   extends GameObject 
{ 
   Graphics g;
   Handler handler; 
   //private int x = 0; 
   //private int y = 0; 
   private GameObjectID id = GameObjectID.Ghost; 
   //private int radius = 1; 
   //private double SPEED = 1.0D; 
    
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
     SPEED = 1.0D; 
     
     redVal = 0.01F; 
     redMult = 1; 
     greenVal = 0.05F; 
     greenMult = 1; 
     blueVal = 0.07F; 
     blueMult = 1; 
      
    this.handler = handler; 
   } 
    
 
 
 
 
  public void tick(double delta) {} 
    
 
 
 
  public void render(Graphics g) 
   { 
     this.g = g;
	 redVal = (float)(redVal + 0.001D * redMult); 
     if (redVal > 0.995D) { 
       redMult = -1; 
     } else if (redVal < 0.005D) { 
       redMult = 1; 
     } 
     greenVal = (float)(greenVal + 0.002D * greenMult); 
     if (greenVal > 0.995D) { 
       greenMult = -1; 
     } else if (greenVal < 0.005D) { 
       greenMult = 1; 
     } 
     blueVal = (float)(blueVal + 0.003D * blueMult); 
     if (blueVal > 0.995D) { 
       blueMult = -1; 
     } else if (blueVal < 0.005D) { 
       blueMult = 1; 
     } 
     String[] differentFonts = GraphicsEnvironment.getLocalGraphicsEnvironment() 
       .getAvailableFontFamilyNames(); 
     String comicSans = differentFonts[5]; 
     Font font = new Font(comicSans, 0, 30); 
     g.setFont(font); 
      
 
    Color color = new Color(redVal, greenVal, blueVal); 
      
    g.setColor(color); 
    
    
    
    g.drawString(handler.handlerTime + "", 785, 30); 
      
    if (handler.objects.size() <= 2) 
    { 
       if (handler.objects.size() > 1) 
       { 
         if (((GameObject)handler.objects.get(1)).getID() != GameObjectID.Player) 
         { 
           g.drawString("Press \"R\" to restart", 700, 450); 
           Game.timeTimer = 0.0D; 
         }
         else
         {
        	 
            
         }
          
      } 
       else 
       { 
         g.drawString("Press \"R\" to restart", 700, 450); 
         Game.timeTimer = 0.0D; 
  
       } 
        
        
     } 
     else if (((GameObject)handler.objects.get(1)).getID() != GameObjectID.Player) 
     { 
       g.drawString("Press \"R\" to restart", 700, 450); 
       Game.timeTimer = 0.0D; 
     } 
     
    if (handler.getSize() > 1) 
    { 
    	g.drawLine(
     			  (int)((((GameObject)handler.objects.get(1)).getX()) + (((GameObject)handler.objects.get(1)).getRadius() * Math.cos(((GameObject)handler.objects.get(1)).getAngle()))), 
     			  (int)((((GameObject)handler.objects.get(1)).getY()) + (((GameObject)handler.objects.get(1)).getRadius() * Math.sin(((GameObject)handler.objects.get(1)).getAngle()))), 
     			  (int)((((GameObject)handler.objects.get(1)).getX()) + (45 * Math.cos(((GameObject)handler.objects.get(1)).getAngle()))), 
     			  (int)((((GameObject)handler.objects.get(1)).getY()) + (45 * Math.sin(((GameObject)handler.objects.get(1)).getAngle())))
     			  );
    }
    
    
    
    
     
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
    
  public void accelerate(int direction) {} 
    
  public void angle(int direction) {} 
    
  public void shoot(int val) {} 
    
  public void setColor(String color) {}





@Override
public double getAngle() 
{
	return 0.0;
} 
} 
  