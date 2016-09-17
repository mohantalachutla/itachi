class TestMultiCatch
{
public static void main(String args[])
{
int a=1,b=1,d[]={2,2},c=0;
try
{
a=b/c;
d[3]=9;
}catch(ArithmeticException|ArrayIndexOutOfBoundsException e)
{
System.out.println("Exception:"+e);
}
}
}