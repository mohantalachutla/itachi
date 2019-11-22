//package com.itachi.practice.test2; //not working
import java.util.*;
import java.util.function.*;
import java.lang.reflect.*;

public class TestFunInterface
{
	public static void main(String args[])
	{
		MainBlock mb = new MainBlock();
		mb.main();
		mb.main2();
	}
}
class MainBlock
{
	public void main()
	{
		Student std1 = new Student("mohan",1,23);
		Student std2 = new Student("sham",2,21);
		boolean result = false;
		
/* 		Check chk= (s) -> {Student s1 =(Student) s; return s1.getRank() > 20;};
		result = chk.test(std1);
		System.out.println("normal Functinal Reference test() :"+result);
		
		Predicate pre= s -> {Student s1 = (Student)s; return s1.getRank() > 20;};
		result = pre.test(std1);
		System.out.println("Predicate test() :"+result);  */
		
		/* Check chk2 = (s) -> s.getRank() > 20;
		result = chk2.test(std1);
		System.out.println("Generic Functinal Reference test() :"+result); */
		
		Class cls = std1.getClass();
		System.out.println("cls ->"+cls +", of"+cls.getClass());
		Check<Student> chk3= new Student()::didPass;
		result = chk3.test(std1);
		System.out.println("normal Functinal Reference test() :"+result);
		
		Predicate<Student> pre2=  new Student()::didPass;;
		result = pre2.test(std1);
		System.out.println("Predicate test() :"+result);
	}
	public void main2()
	{
		TestGeneric tg = new TestGeneric();
		Student std = new Student("pav",1,24);
		tg.print("helllooo");
		tg.print(std);
		tg.printValue(std); //unable to access it's members.
		tg.print(std.getName());
		tg.print(std.getRank());
		
		
		System.out.print("calling access() "+tg.access(std));
		//System.out.print("calling access() "+tg.access("no"));
	}
}

class Student extends Object
{
	private String name;
	private int id;
	private int rank;
	
	Student()
	{
		
	}
	Student(String name,int id,int rank)
	{
		this.name = name;
		this.id = id;
		this.rank = rank;
	}
	public String getName()
	{
		return this.name;
	}
	public int getId()
	{
		return this.id;
	}
	public int getRank()
	{
		return this.rank;
	}
	public boolean didPass(Student s)
	{
		return s.getRank()>20;
	}
	@Override
	public String toString()
	{
		return "Name :"+this.getName()+", Id :"+this.getId()+", Rank:";
	}
}
@FunctionalInterface
interface Check<T>
{
	public boolean test(T t);
}
/* @FunctionalInterface
interface Check2 extends Check
{
	boolean test(T t);
	boolean test(Student t);
} */

class TestGeneric<T>
{
	TestGeneric()
	{
		
	}
	public void print(T t)
	{
		System.out.println(t);
	}
 	public void printValue(T t)
	{
		System.out.println(t.getName());
	}
	public T access(T t)
	{
		Method methods[] = t.getClass().getDeclaredMethods();
		for(Method m : methods)
		{
			try
			{
				System.out.println(m.getName());
				m.setAccessible(true);
				if(m.getName().equals("didPass"))
				System.out.println(m.invoke(t,t));
				else
				System.out.println(m.invoke(t));
			}
			catch(IllegalAccessException | InvocationTargetException e) {} //we can not use Parent exceptions of the provided exception in the multi - catch block
		}
		return t;
	}
}