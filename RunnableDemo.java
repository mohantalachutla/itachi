class UserThread1 implements Runnable
{
String name;
UserThread1(String name)
{
this.name=name;
new Thread(this,this.name).start();
}
public void run()
{
for(int i=3;i>0;i--)
{
System.out.println(name+"\n");
try
{
Thread.sleep(1000);
}catch(Exception e){}
}
}
}
class UserThread2 implements Runnable
{
String name;
UserThread2(String name)
{
this.name=name;
new Thread(this,this.name).start();
}
public void run()
{
for(int i=3;i>0;i--)
{
System.out.println(name+"\n");
try
{
Thread.sleep(2000);
}catch(Exception e){}
}
}
}
class UserThread3 implements Runnable
{
String name;
UserThread3(String name)
{
this.name=name;
new Thread(this,this.name).start();
}
public void run()
{
for(int i=3;i>0;i--)
{
System.out.println(name+"\n");
try
{
Thread.sleep(3000);
}catch(Exception e){}
}
}
}
public class RunnableDemo
{
public static void main(String args[])
{
new UserThread1("good morning");
new UserThread2("hello");
new UserThread3("welcome");
try
{
Thread.sleep(18000); 
}catch(Exception e){}
}
}