#include <stdlib.h>
#include <stdio.h>
#define LEN 64

int main () {
 int i;
 int j; 
 int n;
 char line[LEN];

do 
{
  printf("Enter a #: ");
  fgets(line,LEN,stdin);
  n = atoi(line);
}
while (n < 1); 

for (i = 1; i <= n; i++)
{
	for(j=1; j <=n; j++)
	{
	 printf("%d x %d = %d%c",i,j,i*j,(j==n) ? '\n' : '\t');
	}

}

return(EXIT_SUCCESS);
}
