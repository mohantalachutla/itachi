import java.io.*;
import java.lang.annotation.*;
import java.util.*;
import java.util.regex.*;

@FunctionalInterface
interface P{
	void print(Object o);
}
//stream is flow of data in one direction.
// operation can't be undone once it's done. need to go from the start.
public class TestIO
{
	public static void main(String[] args)
	{
		TestIO ti = new TestIO();
		//ti.out();
		//ti.in();
		ti.others();
		//ti.writeOut();
		//ti.readIn();
	}
	public void out()
	{
		try
		{
		Out out = new Out();
		out.fileOut();
		out.bufferOut();
		out.byteArrOut();
		out.dataOut();
		}
		catch(Exception e)
		{
			System.out.println("exception :"+e+"\nMessage: "+e.getMessage());
		}
	}
	public void in()
	{
		try
		{
			In in = new In();
			in.fileIn();
			in.bufferIn();
			in.sequenceIn();
			in.byteArrin();
			in.dataIn();
		}
		catch(Exception e)
		{
			System.out.println("exception :"+e+"\nMessage: "+e.getMessage());
		}
	}
	public void others()
	{
		try
		{
			Others io = new Others();
			//io.console();
			//io.printStream();
			//io.scanner();
			//io.file();
			//io.randomAccessFile();
			io.flleDescriptor();
		}
		catch(Exception e)
		{
			System.out.println("exception :"+e+"\nMessage: "+e.getMessage());
		}
	}
	public void writeOut()
	{
		try
		{
			WriteOut out = new WriteOut();
			//out.fileOut();
			//out.bufferOut();
			//out.charArrout();
			out.stringWriter();
		}
		catch(Exception e)
		{
			System.out.println("exception :"+e+"\nMessage: "+e.getMessage());
		}
	}
	public void readIn()
	{
		try
		{
			ReadIn in = new ReadIn();
			//in.fileIn();
			//in.bufferIn();
			//in.charArrIn();
			in.stringReader();
		}
		catch(Exception e)
		{
			System.out.println("exception :"+e+"\nMessage: "+e.getMessage());
		}
	}
}
/*
streams used to read/write IO. format : byte.
file stream used to read/write the files. format: byte i.e ascii format
filter stream provides buffer, data, print, push back stream.
buffer stream enhances the IO operations internally by creating buffer. uses IO only when required. format : byte.
data stream reads/writes primitive data. format : all.
print stream prints data. format : all.
push back stream.
sequence input stream used to read data from multiple streams. format : byte.
byte array out stream used to write the same data to multiple streams. format : byte.
byte array in stream used just to read data. format : byte.
pipped stream
object stream is just like reflection, for static fields.
console stream is used do read/write operation to console. format: string

reader/writer used to read/write IO. format : char,string
*/
class Out
{
	P p = System.out::println;
	P p2 = System.out::print;
	OutputStream out = null,bout = null, fout = null;
	ByteArrayOutputStream byout = null;  // can not be declared as OutputStream
	DataOutputStream dout = null; // can not be declared as OutputStream
	byte[] barr = new byte [100], barr1 = new byte[100];
	public void fileOut() throws Exception
	{
		p.print("fileOut() -->");
		String firstName = "itachi";
		String lastName = "Uchiha";
		String name = firstName + lastName;
		byte[] nameBarr = name.getBytes();
		out = new FileOutputStream("./file.txt"); // will create if it doesn't exits. if exits it over rights the data.
		out.write(65); // writes ascii int
		out.write(nameBarr); //writes byte arr only
		out.write(nameBarr,3,5); //writes byte arr only; 3 offset, 4 len
		//out.finalize(); // may used to finilize things in child class
		
		//FileChannel fch = out.getChannel();
		//FileDescriptor fd = out.getFD();
		
		out.close();
		//out.write(47); //exception : stream closed.
	}
	public void bufferOut() throws Exception
	{
		p.print("bufferOut() -->");
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String beta = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
		String firstName = "itachi";
		String lastName = "Uchiha";
		String name = firstName + lastName;
		out = new FileOutputStream("./buffer.txt");
		//fout = new BufferedOutputStream(out); // creates buffer with defualt size.
		bout = new BufferedOutputStream(out,20); // creates buffer with defualt size and writes to the file stream 20 bytes at a time.
		bout.write(65);
		//bout.write(name.getBytes());
		bout.write(alpha.getBytes());
		bout.write(beta.getBytes());
		bout.flush(); // frees the buffer
		bout.close();
		out.close();
	}
	public void byteArrOut() throws Exception
	{
		// buffer limit increases as data comes
		p.print("byteArrOut() -->");
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String beta = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
		String firstName = "itachi";
		String lastName = "Uchiha";
		String name = firstName + lastName;
		byout = new ByteArrayOutputStream(100); // buffer limit 100
		out = new ByteArrayOutputStream(100); // buffer limit 100
		barr = alpha.getBytes();
		//p.print(barr.length);
		byout.write(barr,0,barr.length);
		p.print("toByteArray()  -->");
		barr1 = byout.toByteArray(); 
		printArr(barr1);
		p.print("toString()  -->");
		p.print(byout.toString());
		fout = new FileOutputStream("./byte.txt");
		byout.writeTo(fout); 
		fout = new FileOutputStream("./byte1.txt");
		byout.writeTo(fout); 
		fout = new FileOutputStream("./byte2.txt");
		byout.writeTo(fout); 
		byout.writeTo(out);
	}
	public void dataOut() throws Exception
	{
		p.print("dataOut()   -->");
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		String beta = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
		String firstName = "itachi";
		String lastName = "Uchiha";
		String name = firstName + lastName;
		fout = new FileOutputStream("./data.txt");
		dout = new DataOutputStream(fout);
		dout.write(65);
		barr = alpha.getBytes();
		printArr(barr);
		dout.write(barr,0,barr.length);
		dout.writeByte(65);
		dout.writeBytes("mohan");
		dout.writeChar(65);
		dout.writeChars("mohan");
		dout.writeBoolean(false);
		dout.writeInt(65);
		dout.writeShort(65);
		dout.writeLong(65);
		dout.writeUTF("itachi_Uchiha"); // UTF-8 as string
	}
	public void printArr(byte[] arr)
	{
		for(byte b : arr)
		{
			p2.print(b+",");
		}
		p.print("");
	}
	public String toString(byte[] arr)
	{
		return new String(arr);
	}
}
class In
{
	P p = System.out::println;
	P p2 = System.out::print;
	byte[] barr = new byte [100];
	InputStream in = null, fin = null, bin = null, sqin = null;
	DataInputStream din = null;
	ByteArrayInputStream byin = null;
	public void fileIn() throws Exception
	{
		p.print("fileIn() -->");
		int ascii;
		byte[] readBarr =new byte[5];
		byte[] readBarr1 =new byte[5];
		in = new FileInputStream("./file.txt"); // throws exception if it doesn't exits.
		p.print("available()  -->"+in.available()); // in bytes
		ascii = in.read();
		p.print("read ascii -->"+ascii); // reads a bytes
		p.print("skip() -->"+in.skip(3)); // skips 3 bytes
		p.print("read  -->"+in.read(readBarr)); // reads upto 5 bytes, -1 if nothing to read
		p.print("readBarr  -->");
		printArr(readBarr);
		p.print("\n"+new String(readBarr));
		
		p.print("read  -->"+in.read(readBarr1,2,2)); // -1 if nothing to read;
		p.print("readBarr1  -->");
		printArr(readBarr1);
		p.print("\n"+new String(readBarr1));
	}
	public void bufferIn() throws Exception
	{
		p.print("bufferIn() -->");
		int ascii;
		byte[] readBarr =new byte[14];
		byte[] readBarr1 =new byte[10];
		in = new FileInputStream("./buffer.txt"); // throws exception if it doesn't exits.
		bin = new BufferedInputStream(in,10); // buffer created with size 10 bytes
		p.print("available()  -->"+in.available()); // in bytes
		ascii = bin.read();
		p.print("read ascii -->"+ascii); // reads a bytes
		p.print("skip() -->"+bin.skip(3)); // skips 3 bytes
		p.print("markSupported()  -->"+bin.markSupported());
		p.print("mark()  -->");
		bin.mark(6); // marks the current position with internal buffer of 6 from that position
		bin.read();
		bin.read();
		bin.read();
		bin.read();
		bin.read();
		p.print("reset()   -->");
		bin.reset(); // resets to marked position
		p.print("read  -->"+bin.read(readBarr)); // reads upto 10 bytes, -1 if nothing to read
		p.print("readBarr  -->");
		printArr(readBarr);
		p.print("\n"+new String(readBarr));
		p.print("read  -->"+bin.read(readBarr1,3,5)); // -1 if nothing to read;
		p.print("readBarr1  -->");
		printArr(readBarr1);
		p.print("\n"+new String(readBarr1));
	}
	void sequenceIn() throws Exception
	{
		p.print("sequenceIn()  -->");
		int ascii;
		byte[] readBarr =new byte[14];
		byte[] readBarr1 =new byte[10];
		//sqin = new SequenceInputStream(new FileInputStream("./file.txt"),new FileInputStream("./buffer.txt")); // reads both streams in a sequence
		List<InputStream> fileslist = new ArrayList(10);
		Collections.addAll(fileslist, new FileInputStream("./file.txt"),new FileInputStream("./buffer.txt"),new FileInputStream("./file.txt"),new FileInputStream("./buffer.txt")); // reads enumeration in a sequence
		Enumeration files = Collections.enumeration(fileslist);
		sqin = new SequenceInputStream(files); // reads stream in a sequence
		in = new BufferedInputStream(sqin,10); // buffer created with size 10 bytes i.e reads 10 bytes at a time.
		//in = sqin;
		in.read(readBarr,0,7);
		printArr(readBarr);
		p.print(toString(readBarr));
		in.read(readBarr,0,7);
		printArr(readBarr);
		p.print(toString(readBarr));
		in.read(readBarr,0,7);
		printArr(readBarr);
		p.print(toString(readBarr));
		in.read(readBarr,0,7); // reading the 2nd stream
		printArr(readBarr);
		p.print(toString(readBarr));
		
	}
	public void byteArrin() throws Exception // usage : unknown
	{
		// buffer limit increases as data comes
		// mark, reset, skip can be used
		p.print("byteArrin() -->");
		fin = new FileInputStream("./byte.txt");
		fin.read(barr);
		byin = new ByteArrayInputStream(barr,0, 100); // buffer limit 100
		//in = new ByteArrayInputStream(barr,0, 100); // buffer limit 100
	}
	public void dataIn() throws Exception
	{
		p.print("dataIn()   -->");
		fin = new FileInputStream("./data.txt");
		din = new DataInputStream(fin);
		p.print("read()  -->"+din.read());
		din.read(barr,0,26);
		p.print("printArr");
		printArr(barr);
		p.print("readByte()  -->"+din.readByte());
		din.read(barr,0,5);
		p.print("readChar()  -->"+din.readChar());
		din.read(barr,0,5);
		p.print("readBoolean() -->"+din.readBoolean());
		p.print("readInt() -->"+din.readInt());
		p.print("readShort()  -->"+din.readShort());
		p.print("readLong() -->"+din.readLong());
		p.print("readUTF()  -->"+din.readUTF()); // UTF-8 as string
	}
	public void printArr(byte[] arr)
	{
		for(byte b : arr)
		{
			p2.print(b+",");
		}
		p.print("");
	}
	public String toString(byte[] arr)
	{
		return new String(arr);
	}
}

