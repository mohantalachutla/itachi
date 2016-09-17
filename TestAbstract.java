abstract class  Abstract1
{
abstract void method();
void method2()
{
System.out.println("in m2");
}
}
class Abstract2 extends Abstract1
{
void method()
{
System.out.println("in 2");
}
void method2()
{
System.out.println("over ride");
}
}
class TestAbstract
{
public static void main(String args[])
{
Abstract2 a=new Abstract2();
a.method();
a.method2();
}
}