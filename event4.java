import java.awt.*;
import java.awt.event.*;
public class event4 extends Frame implements ItemListener
{
	Choice c1;
	String msg1,msg2,msg3;
	public event4()
	{
		setLayout(new FlowLayout());
		c1=new Choice();
		c1.addItem("Select Branch");
		c1.addItem("IT");
		c1.addItem("CSE");
		c1.addItem("ECE");
		c1.addItem("civil");
		c1.addItemListener(this);
		add(c1);		
		addWindowListener(new 		java.awt.event.WindowAdapter(){
		public void windowClosing(java.awt.event.WindowEvent we){
			System.exit(0);
		}
		});
	}
	public void itemStateChanged(ItemEvent ae)
	{
		if(c1.getSelectedItem().equals("Select Branch"))
		{
			msg1="No Branch Selected";
			repaint();
		}
		else
		{
			msg1=c1.getSelectedItem()+" 	Selected";
			repaint();
		}
		
	}
	public void paint(Graphics g)
	{
		g.drawString(msg1,100,100);
	}
	public static void main(String args[])
	{
		Frame f=new event4();
		f.setSize(300,300);
		f.setVisible(true);
	}
}