class Others
{
	P p = System.out::println;
	P p2 = System.out::print;
	FileOutputStream fout = null;
	OutputStream out = null;
	FileInputStream fin = null;
	InputStream in = null;
	Console con = null;
	PrintStream ps = null;
	Scanner scan = null;
	File file = null, file2 = null, file3 = null, dir = null;
	RandomAccessFile RAFile = null, RAFile2 = null, RADir;
	FileDescriptor fd = null;
	void console() throws Exception
	{
		//console is final class, doesn't have public constructor.
		con = System.console(); // console creaion
		int age = 0,private_key = 0;
		char sex = 'N';
		Reader reader = null;
		Writer writer = null;
		String name = "",public_key = "", user = "", user2 = "";
		char[] pass = new char[100], pass2 = new char[100];
		p.print("readLine()>>>");
		user = con.readLine();
		p.print("readLine()f >>>");
		user2 = con.readLine("%s,%c,%d",name,sex,age);
		p.print("readPassword()>>>");
		pass = con.readPassword();
		p.print("readPassword()f>>>");
		pass = con.readPassword("%s, %d",public_key,private_key);
		p.print("printf()<<<user");
		con.printf(user);
		p.print("printf<<<f");
		con.printf("%s, %c, %d",name,sex,age);
		p.print("printf() <<<pass");
		con.printf(new String(pass));
		
		p.print("printf()<<<user2");
		con.printf(user2);
		p.print("printf()<<<pass2");
		con.printf(new String(pass2));
		p.print("format()<<<");
		con.format("%s, %d",public_key,private_key);
		reader = con.reader();
		writer = con.writer();
		
	}
	public void printStream() throws Exception
	{
		String firstName = "itachi";
		String lastName = "uchiha";
		String name = firstName+lastName;
		
		
		fout = new FileOutputStream("./print.txt");
		ps = new PrintStream(fout);
		ps.print(23); // has overloading for all types
		ps.print('M');
		ps.print(name);
		ps.print(name.toCharArray());
		ps.print(true);
		ps.print(new Object(){ private String name = "itachi"; private int age = 78; private String clan = "uchiha"; public String toString(){return "name : "+this.name+" age : "+this.age+" clan : "+this.clan;}});
		ps.println(); // has overloading for all types
		ps.println(23); // has overloading for all types
		ps.println('M');
		ps.println(name);
		ps.println(name.toCharArray());
		ps.println(true);
		ps.println(new Object(){ private String name = "itachi"; private int age = 78; private String clan = "uchiha"; public String toString(){return "name : "+this.name+" age : "+this.age+" clan : "+this.clan;}});
		ps.printf("%s %d %c",name,23,'M');
		ps.format("%s %d %c",name,23,'M');
	}
	public void file() throws Exception
	{
		file3 = new File("./__file__.txt");
		p.print("createNewFile() -->"+file3.createNewFile());
		file = new File("./__file.txt");
		p.print("createNewFile() -->"+file.createNewFile());
		p.print("canWrite() -->"+file.canWrite());
		p.print("canRead() -->"+file.canRead());
		p.print("canExecute() -->"+file.canExecute());
		file2 = File.createTempFile("__file","temp");
		p.print("createNewFile() -->"+file2.createNewFile());
		p.print("canWrite() -->"+file2.canWrite());
		p.print("canRead() -->"+file2.canRead());
		p.print("canExecute() -->"+file2.canExecute());
		p.print("isDirectory() -->"+file2.isDirectory());
		p.print("isFile() -->"+file2.isFile());
		p.print("isAbsolute() -->"+file2.isAbsolute());
		p.print("toPath() -->"+file2.toPath());
		p.print("toURI() -->"+file2.toURI());
		p.print("mkDir() -->"+file2.mkdir());
		dir = new File("./dir");
		p.print("mkDir() -->"+dir.mkdir());
		p.print("isDirectory() -->"+dir.isDirectory());
	}
	public void randomAccessFile() throws Exception
	{
		file = new File("./__file.txt");
		RAFile = new RandomAccessFile(file,"rw"); // r = read, w = write
		RAFile.writeFloat(38.383f);
		RAFile.writeDouble(38.383F);
		RAFile.writeUTF("itachi uchiha");  // UTF-8
		RAFile.write(65);  // UTF-8
		p.print("length() -->"+RAFile.length());
		RAFile.seek(1); // position 1
		p.print("readInt() -->"+RAFile.readInt());  // UTF-8
		p.print("readFloat() -->"+RAFile.readFloat());  // UTF-8
		p.print("readLine() -->"+RAFile.readLine());  // UTF-8
		p.print("readUTF() -->"+RAFile.readUTF());  // UTF-8
	}
	public void scanner() throws Exception // InputMismatchException
	{
		scan = new Scanner(System.in); // takes input stream, String, File, Path 
		scan = new Scanner("ADF/@#33/sddf22/df99*ld\n33fkf\n3.33/*lflf@#fasdf\nlk@#a/di883(*");
		p.print("hasNext()  -->"+scan.hasNext());
		p.print("next()  -->"+scan.next()); //checks before line {excluded}, reads token
		p.print("hasNextLine()  -->"+scan.hasNextLine());
		p.print("nextLine()  -->"+scan.nextLine()); //checks for line {included}, reads line
		p.print("nextLine()  -->"+scan.nextLine()); //checks for line
		//p.print("hasNextInt()  -->"+scan.hasNextInt());
		//p.print("nextInt()  -->"+scan.nextInt()); //checks for line, read int
		scan.reset(); //resets to default but not the iterator
		p.print("useDelimiter()  -->"+scan.useDelimiter("/"));
		//p.print("tokens()  -->"+scan.tokens()); // usage : unknown
		scan.skip(Pattern.compile("@#"));
		p.print("next()  -->"+scan.next());
		//scan.remove();  // removes op
		
	}
//System.in{inputStream} System.out{PrintStream} System.err{ErrorStream} 
	public void flleDescriptor() throws Exception
	{// it is represents whether the stream is input, output, error.
		byte[] arrOut = {65,76,97,33,44,98};
		byte[] arrIn = new byte[100];
		file = new File("./__file.txt");
		fin = new FileInputStream(file);
		fout = new FileOutputStream(file);
		fd = fout.getFD();
		fout.write(arrOut);
		fout.flush();
		fd.sync(); // confirms that data has been written
		p.print("read() -->"+fin.read());
		p.print("read() -->");
		fin.read(arrIn);
		printArr(arrIn);
	}
	public void printArr(byte[] arr)
	{
		for(byte b : arr)
		{
			p2.print(b+",");
		}
		p.print("");
	}
	public String toString(byte[] arr)
	{
		return new String(arr);
	}
}
class WriteOut
{
	P p = System.out::println;
	P p2 = System.out::print;
	String name = "itachi uchiha";
	char[] chars = name.toCharArray(); //getChars(arr,i,len)
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	String beta = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
	
