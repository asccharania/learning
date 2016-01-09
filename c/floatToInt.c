#include <stdlib.h>
#include <stdio.h>
#define TEXT_LEN 64
int main ()
{
 while(1)
 {	
	char text[TEXT_LEN];
	printf("please enter a floating point number: ");
	fgets(text,TEXT_LEN,stdin);
	float f = strtod(text,NULL);
	unsigned int* uPtr = (unsigned int*)&f;

	printf("floating point %g has the same bit-pattern as integer 0x%X\n",f,*uPtr);
 }
return(EXIT_SUCCESS);
}
	
