import java.util.Scanner;
public class client
{
	public static void main(String[] args)
	{
		int no_of_process;
		int time_slice;
		Scanner in = new Scanner(System.in);
		OList list = new OList();
		System.out.println("Initiating....");
		System.out.println("Enter no of process you want to spawn initially");
		no_of_process=in.nextInt();
		for(int i=0;i<no_of_process;i++)
		{
			System.out.println("Enter Arrival time : ");
			int it=in.nextInt();
			System.out.println("Enter service time : ");
			int st=in.nextInt();
			System.out.println("Spawning Process#"+i);
			list.ordered_list(i,st,it,0);
		}
		System.out.println("Process spawning complete");
		System.out.println("Insert the time slice for Round Robin : ");
		time_slice=in.nextInt();
		RoundRobin rr = new RoundRobin(time_slice,list.slist,no_of_process);
	}
}
