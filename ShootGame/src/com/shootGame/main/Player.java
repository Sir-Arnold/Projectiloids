package com.shootGame.main; 
  
import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Polygon; 
import java.util.LinkedList; 
import java.util.Vector; 
  
 
 
 
public class Player 
   extends GameObject 
{ 
   private Handler handler; 
   protected int radius; 
   protected double speed; 
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
   
   private int VHX; 
   private int VHY; 
   private int VAX; 
   private int VAY; 
   private int VCX; 
   private int VCY; 
   private int VFX; 
   private int VFY; 
   private int VEX; 
   private int VEY; 
   
   private Color color; 
   
   int[] xArray = new int[6]; 
   int[] yArray = new int[6]; 
    
 
 
 
  public Player(int x, int y, GameObjectID id, int size, double speed, Handler handler, String color) 
   { 
     super(x, y, id, size, speed); 
      
    radius = ((int)Math.sqrt(0 + (size - 0) * (size - 0))); 
     apothom = Math.cos(Math.toRadians(45.0D)); 
     angle = 0.0D; 
      
    delta = 1.0D; 
      
    vel = 0.0D; 
     velX = 0.0D; 
     velY = 0.0D; 
      
    velTurn = 0.0D; 
     velTurnMax = 0.8D; 
      
    maxVel = 100.0D; 
     acceleration = 10.0D; 
     angleChange = 0.2D; 
      
    this.color = Color.blue; 
      
 
    shooting = 0; 
      
    speedGuage = 0.75D; 
     turnSensitivity = 0.2D; 
      
    buildBody(); 
      
    this.handler = handler; 
   } 
    
 
 
 
 
 
  public void tick(double delta) 
   { 
     this.delta = delta; 
      
    velTurn = velTurnGoal; 
      
    angle += velTurn * delta * turnSensitivity; 
      
    if (angle > 6.283185307179586D) { 
       angle -= 6.283185307179586D; 
     } else if (angle < 6.283185307179586D) { 
       angle += 6.283185307179586D; 
     } 
     if ((direction != 1.0D) && (direction != -1.0D)) { 
       vel *= 0.99D; 
     } 
     vel = approach(velGoal, vel, delta); 
      
    velX = (vel * Math.cos(angle)); 
     velY = (vel * Math.sin(angle)); 
      
    if (x + velX * delta - radius > 0.0D) 
     { 
       if (x + velX * delta * speedGuage + radius < 1600.0D) 
       { 
         x = ((int)(x + velX * delta * speedGuage)); 
       } 
     } 
     if (y + velY * delta - radius > 0.0D) 
     { 
       if (y + velY * delta * speedGuage + radius < 900.0D) 
       { 
         y = ((int)(y + velY * delta * speedGuage)); 
       } 
     } 
      
 
    buildBody(); 
      
    if (bulletCoolDown > 0.0D) 
     { 
       bulletCoolDown -= delta; 
       color = Color.red; 
     } 
     else 
     { 
       bulletCoolDown = 0.0D; 
       color = Color.blue; 
        
      if (shooting == 1) 
       { 
         makeProjectile(x, y, angle); 
         bulletCoolDown = 30.0D; 
       } 
     } 
   } 
    
 
 
  public void render(Graphics g) 
   { 
     if ((handler.objects.size() > 1) && (id == GameObjectID.Player)) 
     { 
       Polygon tempShape = new Polygon(xArray, yArray, 6); 
       g.setColor(Color.CYAN); 
        
      g.drawPolygon(tempShape); 
       g.fillPolygon(tempShape); 
     } 
   } 
    
 
  public double approach(double goal, double current, double deltaTime) 
   { 
     double difference = goal - current; 
      
    if (difference > deltaTime) 
       return current + deltaTime; 
     if (difference < -deltaTime) { 
       return current - deltaTime; 
     } 
     return goal; 
   } 
    
  public void accelerate(int direction) 
   { 
     if (direction == 1) 
     { 
       this.direction = 1.0D; 
       velGoal = acceleration; 
       if (vel > maxVel) { 
         vel = maxVel; 
       } 
     } else if (direction == -1) 
     { 
       this.direction = -1.0D; 
       velGoal = (-acceleration); 
       if (vel < -maxVel) { 
         vel = (-maxVel); 
       } 
     } else if (direction == 0) 
     { 
       this.direction = 0.0D; 
       velGoal = 0.0D; 
     } 
   } 
    
  public void angle(int direction) 
   { 
     if (direction == 1) 
     { 
       turnDirection = 1; 
       velTurnGoal += angleChange; 
       if (velTurnGoal > velTurnMax) { 
         velTurnGoal = velTurnMax; 
       } 
     } else if (direction == -1) 
     { 
       turnDirection = -1; 
       velTurnGoal -= angleChange; 
       if (velTurnGoal < -velTurnMax) { 
         velTurnGoal = (-velTurnMax); 
       } 
     } else if (direction == 0) 
     { 
       turnDirection = 0; 
       velTurnGoal = 0.0D; 
     } 
   } 
    
  public void buildBody() 
   { 
     VHX = ((int)(x + (radius * Math.cos(angle)))); 
     VHY = ((int)(y + (radius * Math.sin(angle)))); 
      
    VHX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[0]; 
     VHY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[1]; 
      
    VAX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -135)[0]; 
     VAY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -135)[1]; 
      
    VCX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -90)[0]; 
     VCY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, -90)[1]; 
  
    VFX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 90)[0]; 
     VFY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 90)[1]; 
      
    VEX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 135)[0]; 
     VEY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 135)[1]; 
      
    VHX = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[0]; 
     VHY = SpecialAlgorithms.arcRotation(VHX, VHY, x, y, 0)[1]; 
      
    xArray[0] = VHX;xArray[1] = VCX;xArray[2] = VAX;xArray[3] = VEX;xArray[4] = VFX;xArray[5] = VHX; 
     yArray[0] = VHY;yArray[1] = VCY;yArray[2] = VAY;yArray[3] = VEY;yArray[4] = VFY;yArray[5] = VHY; 
   } 
    
  public void shoot(int val) 
   { 
     if (val == 1) 
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
     handler.addObject(new Projectile((int)(x + radius * Math.cos(angle)) + 2, (int)(y + radius * Math.sin(angle)) + 2, GameObjectID.Projectile, 4, 5.0D, angle, handler, "white", GameObjectID.Player)); 
   } 
    
  public void setColor(String color) 
   { 
     this.color = Color.getColor(color); 
   } 
} 
  