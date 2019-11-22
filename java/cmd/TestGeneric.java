import java.util.*;
import java.lang.annotation.*;

@FunctionalInterface
interface PDLOverrideSupported{
	void print(Object o);
}
public class TestGeneric
{
	public static void main(String[] args)
	{
		MainBlock mb = new MainBlock();
		//mb.usage();
		//mb.generic();
		mb.genericFun();
	}
}
class MainBlock
{
	Student std,std1,std2,std3,std4,std5;
	List<Integer> intArr;
	List<Character> charArr;
	List<Student> stds;
	P p = System.out::println;
	P p2 = System.out::print;
	public MainBlock()
	{
		//<?, extends Collection<T extends Object> var = new <?, extends Collection> <>();
		//List<int> intArr1 = new ArrayList(); // error, GenericType should be inherited from Object.
		intArr = new ArrayList();
		intArr.add(23);
		intArr.add(56);
		intArr.add(89);
		//intArr.add('7'); // error
		//intArr.add('A'); // error
		intArr.forEach(e -> p.print(e));
		
		charArr = new ArrayList();
		charArr.add('A');
		charArr.add('o');
		charArr.add('9');
		//charArr.add(9); // error
		
		charArr.forEach(e -> p.print(e));
		
		std =new Student("Kensen",0,78,"Assasian");
		std1 =new Student("Mohan",1,23,"IT");
		std2 =new Student("Shamu",2,25,"CSE");
		std3 =new Student("Pav",3,22,"CSE");
		std4 =new Student("Chanti",4,24,"ECE");
		std5 =new Student("Naidu",5,23,"IT");
		stds = new ArrayList();
		stds.add(std);
		stds.add(std1);
		stds.add(std2);
		stds.add(std3);
		stds.add(std4);
		stds.add(std5);
		stds.forEach(e -> p.print(e));
		p.print("---------------------------------------------------------");
	}
	public void usage()
	{
		std.setName("Sasuke");
		p.print("std"+std);
		GenericStd<Student> gen = new GenericStd<Student>(std);
		std = gen.modify(std,"Itachi");
		p.print(std);
		//gen.printObject();
	}
	void generic()
	{
		p.print("std -->"+std);
		Generic<Student,String> gen = new Generic(std);
		//Generic<Integer,String> gen = new Generic(std); // error : type argument Integer is not within bounds of type-variable T
		std = gen.modify(std,"Itachi");
		p.print("std"+std);
	}
	void genericFun()
	{
		p.print("std -->"+std);
		GenericFun gen = new GenericFun();
		//std = gen.modify(std,"Itachi"); // error : incompatible types: List<Student> cannot be converted to Student
		std = gen.modify(std,"Itachi");
		p.print("std"+std);
		gen.printAll(stds);
	}
}
// genetic class proto
// definition : class Name<T>
// invocation : Name<T> ojb = new Name();
// where T extends Object
//You can't directly access memeber t of type T cause at compile tim it can not identify the methods but you can access it through reflection.
class GenericStd<Student>
{
	P p = System.out::println;
	P p2 = System.out::print;
	private Student std;
	private Class cls;
	GenericStd()
	{
		
	}
	GenericStd(Student std)
	{
		this.std = std;
		this.cls = std.getClass();
	}
	Student modify(Student std,String str)
	{
		try
		{
			this.cls.getDeclaredMethod("setName",String.class).invoke(std,str);
		}
		catch(NoSuchMethodException | NullPointerException e)
		{
			p.print(e.getMessage());
		}
		catch(Exception e)
		{
			p.print(e.getMessage());
		}
		return std;
	}
	public void printObject()
	{
		try
		{
			System.out.println(this.cls.toString());
			System.out.println(this.cls.getDeclaredMethod("getName").invoke(std));
		}
		catch(NoSuchMethodException | NullPointerException e)
		{
			p.print(e.getMessage());
		}
		catch(Exception e)
		{
			p.print(e.getMessage());
		}
	}
}

//every object extends Object, no need to write it again, can provide more retriction by giving classes and interfaces.
class Generic<T extends Human,U extends Object>
{
	P p = System.out::println;
	P p2 = System.out::print;
	private T t;
	private Class cls;
	Generic()
	{
		
	}
	Generic(T t)
	{
		this.t = t;
		this.cls = t.getClass();
		this.printFields();
	}
	void printFields()
	{
		p.print("t -->"+t);
		p.print("cls  -->"+cls);
	}
	T modify(T t,U u)
	{
		try
		{
			this.cls.getDeclaredMethod("setName",u.getClass()).invoke(t,u);
		}
		catch(NoSuchMethodException | NullPointerException e)
		{
			p.print(e.getMessage());
		}
		catch(Exception e)
		{
			p.print(e.getMessage());
		}
		return t;
	}
}


class GenericFun
{
	P p = System.out::println;
	P p2 = System.out::print;
	
	<T extends Human,U extends Object> T modify(T t,U u)
	{
		try
		{
			t.getClass().getDeclaredMethod("setName",u.getClass()).invoke(t,u);
		}
		catch(NoSuchMethodException | NullPointerException e)
		{
			p.print(e.getMessage());
		}
		catch(Exception e)
		{
			p.print(e.getMessage());
		}
		return t;
	}
	//super means its very own parent, not ancestors
	// notice ? super
	<T extends List<? super Student>,S extends Human> void printAll(T t)
	{
		p.print("printAll -->");
		for(Object s: t) // not accepting S as a type
		{
			p.print(s);
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
interface Human
{
	default void human()
	{
		System.out.println("Human interface");
	}
}
@Provider(intValue = 23)
class Student implements Human
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
	public void setName(String name)
	{
		this.name = name;
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
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getDept()
	{
		return this.dept;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
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