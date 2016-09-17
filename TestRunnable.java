class Parent extends Thread
{
void print(int value)
{
System.out.println(value);
}
}
class Child extends Parent
{
String name;
Child(String name)
{
this.name=name;
new Thread(this,name).start();
}
public void run()
{
for(int i=5;i>0;i--)
{
print(i);
try
{
Thread.sleep(1000);
}catch(Exception e){}
}
}
}
public class TestRunnable
{
public static void main(String args[])
{
new Child("test");
try
{
Thread.sleep(5000);
}catch(Exception e){}
}
}