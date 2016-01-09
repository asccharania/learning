#include <stdlib.h>
#include <stdio.h>
#define LEN 64


int enterNumber (int loLimit, int hiLimit) {

 char line[LEN];
 int n;

 do 
 {
	printf("Enter a number between %d and %d: ",loLimit,hiLimit);
	fgets(line,LEN,stdin);
	n = atoi(line);
 } 
 while (n < loLimit || n > hiLimit);
		
 return(n);

}


 void printTable (int loLimit, int hiLimit) {

 int x; 

 for (x = loLimit; x <= hiLimit; x++){
	printf("ASCII character %3d is %c.\n",x,x);
 }
}


int main() {
 int x = enterNumber(32,127);
 int y = enterNumber(x, 127);

 printTable(x,y);

 return(EXIT_SUCCESS);
} 
