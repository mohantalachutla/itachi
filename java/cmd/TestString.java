import java.lang.annotation.*;
import java.util.StringTokenizer;
import java.util.StringJoiner;

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
		//sop.execute();
		StringBuilderOp sbop =new StringBuilderOp();
		//sbop.execute();
		StringJoinerOp sjoin = new StringJoinerOp();
		sjoin.execute();
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
		String alphaArr[] = {"abcde", "fghi", "jklmno", "pqrs", "tuv", "wxyz"};
		String betaArr[] = {"ABCDEFG", "HIJKLM", "NOPQRSTU", "VWXYZ"};
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
		String alpha="abcde,fghi,jklmno,pqrs,tuv,wxyz";
		String beta= "ABCDEFG#@HIJKLM#@NOPQRSTU#@VWXYZ";
		String alphaArr[] = {"abcde", "fghi", "jklmno", "pqrs", "tuv", "wxyz"};
		String betaArr[] = {"ABCDEFG", "HIJKLM", "NOPQRSTU", "VWXYZ"};
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
class StringJoinerOp
{
	P p = System.out::println;
	P p2 = System.out::print;
	void execute()
	{
		String firstName="Mohan";
		String middleName = "Rao";
		String lastName= "Talachutla";
		String idol = "Itachi Uchiha";
		String tokens[] = {",","#"};
		String alpha="abcde,fghi,jklmno,pqrs,tuv,wxyz";
		String beta= "ABCDEFG#@HIJKLM#@NOPQRSTU#@VWXYZ";
		String alphaArr[] = {"abcde", "fghi", "jklmno", "pqrs", "tuv", "wxyz"};
		String betaArr[] = {"ABCDEFG", "HIJKLM", "NOPQRSTU", "VWXYZ"};
		p.print(alpha);
		p.print(beta);
		this.stringJoiner(tokens ,alphaArr, betaArr);
	}
	void stringJoiner(CharSequence[] tokens, CharSequence[] alphaArr, CharSequence[] betaArr)
	{
		StringJoiner strJnr1 = new StringJoiner(tokens[0]);
		StringJoiner strJnr2 = new StringJoiner(tokens[1]);
		p.print("building strJnr1 ==>");
		for(CharSequence s : alphaArr)
		{
			strJnr1.add(s);
			p2.print(s + "  ");
		}
		p.print("");
		p.print(strJnr1);		
		
		p.print("building strJnr2 ==>");
		for(CharSequence s : betaArr)
		{
			strJnr2.add(s);
			p2.print(s + "  ");
		}
		p.print("");
		p.print(strJnr2);
		
		p.print("merging strJnr1 <> strJnr2 ");
		strJnr1.merge(strJnr2);
	}
}


