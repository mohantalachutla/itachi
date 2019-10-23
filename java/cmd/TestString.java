import java.lang.annotation.*;
import java.util.StringTokenizer;

@FunctionalInterface
interface P
{
	void print(Object o);
}
public class TestString
{
	public static void main(String[] args)
	{
		MainBlock mb = new MainBlock();
		mb.main();
	}
}

class MainBlock
{
	void main()
	{
		StringOp sop = new StringOp();
		sop.execute();
		StringBuilderOp sbop =new StringBuilderOp();
		//sbop.execute();
		
	}
}
class StringOp
{
	// String implements interface CharSequence, Serializable, Comparable
	// String immutable
	P p= System.out::println;
	void execute()
	{
		String firstName="Mohan";
		String middleName = "Rao";
		String lastName= "Talachutla";
		String idol = "Itachi Uchiha";
		String alpha="abcde,fghi,jklmno,pqrs,tuv,wxyz";
		String beta= "ABCDEFG#@HIJKLM#@NOPQRSTU#@VWXYZ";
		//StringOp(firstName,middleName,lastName);
		
		StringTokenizerOp stzr = new StringTokenizerOp();
		stzr.stringTokenizer(alpha,",");
	}
	void StringOp(String firstName, String middleName, String lastName)
	{
		String _fullname=firstName.concat(lastName);
		p.print("concat() = "+_fullname);
		String _alias = _fullname.replace(firstName,middleName);
		p.print("replace() = "+_alias);
		p.print("toUpperCase()"+_alias.toUpperCase());
		p.print("toLowerCase()"+_alias.toLowerCase());
		p.print("charAt()"+_alias.charAt(4));
		p.print("startsWith()"+_alias.startsWith("Ra"));
		p.print("endsWith()"+_alias.endsWith("la"));
		p.print("substring(), indexOf()"+_fullname.substring(0,_fullname.indexOf(lastName)));
		p.print("substring(), indexOf()"+_fullname.substring(_fullname.lastIndexOf(lastName)));
		char[] arr = _fullname.toCharArray();
		p.print("toCharArray(), length");
		for(int i=0; i<arr.length; i++)
		{
			p.print(arr[i]);
		}
		//char[] arr1 = {'B','E','N'};
		//_fullname.getChars(0,_fullname.length()-1,arr1,1);// not working
		String[] _split = _fullname.split("a");
		for(String s:_split)
		{
			p.print("split() ="+s);
		}
		String __fullName = String.join("  ",firstName,lastName);
		p.print("join() ="+__fullName);
		p.print("trim() ="+__fullName.trim());
		p.print("valueOf() ="+String.valueOf(65)); //type casts into String as it is String.valueOf
	}
}

class StringBuilderOp
{
	//StringBuilder implements CharSequence, Serializable, Comparable. It's asynchronous.
	//StringBuilder mutable
	//StringBuffer is equivalent to StringBuilder. It's synchronous.
	P p = System.out::println;
	void execute()
	{
		String firstName="Mohan";
		String middleName = "Rao";
		String lastName= "Talachutla";
		String idol = "Itachi Uchiha";
		String alpha="abcdefghijklmnopqrstuvwxyz";
		String beta= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		op1(firstName,middleName,lastName);
	}
	void op1(String firstName, String middleName, String lastName)
	{
		StringBuilder _firstName = new StringBuilder(firstName);
		p.print("StringBuilder = "+_firstName);
		StringBuilder _fullName = _firstName.append(lastName);
		p.print("append() = "+_firstName); // it modifies the String itself and returns it. 
		p.print("append() ="+_fullName); // new builder not required.
		_fullName.insert(firstName.length()," ");
		p.print("insert() ="+_fullName);
		_fullName.insert(firstName.length(),middleName);
		_fullName.insert(firstName.length()," ");
		p.print("insert() ="+_fullName);
		int ind = _fullName.indexOf("Ra");
		p.print("indexOf() ="+ind);
		p.print("charAt() ="+_fullName.charAt(ind));
		p.print("codePointAt() ="+_fullName.codePointAt(ind)); //R ascci
		p.print("codePointBefore() ="+_fullName.codePointBefore(ind)); //<space> ascci
		_fullName.setCharAt(ind,'Z');
		p.print("setCharAt() ="+_fullName);
		p.print("replace() ="+_fullName.replace(_fullName.indexOf("Ta"),_fullName.length(),"TALACHUTLA"));
		p.print("delete() ="+_fullName.delete(_fullName.indexOf("T"),_fullName.length()));
		p.print("delete() ="+_fullName.reverse());
	}
}

class StringTokenizerOp
{
	P p= System.out::println;
	//StringTokenizer works like iterator
	void stringTokenizer(String str, String token)
	{
		StringTokenizer tzr1 = new StringTokenizer(str);
		StringTokenizer tzr2 = new StringTokenizer(str,token);
		StringTokenizer tzr3 = new StringTokenizer(str,token,true); // default false
		StringTokenizer tzr4 = new StringTokenizer(str,token,true); // default false
		
		p.print("countTokens() ="+tzr2.countTokens());
		while(tzr2.hasMoreTokens())
		{
			p.print("countTokens() ="+tzr2.countTokens()+"nextToken() ="+tzr2.nextToken(token)); // returns String
		}
		p.print("countTokens() ="+tzr1.countTokens());
		
		
		p.print("\n\n\n\n");
		
		
		p.print("countTokens() ="+tzr1.countTokens());
		while(tzr1.hasMoreTokens())
		{
			p.print("countTokens() ="+tzr1.countTokens()+"nextToken() ="+tzr1.nextToken(token));
		}
		p.print("countTokens() ="+tzr1.countTokens());
		
		
		p.print("\n\n\n\n");
		
		
		p.print("countTokens() ="+tzr3.countTokens());
		while(tzr3.hasMoreTokens())
		{
			p.print("countTokens() ="+tzr3.countTokens()+"nextToken() ="+tzr3.nextToken());
		}
		p.print("countTokens() ="+tzr3.countTokens());
		
		
		p.print("\n\n\n\n");
		
		
		p.print("countTokens() ="+tzr4.countTokens());
		while(tzr4.hasMoreElements())
		{
			p.print("countTokens() ="+tzr4.countTokens()+"nextToken() ="+tzr4.nextElement()); // like nextToken but returns Object
		}
		p.print("countTokens() ="+tzr4.countTokens());
		
	}	
}