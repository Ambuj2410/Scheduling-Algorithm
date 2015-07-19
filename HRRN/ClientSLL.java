import java.util.Scanner;

public class ClientSLL
{
   public static void main(String[] args)
   {
      int n1=0;
      
      Scanner in=new Scanner(System.in);
      System.out.println("Enter The number of process");
      int number=in.nextInt();
      int count=number;
        Slist object=new Slist(number);
      for(int i=0;i<count;i++)
      {
      
         object.frontins();
      }
     //object.display();
      for(int i=0;i<count;i++)
         object.Pos();
      object.display();
      
   }
}
      
