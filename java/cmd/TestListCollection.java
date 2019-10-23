import java.util.*;
import java.util.function.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class TestListCollection
{
	public static void main(String args[])
	{
		MainBlock mb = new MainBlock();
		mb.mian();
		//mb.getAllmethods(Spliterator.class);
	}
}
@FunctionalInterface
interface P
{
	void print(Object o);
}
class MainBlock
{
	P p = System.out::println;
	void mian()
	{
		Predicate<Student> pre = null;
		Student std1 =new Student("Mohan",1,23,"IT");
		Student std2 =new Student("Shamu",2,25,"CSE");
		Student std3 =new Student("Pav",3,22,"CSE");
		Student std4 =new Student("Chanti",4,24,"ECE");
		Student std5 =new Student("Naidu",5,23,"IT");
		
		Student std6 =new Student("Laxmi",6,43,"Hkeep");
		Student std7 =new Student("Lakshman",7,45,"Form");
		Student std8 =new Student("Jagadhi",8,42,"Hkeep");
		Student std9 =new Student("Itachi",9,188,"Shinobi");
		Student std10 =new Student("Jagadhi",10,142,"Shinobi");
		
		
		List<Student> stds = new ArrayList(4);
		stds.clear();
		stds.add(std1);
		stds.add(std2);
		stds.add(std3);
		stds.add(std4);
		p.print("size =>"+stds.size()+"stds =>"+stds);
		stds.add(std9);
		p.print("size =>"+stds.size()+"stds =>"+stds);
		verTab(3);
		// inserting
		stds.add(2, std5);
		// setting 
		stds.set(4,std6);
		p.print("size =>"+stds.size()+"stds =>"+stds);
		verTab(3);
		List<Student> stds2 = Arrays.asList(std7,std8,std1,std9);
		stds.addAll(stds2);
		p.print("indexOf(int) =>"+stds.indexOf(std1));
		p.print("lastIndexOf(int) =>"+stds.lastIndexOf(std1));
		p.print("remove(int) =>"+stds.remove(1));
		p.print("contains(int) =>"+stds.contains(std1));
		p.print("remove(E) =>"+stds.remove(std1));
		p.print("contains(int) =>"+stds.contains(std1));
		verTab(2);
		p.print("subList(int,int) =>"+stds.subList(3,5));
		//p.print("removeRange(int,int) =>"+stds.removeRange(3,5)); // such method
		p.print("size =>"+stds.size()+"stds =>"+stds);
		verTab(3);
		p.print("removeIf(Predicate)"+stds.removeIf((s) -> s.getAge() >50));
		p.print("size =>"+stds.size()+"stds =>"+stds);
		stds.replaceAll((s) -> { if(s.getAge() <24) s.setDept("NEW");return s;});
		Spliterator<Student> spl = stds.spliterator();
		p.print("estimateSize()"+spl.estimateSize());
		Spliterator<Student> spl1 = spl.trySplit();
		spl.tryAdvance((s) -> p.print("tryAdvance"+s));
		spl.tryAdvance((s) -> p.print("tryAdvance"+s));
		spl.forEachRemaining((s)-> p.print("rem  ==> "+s));
		p.print("estimateSize()"+spl1.estimateSize());
		spl1.forEachRemaining((s) -> p.print(s));
		verTab(4);
		
		
	}
	void verTab(int times)
	{
		for(int i=0; i<times;i++)
		{
			p.print("\n");
		}
	}
	void getAllmethods(Class cls)
	{
		for(Method m:cls.getMethods())
		{
			p.print(m.getName());
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
	
	public void setDept(String dept)
	{
		this.dept = dept;
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


/*
ArrayList.class
add, add, remove, remove, get, clone, indexOf, clear, contains, isEmpty,
iterator, lastIndexOf, replaceAll, size, subList,
toArray, toArray,
spliterator, addAll, addAll, forEach,set,
ensureCapacity, trimToSize, listIterator, listIterator, removeAll, removeIf, retainAll,
sort, equals, hashCode,
toString, containsAll,
wait,wait, wait, getClass,
notify, notifyAll, stream, parallelStream */

// Iterator directly intacted to it's parent. Modification takes immediate effect.
/*
Iterator.class
remove, hasNext, next, forEachRemaining
*/

/*
ListIterator.class
add, remove, hasNext, next, set,
hasPrevious, nextIndex, previous,
previousIndex, forEachRemaining
*/

/*Spliterator.class
forEachRemaining, tryAdvance, estimateSize, trySplit,
characteristics, getComparator, getExactSizeIfKnow, hasCharacteristics
*/