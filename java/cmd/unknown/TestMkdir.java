import java.io.File;
class TestMkdir
{
public static void main(String args[])
{
File f1=new File(args[0]);
File f2=new File(args[1]);
if(f1.mkdir())
System.out.println("mkdir");
if(f2.mkdirs())
System.out.println("mkdirs");
}
}