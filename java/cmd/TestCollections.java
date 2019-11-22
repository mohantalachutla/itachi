import java.lang.annotation.*;
import java.util.*;

@FunctionalInterface
interface P{
	void print(Object o);
}
public class TestCollections
{
	public static void main(String[] args)
	{
		List<Integer> intList = Arrays.asList(1,23,32,55,56,2,77,99,90);
		List<Character> charList = Arrays.asList('a','c','i','K','k','o','p','w','z');
		List<String> strList = Arrays.asList("mohan","itachi","naidu","sham","pav","sasuke");
		
		Student std1 =new Student("Mohan",1,23,"IT");
		Student std2 =new Student("Shamu",2,25,"CSE");
		Student std3 =new Student("Pav",3,22,"CSE");
		Student std4 =new Student("Chanti",4,24,"ECE");
		Student std5 =new Student("Naidu",5,23,"IT");
		
		Student std6 =new Student("Laxmi",6,43,"Form");
		Student std7 =new Student("Lakshman",7,45,"HKeep");
		Student std8 =new Student("Jagadhi",8,42,"Hkeep");
		Student std9 =new Student("Itachi",9,188,"Shinobi");
		Student std10 =new Student("Sasuke",10,142,"Shinobi");
		
		List<Student> stdList = Arrays.asList(std1,std2 ,std3, std4, std5, std6, std7);
		
		
		CollectionsOp op = new CollectionsOp();
		op.collectionsListOp(stdList,std2,std8,std9);
	}

}
class CollectionsOp
{
	P p = System.out::println;
	P p2 = System.out::print;
	// to add any values to the colletion, it should be allocated memory; emptyList will not do;
	<T> void collectionsListOp(List<T> lst,T... args)
	{
		List<T> lst1 , lst2, lst3, lst4;
		//lst1 = Collections.<T>emptyList(); // returns emptyList obj with no memory
		lst1 = new ArrayList(10);
		lst2 = Collections.<T>emptyList();
		Collections.addAll(lst1,args[0],args[1],args[2]); //lst1 should have memory allocated else unsupported op
		p.print("List.forEach");
		lst.forEach(e -> p.print(e));
		
		// p.print("copy()");
		// Collections.copy(lst1,lst); // useless method
		p.print("collectionsListOp  -->");
		p.print("binarySearch()");
		//p.print("comparable  -->"+Collections.binarySearch(lst,args[0])); //error
		p.print("comparator  -->"+Collections.binarySearch(lst,args[0],new NameComparator()::compare));
		p.print("lamda  -->"+Collections.binarySearch(lst,args[0],(s1,s2) -> ((Student)s1).getName().compareTo(((Student)s2).getName())));
		//p.print("checkedCollection  -->");
		//p.print(Collections.checkedCollection(lst1,Student.class)); // type missmatch, generic should be specific
		p.print("disjoint()  -->");
		p.print(Collections.disjoint(lst1,lst)); //true if no common elements
		p.print(Collections.disjoint(lst1,lst2)); //true if no common elements
		p.print("fill()  -->");
		Collections.fill(lst1,args[0]);
		lst1.forEach(s -> p.print(s));
		p.print("frequency() -->");
		p.print(Collections.frequency(lst1,args[0]));
		lst3 = new ArrayList(lst);
		lst4 = new ArrayList(lst);
		p.print("rotate()  -->");
		Collections.rotate(lst3,3); // distance 3 rotates forward
		lst3.forEach(s -> p.print(s));
		p.print("\n");
		Collections.rotate(lst4,-3); // distance 3 rotates backward
		lst4.forEach(s -> p.print(s));
		p.print("shuffle() -->");
		Collections.shuffle(lst4); // default random
		lst4.forEach(s -> p.print(s));
		p.print("\n");
		Collections.shuffle(lst4, new Random(3)); // random 3
		lst4.forEach(s -> p.print(s));
		p.print("swap()");
		Collections.swap(lst4, 1,3);
		lst4.forEach(s -> p.print(s));
		p.print("sort() -->");
		Collections.sort(lst4,new IdComparator()::compare);
		lst4.forEach(s -> p.print(s));
	}
	
	
	<T> void collectionsSetOp(Set<T> set)
	{
		Set<T> set1, set2, set3;
		p.print("collectionsSetOp -->");
		
	}
	
	
	<K,V> void collectionsMapOp(Map<K,V> map)
	{
		Map<K,V> map1, map2, map3;
		p.print("collectionsMapOp -->");
		
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
class Student //implements Comparable
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
	
	/* @Override
	public int compareTo(Object o)
	{
		this.getName().compareTo(o.getName());
	} */
}

class NameComparator implements Comparator
{
	@Override
	public int compare(Object o1,Object o2)
	{
		Student s1 =(Student)o1;
		Student s2 =(Student)o2;
		return s1.getName().compareTo(s2.getName()); // returning -8 -ve index
		// boolean eq = s1.getName().equals(s2.getName());
		// return eq ? 0 : -1;
	}
}
class AgeComparator implements Comparator
{
	@Override
	public int compare(Object o1,Object o2)
	{
		Student s1 =(Student)o1;
		Student s2 =(Student)o2;
		return s2.getAge() - s1.getAge();
	}
}
class IdComparator implements Comparator
{
	@Override
	public int compare(Object o1,Object o2)
	{
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		return s1.getId() - s2.getId();
	}
}