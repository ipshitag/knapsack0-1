//Knapsack 0/1 implementation
//7th April 2019
//Ipshita Ghosh

#include<iostream.h>
#include <stdlib.h>
#include<conio.h>

//MAX FUNCTION
int max(int a, int b)
{
 if (a>b)
  return a;
  return b;
}

void main()
{
	clrscr();
	int p[5] = { 0,1,2,5,6 }, wt[5] = { 0,2,3,4,5 }, m = 8, n = 4, k[5][9],w,i;
for ( i = 0; i <= n; i++)
{
	for (w = 0; w <= m; w++)
	{
		if (i == 0 || w == 0)
			k[i][w] = 0;
		else if (wt[i] <= w)
			k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
		else
			k[i][w] = k[i - 1][w];

	}
}
//FORMATTING	
cout<<"The objects with their weight and profit:- \n\n";

cout<<"\t objects  ";
for(i=1;i<=4;i++)
cout<<i<<"\t";
	
	
cout<<"\n";
	
cout<<"\t weight   ";
for(i=1;i<=4;i++)
cout<<wt[i]<<"\t";
	
	
cout<<"\n";
	
cout<<"\t profit   ";
for(i=1;i<=4;i++)
cout<<p[i]<<"\t";
	
cout<<"\n\n";

//SHOWING IN TABULAR FORM	
cout<<"In tabular form:-\n\n";
for (i = 0; i <= 4; i++)
{       cout<<"\t";
	for (int j = 0; j <= 8; j++)
	{
		cout << k[n][w] << "\t";
	}
	cout<<"\n";
}

getch();
}
