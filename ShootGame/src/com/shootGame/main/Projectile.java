package com.shootGame.main; 
  
import java.awt.Color; 
import java.awt.Graphics; 
import java.util.LinkedList; 
  
public class Projectile extends GameObject 
{ 
   private Handler handler; 
   protected int x; 
   protected int y; 
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
     velX = (speed * Math.cos(angle)); 
     velY = (speed * Math.sin(angle)); 
     timer = 600; 
      
    this.parentID = parentID; 
      
    if (parentID == GameObjectID.Player) { 
       this.color = Color.white; 
     } else { 
       this.color = Color.red; 
     } 
     this.handler = handler; 
   } 
    
 
 
  public void tick(double delta) 
   { 
     if ((x + velX > 0.0D) && (x + velX < 1600.0D)) 
     { 
       if ((y + velY > 0.0D) && (y + velY < 900.0D)) 
       { 
         x = ((int)(x + velX)); 
         y = ((int)(y + velY)); 
       } 
       else if (y + velY < 0.0D) 
       { 
         angle *= -1.0D; 
         if (angle > 6.283185307179586D) { 
           angle -= 6.283185307179586D; 
         } else if (angle < 6.283185307179586D) { 
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
         } else if (angle < 6.283185307179586D) { 
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
       } else if (angle < 6.283185307179586D) { 
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
       } else if (angle < 6.283185307179586D) { 
         angle += 6.283185307179586D; 
       } 
       velX = (speed * Math.cos(angle)); 
       velY = (speed * Math.sin(angle)); 
       x = ((int)(x + velX)); 
       y = ((int)(y + velY)); 
     } 
      
    checkTimer(); 
     checkCollision(); 
      
    x = ((int)(x + velX)); 
     y = ((int)(y + velY)); 
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
} 
  