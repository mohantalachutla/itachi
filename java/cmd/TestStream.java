//package com.itachi.practice.test1; //not working 
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
/*
Functional Reference FR

SEQUENTIAL, CONCURRENT, PARALLEL

Predicate can not take FR
Class instace is different from Supplier.
Comparator comparator reference and labda function equi to compare function of comparator

*/
 @FunctionalInterface
 interface Fip
 {
		void p(Object e);
 }
public class TestStream
{
	public static void main(String arg[])
	{

		MainBlock mb = new MainBlock();
		mb.main();

		
	}
	
}
class MainBlock
{
	public void main()
	{
		Fip p = System.out::println;
		AnnotationExp an = new AnnotationExp();
		CollectorExp col = new CollectorExp();
		StreamExp strm = new StreamExp();
		Student std1 =new Student("Mohan",1,23,"IT");
		Student std2 =new Student("Shamu",2,25,"CSE");
		Student std3 =new Student("Pav",3,22,"CSE");
		Student std4 =new Student("Chanti",4,24,"ECE");
		Student std5 =new Student("Naidu",5,23,"IT");
		
		Student std6 =new Student("Laxmi",6,43,"Form");
		Student std7 =new Student("Lakshman",7,45,"HKeep");
		Student std8 =new Student("Jagadhi",8,42,"Hkeep");
		Student std9 =new Student("Itachi",9,188,"Shinobi");
		Student std10 =new Student("Jagadhi",10,142,"Shinobi");
		
		
		List<Student> stds = Arrays.asList(std1,std2,std3,std4,std5);
		List<Student> stds2 = Arrays.asList(std6,std7,std8);
		List<List<Student>> flatMapStds = Arrays.asList(stds,stds,stds);
		// p.p(stds);
		// p.p(flatMapStds);
		
		// p.p("\n\n stds displaying \n");
		/* 		for(Student s : stds)
		{
			p.p(s);
		} */
		//stds.stream().forEach((s) -> p.p(s));
		//p.p("\n\n flatMapStds displaying \n");
		//flatMapStds.stream().forEach((s) -> p.p(s.getClass()));
		
		try{
			/*java 5 practice*/
			
			//an.readAnnotaionOf(std1);
			
			/*java 8 practice*/
			// Core Stream
			//p.p("filterStdByAge from Stream ->"+strm.filterStdByAge(stds));
			p.p("strmConcat ->"+strm.strmConcat(stds,stds2));
			//p.p("getNamesByflatMap from Stream ->"+strm.getNamesByflatMap(flatMapStds));
			
			// using stream builder
			
			p.p("streamBuilder"+strm.streamBuilder(std1,std2,std3,std4,std5));
			
			// Using Collectors
			
			p.p(col.filterStdByAge(stds));
			p.p(col.getStdGrpByDept(stds));
			p.p(col.getStdGrpByDept1(stds));
			p.p(col.getStdPrtnByAge(stds));
			p.p(col.getStdPrtnByAge1(stds));
			p.p(col.getStdPrtnByAge2(stds));
			p.p(col.getStdPrtnByAge3(stds));
			p.p(col.getStdPrtnByAge4(stds));
			p.p(col.getStdPrtnByAge5(stds));
			//p.p(col.getStdPrtnByAge6(stds)); // not working
			Map<Boolean,List<Student>> unmodifiableMap = col.getStdPrtnByAge7(stds);
			//unmodifiableMap.remove(false); not woking
			p.p("unmodifiableMap"+unmodifiableMap);
			
			
		}
		catch(NoClassDefFoundError | NoSuchMethodException | NullPointerException e)
		{
			p.p(e.getMessage());
		}
	}
/* 	public void p(Object s)
	{
		System.out.println(s);
	}
	public void p(String s)
	{
		System.out.println();
	} */
	
	
}
class AnnotationExp
{
	public void readAnnotaionOf(Student s)
	{
		Fip p = System.out::println;
		try
		{
			Provider pro = null;
			Class classObj = s.getClass();
			p.p(classObj.toString());
			if(classObj != null)
			{
				pro= (Provider)classObj.getAnnotation(Provider.class);
				p.p(pro.intValue());
			}
			Method methodObj = classObj.getDeclaredMethod("getAge");
			if(methodObj != null)
			{
				pro= (Provider)methodObj.getAnnotation(Provider.class);
				p.p(pro.intValue());
			}
		}
		catch(NoSuchMethodException | NullPointerException e)
		{
			p.p(e.getMessage());
		}
		
	}
/* 	public void p(Object s)
	{
		System.out.println(s);
	}
	public void p(String s)
	{
		System.out.println();
	} */
}
class StreamExp
{
	public List<Object> filterStdByAge(List<Student> stds)
	{
		//return stds.stream().filter(s -> s.getAge() >23).map(s -> s.getName()).collect(Collectors.toList());
		//return stds.stream().filter(s -> s.getAge() >23).map(s -> s.getName()).collect(ArrayList::new, ArrayList::add,ArrayList::addAll);   // collecting without using collectors
		return stds.stream().filter(s -> s.getAge() >23).map(s -> s.getName()).collect(ArrayList::new, (r,s) -> r.add(s), (r1,r2) -> r1.addAll(r2));   // collecting without using collectors
		//return Arrays.asList(stds.stream().filter(s -> s.getAge() >23).map(s -> s.getName()).sorted().toArray());
		//return Arrays.asList(stds.stream().filter(s -> s.getAge() >23).sorted(new NameComparator()::compare).map(s -> s.getName()).toArray()); 
		//return Arrays.asList(stds.stream().filter(s -> s.getAge() > s.getClass().getAnnotation(Provider.class).intValue()).sorted((s1,s2)-> s1.getName().compareTo(s2.getName())).map(Student::getName).toArray());
		//return Arrays.asList(stds.stream().filter(s -> s.getAge() > s.getClass().getAnnotation(Provider.class).intValue()).sorted((s1,s2)-> s1.getName().compareTo(s2.getName())).map(s -> s.getName()).toArray());
		//return Arrays.asList(stds.stream().filter(s -> s.getAge() > s.getClass().getAnnotation(Provider.class).intValue()).sorted(new NameComparator()::compare).map(s -> s.getName()).toArray());
	}	
	