	FileWriter fout = null;
	BufferedWriter bout = null;
	Writer out = null;
	CharArrayWriter cout = null;
	PrintWriter pw = null;
	StringWriter sw = null;
	
	
	void fileOut() throws Exception
	{
		fout = new FileWriter("./__file__.txt");
		fout.write(name);
		fout.write('M');
		fout.write(chars);
		fout.flush();
		fout.close();
	}
	void bufferOut() throws Exception
	{
		fout = new FileWriter("./__buffer__.txt");
		bout = new BufferedWriter(fout);
		bout.write(name,0,name.length()-1);
		bout.write(65);
		bout.newLine();
		bout.write(chars,0,chars.length-1);
		bout.flush();
		bout.close();
		fout.close();
	}
	void charArrout() throws Exception  // like byteArrStream, it can  write charArrStream
	{
		cout = new CharArrayWriter();
		cout.append(name).append('#').append(name,0,5).write(3);  // append return CharArrayWriter where write returns void
		cout.write(name);
		cout.write(4);
		cout.write(chars,0,5);
		fout = new FileWriter("./__char__.txt");
		cout.writeTo(fout);
		fout.close();
		fout = new FileWriter("./__char2__.txt");
		cout.writeTo(fout);
		fout.close();
		cout.close();
	}
	/* public void printWriter() throws Exception  // PrintWriter Error : unknown symbol
	{
		String firstName = "itachi";
		String lastName = "uchiha";
		String name = firstName+lastName;
		
		
		fout = new FileOutputStream("./print.txt");
		PrintWriter = new PrintWriter(fout);
		pw.println(23);
		pw.println(name.toCharArray());
		pw.println(true);
		pw.append('M');
		pw.append(name);
		pw.print(new Object(){ private String name = "itachi"; private int age = 78; private String clan = "uchiha"; public String toString(){return "name : "+this.name+" age : "+this.age+" clan : "+this.clan;}});
		pw.format("%s %d %c",name,23,'M');
		p.print("checkError() -->"+pw.checkError());
		//pw.setError(); // protected
		//pw.clearError(); // protected
	} */ 
	public void outputStreamWriter()  // writes to a stream insted of writer, chars internally converted into bytes
	{}
	public void stringWriter() throws Exception// used write to a string
	{
		String name = "itachi uchiha";
		sw =new StringWriter(30);
		sw.write(65);
		sw.write(name.toCharArray());
		sw.append('M');
		sw.append(name);
		p.print("toString()  -->"+sw.toString());
		StringBuffer sb = sw.getBuffer();
		p.print("getBuffer()  -->"+sb);
		sw.flush();
		sw.close();
	}
	public void pippedOut() // used in multi-threding to write to pipped writer
	{
		
	}
	public void printArr(byte[] arr)
	{
		for(byte b : arr)
		{
			p2.print(b+",");
		}
		p.print("");
	}
	public String toString(byte[] arr)
	{
		return new String(arr);
	}
}
class ReadIn
{
	P p = System.out::println;
	P p2 = System.out::print;
	String name = "";
	char[] chars = new char[100];
	int ascii;
	String data = "";
	
