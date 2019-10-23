import java.util.*;
import java.math.*;
class WrapperDemo
{
public static void main(String args[])throws Exception
{
Scanner scan=new Scanner(System.in);
System.out.println("enter string:");
String s=scan.nextLine();
System.out.println("enter a number:");
int a=scan.nextInt();
System.out.println(a);
Integer j=new Integer(a);
System.out.println("number is:"+j+"string is:"+s);
int c=Integer.parseInt(s);
System.out.println("int :"+c);
String st=Integer.toString(j);
int v=j.intValue();
Integer i=Integer.valueOf(st);
System.out.println("object to prim:"+v+"object to string:"+st+"string to object:"+i);
BigDecimal b=new BigDecimal(j);
System.out.println("moving left:"+b.movePointLeft(9));
System.out.println("moving left:"+b.movePointRight(9));
}
}