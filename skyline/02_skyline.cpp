#include <iostream>

int sky[1000000]={0,};

class Building
{
public:
  int begin;
  int height;
  int width;

public:
  Building()
  :begin(0), height(0), width(0)
  {}

  Building(int begin, int height, int width)
  :begin(begin), height(height), width(width)
  {}

  void BuildSet(int begin, int height, int width)
  {
    this->begin=begin;
    this->height=height;
    this->width=width;
  }
};

int main(void)
{
  int begin=0, height=0, width=0;
  int buildNum=0;
  int xpos=0, ypos=0;
  int i=0, j=0;


  std::cin>>buildNum;
  Building Build[buildNum];

  //input
  for(i=0; i < buildNum; i++)
  {
    std::cin>>begin;
    std::cin>>height;
    std::cin>>width;
    Build[i].BuildSet(begin, height, width);
  }

  for(i=0; i<buildNum; i++)
  {
    for(j=Build[i].begin;j<Build[i].begin+Build[i].width;j++)
    {
      if(sky[j] < Build[i].height)
      {
        sky[j]=Build[i].height;
      }
    }
  }

  ypos=sky[0];
  xpos=0;

  for(i=1; i<1000000; i++)
  {
    if(ypos!=sky[i])
    {
      std::cout<<i-xpos<<' ';
      std::cout<<sky[i]-ypos<<' ';
      xpos=i;
      ypos=sky[i];
    }
  }


  return 0;
}
