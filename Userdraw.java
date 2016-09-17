import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.applet.*;
public class UserDraw extends Frame
{
static int choice=0,x,y,h,w,r,l;
static String fill="no";
public void init()
{
setBackground(Color.cyan);
addWindowListener(new java.awt.event.WindowAdapter(){
		public void windowClosing(java.awt.event.WindowEvent we){
			System.exit(0);
		}
		});
}
public void paint(Graphics g)
{
if(fill.equals("no"))
{
if(choice==1)
g.drawRect(x,y,w,h);
else if(choice==2)
g.drawOval(x,y,w,h);
else
g.drawArc(x,y,w,h,r,l);
}
else
{
if(choice==1)
g.fillRect(x,y,w,h);
else if(choice==2)
g.fillOval(x,y,w,h);
else
g.fillArc(x,y,w,h,r,l);
}
}
public static void main(String args[])
{
Scanner scan=new Scanner(System.in);
System.out.println("fill :(yes/no)");
fill=scan.nextLine();
System.out.println("1.rectangle or square\n2.circle or ellips\n3.arc...\nenter choice");
choice=scan.nextInt();
System.out.println("enter details:");
switch(choice)
{
case 1:System.out.println("x-co y-co height width:");
x=scan.nextInt();
y=scan.nextInt();
h=scan.nextInt();
w=scan.nextInt();
break;
case 2:System.out.println("x-co y-co major minor:");
x=scan.nextInt();
y=scan.nextInt();
h=scan.nextInt();
w=scan.nextInt();
break;
case 3:System.out.println("x-co y-co height width r_angle l_angle:");
x=scan.nextInt();
y=scan.nextInt();
h=scan.nextInt();
w=scan.nextInt();
r=scan.nextInt();
l=scan.nextInt();
break;
default:
System.exit(0);
}
Frame f=new UserDraw();
f.setVisible(true);
f.setSize(500,500);
}
}