import java.util.*;
public class VectorDemo
{
public static void main(String args[])throws Exception
{
Vector list=new Vector();
int len=args.length;
Vector v=new Vector();
Scanner scan=new Scanner(System.in);
System.out.println("enter rang:");
int rang =scan.nextInt();
for(int j=0;j<rang;j++)
{
v.addElement(scan.nextInt());
}
for(int i=0;i<len;i++)
{
list.addElement(args[i]);
}
list.insertElementAt("ex",2);
int s=v.size();
Integer Array[]=new Integer[s];
v.copyInto(Array);
for(int i=0;i<s;i++)
{
System.out.println(Array[i]);
}
}
}