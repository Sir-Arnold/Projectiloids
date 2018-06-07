package com.shootGame.main; 
  
import java.awt.Canvas; 
import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.image.BufferStrategy; 
import java.io.PrintStream; 
  
public class Game extends Canvas implements Runnable 
{ 
   private static final long serialVersionUID = 1L; 
   public static final int WIDTH = 1600; 
   public static final int HEIGHT = 900; 
   private Thread thread; 
   protected boolean running = false; 
    
  private Handler handler; 
    
  public static double startTime; 
   public static double time; 
   public static double runningTime; 
   public static double timeTimer; 
    
  public Game() 
   { 
     handler = new Handler(); 
     addKeyListener(new KeyInput(handler, this, new Window(WIDTH, HEIGHT, "Shoot Gun", this))); 
      
    System.out.println("Game constructing..."); 
  
    time = 0.0; 
     timeTimer = 1.0; 
      
    handler.addObject(new Ghost(0, 0, GameObjectID.Ghost, 0, 0.0, handler)); 
     handler.addObject(new Player(800, 450, GameObjectID.Player, 25, 2.0, handler, "blue")); 
      
    System.out.println("Game constructed."); 
   } 
    
  public synchronized void start() 
   { 
     System.out.println("Thread starting..."); 
     thread = new Thread(this); 
     thread.start(); 
     running = true; 
     System.out.println("Thread started."); 
   } 
    
  public synchronized void stop() 
   { 
     try { 
       System.out.println("Thread stopping..."); 
       thread.join(); 
       running = false; 
       System.out.println("Thread stopped."); 
     } 
     catch (Exception e) 
     { 
       e.printStackTrace(); 
     } 
   } 
    
  public void run() 
   { 
     long lastTime = System.nanoTime(); 
     double amountOfTicks = 60.0; 
     double ns = 1000000000 / amountOfTicks; 
     double delta = 0.0; 
     long timer = System.currentTimeMillis(); 
     startTime = System.currentTimeMillis(); 
     int frames = 0; 
      
    while (running) 
     { 
       long now = System.nanoTime(); 
       delta += (now - lastTime) / ns; 
       lastTime = now; 
        
      runningTime = (System.currentTimeMillis() - startTime) / (double) 1000; 
  
      while (delta >= 1.0) 
       { 
         tick(delta); 
         delta -= 1.0; 
       } 
       if (running) 
         render(); 
       frames++; 
        
      if (System.currentTimeMillis() - timer > 1000) 
       { 
         timer += 1000; 
         time = (int) (runningTime + 0.5); 
         System.out.println("Frames per second: " + frames); 
         frames = 0; 
       } 
        
      time = runningTime * timeTimer; 
        
    } 
     stop(); 
   } 
    
  private void tick(double delta) 
   { 
     handler.tick(delta); 
   } 
    
  private void render() 
   { 
     BufferStrategy bs = getBufferStrategy(); 
     if (bs == null) 
     { 
       createBufferStrategy(3); 
       return; 
     } 
      
    Graphics g = bs.getDrawGraphics(); 
      
    g.setColor(Color.black); 
     g.fillRect(0, 0, 1600, 900); 
      
    handler.render(g); 
      
    g.dispose(); 
     bs.show(); 
   } 
    
 
  public boolean isRunning() 
   { 
     return running; 
   } 
    
  public static void main(String[] args) 
   { 
     boolean running = true; 
     while (running) 
     { 
       Game game = new Game(); 
       while (game.isRunning()) 
       { 
         if (!game.isRunning())  
        { 
           break; 
        } 
       } 
     } 
   } 
} 
  