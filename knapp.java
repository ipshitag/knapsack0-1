package knapsackDyn;
import java.util.Scanner;



public class knapp 
{
	//max function
	public static int max(int a, int b)
	{
	 if (a>b)
	 return a;
	 else
	 return b;
	}
	
    public static void main(String args[])
	{
		int nObj,cap;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the number of object");
		nObj = input.nextInt();
		System.out.println("Enter the maximum capacity of the sack");
		cap = input.nextInt();
		
			int p[] = new int[nObj+1] , 
			wt[] = new int[nObj+1] ,n,m,
			k[][] = new int[nObj+1][cap+1] , w, i;
			p[0]=0;
			wt[0]=0;
			n = nObj;
			m = cap;
			
		System.out.println("Enter the profits of the "+ nObj + " articles" );
		
		for(i=1;i<=n;i++)
		{
			p[i]= input.nextInt();
		}
		
		System.out.println("Enter the weights of the "+ nObj + " articles" );
		for(i=1;i<=n;i++)
		{
			wt[i]= input.nextInt();
		}
		

		for ( i = 0; i <= n; i++)
		{
			for (w = 0; w <= m; w++)
			{
				if (i==0||w==0)
				{
					k[i][w] = 0;
				}
				else
				{
				  if (wt[i] <= w)
				    {
					k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
				    }
				else
				    {
					k[i][w] = k[i - 1][w];
				    }
			       }
			}
		}
	//formating
	System.out.println(" The object with their weight and profit:-\n\n");

	System.out.println("\t objects ");
	for(i=1;i<=n;i++)
	System.out.println(i + "\t");

	System.out.println("\n");

	
	System.out.println("\t weight  ");
	for(i=1;i<=n;i++)
    System.out.println(wt[i] + "\t");

	System.out.println("\n");
	

	System.out.println("\t profit  ");
	for(i=1;i<=n;i++)
	System.out.println(p[i] + "\t");

	System.out.println("\n\n");

	//showing in tabular form
	System.out.println("In tabular form:- \n\n");
	for(i=0;i<=n;i++)
	{
		System.out.println('\t');
		for(int j=0;j<=cap;j++)
		{
			System.out.println(k[i][j] + '\t');
		}
		System.out.println('\n');
	}

	// checking objects to be included
	i=n;
	int j=cap;
	int pr = 0;
	System.out.println("\n\n\t The objects to be included are:-\n");
	while(i>0 && j>0)
	{
	 if(k[i][j] == k[i-1][j])
	 {
	  i--;
	 }
	 else
	 {
	  System.out.println("\t" + i + "\n");
	  pr = pr + p[i];
	  i--;
	  j= j-wt[i];
	  }
	}
	System.out.println("\n\t Maximum profit is " + pr);
	
	}


}
