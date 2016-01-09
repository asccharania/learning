#include <stdlib.h>
#include <stdio.h>

int main()
{
	int i;
	int* iPtr;
	
	i = 10;
	
	printf("Originally i  = %d\n",i);
	iPtr = &i;
	(*iPtr)++;
	printf("Now i =  %d\n",i);
	return(EXIT_SUCCESS);


}
