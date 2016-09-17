import java.io.*;
class TestTry
{
public static void main(String args[]) throws Exception
{
try
{
FileInputStream f = new FileInputStream("TestTry.java");
System.out.println(f.Available());
}catch(Exception e){}
//System.out.println(f.isFile ? "file":"not");
}
}