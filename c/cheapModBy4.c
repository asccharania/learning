#include <stdlib.h>
#include <stdio.h>

int main()
{
 int i;

 for (i = 0; i < 16; i++)
	printf("%d mod 4 = %X, %d & Ox3 = %X\n",i,i%4, i,i & 0x3);
 return(EXIT_SUCCESS);
}

