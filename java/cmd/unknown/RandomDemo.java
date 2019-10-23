import java.util.*;
class RandomDemo
{
public static void main(String args[])
{
Random random=new Random();
System.out.println("enter range:");
Scanner scan=new Scanner(System.in);
int start=scan.nextInt();
int end=scan.nextInt();
System.out.println("enter no.Of numbers to be print");
int num=scan.nextInt();
int count=0;
int number;
while(count!=num)
{
number=random.nextInt(end);
if(number>start)
{
count++;
System.out.println(number);
}
}
}
}