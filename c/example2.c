#include <stdlib.h>
#include <stdio.h>

int foo (int i,
	 int j, 
	 int k
	)
{
 int x;
 int y;
 int z; 

 printf("&i == %p\n",&i);
 printf("&j == %p\n",&j);
 printf("&k == %p\n",&k);
 printf("&x == %p\n",&x);
 printf("&y == %p\n",&y);
 printf("&z == %p\n",&z);

 return(0);
}

int main() 
{
foo(1,2,3);
return(EXIT_SUCCESS);
}
