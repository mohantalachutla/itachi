package packexp;
import packstudent.*;
import packsport.*;
class Test extends Student implements Sport
{
	public void equipment()
	{
		System.out.println("implements equipments...");
	}
}
public class Exp
{
public static void main(String args[])
{
Test ref=new Test();
ref.get_details();
ref.equipment();	
}
}