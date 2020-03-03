package com.shootGame.main; 
  
import java.awt.Color; 
import java.awt.Graphics; 
import java.util.LinkedList; 
  
public class Projectile extends GameObject 
{ 
   private Handler handler; 
   protected int x; 
   protected int y; 
   protected double velX;
   protected double velY;
   protected int size; 
   protected double speed; 
   protected double angle; 
   protected Color color; 
   protected float redVal;
   protected float greenVal;
   protected float blueVal;
   protected GameObjectID parentID; 
   protected int timer; 

   
  public Projectile(int x, int y, GameObjectID id, int size, double speed, double someAngle, Handler handler, GameObjectID parentID) 
  { 
    super(x, y, id, size, speed); 
     
    this.x = x; 
    this.y = y; 
    this.size = size; 
    this.speed = speed;
    this.angle = someAngle;
    this.velX = (speed * Math.cos(angle)); 
    this.velY = (speed * Math.sin(angle)); 
    super.velX = this.velX;
    super.velY = this.velY;
    timer = 600; 
    
     
    this.parentID = parentID; 
     
    if (parentID == GameObjectID.Player) 
    { 
      redVal = 0.10F;
      greenVal = 0.10F;
      blueVal = 0.90F;
    } else 
    { 
    	redVal = 0.999F;
        greenVal = 0.00F;
        blueVal = 0.00F;
    } 
    this.color = new Color(redVal, greenVal, blueVal);
    
    this.handler = handler; 
  } 
    
 
 
  public void tick(double delta) 
   { 
	  if ((x + velX > 0.0D) && (x + velX < 1600.0D)) 
     { 
       if ((y + velY > 0.0D) && (y + velY < 900.0D)) 
       { 
    	 velX = (speed * Math.cos(angle)); 
         velY = (speed * Math.sin(angle));
    	 x = ((int)(x + velX * delta)); 
         y = ((int)(y + velY * delta)); 
       } 
       else if (y + velY < 0.0D) 
       { 
    	 angle *= -1.0D; 
         if (angle > 6.283185307179586D) { 
           angle -= 6.283185307179586D; 
         } else if (angle < 0) { 
           angle += 6.283185307179586D; 
         } 
         velX = (speed * Math.cos(angle)); 
         velY = (speed * Math.sin(angle)); 
         x = ((int)(x + velX)); 
         y = ((int)(y + velY)); 
       } 
       else if (y + velY > 900.0D) 
       { 
         angle *= -1.0D; 
         if (angle > 6.283185307179586D) { 
           angle -= 6.283185307179586D; 
         } else if (angle < 0) { 
           angle += 6.283185307179586D; 
         } 
         velX = (speed * Math.cos(angle)); 
         velY = (speed * Math.sin(angle)); 
         x = ((int)(x + velX)); 
         y = ((int)(y + velY)); 
       } 
        
 
    } 
     else if (x + velX < 0.0D) 
     { 
       angle = (-1.0D * (angle - Math.toRadians(180.0D))); 
       if (angle > 6.283185307179586D) { 
         angle -= 6.283185307179586D; 
       } else if (angle < 0) { 
         angle += 6.283185307179586D; 
       } 
       velX = (speed * Math.cos(angle)); 
       velY = (speed * Math.sin(angle)); 
       x = ((int)(x + velX)); 
       y = ((int)(y + velY)); 
     } 
     else if (x + velX > 1600.0D) 
     { 
       angle = (-1.0D * (angle - Math.toRadians(180.0D))); 
       if (angle > 6.283185307179586D) { 
         angle -= 6.283185307179586D; 
       } else if (angle < 0) { 
         angle += 6.283185307179586D; 
       } 
       velX = (speed * Math.cos(angle)); 
       velY = (speed * Math.sin(angle)); 
       x = ((int)(x + velX)); 
       y = ((int)(y + velY)); 
     } 
      
    checkTimer(); 
    checkCollision(); 
   } 
    
 
 
 
  public void checkCollision() 
   { 
     for (int i = 0; i < handler.objects.size(); i++) 
     { 
       GameObject tempObject = (GameObject)handler.objects.get(i); 
       if (tempObject.getID() == GameObjectID.Player) 
       { 
  
        if (Math.hypot(x - tempObject.getX(), y - tempObject.getY()) < tempObject.getRadius() - 5) 
         { 
           handler.clearBoard(); 
         } 
       } 
        
 
 
 
 
 
      if (tempObject.getID() == GameObjectID.enemySentry) 
       { 
         if (parentID == GameObjectID.Player) 
         { 
           if (Math.hypot(x - tempObject.getX(), y - tempObject.getY()) < tempObject.getRadius() - 5) 
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
     if (timer > 0) 
     { 
       timer -= 1; 
       if (parentID == GameObjectID.Player && redVal <= 1.00F - 0.8/timer) 
       {
    	   redVal += 0.8/timer;
    	   greenVal += 0.8/timer;
       }
       else if(parentID == GameObjectID.enemySentry && blueVal <= 1.00F - 0.999/timer) 
       {
    	   blueVal += 0.999/timer;
    	   greenVal += 0.999/timer;
       }
       else
       {
    	   
       }
       
       this.color = new Color(redVal, greenVal, blueVal);
       
     } 
     else 
     { 
       handler.removeObject(this); 
     } 
   } 
    
  public void render(Graphics g) { 
     g.setColor(color); 
     g.drawArc(x, y, size, size, 0, 360); 
     g.fillArc(x, y, size, size, 0, 360); 
   } 
    
 
 
 
  public void angle(int direction) {} 
    
 
 
 
  public void shoot(int val) {} 
    
 
 
 
  public void accelerate(int direction) {} 
    
 
 
 
  public void setColor(String color) 
   { 
     this.color = Color.getColor(color); 
   }



@Override
public double getAngle() 
{
	return angle;
} 
} 
  