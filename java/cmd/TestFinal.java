
/**
 * final class can not be inherited
 * final method can not be overrided
 * final variable can not be modified
 * 
 * 
 */

public class TestDownCasting
{
	public static void main(String[] args)
	{
		
	}
}

class Parent{
	String name= "itachi";
	String parent = "parent";

	void method()
	{
		System.out.println("method from Parent");
	}
	void parent()
	{
		System.out.println("I'm parent");
	}
}

class Child extends Parent{
	String name = "sasuke"; 
	String child = "child";
	protected void method()
	{
		System.out.println("method from Child");
	}
	void child()
	{
		System.out.println("I'm child");
	}
}
class GrandChild extends Child{
	String name = "sarada";
	String grandChild = "grandChild";
	public void method()
	{
		System.out.println("method from GrandChild");
	}
	void grandChild()
	{
		System.out.println("I'm grandChild");
	}
}