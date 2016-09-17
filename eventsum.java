import java.awt.*;
import java.awt.event.*;
public class eventsum extends Frame implements ActionListener
{
	TextField t1,t2,t3;
	Button b;
	public eventsum()
	{
		setLayout(new FlowLayout());
		t1=new TextField();
		add(t1);
		t2=new TextField();
		add(t2);
		t3=new TextField();
		add(t3);
		b=new Button("ADD");
		b.addActionListener(this);
		add(b);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
		int a=Integer.parseInt(t1.getText());
		int b=Integer.parseInt(t2.getText());
		t3.setText(String.valueOf(a+b));	
		}
	}
	public static void main(String args[])
	{
		Frame f=new eventsum();
		f.setSize(300,300);
		f.setVisible(true);
	}
}