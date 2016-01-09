#include <stdlib.h>
#include <stdio.h>

void	foo	(int i, int j)
{
  int	a;
  int	b;
  int	c;
  
  printf("&j == %p\n",&j);
  printf("&i == %p\n",&i);
  printf("&a == %p\n",&a);
  printf("&b == %p\n",&b);
  printf("&c == %p\n",&c);
}

int main ()
{
 foo(1,2);
 return(EXIT_SUCCESS);

}
