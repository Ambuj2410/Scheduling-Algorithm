public class RoundRobin
{
	int time_slice;//Time slice for Round Robin
	Process pro;//Header of the first process of initial given list
	int total_time;//Total Execution Time of Processes
	int execution_time;//Current execution time
	int current_exection_time=0;//to check time slice
	int size;//size of wait queue
	CircQueue cq;
	int[][] a=new int[5][20];
	public RoundRobin(int t, Process pro,int size)
	{
		this.time_slice=t;
		this.pro=pro;
		this.size=size;
		List l = new List();
		for(int i=0;i<5;i++)
			for(int j=0;j<20;j++)
				a[i][j]=0;
		System.out.println("Displaying The initial list : ");
		l.display(pro);
		total_time=l.TotalTime(pro);
		System.out.println("Total execution time is "+l.TotalTime(pro)+" units of time.");
		execution_time=0;
		current_exection_time=0;
		System.out.println("Starting Execution...");
		cq = new CircQueue(size);
		if(time_slice==1)
			executionIfTimesliceIsOne();
		else
			execution();
		display(total_time,size);
		System.out.println("Execution complete!");
	}
	public void executionIfTimesliceIsOne()
	{
		
		Process temp=pro;
		Process t2=null;
		if(IsArrived(temp))
		{
			System.out.println("Starting insertion of "+temp.pid+" with service time "+temp.service_time);
			cq.insert(temp.pid,temp.service_time,temp.in_time,temp.time_serviced);
			t2=cq.remove();
			SendForProcessing(t2);
		}
		else
		{
			System.out.println("No process in queue.");
			execution_time++;
			System.out.println("No process to execute at "+ execution_time);
		}
		while(execution_time<=total_time)
		{
			insertArrivedProcessOne(temp);
			if(!IsServiceComplete(t2))
			{
				cq.insert(t2.pid,t2.service_time,t2.in_time,t2.time_serviced);
			}
			t2=cq.remove();
			SendForProcessing(t2);
		}	
	}
	public void execution()
	{
		
		Process temp=pro;
		Process t2=null;
		if(IsArrived(temp))
		{
			System.out.println("Starting insertion of "+temp.pid+" with service time "+temp.service_time);
			cq.insert(temp.pid,temp.service_time,temp.in_time,temp.time_serviced);
			t2=cq.remove();
			SendForProcessing(t2);
		}
		else
		{
			System.out.println("No process in queue.");
			execution_time++;
			System.out.println("No process to execute at " + execution_time);
		}
		while(execution_time<=total_time)
		{
			insertArrivedProcess(temp.next);
			if(!IsServiceComplete(t2))
			{
				cq.insert(t2.pid,t2.service_time,t2.in_time,t2.time_serviced);
			}
			t2=cq.remove();
			SendForProcessing(t2);
		}	
	}
	public void SendForProcessing(Process process)
	{
		if(process == null)
		{ 
			execution_time++;
			System.out.println("Process finished executing or no process to execute at Execution time : "+execution_time);
			//initialise(0,execution_time);
		}
		else
		{
			System.out.println("Starting processing of Process #"+process.pid+" with time serviced already is " + 				process.time_serviced);
			System.out.println("Process #"+process.pid+" Total service time : "+process.service_time);
			while(!IsServiceComplete(process) && !(current_exection_time==time_slice))
			{
				current_exection_time++;
				process.time_serviced++;
				execution_time++;
				System.out.println("Executed Process#"+ process.pid + " at execution time " + execution_time);
				initialise(process.pid,execution_time);
			}
			current_exection_time=0;
		}
	}
	public void insertArrivedProcessOne(Process temp)
	{
		while(temp.next!=null)
		{
			if(checkIfProcessArriveForFirstTime(temp))
			{
				cq.insert(temp.pid,temp.service_time,temp.in_time,temp.time_serviced);
			}
			temp=temp.next;
		}
		if(checkIfProcessArriveForFirstTime(temp))
		{
			cq.insert(temp.pid,temp.service_time,temp.in_time,temp.time_serviced);
		}
	}
	public void insertArrivedProcess(Process temp)
	{
		while(temp.next!=null)
		{
			if(IsArrived(temp) && !temp.isArrived)
			{
				temp.isArrived=true;
				cq.insert(temp.pid,temp.service_time,temp.in_time,temp.time_serviced);
			}
			temp=temp.next;
		}
		if(IsArrived(temp) && !temp.isArrived)
		{
			temp.isArrived=true;
			cq.insert(temp.pid,temp.service_time,temp.in_time,temp.time_serviced);
		}
	}
	public boolean checkIfProcessArriveForFirstTime(Process check)
	{
		System.out.println("Process#"+check.pid+" intime is "+check.in_time);
		System.out.println("Execution time is : "+execution_time);
		if(check.in_time==execution_time)
		{
			System.out.println("Process is arriving for first time.");
			return true;
		}
		else
		{
			//System.out.println("process in not arrived or may have arrived earlier.");
			return false;
		}
	}
	public boolean IsArrived(Process check)
	{
		System.out.println("Process#"+check.pid+" intime is "+check.in_time);
		System.out.println("Execution time is : "+execution_time);
		if(check.in_time<=execution_time && check.time_serviced == 0)
		{
			System.out.println("Process is arrived.");
			return true;
		}
		else
		{
			//System.out.println("process in not arrived or arrived earlier.");
			return false;
		}
	}
	public boolean IsServiceComplete(Process check)
	{
		if(check == null)
		{
			System.out.println("No process in queue");
			return true;
		}
		else
		{
			System.out.println("Total service time required by process#"+check.pid+"is : "+check.service_time);
			System.out.println("serviced time : "+check.time_serviced);
			if(check.service_time<=check.time_serviced)
			{
				System.out.println("Service complete.");
				return true;
			}
			else
			{
				//System.out.println("Service remaining.");
				return false;
			}
		}
	}
	public void initialise(int x, int y)
	{
		a[x][y-1]=1;
	}
	public void display(int n,int m)
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


