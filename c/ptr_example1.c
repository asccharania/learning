#include <stdlib.h>
#include <stdio.h>

int main () 
{

	int i;
	int* iPtr = &i; 

	for(*iPtr = 1; *iPtr <= 10; (*iPtr)++)
		printf("%d\n",*iPtr);

	return(EXIT_SUCCESS); 
}
