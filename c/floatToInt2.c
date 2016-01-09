#include <stdlib.h>
#include <stdio.h>
#define TEXT_LEN 64


void printBinary (unsigned int u)
{

 unsigned int mask;
 for (mask = 1 << 31; mask !=0; mask = mask >> 1)
  if ( (u & mask) == mask) 
   printf("1");
  
  else
   printf("0");

}


int main ()
{
 while(1)
 {	
	char text[TEXT_LEN];
	printf("please enter a floating point number: ");
	fgets(text,TEXT_LEN,stdin);
	float f = strtod(text,NULL);
	unsigned int* uPtr = (unsigned int*)&f;

	printf("floating point %g has the bit-pattern 0x%X\t",f,*uPtr);
	printBinary(*uPtr);
	printf("\n");
 } 
return(EXIT_SUCCESS);
}
	
