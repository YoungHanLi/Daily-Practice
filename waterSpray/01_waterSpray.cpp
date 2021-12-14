#include <iostream>

class Drone
{
public:
  int xpos,ypos;
  int width, height;
public:
  Drone() // constructor
  :xpos(0), ypos(0), width(0), height(0)
  {}

  void setPos(int xpos, int ypos, int width, int height)
  {
    this->xpos=xpos;
    this->ypos=ypos;
    this->width=width;
    this->height=height;
  }
};

int main(void)
{
  int xpos, ypos, width, height;
  int i=0, j=0, k=0;
  int drones_num=0;
  int result=0;
  char board[1700][1700]={0,};

  std::cin>>drones_num;
  Drone drones[drones_num];

  while(1)
  {
    std::cin>>xpos;
    if(xpos==-1)
      break;
    std::cin>>ypos;
    std::cin>>width;
    std::cin>>height;
    drones[i++].setPos(xpos, ypos, width, height);
  }

  for(i=0;i<drones_num;i++)
  {
    for(j=drones[i].ypos-(drones[i].height/2);j<drones[i].ypos+(drones[i].height/2);j++)
    {
      for(k=drones[i].xpos-(drones[i].width/2);k<drones[i].xpos+(drones[i].width/2);k++)
      {
        if(board[j][k]<2)
          board[j][k]+=1;
      }
    }
  }

  for(i=0;i<1700;i++)
  {
    for(j=0;j<1700;j++)
    {
      if(board[i][j])
        result+=1;
    }
  }

  std::cout<<result<<std::endl;

  return 0;
}
