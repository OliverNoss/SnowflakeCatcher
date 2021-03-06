// Oliver Noss AP Computer Science
SnowFlake[] snow = new SnowFlake[1000];

void setup()
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
void draw()
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
void mouseDragged()
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
void keyPressed()
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
    dy=(float)(Math.random()*.8+.3);
    isMoving = true;
  }
  void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,d,d);
  }
  void lookDown()
  {
    if(get(x,int(y+d/2+3))!=color(0,0,0))
      {
        isMoving=false;
      }
      else 
      {
        isMoving=true;        
      }
  }
  void erase()
  {
    stroke(0);
    fill(0);
    ellipse(x,y-2,d+2,d+1);
  }
  void move()
  {
    if (isMoving)
    y+=dy;
  }
  boolean wrap()
  {
    return y>496-d/2;  
  }
}//
