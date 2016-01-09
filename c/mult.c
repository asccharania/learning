#include <stdlib.h>
#include <stdio.h>

#define TEXT_LEN 32

int main()
{
 int x; 
 char text[TEXT_LEN];

 while(1)
{ 
 printf("Please enter a negative int ");
 fgets(text,TEXT_LEN,stdin);
 x = strtol(text,NULL,10);

 printf("%d squared is %d\n",x,x*x); 
}
return(EXIT_SUCCESS);
}
