import java.awt.*;
import java.awt.event.*;
public class MenuDemo extends Frame 
{
public MenuDemo()
{
setLayout(new FlowLayout());
addWindowListener(new java.awt.event.WindowAdapter(){public void windowClosing(java.awt.event.WindowEvent we)
{System.exit(0);}});
MenuBar mb=new MenuBar();
Menu menu=new Menu("FILE");
menu.add(new MenuItem("New"));
menu.add(new MenuItem("Open"));
menu.add(new MenuItem("exit"));
}
public static void main(String args[])
{
Frame fr=new Frame();
fr.setSize(500,500);
fr.setVisible(true);
}
}