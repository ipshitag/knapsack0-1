/**
 * File_Name   : knapp_resolved.java
 * Updated     : 10 April 2019
 * Contributor : Rishi
 * Updates     : Indentations and Print Statements.
 * 
 ************************************************************************************************
 * 
 * Sample Input : 
 * 
 * Enter the number of object : 5
 * Enter the maximum capacity of the sack : 5
 * Enter the profits of the 5 articles : 1 2 3 4 5
 * Enter the weights of the 5 articles : 1 2 3 4 5
 * 
 ************************************************************************************************
 *
 * Sample Output : 
 * 
 * The object with their weight and profit:-
 * 
 * objects 1	2	3	4	5	
 * weight  1	2	3	4	5	
 * profit  1	2	3	4	5	
 * 
 * In tabular form:- 
 * 
 * 0	0	0	0	0	0	
 * 0	1	1	1	1	1	
 * 0	1	2	3	3	3	
 * 0	1	2	3	4	5	
 * 0	1	2	3	4	5	
 * 0	1	2	3	4	5	
 * 
 * The objects to be included are:-
 * 
 * 3
 * 2
 * 1
 * 
 * Maximum profit is 6
 * 
 ************************************************************************************************
 */
//package knapsackDyn;
import java.util.Scanner;

public class knapp_resolved
{
	//max function
	public static int max(int a, int b)
	{
		if (a>b)
			return a;
		else
			return b;
	}

	//Main function	
	public static void main(String args[])
	{
		int nObj,cap;
		// nObj stores the number of Objects and cap stores the capacity of the sack

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of object");
		nObj = input.nextInt();
		System.out.println("Enter the maximum capacity of the sack");
		cap = input.nextInt();

		int p[] = new int[nObj+1]; 
		int wt[] = new int[nObj+1];
		int k[][] = new int[nObj+1][cap+1];
		int n = nObj, m = cap;
		int w, i;

		System.out.println("Enter the profits of the "+ nObj + " articles" );

		for(i=1;i<=n;i++)
			p[i]= input.nextInt();

		System.out.println("Enter the weights of the "+ nObj + " articles" );
		for(i=1;i<=n;i++)
			wt[i]= input.nextInt();

		//using formula
		for ( i = 0; i <= n; i++)
		{
			for (w = 0; w <= m; w++)
			{
				if (i != 0 && w != 0)
				{
					if (wt[i] <= w)
						k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
					else
						k[i][w] = k[i - 1][w];
				}
			}
		}
		//formating
		System.out.println("\nThe object with their weight and profit:-\n");

		System.out.print("objects ");
		for(i=1;i<=n;i++)
			System.out.print(i + "\t");
		System.out.println();


		System.out.print("weight  ");
		for(i=1;i<=n;i++)
			System.out.print(wt[i] + "\t");
		System.out.println();


		System.out.print("profit  ");
		for(i=1;i<=n;i++)
			System.out.print(p[i] + "\t");
		System.out.println();


		//showing in tabular form
		System.out.println("\nIn tabular form:- \n");
		for(i=0;i<=n;i++)
		{
			for(int j=0;j<=cap;j++)
				System.out.print(k[i][j] + "\t");
			System.out.println();
		}

		// checking objects to be included
		i = n;
		int j = cap;
		int pr = 0;
		System.out.println("\nThe objects to be included are:-\n");
		while(i>0 && j>0)
		{
			if(k[i][j] == k[i-1][j])
			{
				i--;
			}
			else
			{
				System.out.println(i);
				pr = pr + p[i];
				i--;
				j= j-wt[i];
			}
		}
		System.out.println("\nMaximum profit is " + pr);
		input.close();
	}
}
