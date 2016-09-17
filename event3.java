import java.awt.*;
import java.awt.event.*;
public class event3 extends Frame implements ItemListener
{
	Checkbox c1,c2,c3;
	String msg1,msg2,msg3;
	public event3()
	{
		setLayout(new FlowLayout());
		c1=new Checkbox("IT");
		c1.addItemListener(this);
		add(c1);
		c2=new Checkbox("CSE");
		c2.addItemListener(this);
		add(c2);
		c3=new Checkbox("ECE");
		c3.addItemListener(this);
		add(c3);
		addWindowListener(new 		java.awt.event.WindowAdapter(){
		public void windowClosing(java.awt.event.WindowEvent we){
			System.exit(0);
		}
		});
	}
	public void itemStateChanged(ItemEvent ae)
	{
		msg1="IT :"+c1.getState();
		
		msg2="CSE :"+c2.getState();
		
		msg3="ECE :"+c3.getState();
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg1,100,100);
		g.drawString(msg2,100,120);
		g.drawString(msg3,100,140);
	}
	public static void main(String args[])
	{
		Frame f=new event3();
		f.setSize(300,300);
		f.setVisible(true);
	}
}