 	public List<Object> getNamesByflatMap(List<List<Student>> stds)
	{
		return stds.stream().flatMap((l) -> l.stream()).collect(Collectors.toList()); //it's input List<Student>
		//return stds.stream().map((l) -> l.stream()).collect(Collectors.toList()); // it's input Student
	}
 	public Object streamBuilder(Student... stds)
	{
		Stream.Builder builder = Stream.builder(); // in building phase
		for(Student s : stds)
		{
			builder.accept(s);
		}
		//return builder.build().collect(ArrayList::new, ArrayList::add, ArrayList::addAll); // in built phase
		return builder.build().collect(Collectors.toList());
	} 
	public List<Object> strmConcat(List<Student> stds1, List<Student> stds2)
	{
		return Stream.concat(stds1.stream(),stds2.stream()).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
	}
}
class CollectorExp
{
	public Map<Object,Object> filterStdByAge(List<Student> stds) throws NoSuchMethodException
	{
		//return stds.stream().filter(s -> s.getAge() > s.getClass().getDeclaredMethod("getAge").getAnnotation(Provider.class).intValue()).collect(Collectors.toMap(s -> s.getName(),s -> s.getDept()));  // NoSuchMethodException
		return stds.stream().filter(s -> s.getAge() > s.getClass().getAnnotation(Provider.class).intValue()).collect(Collectors.toMap(s -> s.getName(),s -> s.getDept()));
	}
	
 	public Map<Object,List<Student>> getStdGrpByDept(List<Student> stds)
	{
		//return stds.stream().collect(Collectors.groupingBy(Student::getDept));
		return stds.stream().collect(Collectors.groupingBy(s -> s.getDept()));
		//return stds.stream().collect(Collectors.groupingByConcurrent(Student::getDept)); //characterstics.CONCURRENT
	}  
	public Object getStdGrpByDept1(List<Student> stds)
	{
		//return stds.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.maxBy(new NameComparator())));
		return stds.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.maxBy((s1,s2 )-> s1.getName().compareTo(s2.getName()))));
		//return stds.stream().collect(Collectors.groupingByConcurrent(Student::getDept)); //same result but concurrent approch
	} 
	
	public Map<Boolean,List<Student>> getStdPrtnByAge(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		return stds.stream().collect(Collectors.partitioningBy(preAge));
		//return stds.stream().collect(Collectors.partitioningBy(s -> s.getAge() > s.getClass().getAnnotation(Provider.class).intValue()));
	}	
	public Map<Boolean,List<Object>> getStdPrtnByAge1(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.toList())));
		return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.toCollection(ArrayList::new))));
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.toCollection(new ArrayList())))); //need provide a Supplier. Class instace is different from Supplier.
	} 	
	public Map<Boolean,String> getStdPrtnByAge2(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining(","))));
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining())));
		return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining(",","BEGIN","END"))));
	}   
	public Map<Boolean,Integer> getStdPrtnByAge3(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining(","))));
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining())));
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.summingInt(s -> s.getAge()))); //same feat can be acheived by reducing
		return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getAge(),Collectors.reducing(5,(a1,a2)-> a1+a2))));
	}
	public Map<Boolean,Integer> getStdPrtnByAge4(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining(","))));
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getName().toString(),Collectors.joining())));
		//return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.summingInt(s -> s.getAge()))); //same feat can be acheived by reducing
		return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getAge(),Collectors.reducing(5,(a1,a2)-> a1+a2))));
	}
	/* public Map<Boolean,Float> getStdPrtnByAge6(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getAge(),Collectors.reducing(5.0,a -> Integer.floatValue(a),(a1,a2)-> a1+a2))));
	} */
	public Map<Boolean,Optional<Integer>> getStdPrtnByAge5(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		return stds.stream().collect(Collectors.partitioningBy(preAge,Collectors.mapping(s -> s.getAge(),Collectors.reducing((a1,a2)-> a1+a2))));
	}
	public Map<Boolean,List<Student>> getStdPrtnByAge7(List<Student> stds)
	{
		Predicate<Student> preAge= new Student()::ageLimit; // need to specify the type
		return stds.stream().collect(Collectors.collectingAndThen(Collectors.partitioningBy(preAge),Collections::unmodifiableMap)); // gives result to the function
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