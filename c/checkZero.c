#include <stdlib.h>
#include <stdio.h>

int main() {

float z1 = -0.0;

float z2 = +0.0;

printf("positive Zero = %g\n",z2);
printf("negative Zero = %g\n",z1);


if (z1 == z2)
	printf("-0 == 0\n");
else 
	printf("-0 != 0\n");

return(EXIT_SUCCESS);


}
