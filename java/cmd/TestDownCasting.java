import java.util.*;
import java.util.stream.*;


// down casting is nothing but undo of upcasting

// all the members, both variable and functions are accessed at type level except the member functions which can be overriden are accessed at contructor level

public class TestDownCasting
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


		// Child _p = new Parent(); // compilation error

		Child _c = (Child) p_; // Down Casting
		System.out.println("down casting");
		_c.method();
		_c.parent();
		_c.child();
		System.out.println(_c.name);
		System.out.println(_c.parent);
		System.out.println(_c.child); // not accessible, upcasted





		Child c_ = new GrandChild(); //upcasting
		System.out.println("Child c_ new GrandChild");
		c_.method(); // overrded
		c_.parent();
		c_.child();
		//c_.grandChild(); // upcasted to Child, not accessible
		System.out.println(c_.name);
		System.out.println(c_.parent);
		System.out.println(c_.child);
		//System.out.println(c_.grandChild); // upcasted

		Parent p__ = new GrandChild(); //upcasting
		System.out.println("Parent p__ new GrandChild");
		p__.method(); // overrded
		p__.parent();
		//p__.child(); // upcasted to Parent, not accessible
		//p__.grandChild(); // upcasted to Parent, not accessible
		System.out.println(p__.name);
		System.out.println(p__.parent);
		//System.out.println(p__.child); // upcasted
		//System.out.println(p__.grandChild); // upcasted

		Child _c1 = (GrandChild) p__;
		System.out.println("Down casted");
		_c1.method(); // overrded
		_c1.parent();
		_c1.child(); // downcasted to Child, thus accessible
		//_c1.grandChild(); // upcasted to Child, not accessible
		System.out.println(_c1.name);
		System.out.println(_c1.parent);
		System.out.println(_c1.child); // downcasted
		//System.out.println(_c1.grandChild); // upcasted

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