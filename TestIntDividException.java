import java.util.*;
class TestIntDividException
{
public static void main(String args[])
{
Scanner scan=new Scanner(System.in);
System.out.println("enter any two integers:");
int num1,num2;
float div;
try
{
num1=Integer.parseInt(scan.nextLine());
num2=Integer.parseInt(scan.nextLine());
div=num1/num2;
System.out.println("division:"+div);
}
catch(ArithmeticException e){System.out.println(e);}
catch(NumberFormatException e){System.out.println(e);}
}
}