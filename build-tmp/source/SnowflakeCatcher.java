import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake[] snow = new SnowFlake[1000];

public void setup()
{
  size(500,500);
  background(0);
  stroke(255);
  for (int i = 0; i < snow.length; i++) 
  {
    snow[i]= new SnowFlake();
  }
  background(0);
}
public void draw()
{
  fill(0);
  stroke(0);
  rect(0,495, 500,5);
  for (int i = 0; i < snow.length; i++) 
  {
    snow[i].erase();
    snow[i].show();
    snow[i].lookDown();
    
    snow[i].move();
    if (snow[i].wrap())
    { 

      stroke(0);
      fill(0);
      rect(0,495, 500,7);
      ellipse(snow[i].x,snow[i].y,snow[i].d+3,snow[i].d+3);
      snow[i] = new SnowFlake();
    }  
  }
}
public void mouseDragged()
{if(mouseButton==LEFT)
  {
  stroke(0,150,255);
}
else if (mouseButton==RIGHT) {
  stroke(0);
}
  strokeWeight(4);
  line(pmouseX,pmouseY,mouseX,mouseY);
}
public void keyPressed()
{
  if (key=='q')
    {
      background(0);
    }
}
class SnowFlake
{
  int x,d;
  float y, dy;
  boolean isMoving;

  SnowFlake()
  {
    x=(int)(Math.random()*500);
    y=0;
    d=(int)(Math.random()*4+2);
    dy=(float)(Math.random()*.8f+.3f);
    isMoving = true;
  }
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,d,d);
  }
  public void lookDown()
  {
    if(get(x,PApplet.parseInt(y+d/2+3))!=color(0,0,0))
      {
        isMoving=false;
      }
      else 
      {
        isMoving=true;        
      }
  }
  public void erase()
  {
    stroke(0);
    fill(0);
    ellipse(x,y-2,d+2,d+1);
  }
  public void move()
  {
    if (isMoving)
    y+=dy;
  }
  public boolean wrap()
  {
    return y>496-d/2;  
  }
}//
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
