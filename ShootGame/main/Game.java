package com.shootGame.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1600, HEIGHT = 900;
   
	private Thread thread;
	protected boolean running = false;
   
	private Handler handler;
	
	public static double time;
	public static double timeTimer;
   
   public Game()
   {
	  handler = new Handler();
	  this.addKeyListener(new KeyInput(handler, this, new Window(WIDTH, HEIGHT, "Shoot Gun", this)));
	  
	  //new Window(WIDTH, HEIGHT, "Shoot Gun", this);
      
	  time = 0;
	  timeTimer = 1;
	  
	  handler.addObject(new Ghost(0, 0, GameObjectID.Ghost, 0, 0, handler));
      handler.addObject(new Player(WIDTH / 2, HEIGHT / 2, GameObjectID.Player, 25, 2, handler, "blue"));
   }
   
   public synchronized void start()
   {
      thread = new Thread(this);
      thread.start();
      running = true;
   }
   
   public synchronized void stop()
   {
      try{
         thread.join();
         running = false;
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void run()
   {
      long lastTime = System.nanoTime();
      double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      long timer = System.currentTimeMillis();
      int frames = 0;
      
      while(running)
      {
         long now = System.nanoTime();
         delta += (now - lastTime) / ns;
         lastTime = now;
         
         // System.out.println(delta);
         
         while(delta >= 1)
         {
            tick(delta);
            delta--;
         }
         if(running)
            render();
         frames++;
         
         if(System.currentTimeMillis() - timer > 1000)
         {
            timer += 1000;
            time += timeTimer;
            System.out.println(time);
            frames = 0;
         }
      }
      stop();
   }
   
   private void tick(double delta)
   {
	   handler.tick(delta);
   }
   
   private void render()
   {
      BufferStrategy bs = this.getBufferStrategy();
      if(bs == null)
      {
         this.createBufferStrategy(3);
         return;
      }
      
      Graphics g = bs.getDrawGraphics();
      
      g.setColor(Color.black);
      g.fillRect(0,0, WIDTH, HEIGHT);
      
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
	   while(running)
	   {
		   Game game = new Game();
		   while (game.isRunning())
		   {
			   if(!game.isRunning())
				   break;
		   }
	   }
   }

}