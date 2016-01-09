#include <stdlib.h> 
#include <stdio.h> 
#include <string.h> 
#define LEN 64

int main ()
{ 
 char* cPtr;
 char name[LEN]; 
 
 printf("Name? "); 
 fgets(line,LEN,stdin); 
 cPtr=strchr(name,'\n'); 
 
 if (cPtr!=NULL)
 	*cPtr='\0';  
 
 printf("Hello "); 
 printf("%s\n",name); 
 return(EXIT_SUCCESS);
}
