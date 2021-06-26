
/** package parentof class parentof method
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


public class TestAccessModifiers
{
	public static void main(String[] args)
	{
		Parent p = new Parent();
		Child c = new Child();
		c.method();
		GrandChild gc = new GrandChild();
		gc.method();
	}
}

class Parent{
	String name= "itachi";
	String parent = "parent";

	private void method()
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
	void method() // private method can be overrided with public, protected, default
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