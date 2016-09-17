import java.io.*;
class FileCharCount
{
static int ch=0,cc=0,wc=0,lc=0;
public static void main(String args[])
{
File f=null;
FileReader ob=null;
try
{
f=new File(args[0]);
ob=new FileReader(f);
if(!f.canRead())
System.out.println("not readable");
else
{
while(((ch=ob.read())!=-1))
{
if(ch==9|ch==10|ch==32)
{
wc++;
if(ch=='\n')
lc++;
}
else
cc++;
}
}
}catch(Exception e){}
finally
{
try
{
ob.close();
}catch(Exception e2){}
}
System.out.println("no.of characters:"+cc);
if(cc!=0)
System.out.println("no.of words:"+(wc+1));
else
System.out.println("no.of words:"+wc);
if(cc!=0)
System.out.println("no.of lines: "+(lc+1));
else
System.out.println("no.of words:"+lc);
}
}