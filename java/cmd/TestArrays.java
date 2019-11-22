import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.stream.*;

@FunctionalInterface
interface P{
	void print(Object o);
}
public class TestArrays
{
	public static void main(String[] args)
	{
		int[] intArr = {1,23,32,55,56,2,77,99,90};
		char[] charArr = {'a','c','i','K','k','o','p','w','z'};
		String[] strArr = {"mohan","itachi","naidu","sham","pav","sasuke"};
		
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
		
		Student[] stdArr = {std1,std2 ,std3, std4, std5, std6, std7};
		
		
		ArraysOp op = new ArraysOp();
		//op.intOp(intArr);
		op.arrayOp(stdArr,std2,std8,std9,std10);
		
		System.out.println("sortString() --->"+op.sortString("itachi Uchiha"));
	}

}
class ArraysOp
{
	P p = System.out::println;
	P p2 = System.out::print;
	void intOp(int[] arr)
	{
		int[] arr2, arr3, arr4;
		arr4 = new int[100];
		
		p.print("Arrys.asList() -->");
		List list = Arrays.asList(arr);
		list.forEach(e -> p2.print(e+"  "));
		p.print("Arrys.binarySearch() -->");
		p.print("at index"+Arrays.binarySearch(arr,77));
		p.print("at index"+Arrays.binarySearch(arr,0,4,77));
		p.print("Arrys.copyOf() -->");
		arr2 = Arrays.copyOf(arr,5); // of length 5, trucates remaining
		p.print("arr2, truncates ->");
		for(int el : arr2) p.print(el);
		arr2 = Arrays.copyOf(arr,15); // of length 15, sets 0 for remaining
		p.print("arr2, sets to zero ->");
		for(int el : arr2) p.print(el);
		p.print("Arrys.copyOfRange() -->");
		arr2 = Arrays.copyOfRange(arr,0,4);// index
		p.print("arr2, trucates ->");
		for(int el : arr2) p.print(el);
		arr2 = Arrays.copyOfRange(arr,3,15); //index
		p.print("arr2, sets to zero ->");
		for(int el : arr2) p.print(el);
		Arrays.fill(arr2, 23);
		p.print("arr2, Arrays.fill() ->");
		for(int el : arr2) p.print(el);
		Arrays.fill(arr2, 3,6,40);
		p.print("arr2, Arrays.fill() ->");
		for(int el : arr2) p.print(el);
		
		this.testParallelSetAll(arr2);
		arr3 = Arrays.copyOf(arr2,100);
		p.print("arr3, length -->" +arr3.length);
		arr3 = this.testParallelSetAll(arr3);
		Arrays.parallelPrefix(arr3, (el1,el2) -> {return el1+el2;} ); // array and BinaryOperator i.e. performs binaryoperation on consecutive values and replaces 2nd value with the result.
		for(int el : arr3) p.print(el);
		int[] arr5 = {3,323,32,93,99,33,23,1,0,-3,33,43,66,67,98,6,4,36,77};
		arr4 = this.testParallelSort(arr5);
		for(int el : arr4) p.print(el);
	}
	
	int[] testParallelSetAll(int[] arr2)
	{
		long begin =0, end =0;
		int[] arr;
		p.print("arr2, Arrays.setAll() ->");
		begin = System.currentTimeMillis();
		Arrays.setAll(arr2,(el) -> {el = el+1; return el;}); // setAll is for entire array
		end = System.currentTimeMillis();
		p.print("duration -->"+(end - begin));
		//for(int el : arr2) p.print(el);
		arr = Arrays.copyOf(arr2,arr2.length);
		p.print("arr2, Arrays.parallelSetAll() ->");
		begin = System.currentTimeMillis();
		Arrays.parallelSetAll(arr2,(el) -> {el = el+1; return el;}); // setAll is for entire array
		end = System.currentTimeMillis();
		p.print("duration -->"+(end - begin));
		//for(int el : arr2) p.print(el);
		p.print("Arrays.equals() -->"+Arrays.equals(arr,arr2));
		return arr2;
	}
	int[] testParallelSort(int[] arr2)
	{
		long begin =0, end =0;
		int[] arr;
		p.print("arr2, Arrays.sort() ->");
		begin = System.currentTimeMillis();
		Arrays.sort(arr2); // setAll is for entire array
		end = System.currentTimeMillis();
		p.print("duration -->"+(end - begin));
		//for(int el : arr2) p.print(el);
		arr = Arrays.copyOf(arr2,arr2.length);
		p.print("arr2, Arrays.parallelSort() -->");
		begin = System.currentTimeMillis();
		Arrays.parallelSort(arr2); // setAll is for entire array
		end = System.currentTimeMillis();
		p.print("duration -->"+(end - begin));
		//for(int el : arr2) p.print(el);
		p.print("Arrays.equals() -->"+Arrays.equals(arr,arr2));
		return arr2;
	}
	
