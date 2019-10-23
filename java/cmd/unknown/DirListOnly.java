import java.io.*;
class OnlyExt implements FilenameFilter
{
String ext;
public OnlyExt(String ext)
{
this.ext="."+ext;
}
public boolean accept(File dir,String name)
{
return name.endsWith(ext);
}
}
public class DirListOnly 
{
public static void main(String args[])
{
String dirname=args[0];
File f=new File(dirname);
FilenameFilter only=new OnlyExt("txt");
String s[]=f.list(only);
for(int i=0;i<s.length;i++)
{
System.out.println(s[i]);
}
}
}