	FileReader fin = null;
	Reader in = null;
	BufferedReader bin = null;
	StringReader sr = null;
	
	void fileIn() throws Exception
	{
		fin = new FileReader("./__file__.txt");
		ascii = fin.read(); // reads in byte
		p.print("read()  -->"+ascii);
	}
	void bufferIn() throws Exception
	{
		// mark, reset, skip can be used
		fin = new FileReader("./__buffer__.txt");
		bin = new BufferedReader(fin);
		ascii = bin.read(); // reads in byte
		p.print("read()  -->"+ascii);
		p.print(bin.readLine());
		bin.read(chars,0,10);
		printArr(chars);
	}
	void charArrIn() // Usage Unknown 
	{}
	
	public void inputStreamReader()  // reads from a stream insted of reader, chars internally read bytes but as chars
	{}
	public void stringReader() throws Exception
	{//mark, skip, ready, reset can be used
		String buffer = "23sdfasdaf292333foiadadflkdfjsdfll233((9332#@#@dsf";
		char[] chars = new char[20];
		sr = new StringReader(buffer);
		p.print(sr.read());
		sr.read(chars,0,15);
		printArr(chars);
		sr.close();
	}
	public void pippedIn() // used in multi-threding to read from pipped writer
	{
		
	}
	public void printArr(char[] arr)
	{
		for(char c : arr)
		{
			p2.print(c+",");
		}
		p.print("");
	}
	public String toString(char[] arr)
	{
		return new String(arr);
	}
}

