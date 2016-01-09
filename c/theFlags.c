#include <stdlib.h>
#include <stdio.h>
#define	TEXT_LEN	64
int	main	()
{
  char	text[TEXT_LEN];
  printf("Enter first number: ");
  fgets(text,TEXT_LEN,stdin);
  int a = atoi(text);
  printf("Enter second number: ");
  fgets(text,TEXT_LEN,stdin);
  int b = atoi(text);
  int c = a - b;
  printf("%d - %d = %d\n",a,b,c); // Line 14
  return(EXIT_SUCCESS);
}

