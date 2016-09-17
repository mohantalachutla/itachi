import java.util.*;
class TokenizerDemo
{
public static void main(String args[])
{
Scanner scan=new Scanner(System.in);
System.out.println("enter a sentence:");
String str=scan.nextLine();
StringTokenizer st=new StringTokenizer(str," ");
int sum=0;
while(st.hasMoreTokens())
{
//System.out.println(st.nextToken());
sum+=Integer.parseInt(st.nextToken());
}
System.out.println(sum);
}
}