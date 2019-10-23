import java.awt.*;
import java.awt.event.*;
public class event2 extends Frame implements ActionListener
{
	TextField t1;
	Button b;
	public event2()
	{
		setLayout(new FlowLayout());
		t1=new TextField(20);
		add(t1);
		b=new Button("SUBMIT");
		b.addActionListener(this);
		add(b);
		addWindowListener(new 		java.awt.event.WindowAdapter(){
		public void windowClosing(java.awt.event.WindowEvent we){
			System.exit(0);
		}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			t1.setText("Button Clicked");
		}		
	}
	public static void main(String args[])
	{
		Frame f=new event2();
		f.setSize(300,300);
		f.setVisible(true);
	}
}