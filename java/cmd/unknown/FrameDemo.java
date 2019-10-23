import java.awt.*;
public class FrameDemo extends Frame
{
public FrameDemo()
{
setSize(500,500);
setVisible(true);
addWindowListener(new java.awt.event.WindowAdapter(){
public void windowClosing(java.awt.event.WindowEvent we)
{
System.exit(0);
}
});
}
public void paint(Graphics g)
{
g.drawString("hello world",150,100);
}
public static void main(String args[])
{
Frame fr=new FrameDemo();
//fr.setSize(500,500);
//fr.setVisible(true);
}
} 