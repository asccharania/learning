#include <stdlib.h>
#include <stdio.h>

unsigned int getExponentField(float f)
{
 unsigned int* uPtr = (unsigned int*)&f;

 return((*uPtr & 0x7F800000) >> 23);
}

unsigned int getMantissaField(float f)
{
 unsigned int* uPtr = (unsigned int*)&f;
 return(*uPtr & 0X007FFFFF );
}

int main ()
{

float f;

for (f = 1.0; f != 0.0; f = f/2)
 {
	printf("%g has exponenent field %02X, mantissa %06X\n",f,getExponentField(f),getMantissaField(f));
 }

return(EXIT_SUCCESS);

}
