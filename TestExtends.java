class test1
{
	void display()
	{
		System.out.println("test1...dispayed");
	}
}
class test2 extends test1
{
	void display()
	{
		System.out.println("test2 extends test1..");
	}
}
class TestExtends
{
	public static void main(String args[])
	{	try{
		test1 r1=new test1();
		test2 r2=new test2();
		test1 r3=new test2();
		test1 r4;
		r1=r2;
		r4=r2;
		r1.display();
		r2.display();
		r3.display();
		r4.display();
		}catch(Exception e){System.out.println(e);}
	}
}