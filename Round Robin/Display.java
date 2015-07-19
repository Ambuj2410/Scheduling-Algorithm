class Display
{
	int[][] a=new int[5][20];
	public void initialise()
	{
		for(int i=0;i<5;i++)
			for(int j=0;j<20;j++)
				a[i][j]=0;
		a[4][1]=1;
		a[2][10]=1;
		a[3][5]=1;
		a[1][18]=1;
		display(20,5);
	}
	public void display(int n,int m)
	{
		System.out.print("\n");
		for(int i=0;i<n;i++)
		{
			System.out.print("-------");
		}
		System.out.print("\n");
		for(int i=0;i<=n*7;i++)
		{
			if(i%7==0)
				System.out.print("|");
			else
				System.out.print(" ");
		}
		System.out.print("\n");
		for(int i=0;i<=n*7;i++)
		{
			if((i==4 && i!=0) || (((i-4) % 7 == 0) && i!=0)) 
				System.out.print((i/7)+1);
			else
				System.out.print(" ");
		}
		System.out.print("\n");
		for(int j=0;j<m;j++)
		{
			for(int i=0;i<=n*7;i++)
			{
				if(i%7==0)
					System.out.print("|");
				else if(search(j,i/7) && ((i==4 && i!=0) || (((i-4) % 7 == 0) && i!=0)))
					System.out.print("1");
				else if((i==4 && i!=0) || (((i-4) % 7 == 0) && i!=0)) 
					System.out.print("0");
				else
					System.out.print(" ");
			}
			System.out.println("");
			for(int i=0;i<n;i++)
			{
				System.out.print("-------");
			}
			System.out.println("");
		}
	}
	boolean search(int x, int y)
	{
		//System.out.println("This is y : "+y);
		//System.out.println("This is x : "+x);
		if(a[x][y]==1)
		{
			//System.out.println("returning true");
			return true;
		}
		else
		{
			//System.out.println("returning false");
			return false;
		}
	}
}
