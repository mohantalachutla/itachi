import java.awt.*;
public class event1 extends Frame
{
	public event1()
	{
		addWindowListener(new 		java.awt.event.WindowAdapter(){
		public void windowClosing(java.awt.event.WindowEvent we){
			System.exit(0);
		}
		});
	}
	public static void main(String args[])
	{
		Frame f=new event1();
		f.setSize(300,300);
		f.setVisible(true);
	}
}