	<T> void arrayOp(T[] arr,T... args)
	{
		T[] arr1,arr2, arr3, arr4,arr5;
		arr1 = Arrays.copyOf(arr,arr.length);
		arr5 = Arrays.copyOf(arr,arr.length);
		p.print("Arrys.asList() -->");
		List<? extends T> list = Arrays.asList(arr);
		list.forEach(e -> p2.print(e+"  "));
		
		//p.print("Arrys.binarySearch() -->");
		//p.print("at index"+Arrays.binarySearch(arr,args[0]));
		//p.print("at index"+Arrays.binarySearch(arr,0,4,77));
		//p.print("Arrys.binarySearch() -->");
		
		p.print("Arrys.copyOf() -->");
		arr2 = Arrays.copyOf(arr,5); // of length 5, trucates remaining
		p.print("arr2, truncates ->");
		for(T el : arr2) p.print(el);
		arr2 = Arrays.copyOf(arr,15); // of length 15, sets 0 for remaining
		p.print("arr2, sets to zero ->");
		for(T el : arr2) p.print(el);
		p.print("Arrys.copyOfRange() -->");
		arr2 = Arrays.copyOfRange(arr,0,4);// index
		p.print("arr2, trucates ->");
		for(T el : arr2) p.print(el);
		arr2 = Arrays.copyOfRange(arr,3,15); //index
		p.print("arr2, sets to zero ->");
		for(T el : arr2) p.print(el);
		
		Arrays.fill(arr2, args[1]);
		p.print("arr2, Arrays.fill() ->");
		for(T el : arr2) p.print(el);
		Arrays.fill(arr2, 3,6,args[2]);
		p.print("arr2, Arrays.fill() ->");
		for(T el : arr2) p.print(el);
		
		/* this.testParallelSetAll(arr2);
		arr3 = Arrays.copyOf(arr2,100);
		p.print("arr3, length -->" +arr3.length);
		arr3 = this.testParallelSetAll(arr3);
		//Arrays.parallelPrefix(arr3, (el1,el2) -> {return el1.getAge()+el2.getAge();} ); // array and BinaryOperator i.e. performs binaryoperation on consecutive values and replaces 2nd value with the result.
		for(T el : arr3) p.print(el);*/
		arr4 = this.testParallelSort(arr);
		for(T el : arr4) p.print(el);
		p.print("before:" );
		for(T el : arr5) p.print(el);
		Arrays.sort(arr5,new NameComparator());
		p.print("after:");
		for(T el : arr5) p.print(el);
		
	}
	
	<T> T[] testParallelSort(T[] arr2)
	{
		long begin =0, end =0;
		T[] arr;
		p.print("arr2, Arrays.sort() ->");
		begin = System.currentTimeMillis();
		Arrays.sort(arr2); // setAll is for entire array
		end = System.currentTimeMillis();
		p.print("duration -->"+(end - begin));
		//for(T el : arr2) p.print(el);
		arr = Arrays.copyOf(arr2,arr2.length);
		/* p.print("arr2, Arrays.parallelSort() -->");
		begin = System.currentTimeMillis();
		Arrays.parallelSort(arr2); // setAll is for entire array
		end = System.currentTimeMillis();
		p.print("duration -->"+(end - begin));
		//for(T el : arr2) p.print(el);
		p.print("Arrays.equals() -->"+Arrays.equals(arr,arr2)); */
		return arr2;
	}
	
