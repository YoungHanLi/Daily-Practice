#include <iostream>
#include <bitset>

int main(void)
{
  long long bmap[64]={0,};
  long long tmap[64]={0,};
  int binary[64][64]={0,};
  int tranBinary[64][64]={0,};
  int i=0, j=0, k=0;
  std::string tempString[64];
  std::string tempString2[64];

  //input bmap
  for(i=0; i<64; i++)
  {
    std::cin>>bmap[i];
  }

  for(i=0; i<64; i++)
  {
    tempString[i] = std::bitset<64>(bmap[i]).to_string();
    for(j=0; j<64; j++)
    {
      binary[i][j] = tempString[i].at(j);
    }
  }

  for(j=0; j<64; j++)
  {
    for(i=0; i<64; i++)
    {
      tranBinary[j][i]=binary[i][j];
      //std::cout<<tranBinary[j][i];
    }
    //std::cout<<'\n';
  }

  for(i=0; i<64; i++)
  {
    for(j=0; j<64; j++)
    {
      tempString2[i]+=tranBinary[i][j];
    }
  }

  for(i=0; i<64; i++)
  {
    for(j=0; j<64; j++)
    {
      tmap[i]= (tmap[i]<<1) + (tempString2[i].at(j)-'0');
    }
  }

  //print tmap
  i=0;
  while(i<64)
  {
    printf("%lld\n", tmap[i]);
    i++;
  }

  return 0;
}
