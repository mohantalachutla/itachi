import java.lang.annotation.*;
import java.util.*;
import java.lang.reflect.*;

@FunctionalInterface
interface P
{
	void print(Object o);
}
public class TestOptional
{
	public static void main(String[] args)
	{
		MainBlock mb = new MainBlock();
		//mb.main();
		mb.main2();
	}
}

class MainBlock
{
	// optional class can be used to avoid NullPointerException, in such case it retuns Optional.empty object. It supports FunctionalInterface methods.
	P p = System.out::println;
	void main()
	{
		String firstName = "Mohan";
		String lastName = "Talachutla";
		String middleName = "Rao";
		
		Optional<String> opn = Optional.of(firstName);
		Optional<String> opn1 = Optional.of("");
		//Optional<String> opn2 = Optional.of(null);  // NullPointerException. doesn't take null
		Optional<String> opn2 = Optional.ofNullable(null);
		stringop1(opn, "Itachi","Moh");
		p.print("\n\n\n");
		stringop1(opn, "Itachi","Nai");
		p.print("\n\n\n");
		stringop1(opn1, "Itachi","Nai");
		p.print("\n\n\n");
		stringop1(opn2, "Itachi","Nai");
	}
	void main2()
	{
		Student std =null;
		Student std1 =new Student("Mohan",1,23,"IT");
		Student std2 =new Student("Shamu",2,25,"CSE");
		Student std3 =new Student("Pav",3,22,"CSE");
		Student std4 =new Student("Chanti",4,24,"ECE");
		Student std5 =new Student("Naidu",5,23,"IT");
		Student std6 =new Student("Itachi",9,188,"Shinobi");
		
		
		Optional<Student> opn = Optional.ofNullable(std);
		Optional<Student> opn1 = Optional.of(std1);
		Optional<Student> opn2 = Optional.of(std2);
		Optional<Student> opn3 = Optional.of(std3);
		Optional<Student> opn4 = Optional.empty();
		Optional<Student> opn6 = Optional.of(std6);
		
		
		stringop2(opn1, std1);
		p.print("\n\n\n");
		stringop2(opn2, std6);
		p.print("\n\n\n");
		stringop2(opn4, std6);
		p.print("\n\n\n");
		stringop2(opn, std6);
	}
	void stringop1(Optional<String> opn, String... args)
	{
		//get throws NoSuchElementException in case of null or empty
		try{
			p.print("Optional ="+opn);
			p.print("isPresent() ="+opn.isPresent());
			opn.ifPresent((s) -> p.print("ifPresent() "+s));
			p.print("equals() ="+opn.equals(args[0]));
			//p.print("get() ="+opn.get());
			p.print("orElse() ="+opn.orElse(args[0]));
			p.print("orElseGet() ="+opn.orElseGet(() -> args[0]));
			p.print("filter() ="+opn.filter(o -> o.startsWith(args[1])));
			//p.print("filter().get() ="+opn.filter(o -> o.startsWith(args[1])).get());  // NoSuchElementException on Optinal.empty
			p.print("filter().orElse() ="+opn.filter(o -> o.startsWith(args[1])).orElse(args[0]));
			p.print("filter().orElseGet() ="+opn.filter(o -> o.startsWith(args[1])).orElseGet(() -> args[0]));
		}
		catch(NullPointerException | NoSuchElementException e)
		{
			p.print("caught ->"+e.getMessage());
		}
	}
	void stringop2(Optional<Student> opn, Student... args)
	{
		//get throws NoSuchElementException in case of null or empty
		try{
			p.print("Optional ="+opn);
			p.print("isPresent() ="+opn.isPresent());
			opn.ifPresent((s) -> p.print("ifPresent() "+s));
			p.print("equals() ="+opn.equals(args[0]));
			//p.print("get() ="+opn.get());
			p.print("orElse() ="+opn.orElse(args[0]));
			p.print("orElseGet() ="+opn.orElseGet(() -> args[0]));
			p.print("filter() ="+opn.filter(o -> o.getAge() > o.getClass().getAnnotation(Provider.class).intValue()));
			//p.print("filter().get() ="+opn.filter(o -> o.getAge() > o.getAge().getAnnotation(Provider.class).intValue()).get());  // NoSuchElementException on Optinal.empty
			p.print("filter().isPresent() ="+opn.filter(o -> o.getAge() > o.getClass().getAnnotation(Provider.class).intValue()).isPresent());
			p.print("filter().orElse() ="+opn.filter(o -> o.getAge() > o.getClass().getAnnotation(Provider.class).intValue()).orElse(args[0]));
			p.print("filter().orElseGet() ="+opn.filter(o -> o.getAge() > o.getClass().getAnnotation(Provider.class).intValue()).orElseGet(() -> args[0]));
			p.print("map().orElse ="+opn.map(o -> o.getName()).orElse(args[0].getName()));
			p.print("map().orElseGet() ="+opn.map(o -> o.getName()).orElseGet(() -> args[0].getName()));
		}
		catch(NullPointerException | NoSuchElementException e)
		{
			p.print("caught ->"+e.getMessage());
		}
	}
}


@Target({ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Provider
{
	int intValue() default 0;
	float floatValue() default 0.0f;
	double doubleValue() default 0.0f;
	String stringValue() default "";
}
@Provider(intValue = 23)
class Student
{
	Student(String name, int id, int age, String dept)
	{
		this.name = name;
		this.id = id;
		this.age = age;
		this.dept = dept;
	}
	Student()
	{
		
	}
	private String name;
	private int id;
	private int age;
	private String dept;
	
	public String getName()
	{
		return this.name;
	}
	public int getId()
	{
		return this.id;
	}
	@Provider(intValue = 23)
	public int getAge()
	{
		return this.age;
	}
	public String getDept()
	{
		return this.dept;
	}
	
	public boolean ageLimit(Student s)
	{
		return (s.getAge() >=s.getClass().getAnnotation(Provider.class).intValue());
		//return true;
	} 
	
	@Override
	public String toString()
	{
		return "Name : "+this.name
		+ ", Id : "+this.id
		+ ", Age : "+this.age
		+ ", Dept : "+this.dept;
	}
}

class NameComparator implements Comparator
{
	@Override
	public int compare(Object o1,Object o2)
	{
		Student s1 =(Student)o1;
		Student s2 =(Student)o2;
		return s1.getName().compareTo(s2.getName());
	}
}

/*
public boolean    equals(java.lang.Object)
public boolean    isPresent()
public final native java.lang.Class    getClass()
public final native void    notify()
public final native void    notifyAll()
public final native void    wait(long)
public final void    wait()
public final void    wait(long,int)
public int    hashCode()
public java.lang.Object    get()
public java.lang.Object    orElse(java.lang.Object)
public java.lang.Object    orElseGet(java.util.function.Supplier)
public java.lang.Object    orElseThrow(java.util.function.Supplier)
public java.lang.String    toString()
public java.util.Optional    filter(java.util.function.Predicate)
public java.util.Optional    flatMap(java.util.function.Function)
public java.util.Optional    map(java.util.function.Function)
public static java.util.Optional    empty()
public static java.util.Optional    of(java.lang.Object)
public static java.util.Optional    ofNullable(java.lang.Object)
public void    ifPresent(java.util.function.Consumer)
*/