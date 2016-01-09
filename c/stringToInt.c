#include <stdlib.h>
#include <stdio.h> 

void stringToInt (char* text,
		int* iPtr)
{
	*iPtr = atoi(text);
}

int main () 
{
	int i;

	stringToInt("17", &i);
	printf("i == %d\n", i);

	stringToInt("20",&i);
	printf("i == %d\n",i);

	return(EXIT_SUCCESS);
}
