#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main()
{

 unsigned int posInfBitPattern =  0x7F800000;
 float posInfinity = *(float*)&posInfBitPattern;

 printf("Positive Infinity = %g\n",posInfinity);

 unsigned int biggyBitPattern = 0x7F000000;
 float biggy = *(float*)&biggyBitPattern;

 printf("biggy = %g\n",biggy);


 printf("2.0/0,0 = %g\n",2.0/0.0);
 printf("log(-1) = %g\n",log(-1));

 return(EXIT_SUCCESS);
}
