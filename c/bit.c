#include <stdlib.h>
#include <stdio.h>
#define LEN 32

int main() 
{
 char line[LEN];
 int i;

 printf("Enter a number: ");
 fgets(line,LEN,stdin);
 i = atoi(line);
 
 char* cPtr =(char*) &i;
 unsigned char first = *cPtr; 

 cPtr++;
 unsigned char second = *cPtr;

 cPtr++;
 unsigned char third = *cPtr;
 
 cPtr++;
 unsigned char fourth = *cPtr;

 printf("i byte's 0 0x%02X\n",(unsigned int)first);
 printf("i byte's 1 0x%02X\n",(unsigned int)second);
 printf("i byte's 2 0x%02X\n",(unsigned int)third);
 printf("i byte's 3 0x%02X\n",(unsigned int)fourth);

 return(EXIT_SUCCESS);
}

