class Store
{
int n=0,count;
boolean flag=false;
synchronized void push()
{
for(count =4;count>0;count--)
{
while(flag)
{
try
{
wait();
}catch(Exception e){}
}
System.out.println("produced: "+(++n));
flag=true;
notify();
}
}
synchronized void pop()
{
for(count =4;count>0;count--)
{
while(!flag)
{
try
{
wait();
}catch(Exception e){}
}
System.out.println("consumed: "+(--n));
flag=false;
notify();
}
}
}
class Producer implements Runnable
{
String tname;
Store st;
Producer(Store st1,String name)
{
tname=name;
st=st1;
new Thread(this,tname).start();
}
public void run()
{
st.push();
}
}
class Consumer implements Runnable
{
Store st;
String tname;
Consumer(Store st1,String name)
{
st=st1;
tname=name;
new Thread(this,tname).start();
}
public void run()
{
st.pop();
}
}
class ProducerConsumer
{
public static void main(String args[])
{
Store st=new Store();
new Producer(st,"producer");
new Consumer(st,"consumer");
}
}