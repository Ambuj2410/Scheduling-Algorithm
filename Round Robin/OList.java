import java.util.Scanner;

public class OList
{
	int k;
	Process slist;

	OList()
	{
		slist=null;
	}

	public void ordered_list(int x, int y, int z, int ts)
	{
		Process n1 = new Process(x,y,z,ts);
		
		if(slist==null)
		{
			slist=n1;
		}
		
		else
		{
			Process temp=slist;
			Process prev=null;

			while((temp.next!=null)&&(n1.in_time>temp.in_time))
			{
				prev=temp;
				temp=temp.next;
			}

			if(n1.in_time<temp.in_time)
			{
				prev.next=n1;
				n1.next=temp;
			}
		
			else
			{
				temp.next=n1;
			}
			
		}

		System.out.println("\n");
		//display();
	}

	public void display(Process hello)
	{
		if(hello==null)
		{
			System.out.println("List is empty ");
		}
		
		else	
		{
			Process temp=hello;

			while(temp.next!=null)
			{
				System.out.println("Process #"+temp.pid+" Process time : "+temp.service_time+"\n");
				temp=temp.next;
			}

			System.out.println("Process #"+temp.pid+" Process time : "+temp.service_time+"\n");
		}
	}
}