/*
System.class
Methods:
private static java.io.PrintStream    newPrintStream(java.io.FileOutputStream,java.lang.String)
private static native java.util.Properties    initProperties(java.util.Properties)
private static native void    registerNatives()
private static native void    setErr0(java.io.PrintStream)
private static native void    setIn0(java.io.InputStream)
private static native void    setOut0(java.io.PrintStream)
private static synchronized void    setSecurityManager0(java.lang.SecurityManager)
private static void    checkIO()
private static void    checkKey(java.lang.String)
private static void    initializeSystemClass()
private static void    setJavaLangAccess()
public static java.io.Console    console()
public static java.lang.SecurityManager    getSecurityManager()
public static java.lang.String    clearProperty(java.lang.String)
public static java.lang.String    getProperty(java.lang.String)
public static java.lang.String    getProperty(java.lang.String,java.lang.String)
public static java.lang.String    getenv(java.lang.String)
public static java.lang.String    lineSeparator()
public static java.lang.String    setProperty(java.lang.String,java.lang.String)
public static java.nio.channels.Channel    inheritedChannel()
public static java.util.Map    getenv()
public static java.util.Properties    getProperties()
public static native int    identityHashCode(java.lang.Object)
public static native java.lang.String    mapLibraryName(java.lang.String)
public static native long    currentTimeMillis()
public static native long    nanoTime()
public static native void    arraycopy(java.lang.Object,int,java.lang.Object,int,int)
public static void    exit(int)
public static void    gc()
public static void    load(java.lang.String)
public static void    loadLibrary(java.lang.String)
public static void    runFinalization()
public static void    runFinalizersOnExit(boolean)
public static void    setErr(java.io.PrintStream)
public static void    setIn(java.io.InputStream)
public static void    setOut(java.io.PrintStream)
public static void    setProperties(java.util.Properties)
public static void    setSecurityManager(java.lang.SecurityManager)

Fields:
public static final java.io.InputStream java.lang.System.in
public static final java.io.PrintStream java.lang.System.out
public static final java.io.PrintStream java.lang.System.err
private static volatile java.io.Console java.lang.System.cons
private static java.util.Properties java.lang.System.props
private static java.lang.String java.lang.System.lineSeparator


Constructors:
private java.lang.System()

*/

/*
OutputStream.class
Methods:
public abstract void    write(int)
public void    close()
public void    flush()
public void    write(byte[])
public void    write(byte[],int,int)

Constructors:
public java.io.OutputStream()

InputStream.class
Methods:
public abstract int    read()
public boolean    markSupported()
public int    available()
public int    read(byte[])
public int    read(byte[],int,int)
public long    skip(long)
public synchronized void    mark(int)
public synchronized void    reset()
public void    close()

Fields:
private static final int java.io.InputStream.MAX_SKIP_BUFFER_SIZE

Constructors:
public java.io.InputStream()
*/