	String sortString(String str)
	{
		char[] charArr = str.toCharArray();
		// Arrays.sort(charArr);
		return new String(charArr); // can use String.valueOf();
		//return Stream.of(charArr).sorted().map(s -> s.toString()).collect(Collectors.joining()); // not working
		//return str.chars().sorted().collect(Collectors.joining()); // Collectors can not be used
		//return str.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append); // chars() converts string into IntStream //notworking
		//return Stream.of(charArr).sorted().collect(StringBuilder::new,StringBuilder::append,StringBuilder::append); // not working
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
class Student implements Comparable
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
	@Override
	public int compareTo(Object std)
	{
		return this.getName().compareTo(((Student)std).getName());
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
Arrays:
methods:
private static int    binarySearch0(int[],int,int,int)
private static int    binarySearch0(java.lang.Object[],int,int,java.lang.Object)
private static int    binarySearch0(java.lang.Object[],int,int,java.lang.Object,java.util.Comparator)
private static void    deepToString(java.lang.Object[],java.lang.StringBuilder,java.util.Set)
private static void    lambda$parallelSetAll$0(java.lang.Object[],java.util.function.IntFunction,int)
private static void    lambda$parallelSetAll$1(int[],java.util.function.IntUnaryOperator,int)
private static void    lambda$parallelSetAll$2(long[],java.util.function.IntToLongFunction,int)
private static void    lambda$parallelSetAll$3(double[],java.util.function.IntToDoubleFunction,int)
private static void    legacyMergeSort(java.lang.Object[])
private static void    legacyMergeSort(java.lang.Object[],int,int)
private static void    legacyMergeSort(java.lang.Object[],int,int,java.util.Comparator)
private static void    legacyMergeSort(java.lang.Object[],java.util.Comparator)
private static void    mergeSort(java.lang.Object[],java.lang.Object[],int,int,int)
private static void    mergeSort(java.lang.Object[],java.lang.Object[],int,int,int,java.util.Comparato
private static void    rangeCheck(int,int,int)
private static void    swap(java.lang.Object[],int,int)
public static    stream.IntStream java.util.Arrays.stream(int[])
public static    stream.IntStream java.util.Arrays.stream(int[],int,int)
public static    stream.Stream java.util.Arrays.stream(java.lang.Object[])
public static    stream.Stream java.util.Arrays.stream(java.lang.Object[],int,int)
public static boolean    deepEquals(java.lang.Object[],java.lang.Object[])
public static boolean    equals(int[],int[])
public static boolean    equals(java.lang.Object[],java.lang.Object[])
public static int    binarySearch(int[],int)
public static int    binarySearch(int[],int,int,int)
public static int    binarySearch(java.lang.Object[],int,int,java.lang.Object)
public static int    binarySearch(java.lang.Object[],int,int,java.lang.Object,java.util.Comparator)
public static int    binarySearch(java.lang.Object[],java.lang.Object)
public static int    binarySearch(java.lang.Object[],java.lang.Object,java.util.Comparator)
public static int    deepHashCode(java.lang.Object[])
public static int    hashCode(int[])
public static int    hashCode(java.lang.Object[])
public static int[]    copyOf(int[],int)
public static int[]    copyOfRange(int[],int,int)
public static java.lang.Object[]    copyOf(java.lang.Object[],int)
public static java.lang.Object[]    copyOf(java.lang.Object[],int,java.lang.Class)
public static java.lang.Object[]    copyOfRange(java.lang.Object[],int,int)
public static java.lang.Object[]    copyOfRange(java.lang.Object[],int,int,java.lang.Class)
public static java.lang.String    deepToString(java.lang.Object[])
public static java.lang.String    toString(int[])
public static java.lang.String    toString(java.lang.Object[])
public static java.util.List    asList(java.lang.Object[])
public static java.util.Spliterator    spliterator(java.lang.Object[])
public static java.util.Spliterator    spliterator(java.lang.Object[],int,int)
public static java.util.Spliterator$OfInt    spliterator(int[])
public static java.util.Spliterator$OfInt    spliterator(int[],int,int)
public static void    fill(int[],int)
public static void    fill(int[],int,int,int)
public static void    fill(java.lang.Object[],int,int,java.lang.Object)
public static void    fill(java.lang.Object[],java.lang.Object)
public static void    parallelPrefix(double[],int,int,java.util.function.DoubleBinaryOperator)
public static void    parallelPrefix(double[],java.util.function.DoubleBinaryOperator)
public static void    parallelPrefix(int[],int,int,java.util.function.IntBinaryOperator)
public static void    parallelPrefix(int[],java.util.function.IntBinaryOperator)
public static void    parallelPrefix(java.lang.Object[],int,int,java.util.function.BinaryOperator)
public static void    parallelPrefix(java.lang.Object[],java.util.function.BinaryOperator)
public static void    parallelPrefix(long[],int,int,java.util.function.LongBinaryOperator)
public static void    parallelPrefix(long[],java.util.function.LongBinaryOperator)
public static void    parallelSetAll(double[],java.util.function.IntToDoubleFunction)
public static void    parallelSetAll(int[],java.util.function.IntUnaryOperator)
public static void    parallelSetAll(java.lang.Object[],java.util.function.IntFunction)
public static void    parallelSetAll(long[],java.util.function.IntToLongFunction)
public static void    parallelSort(int[])
public static void    parallelSort(int[],int,int)
public static void    parallelSort(java.lang.Comparable[])
public static void    parallelSort(java.lang.Comparable[],int,int)
public static void    parallelSort(java.lang.Object[],int,int,java.util.Comparator)
public static void    parallelSort(java.lang.Object[],java.util.Comparator)
public static void    setAll(int[],java.util.function.IntUnaryOperator)
public static void    setAll(java.lang.Object[],java.util.function.IntFunction)
public static void    sort(int[])
public static void    sort(int[],int,int)
public static void    sort(java.lang.Object[])
public static void    sort(java.lang.Object[],int,int)
public static void    sort(java.lang.Object[],int,int,java.util.Comparator)
public static void    sort(java.lang.Object[],java.util.Comparator)
static boolean    deepEquals0(java.lang.Object,java.lang.Object)


fields:

private static final int java.util.Arrays.MIN_ARRAY_SORT_GRAN
private static final int java.util.Arrays.INSERTIONSORT_THRESHOLD
static final boolean java.util.Arrays.$assertionsDisabled



construstors:

private java.util.Arrays()
*/

/*
Array:
private static native java.lang.Object    multiNewArray(java.lang.Class,int[])
private static native java.lang.Object    newArray(java.lang.Class,int)
public static java.lang.Object    newInstance(java.lang.Class,int)
public static java.lang.Object    newInstance(java.lang.Class,int[])
public static native boolean    getBoolean(java.lang.Object,int)
public static native byte    getByte(java.lang.Object,int)
public static native char    getChar(java.lang.Object,int)
public static native double    getDouble(java.lang.Object,int)
public static native float    getFloat(java.lang.Object,int)
public static native int    getInt(java.lang.Object,int)
public static native int    getLength(java.lang.Object)
public static native java.lang.Object    get(java.lang.Object,int)
public static native long    getLong(java.lang.Object,int)
public static native short    getShort(java.lang.Object,int)
public static native void    set(java.lang.Object,int,java.lang.Object)
public static native void    setBoolean(java.lang.Object,int,boolean)
public static native void    setByte(java.lang.Object,int,byte)
public static native void    setChar(java.lang.Object,int,char)
public static native void    setDouble(java.lang.Object,int,double)
public static native void    setFloat(java.lang.Object,int,float)
public static native void    setInt(java.lang.Object,int,int)
public static native void    setLong(java.lang.Object,int,long)
public static native void    setShort(java.lang.Object,int,short)
*/