public class Process
{
	int pid; //Process ID
	int service_time; //Service Time
	int in_time;//Process In Time
	Process next;
	int time_serviced;
	boolean isArrived;
	public Process(int pid,int st, int it,int ts)
	{
		this.pid=pid;
		this.service_time=st;
		this.next=null;
		this.in_time=it;
		this.time_serviced=ts;
		isArrived=false;
	}
}