/*
FileOutputStream.class
Methods:
private native void    close0()
private native void    open0(java.lang.String,boolean)
private native void    write(int,boolean)
private native void    writeBytes(byte[],int,int,boolean)
private static native void    initIDs()
private void    open(java.lang.String,boolean)
protected void    finalize()
public final java.io.FileDescriptor    getFD()
public java.nio.channels.FileChannel    getChannel()
public void    close()
public void    write(byte[])
public void    write(byte[],int,int)
public void    write(int)
static void    access$000(java.io.FileOutputStream)

Fields:
private final java.io.FileDescriptor java.io.FileOutputStream.fd
private final boolean java.io.FileOutputStream.append
private java.nio.channels.FileChannel java.io.FileOutputStream.channel
private final java.lang.String java.io.FileOutputStream.path
private final java.lang.Object java.io.FileOutputStream.closeLock
private volatile boolean java.io.FileOutputStream.closed

Constructors:
public java.io.FileOutputStream(java.io.FileDescriptor)
public java.io.FileOutputStream(java.io.File,boolean) throws java.io.FileNotFoundException
public java.io.FileOutputStream(java.io.File) throws java.io.FileNotFoundException
public java.io.FileOutputStream(java.lang.String,boolean) throws java.io.FileNotFoundException
public java.io.FileOutputStream(java.lang.String) throws java.io.FileNotFoundException

FileInputStream.class
Methods:
private native int    read0()
private native int    readBytes(byte[],int,int)
private native void    close0()
private native void    open0(java.lang.String)
private static native void    initIDs()
private void    open(java.lang.String)
protected void    finalize()
public final java.io.FileDescriptor    getFD()
public int    read()
public int    read(byte[])
public int    read(byte[],int,int)
public java.nio.channels.FileChannel    getChannel()
public native int    available()
public native long    skip(long)
public void    close()
static void    access$000(java.io.FileInputStream)

Fields:
private final java.io.FileDescriptor java.io.FileInputStream.fd
private final java.lang.String java.io.FileInputStream.path
private java.nio.channels.FileChannel java.io.FileInputStream.channel
private final java.lang.Object java.io.FileInputStream.closeLock
private volatile boolean java.io.FileInputStream.closed

Constructors
public java.io.FileInputStream(java.io.FileDescriptor)
public java.io.FileInputStream(java.io.File) throws java.io.FileNotFoundException
public java.io.FileInputStream(java.lang.String) throws java.io.FileNotFoundException
*/
/*
ByteArrayOutputStream.class
Methods:
private static int    hugeCapacity(int)
private void    ensureCapacity(int)
private void    grow(int)
public synchronized byte[]    toByteArray()
public synchronized int    size()
public synchronized java.lang.String    toString()
public synchronized java.lang.String    toString(int)
public synchronized java.lang.String    toString(java.lang.String)
public synchronized void    reset()
public synchronized void    write(byte[],int,int)
public synchronized void    write(int)
public synchronized void    writeTo(java.io.OutputStream)
public void    close()

getDeclaredFields:
protected byte[] java.io.ByteArrayOutputStream.buf
protected int java.io.ByteArrayOutputStream.count
private static final int java.io.ByteArrayOutputStream.MAX_ARRAY_SIZE

getDeclaredConstructors:
public java.io.ByteArrayOutputStream()
public java.io.ByteArrayOutputStream(int)

ByteArrayInputStream.class
Methods:
public boolean    markSupported()
public synchronized int    available()
public synchronized int    read()
public synchronized int    read(byte[],int,int)
public synchronized long    skip(long)
public synchronized void    reset()
public void    close()
public void    mark(int)

getDeclaredFields:
protected byte[] java.io.ByteArrayInputStream.buf
protected int java.io.ByteArrayInputStream.pos
protected int java.io.ByteArrayInputStream.mark
protected int java.io.ByteArrayInputStream.count

getDeclaredConstructors:
public java.io.ByteArrayInputStream(byte[])
public java.io.ByteArrayInputStream(byte[],int,int)
*/
/*
FilterOutputStream.class
Methods:
public void    close()
public void    flush()
public void    write(byte[])
public void    write(byte[],int,int)
public void    write(int)

getDeclaredFields:
protected java.io.OutputStream java.io.FilterOutputStream.out

getDeclaredConstructors:
public java.io.FilterOutputStream(java.io.OutputStream)

FilterInputStream.class
Methods:
public boolean    markSupported()
public int    available()
public int    read()
public int    read(byte[])
public int    read(byte[],int,int)
public long    skip(long)
public synchronized void    mark(int)
public synchronized void    reset()
public void    close()

getDeclaredFields:
protected volatile java.io.InputStream java.io.FilterInputStream.in

getDeclaredConstructors:
protected java.io.FilterInputStream(java.io.InputStream)

*/
/*
PipedOutputStream.class
Methods:
public synchronized void    connect(java.io.PipedInputStream)
public synchronized void    flush()
public void    close()
public void    write(byte[],int,int)
public void    write(int)

getDeclaredFields:
private java.io.PipedInputStream java.io.PipedOutputStream.sink

getDeclaredConstructors:
public java.io.PipedOutputStream(java.io.PipedInputStream) throws java.io.IOException

PipedInputStream.class
Methods:
private void    awaitSpace()
private void    checkStateForReceive()
private void    initPipe(int)
protected synchronized void    receive(int)
public synchronized int    available()
public synchronized int    read()
public synchronized int    read(byte[],int,int)
public void    close()
public void    connect(java.io.PipedOutputStream)
synchronized void    receive(byte[],int,int)
synchronized void    receivedLast()




getDeclaredFields:
boolean java.io.PipedInputStream.closedByWriter
volatile boolean java.io.PipedInputStream.closedByReader
boolean java.io.PipedInputStream.connected
java.lang.Thread java.io.PipedInputStream.readSide
java.lang.Thread java.io.PipedInputStream.writeSide
private static final int java.io.PipedInputStream.DEFAULT_PIPE_SIZE
protected static final int java.io.PipedInputStream.PIPE_SIZE
protected byte[] java.io.PipedInputStream.buffer
protected int java.io.PipedInputStream.in
protected int java.io.PipedInputStream.out
static final boolean java.io.PipedInputStream.$assertionsDisabled




getDeclaredConstructors:
public java.io.PipedInputStream(int)
public java.io.PipedInputStream()
public java.io.PipedInputStream(java.io.PipedOutputStream,int) throws java.io.IOException
public java.io.PipedInputStream(java.io.PipedOutputStream) throws java.io.IOException
*/
/*
ObjectOutputStream.class
Methods:
int    getProtocolVersion()
private boolean    isCustomSubclass()
private static boolean    auditSubclass(java.lang.Class)
private static native void    doublesToBytes(double[],int,byte[],int,int)
private static native void    floatsToBytes(float[],int,byte[],int,int)
private void    clear()
private void    defaultWriteFields(java.lang.Object,java.io.ObjectStreamClass)
private void    verifySubclass()
private void    writeArray(java.lang.Object,java.io.ObjectStreamClass,boolean)
private void    writeClass(java.lang.Class,boolean)
private void    writeClassDesc(java.io.ObjectStreamClass,boolean)
private void    writeEnum(java.lang.Enum,java.io.ObjectStreamClass,boolean)
private void    writeExternalData(java.io.Externalizable)
private void    writeFatalException(java.io.IOException)
private void    writeHandle(int)
private void    writeNonProxyDesc(java.io.ObjectStreamClass,boolean)
private void    writeNull()
private void    writeObject0(java.lang.Object,boolean)
private void    writeOrdinaryObject(java.lang.Object,java.io.ObjectStreamClass,boolean)
private void    writeProxyDesc(java.io.ObjectStreamClass,boolean)
private void    writeSerialData(java.lang.Object,java.io.ObjectStreamClass)
private void    writeString(java.lang.String,boolean)
protected boolean    enableReplaceObject(boolean)
protected java.lang.Object    replaceObject(java.lang.Object)
protected void    annotateClass(java.lang.Class)
protected void    annotateProxyClass(java.lang.Class)
protected void    drain()
protected void    writeClassDescriptor(java.io.ObjectStreamClass)
protected void    writeObjectOverride(java.lang.Object)
protected void    writeStreamHeader()
public final void    writeObject(java.lang.Object)
public java.io.ObjectOutputStream$PutField    putFields()
public void    close()
public void    defaultWriteObject()
public void    flush()
public void    reset()
public void    useProtocolVersion(int)
public void    write(byte[])
public void    write(byte[],int,int)
public void    write(int)
public void    writeBoolean(boolean)
public void    writeByte(int)
public void    writeBytes(java.lang.String)
public void    writeChar(int)
public void    writeChars(java.lang.String)
public void    writeDouble(double)
public void    writeFields()
public void    writeFloat(float)
public void    writeInt(int)
public void    writeLong(long)
public void    writeShort(int)
public void    writeUTF(java.lang.String)
public void    writeUnshared(java.lang.Object)
static boolean    access$100()
static java.io.ObjectOutputStream$BlockDataOutputStream    access$000(java.io.ObjectOutputStream)
static java.io.ObjectOutputStream$DebugTraceInfoStack    access$200(java.io.ObjectOutputStream)
static void    access$300(java.io.ObjectOutputStream,java.lang.Object,boolean)
static void    access$400(float[],int,byte[],int,int)
static void    access$500(double[],int,byte[],int,int)
void    writeTypeString(java.lang.String)

Fields:
private final java.io.ObjectOutputStream$BlockDataOutputStream java.io.ObjectOutputStream.bout
private final java.io.ObjectOutputStream$HandleTable java.io.ObjectOutputStream.handles
private final java.io.ObjectOutputStream$ReplaceTable java.io.ObjectOutputStream.subs
private int java.io.ObjectOutputStream.protocol
private int java.io.ObjectOutputStream.depth
private byte[] java.io.ObjectOutputStream.primVals
private final boolean java.io.ObjectOutputStream.enableOverride
private boolean java.io.ObjectOutputStream.enableReplace
private java.io.SerialCallbackContext java.io.ObjectOutputStream.curContext
private java.io.ObjectOutputStream$PutFieldImpl java.io.ObjectOutputStream.curPut
private final java.io.ObjectOutputStream$DebugTraceInfoStack java.io.ObjectOutputStream.debugInfoStack
private static final boolean java.io.ObjectOutputStream.extendedDebugInfo

Constructors:
public java.io.ObjectOutputStream(java.io.OutputStream) throws java.io.IOException
protected java.io.ObjectOutputStream() throws java.io.IOException,java.lang.SecurityException

ObjectInputStream.class
Methods:
java.lang.String    readTypeString()
private boolean    isCustomSubclass()
private final sun.misc.ObjectInputFilter    getInternalObjectInputFilter()
private final void    setInternalObjectInputFilter(sun.misc.ObjectInputFilter)
private java.io.IOException    readFatalException()
private java.io.ObjectStreamClass    readClassDesc(boolean)
private java.io.ObjectStreamClass    readNonProxyDesc(boolean)
private java.io.ObjectStreamClass    readProxyDesc(boolean)
private java.lang.Class    readClass(boolean)
private java.lang.Enum    readEnum(boolean)
private java.lang.Object    checkResolve(java.lang.Object)
private java.lang.Object    readArray(boolean)
private java.lang.Object    readHandle(boolean)
private java.lang.Object    readNull()
private java.lang.Object    readObject0(boolean)
private java.lang.Object    readOrdinaryObject(boolean)
private java.lang.String    readString(boolean)
private static boolean    auditSubclass(java.lang.Class)
private static java.lang.ClassLoader    latestUserDefinedLoader()
private static java.lang.Object    cloneArray(java.lang.Object)
private static native void    bytesToDoubles(byte[],int,double[],int,int)
private static native void    bytesToFloats(byte[],int,float[],int,int)
private static void    setValidator(java.io.ObjectInputStream,sun.misc.ObjectStreamClassValidator)
private void    clear()
private void    defaultReadFields(java.lang.Object,java.io.ObjectStreamClass)
private void    filterCheck(java.lang.Class,int)
private void    handleReset()
private void    readExternalData(java.io.Externalizable,java.io.ObjectStreamClass)
private void    readSerialData(java.lang.Object,java.io.ObjectStreamClass)
private void    skipCustomData()
private void    validateDescriptor(java.io.ObjectStreamClass)
private void    verifySubclass()
protected boolean    enableResolveObject(boolean)
protected java.io.ObjectStreamClass    readClassDescriptor()
protected java.lang.Class    resolveClass(java.io.ObjectStreamClass)
protected java.lang.Class    resolveProxyClass(java.lang.String[])
protected java.lang.Object    readObjectOverride()
protected java.lang.Object    resolveObject(java.lang.Object)
protected void    readStreamHeader()
public boolean    readBoolean()
public byte    readByte()
public char    readChar()
public double    readDouble()
public final java.lang.Object    readObject()
public float    readFloat()
public int    available()
public int    read()
public int    read(byte[],int,int)
public int    readInt()
public int    readUnsignedByte()
public int    readUnsignedShort()
public int    skipBytes(int)
public java.io.ObjectInputStream$GetField    readFields()
public java.lang.Object    readUnshared()
public java.lang.String    readLine()
public java.lang.String    readUTF()
public long    readLong()
public short    readShort()
public void    close()
public void    defaultReadObject()
public void    readFully(byte[])
public void    readFully(byte[],int,int)
public void    registerValidation(java.io.ObjectInputValidation,int)
static boolean    access$900(java.io.ObjectInputStream)
static int    access$400(java.io.ObjectInputStream)
static int    access$402(java.io.ObjectInputStream,int)
static java.io.ObjectInputStream$BlockDataInputStream    access$600(java.io.ObjectInputStream)
static java.io.ObjectInputStream$HandleTable    access$500(java.io.ObjectInputStream)
static java.lang.Object    access$700(java.io.ObjectInputStream,boolean)
static sun.misc.ObjectInputFilter    access$100(java.io.ObjectInputStream)
static void    access$000(java.io.ObjectInputStream,sun.misc.ObjectInputFilter)
static void    access$1000(java.io.ObjectInputStream)
static void    access$1100(byte[],int,float[],int,int)
static void    access$1200(byte[],int,double[],int,int)

Fields:
private static final int java.io.ObjectInputStream.NULL_HANDLE
private static final java.lang.Object java.io.ObjectInputStream.unsharedMarker
private static final java.util.HashMap java.io.ObjectInputStream.primClasses
private final java.io.ObjectInputStream$BlockDataInputStream java.io.ObjectInputStream.bin
private final java.io.ObjectInputStream$ValidationList java.io.ObjectInputStream.vlist
private long java.io.ObjectInputStream.depth
private long java.io.ObjectInputStream.totalObjectRefs
private boolean java.io.ObjectInputStream.closed
private final java.io.ObjectInputStream$HandleTable java.io.ObjectInputStream.handles
private int java.io.ObjectInputStream.passHandle
private boolean java.io.ObjectInputStream.defaultDataEnd
private byte[] java.io.ObjectInputStream.primVals
private final boolean java.io.ObjectInputStream.enableOverride
private boolean java.io.ObjectInputStream.enableResolve
private java.io.SerialCallbackContext java.io.ObjectInputStream.curContext
private sun.misc.ObjectInputFilter java.io.ObjectInputStream.serialFilter
private volatile sun.misc.ObjectStreamClassValidator java.io.ObjectInputStream.validator

Constructors:
public java.io.ObjectInputStream(java.io.InputStream) throws java.io.IOException
protected java.io.ObjectInputStream() throws java.io.IOException,java.lang.SecurityException
*/