/*
String:
methods:
private boolean    nonSyncContentEquals(java.lang.AbstractStringBuilder)
private int    indexOfSupplementary(int,int)
private int    lastIndexOfSupplementary(int,int)
private static void    checkBounds(byte[],int,int)
public boolean    contains(java.lang.CharSequence)
public boolean    contentEquals(java.lang.CharSequence)
public boolean    contentEquals(java.lang.StringBuffer)
public boolean    endsWith(java.lang.String)
public boolean    equals(java.lang.Object)
public boolean    equalsIgnoreCase(java.lang.String)
public boolean    isEmpty()
public boolean    matches(java.lang.String)
public boolean    regionMatches(boolean,int,java.lang.String,int,int)
public boolean    regionMatches(int,java.lang.String,int,int)
public boolean    startsWith(java.lang.String)
public boolean    startsWith(java.lang.String,int)
public byte[]    getBytes()
public byte[]    getBytes(java.lang.String)
public byte[]    getBytes(java.nio.charset.Charset)
public char    charAt(int)
public char[]    toCharArray()
public int    codePointAt(int)
public int    codePointBefore(int)
public int    codePointCount(int,int)
public int    compareTo(java.lang.Object)
public int    compareTo(java.lang.String)
public int    compareToIgnoreCase(java.lang.String)
public int    hashCode()
public int    indexOf(int)
public int    indexOf(int,int)
public int    indexOf(java.lang.String)
public int    indexOf(java.lang.String,int)
public int    lastIndexOf(int)
public int    lastIndexOf(int,int)
public int    lastIndexOf(java.lang.String)
public int    lastIndexOf(java.lang.String,int)
public int    length()
public int    offsetByCodePoints(int,int)
public java.lang.CharSequence    subSequence(int,int)
public java.lang.String    concat(java.lang.String)
public java.lang.String    replace(char,char)
public java.lang.String    replace(java.lang.CharSequence,java.lang.CharSequence)
public java.lang.String    replaceAll(java.lang.String,java.lang.String)
public java.lang.String    replaceFirst(java.lang.String,java.lang.String)
public java.lang.String    substring(int)
public java.lang.String    substring(int,int)
public java.lang.String    toLowerCase()
public java.lang.String    toLowerCase(java.util.Locale)
public java.lang.String    toString()
public java.lang.String    toUpperCase()
public java.lang.String    toUpperCase(java.util.Locale)
public java.lang.String    trim()
public java.lang.String[]    split(java.lang.String)
public java.lang.String[]    split(java.lang.String,int)
public native java.lang.String    intern()
public static java.lang.String    copyValueOf(char[])
public static java.lang.String    copyValueOf(char[],int,int)
public static java.lang.String    format(java.lang.String,java.lang.Object[])
public static java.lang.String    format(java.util.Locale,java.lang.String,java.lang.Object[])
public static java.lang.String    join(java.lang.CharSequence,java.lang.CharSequence[])
public static java.lang.String    join(java.lang.CharSequence,java.lang.Iterable)
public static java.lang.String    valueOf(boolean)
public static java.lang.String    valueOf(char)
public static java.lang.String    valueOf(char[])
public static java.lang.String    valueOf(char[],int,int)
public static java.lang.String    valueOf(double)
public static java.lang.String    valueOf(float)
public static java.lang.String    valueOf(int)
public static java.lang.String    valueOf(java.lang.Object)
public static java.lang.String    valueOf(long)
public void    getBytes(int,int,byte[],int)
public void    getChars(int,int,char[],int)
static int    indexOf(char[],int,int,char[],int,int,int)
static int    indexOf(char[],int,int,java.lang.String,int)
static int    lastIndexOf(char[],int,int,char[],int,int,int)
static int    lastIndexOf(char[],int,int,java.lang.String,int)
void    getChars(char[],int)

Fields:

private final char[] java.lang.String.value
private int java.lang.String.hash
private static final long java.lang.String.serialVersionUID
private static final java.io.ObjectStreamField[] java.lang.String.serialPersistentFields
public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER




Constructors:

public java.lang.String(byte[],int,int)
public java.lang.String(byte[],java.nio.charset.Charset)
public java.lang.String(byte[],java.lang.String) throws java.io.UnsupportedEncodingException
public java.lang.String(byte[],int,int,java.nio.charset.Charset)
public java.lang.String(byte[],int,int,java.lang.String) throws java.io.UnsupportedEncodingException
java.lang.String(char[],boolean)
public java.lang.String(java.lang.StringBuilder)
public java.lang.String(java.lang.StringBuffer)
public java.lang.String(byte[])
public java.lang.String(int[],int,int)
public java.lang.String()
public java.lang.String(char[])
public java.lang.String(java.lang.String)
public java.lang.String(char[],int,int)
public java.lang.String(byte[],int)
public java.lang.String(byte[],int,int,int)
*/

