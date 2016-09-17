class check_constructer
{	
int a=10,b=9;
check_constructer()
{
a=a+b;
System.out.println("in constructer:"+a);
}
}
class check
{
public static void main(String args[])
{
check_constructer ch=new check_constructer();
}
}