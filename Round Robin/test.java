public class test
{
	public static void main(String[] args)
	{
		CircQueue  l = new CircQueue();
		//List l1 = new List();
		l.insert(1,2,3);
		//l1.end_ins(10,11,12);
		l.insert(2,2,3);
		l.insert(3,2,3);
		l.insert(4,2,3);
		l.insert(5,2,3);
		l.display();
		l.remove(1,2,3);
		l.insert(6,2,3);
		l.display();
		//l1.display(); 
	}
}
