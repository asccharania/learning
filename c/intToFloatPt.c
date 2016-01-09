#include <stdlib.h>
#include <stdio.h>
#define TEXT_LEN 64
int main ()
{
 while(1)
 {	
	char text[TEXT_LEN];
	printf("please enter a hex number without the 0x");
	fgets(text,TEXT_LEN,stdin);
	unsigned int i = strtol(text,NULL,16);
	float* fPtr = (float*)&i;

	printf("integer 0x%X has the same bit-pattern as floating point %g\n",i,*fPtr);
 }
return(EXIT_SUCCESS);
}
	