/*
StringBuilder:
methods:
private void    readObject(java.io.ObjectInputStream)
private void    writeObject(java.io.ObjectOutputStream)
public char    charAt(int)
public int    capacity()
public int    codePointAt(int)
public int    codePointBefore(int)
public int    codePointCount(int,int)
public int    indexOf(java.lang.String)
public int    indexOf(java.lang.String,int)
public int    lastIndexOf(java.lang.String)
public int    lastIndexOf(java.lang.String,int)
public int    length()
public int    offsetByCodePoints(int,int)
public java.lang.AbstractStringBuilder    append(boolean)
public java.lang.AbstractStringBuilder    append(char)
public java.lang.AbstractStringBuilder    append(char[])
public java.lang.AbstractStringBuilder    append(char[],int,int)
public java.lang.AbstractStringBuilder    append(double)
public java.lang.AbstractStringBuilder    append(float)
public java.lang.AbstractStringBuilder    append(int)
public java.lang.AbstractStringBuilder    append(java.lang.CharSequence)
public java.lang.AbstractStringBuilder    append(java.lang.CharSequence,int,int)
public java.lang.AbstractStringBuilder    append(java.lang.Object)
public java.lang.AbstractStringBuilder    append(java.lang.String)
public java.lang.AbstractStringBuilder    append(java.lang.StringBuffer)
public java.lang.AbstractStringBuilder    append(long)
public java.lang.AbstractStringBuilder    appendCodePoint(int)
public java.lang.AbstractStringBuilder    delete(int,int)
public java.lang.AbstractStringBuilder    deleteCharAt(int)
public java.lang.AbstractStringBuilder    insert(int,boolean)
public java.lang.AbstractStringBuilder    insert(int,char)
public java.lang.AbstractStringBuilder    insert(int,char[])
public java.lang.AbstractStringBuilder    insert(int,char[],int,int)
public java.lang.AbstractStringBuilder    insert(int,double)
public java.lang.AbstractStringBuilder    insert(int,float)
public java.lang.AbstractStringBuilder    insert(int,int)
public java.lang.AbstractStringBuilder    insert(int,java.lang.CharSequence)
public java.lang.AbstractStringBuilder    insert(int,java.lang.CharSequence,int,int)
public java.lang.AbstractStringBuilder    insert(int,java.lang.Object)
public java.lang.AbstractStringBuilder    insert(int,java.lang.String)
public java.lang.AbstractStringBuilder    insert(int,long)
public java.lang.AbstractStringBuilder    replace(int,int,java.lang.String)
public java.lang.AbstractStringBuilder    reverse()
public java.lang.Appendable    append(char)
public java.lang.Appendable    append(java.lang.CharSequence)
public java.lang.Appendable    append(java.lang.CharSequence,int,int)
public java.lang.CharSequence    subSequence(int,int)
public java.lang.String    substring(int)
public java.lang.String    substring(int,int)
public java.lang.String    toString()
public java.lang.StringBuilder    append(boolean)
public java.lang.StringBuilder    append(char)
public java.lang.StringBuilder    append(char[])
public java.lang.StringBuilder    append(char[],int,int)
public java.lang.StringBuilder    append(double)
public java.lang.StringBuilder    append(float)
public java.lang.StringBuilder    append(int)
public java.lang.StringBuilder    append(java.lang.CharSequence)
public java.lang.StringBuilder    append(java.lang.CharSequence,int,int)
public java.lang.StringBuilder    append(java.lang.Object)
public java.lang.StringBuilder    append(java.lang.String)
public java.lang.StringBuilder    append(java.lang.StringBuffer)
public java.lang.StringBuilder    append(long)
public java.lang.StringBuilder    appendCodePoint(int)
public java.lang.StringBuilder    delete(int,int)
public java.lang.StringBuilder    deleteCharAt(int)
public java.lang.StringBuilder    insert(int,boolean)
public java.lang.StringBuilder    insert(int,char)
public java.lang.StringBuilder    insert(int,char[])
public java.lang.StringBuilder    insert(int,char[],int,int)
public java.lang.StringBuilder    insert(int,double)
public java.lang.StringBuilder    insert(int,float)
public java.lang.StringBuilder    insert(int,int)
public java.lang.StringBuilder    insert(int,java.lang.CharSequence)
public java.lang.StringBuilder    insert(int,java.lang.CharSequence,int,int)
public java.lang.StringBuilder    insert(int,java.lang.Object)
public java.lang.StringBuilder    insert(int,java.lang.String)
public java.lang.StringBuilder    insert(int,long)
public java.lang.StringBuilder    replace(int,int,java.lang.String)
public java.lang.StringBuilder    reverse()
public void    ensureCapacity(int)
public void    getChars(int,int,char[],int)
public void    setCharAt(int,char)
public void    setLength(int)
public void    trimToSize()


Fields:

static final long java.lang.StringBuilder.serialVersionUID


Constructors:

public java.lang.StringBuilder(java.lang.CharSequence)
public java.lang.StringBuilder(java.lang.String)
public java.lang.StringBuilder(int)
public java.lang.StringBuilder()
*/

/*
StringTokenizer:
methods:
private boolean    isDelimiter(int)
private int    scanToken(int)
private int    skipDelimiters(int)
private void    setMaxDelimCodePoint()
public boolean    hasMoreElements()
public boolean    hasMoreTokens()
public int    countTokens()
public java.lang.Object    nextElement()
public java.lang.String    nextToken()
public java.lang.String    nextToken(java.lang.String)


fields:

private int java.util.StringTokenizer.currentPosition
private int java.util.StringTokenizer.newPosition
private int java.util.StringTokenizer.maxPosition
private java.lang.String java.util.StringTokenizer.str
private java.lang.String java.util.StringTokenizer.delimiters
private boolean java.util.StringTokenizer.retDelims
private boolean java.util.StringTokenizer.delimsChanged
private int java.util.StringTokenizer.maxDelimCodePoint
private boolean java.util.StringTokenizer.hasSurrogates
private int[] java.util.StringTokenizer.delimiterCodePoints



constructors:

public java.util.StringTokenizer(java.lang.String,java.lang.String)
public java.util.StringTokenizer(java.lang.String,java.lang.String,boolean)
public java.util.StringTokenizer(java.lang.String)
*/

/*
StringJoiner:
methods:
private java.lang.StringBuilder    prepareBuilder()
public int    length()
public java.lang.String    toString()
public java.util.StringJoiner    add(java.lang.CharSequence)
public java.util.StringJoiner    merge(java.util.StringJoiner)
public java.util.StringJoiner    setEmptyValue(java.lang.CharSequence)


fields:

private final java.lang.String java.util.StringJoiner.prefix
private final java.lang.String java.util.StringJoiner.delimiter
private final java.lang.String java.util.StringJoiner.suffix
private java.lang.StringBuilder java.util.StringJoiner.value
private java.lang.String java.util.StringJoiner.emptyValue


constructors:

public java.util.StringJoiner(java.lang.CharSequence)
public java.util.StringJoiner(java.lang.CharSequence,java.lang.CharSequence,java.lang.CharSequence)
*/