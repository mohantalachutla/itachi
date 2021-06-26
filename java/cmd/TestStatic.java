
/**
 * static methods can be inherited 
 * static methods can override static methods
 * instance methods can NOT override static methods
 * static methods can NOT override instace methods
 * static methods can be accessed by instace, Type
 * instace method can NOT  accessed by Type
 * 
 * package parentof class parentof method
 * public > protected > default > private
 * you can not reduce the acccessibility
 * default is not a access keyworkd, but not spesifying one is default
 * Can be applied to classs, fields, methods
 * public items can be accessed anywhere
 * protected items can be accessed with-in the class, sub class of current package, non-sub class, sub class of other package
 * default items can be accessess with-in, sub, non-sub of current package
 * private items are on with-in the class
 * 
 * 
*/


public class TestStatic
{
	public static void main(String[] args)
	{
		Parent p = new Parent();
		Parent.method();
		// Parent.parent(); // error
		p.method(); // static can be accessed by instance, Type
		Child c = new Child();
		//c.method();
		Child.method();
		GrandChild gc = new GrandChild();
		gc.method();
		GrandChild.method();

		GrandChild2 gc2 = new GrandChild2();
		//gc2.method();
		GrandChild2.method();
	}
}

class Parent{
	String name= "itachi";
	String parent = "parent";

	static void method()
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
	protected static void method()
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

	void grandChild()
	{
		System.out.println("I'm grandChild");
	}
}
class GrandChild2 extends Child{
	String name = "sarada";
	String grandChild = "grandChild";
	public static void method()
	{
		System.out.println("method from GrandChild");
	}
	void grandChild()
	{
		System.out.println("I'm grandChild");
	}
}