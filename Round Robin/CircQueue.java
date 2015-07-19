import java.util.Scanner;
public class CircQueue 
{
    Scanner in=new Scanner(System.in);
    Process first;
    int size;
    CircQueue(int size)
    {
        this.size =size;
       	first=new Process(0,0,0,0);
    }
    private int countNodes()
    {
        int count=0;
        Process temp=first;
        if(first.next==null)
        {	
		return 1;
        }   
        else do
        {
            count++;
            temp=temp.next;
        }while(temp!=first);
        return count;
    }
    public void insert(int x,int y, int z, int ts)
    {
        if(countNodes()==size+1)
        {
            System.out.println("Queue is full.");
        }
        else 
        {
            Process t=new Process(x,y,z,ts);
            if(first.next==null)
            {
                first.next=t;
                t.next=first;
		System.out.println("Process#"+t.pid+" inserted in to the queue.");
            }
            else
            {
                Process temp=first.next;
                while(temp.next!=first)
                {
                    temp=temp.next;
                }
                temp.next=t;
                t.next=first;
		System.out.println("Process#"+t.pid+" inserted in to the queue.");
            }
        }
    }
    public Process remove()
        {
            if(countNodes()==1)
            {
                System.out.println("Queue is Empty");
                return null;
            }
            else
            {
		System.out.println("Sending process#"+first.next.pid+" for processing.");
		Process temp=first.next;
		first.next=first.next.next;
		System.out.println("Now in top of queue is : Process#"+first.next.pid);
		return temp;
            }
        }
    
public void display()
{
    if(first.next!=first)
    {
        Process temp=first.next;
        while(temp!=first)
        {
            System.out.println(temp.pid);
            temp=temp.next;
        }
    }
}
}

