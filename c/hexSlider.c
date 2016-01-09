#include <stdlib.h>
#include <stdio.h>

#define TEXT_LEN 64

int f(int a, int b)
{
 return( ((0xF & a) >> 2) | ((0x3 & b) << 2) );
}

int main ()
{
 int a;
 int b;
 char text[TEXT_LEN];

 while(1)
 {
 printf("Enter first hexadecimal int 0x");
 fgets(text,TEXT_LEN,stdin);
 a = strtol(text,NULL,16);


 printf("Enter another hexadecimal int 0x");
 fgets(text,TEXT_LEN,stdin);
 b = strtol(text,NULL,16);

 printf("f(%X,%X) = %X\n",a,b,f(a,b));
 }

return(EXIT_SUCCESS);
}
