import java.util.Scanner;
public class UserDefException
{
public static void main(String args[])
{
Scanner scan=new Scanner(System.in);
System.out.println("odd number:");
int num=scan.nextInt();
try
{
if(num%2==0)
throw new OddNumException("enter odd");
}catch(Exception e1){System.out.println(e1);}
}
}
class OddNumException extends Exception
{
String s;
OddNumException(String s)
{
this.s=s;
}
public String toString()
{
return "not a odd number:"+s;
}
}