import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.io.*;

@FunctionalInterface
interface MyPrinter
{
	void print(Object s);
}

public class TestSecurity
{
	public static void main(String[] args)
	{
		Supplier<MainBlock> mb = MainBlock::new;
		mb.get().main();
	}
}

class MainBlock
{
	public MyPrinter p = System.out::println;
	void main()
	{
		System.out.println("calling main method");
		p.print("printing \n\n");
		String name = "mohan";
		String path = "D:\\programming\\java\\cmd\\TestFunInterface.java";
		int age = 23;
		char sex = 'M';
		float percent = 95.00f;
		Student std = new Student("mohan", 23, 'M', 95.00f);
		
		p.print("String data ->"+name);
		testBase64(name.getBytes());
		
/* 		p.print("int data ->"+age);
		testBase64(name.getBytes());
		
		p.print("char data ->"+sex);
		testBase64(name.getBytes());
		
		p.print("float data ->"+percent);
		testBase64(name.getBytes()); */
		
		
		p.print("\n \n \n String data ->"+name);
		testBase64ToString(name.getBytes(),Base64.getEncoder(),Base64.getDecoder());		
		
		p.print("\n \n \n File path normal enc-dec ->"+path);
		testBase64ToString(path.getBytes(),Base64.getEncoder(),Base64.getDecoder());		
		
		p.print("\n \n \n File path urlenc-dec ->"+path);
		testBase64ToString(path.getBytes(),Base64.getUrlEncoder(),Base64.getUrlDecoder());
		
		
		
	}
	void testBase64(byte[] byteData)
	{
		Base64.Encoder enc = Base64.getEncoder();
		Base64.Decoder dec = Base64.getDecoder();
		byte[] encdata ;
		byte[] decdata ;
		p.print(" byteData ->"+byteData);
		encdata = enc.encode(byteData);
		p.print("After encrypting encdata ->"+encdata);
		decdata = dec.decode(encdata);
		p.print("After decrypting decdata ->"+decdata);
		BiPredicate<byte[],byte[]> pred = Arrays::equals;
		p.print(pred.test(byteData,decdata));
	}
	
	void testBase64ToString(byte[] byteData,Base64.Encoder enc,Base64.Decoder dec)
	{
		String encdata ;
		byte[] decdata ;
		p.print("byteData ->"+byteData);
		encdata = enc.encodeToString(byteData);
		p.print("After encrypting to string  encdata ->"+encdata);
		decdata = dec.decode(encdata);
		p.print("After decrypting from string decdata ->"+decdata);
		BiPredicate<byte[],byte[]> pred = Arrays::equals;
		p.print(pred.test(byteData,decdata));
		
		p.print("encoding toString   "+Arrays.toString(decdata));
		p.print("encoding String Obj  "+new String(decdata));
	}
	
	
}
class Student
{
	String name = "mohan";
	int age = 23;
	char sex = 'M';
	float percent = 95.0f;
	Student()
	{
		
	}
	Student(String name, int age, char sex, float percent)
	{
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.percent = percent;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public char getSex()
	{
		return this.sex;
	}
	public float getPercent()
	{
		return this.percent;
	}
}