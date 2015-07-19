import java.util.*;
public class List
{
	Process head;
	public List()
	{
		this.head = null;
	}
	public void end_ins(int x, int y, int z, int ts)
	{
		Process process = new Process(x,y,z,ts);
		
		if(head==null)
		{
			head=process;
		}
		
		else
		{
			Process temp=head;

			while(temp.next!=null)
			{
				temp=temp.next;
			}
			
			temp.next=process;
			//process.next=head;			
		}
	}
	public void front_ins(int x, int y, int z, int ts)
	{
		Process process = new Process(x,y,z,ts);
		if(head==null)
		{
			head=process;
		}
		else
		{
			process.next=head;
			head=process;
		}
	}
	public void position_ins(int x, int y,int z,int pos ,int ts)
	{
		Process process = new Process(x,y,z,ts);
		Scanner in=new Scanner(System.in);
		if(head==null&&pos==1)
		{
			front_ins(x,y,z,ts);
		}
		else if(head==null&&pos!=1)
		{
			System.out.println("Invalid Position");
		}
		else
		{
			Process temp=head;
			Process prev=null;
			int i=1;
			while(temp.next!=null&&i<pos)
			{
				prev=temp;
				temp=temp.next;
				i++;
			}
			if(pos==i)
			{
				prev.next=process;
				process.next=temp;
			}
		
			else if((i+1)==pos)
			{
				temp.next=process;
			}

			else 
			{
				System.out.println("Invalid Position ");
			}
		}
	}
	public void display(Process hello)
	{
		if(hello==null)
		{
			System.out.println("Lis is empty ");
		}
		
		else	
		{
			Process temp=hello;

			while(temp.next!=null)
			{
				System.out.print("Process #"+temp.pid+" Total service time is : "+temp.service_time+"\n");
				temp=temp.next;
			}
			System.out.print("Process #"+temp.pid+" Total service time is : "+temp.service_time+"\n");
		}
	}
	public int TotalTime(Process time)
	{
		if(time==null)
		{
			System.out.println("Lis is empty ");
			return 0;
		}
		else
		{
			Process temp=time;
			int sum=0;
			while(temp.next!=null)
			{
				//int sum;
				sum=sum+temp.service_time;
				temp=temp.next;
			}
			sum=sum+temp.service_time;
			return sum;
		}
	}
	
}
