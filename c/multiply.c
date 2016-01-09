#include <stdlib.h> 
#include <stdio.h> 
#define LEN 64

int main () {
  char line[LEN];
  printf("Enter a #: ");
  fgets(line,LEN,stdin);
  int   n = atoi(line);
  int x; 
  int i; 
 if (n > 0){
	 for (x = 1; x <= n; x++)
		for(i = 1; i <= n; i++)
 		 printf("%d x %d =%d\n",x,i,x*i);
 		 return(EXIT_SUCCESS);}
 else {
	printf("Please enter a non-negative number\n");
 	return(EXIT_FAILURE);
}
}
