import java.util.*;
import java.util.stream.*;

// all the members, both variable and functions are accessed at type level except the member functions which can be overriden are accessed at contructor level

public class TestUpCasting
{
	public static void main(String[] args)
	{
		Parent p = new Parent(); //no casting
		System.out.println("Parent p new Parent");
		p.method();
		p.parent();
		System.out.println(p.name);
		System.out.println(p.parent);

		Child c = new Child();
		System.out.println("Child p new Child");
		c.method(); // override
		c.parent();	// inherited
		c.child();
		System.out.println(c.name); // overrided
		System.out.println(c.parent); // inherited
		System.out.println(c.child);

		
		Parent p_ = new Child(); // upcasting
		System.out.println("Parent p_ new Child");
		p_.method();
		p_.parent();
		//p_.child(); not accessible, cause of upcasting
		System.out.println(p_.name);
		System.out.println(p_.parent);
		//System.out.println(p_.child); // not accessible, upcasted


		Child c_ = new GrandChild(); //upcasting
		System.out.println("Child c_ new GrandChild");
		c_.method(); // overrded
		c_.parent();
		c_.child();
		//c_.garndChild(); // upcasted to Child, not accessible

		System.out.println(c_.name);
		System.out.println(c_.parent);
		System.out.println(c_.child);
		//System.out.println(c_.garndChild); // upcasted
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
	String garndChild = "garndChild";
	public void method()
	{
		System.out.println("method from GrandChild");
	}
	void garndChild()
	{
		System.out.println("I'm garndChild");
	}
}