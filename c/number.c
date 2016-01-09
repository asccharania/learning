#include <stdlib.h>
#include <stdio.h> 
#define LEN 64
int main () {
 char line[LEN];
 printf("Enter a #: ");
 fgets(line,LEN,stdin);
 int   i = atoi(line);
 float f = atof(line);
 printf("i = %d\n",i);
 printf("f = %g\n",f);
 return(EXIT_SUCCESS);
}
