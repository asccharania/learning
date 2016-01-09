#include <stdlib.h>
#include <stdio.h>


int main ()
{
 int i = 1;
 int* iPtr = &i;
 char* cPtr = (char*)iPtr; 
 char first = *cPtr; 

 cPtr++;     
 char second = *cPtr;
 
 cPtr++;     
 char third = *cPtr; 
 
 cPtr++;     
 char fourth = *cPtr;

 printf("i's byte 0: %d\n",(int)first);
 printf("i's byte 1: %d\n",(int)second);
 printf("i's byte 2: %d\n",(int)third);
 printf("i's byte 3: %d\n",(int)fourth);
 
 return(EXIT_SUCCESS);
}

