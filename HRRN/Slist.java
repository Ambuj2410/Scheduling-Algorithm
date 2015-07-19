import java.util.Scanner;

class Slist
{
   int [][] a=new int[6][22];
   Node list;
   Node list1;
   int size;
   static int ct=0;
   Slist(int size)
   {
      list=null;
      list1=null;
      this.size=size;
   }
 
   Node create()
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter the arrival time ");
      int at=in.nextInt();
      System.out.println("Enter the service time");
      int st=in.nextInt();
      System.out.println("Enter process id");
      int id=in.nextInt();
      Node node = new Node(at,st,0.0,id);
      return node;
   }
 
   void frontins()
   {
   
      Node node=create();
      if(list==null)
      {
         list=node;
      }
      else
      {
          Node temp=list;
    while(temp.next!=null)
	 temp=temp.next;
	 
	 temp.next=node;
  
  
      }
   }
  
   
   void Pos()
   {
      Node temp,prev;
      temp=list;
      prev=list;
      int i=0;
      double hrrn=0.0;
      if(list1==null)
      {
         while(temp!=null && temp.at!=0)
         temp=temp.next;
         Node node=new Node(temp.at,temp.st,temp.ratio,temp.id);
         list1=node;
         ct=ct+temp.st;
         posdel(temp.id);
      }
      else
      {
         hrrn=temp.ratio;
         while(prev!=null)
         {
            if(prev.ratio>=hrrn)
               hrrn=prev.ratio;
            prev=prev.next;
         }
         Node first=list1;
       while(temp!=null&&temp.ratio!=hrrn)
       temp=temp.next;  
         while(first.next!=null)
            first=first.next;
         first.next=new Node(temp.at,temp.st,temp.ratio,temp.id);
               ct=ct+temp.st;
             posdel(temp.id);
      }
      computehrrn();
   }
   
   
   
   public void computehrrn()
   {
     Node temp=list;
      while(temp!=null)
       {
         if(ct>=temp.at)
         {
            int w=ct-temp.at;
            int s=temp.st;
            temp.ratio=(double)(w+s)/s;
         }
         temp=temp.next;
       }
   }
   
   void posdel(int pos)
	{ 
	   Node temp=list, prev=null;		 
	
	   if(list==null)
	    System.out.println("List is Empty");
	   else
	   {
	     while(temp!=null && temp.id!=pos)
		   { 
		     prev=temp;
		     temp=temp.next;
		   }
		   if(temp.id==pos)
          {
            if(temp==list)
               list=list.next;
            else
		        prev.next=temp.next;		 
          }	  
      }
	}	
   void display()
   {
     Node temp1=list1;
     int clock=0;
     int c=1;
     if(list1==null)
         System.out.println("List is Empty");
     else
      {
         while(temp1!=null)
         {
            if(temp1.at<=c)
            {
               for(clock=1;clock<=temp1.st;clock++)
                  {
                     System.out.println("Process"+" "+temp1.id+" is executing in the "+c+" "+"sec");
                     insert(temp1.id,c);
                     c++;
                  }
            }      
            else
            {
              for(int i=c;i<temp1.at;i++)
              {
              System.out.println("No Process is executed in "+c+"sec");
              insert(0,c);
              c++;
              }
            if(temp1.at<=c)
            {
               for(clock=1;clock<=temp1.st;clock++)
                  {
                     System.out.println("Process"+" " +temp1.id+ " is executing in the "+c+" "+"sec");
                     insert(temp1.id,c);
                     c++;
                  }

             
            }
            }
            temp1=temp1.next;
            }       
                     
                                   
                     System.out.println("The total Service time is "+ct);

      }
        display1(ct,size);
   }
void insert(int x,int y)
   {
     a[x][y-1]=1; 
      
   }
   public void display1(int n,int m)
	{
		System.out.print("\n");
		for(int i=0;i<n;i++)
		{
			System.out.print("-------");
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
























