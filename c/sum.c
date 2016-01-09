#include <stdlib.h>
#include <stdio.h>


int main ()
{
 unsigned int u = 0x80000000;

 printf("0x%X + 0x%X = 0x%X\n", u, u, u+u);
 printf("%u + %u = %u\n", u, u, u+u);
 return(EXIT_SUCCESS);
}
