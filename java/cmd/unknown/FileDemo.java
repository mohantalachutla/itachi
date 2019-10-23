import java.io.*;
import java.util.*;
public class FileDemo
{
static void print(String msg)
{
System.out.println(msg);
}
public static void main(String args[])
{
int ch=0;
File f=null;
FileInputStream fis=null;
Scanner scan=new Scanner(System.in);
print("enter file name:");
String str=scan.nextLine();
try
{
f=new File("D:/programming/java",str);
print(f.exists()?"f exists":"not exists");
print(f.canRead()?"f is readable":"not readable");
print(f.canWrite()?"writable":"not writable");
print("file name:"+f.getName());
print("file extension is:"+getFileExtension(f));
print("size:"+f.length()+"bytes");
fis=new FileInputStream(f);
while((ch=fis.read())!=-1)
{
System.out.print((char)ch);
}
}catch(Exception e){}
finally
{`
try
{
fis.close();
}catch(Exception e1){System.out.println(e1);}
}
}
static String getFileExtension(File f)
{
int n=0;
String fileName=f.getName();
n=fileName.lastIndexOf(".");
if(fileName.lastIndexOf(".")!=-1 && fileName.lastIndexOf(".")!=0)
return fileName.substring(fileName.lastIndexOf(".")+1);
else return " ";
}
}