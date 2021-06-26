
/**
 * by default, all methods in interface public abstract
 * by default, can not have body
 * by default, all fields in interface final public static
 * 
 * 
 * public, private, default(not a modifier), static, abstract, strictfp are only used in interface
 * static methods can, must have body, will be static
 * default methods can,must have body, will be instance type, can not be accessed by type
 * default is not a access modifier, but a keyword can only used in interface, switch case
 * 
 * 
*/


public class TestInterfaceVsAbstract
{
	public static void main(String[] args)
	{
		IParent.method();
		Parent p = new Parent();
		Parent.method();
		// IParent.builtin(); error
		p.method(); // static can be accessed by instance, Type
		Child c = new Child();
		//c.method();
		c.child();
		// Child.child(); error
		Child.method();
		GrandChild gc = new GrandChild();
		gc.method();
		GrandChild.method();

		GrandChild2 gc2 = new GrandChild2();
		//gc2.method();
		GrandChild2.method();
	}
}


interface IParent{
	static void method(){
		System.out.println("method from IParent");
	}
	void parent();
	default void builtin()
	{
		System.out.println("I'm built in function");
	}
} 
interface IChild{
	static void method(){
		System.out.println("method from IParent");
		another2(); // possible
	}
	default void child()
	{
		System.out.println("I'm built function");
		another(); // possible
	}
	private void another()
	{
		System.out.println("I'm another function");
	}
	private static void another2()
	{
		System.out.println("I'm another2 function");
	}
} 
class Parent implements IParent{
	String name= "itachi";
	String parent = "parent";

	static void method()
	{
		System.out.println("method from Parent");
	}
	public void parent()
	{
		System.out.println("I'm parent");
	}

}

class Child extends Parent implements IChild{
	String name = "sasuke"; 
	String child = "child";
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
	String name = "sarada2";
	String grandChild = "grandChild2";
	public static void method()
	{
		System.out.println("method from GrandChild2");
	}
	void grandChild()
	{
		System.out.println("I'm grandChild2");
	}
}