package packstudent;
import java.util.*;
public class Student
{
Scanner scan=new Scanner(System.in);
public String name,roll_no;
public int rank;
/*public void over()
{
System.out.println("not over rided");
}*/
public void get_details()
{
System.out.println("enter name:");
name=scan.nextLine();
System.out.println("enter roll number:");
roll_no=scan.nextLine();
System.out.println("enter rank:");
rank=scan.nextInt();
}
}

