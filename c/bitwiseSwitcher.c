#include <stdlib.h>
#include <stdio.h>
#define TEXT_LEN 32


int f(int i) 
{
 return((i&0xF0F0) | 0x0F00 | 0x0000);
}

int main ()
{
 int i;
 char text[TEXT_LEN];

while(1)
{
 printf("Enter a Hexadecimal int without the 0x");
 fgets(text,TEXT_LEN,stdin);
 i  = atoi(text);
 printf("%X\n",f(i));
}
return(EXIT_SUCCESS);

}
