import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class event7 extends Frame implements ActionListener
{
	String msg;
	FileDialog fd;
	BufferedImage img;
	TextField t1;
	Button b1,b2;
	public event7()
	{
		setLayout(new FlowLayout());
		Font ff=new Font("Arial",Font.BOLD,12);
		setFont(ff);
		t1=new TextField(25);
		add(t1);
		b1=new Button("BROWSE");
		b1.addActionListener(this);
		add(b1);
		b2=new Button("UPLOAD");
		b2.addActionListener(this);
		add(b2);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			fd=new FileDialog(this,"OPEN");
			fd.setVisible(true);
			String path=fd.getDirectory()+fd.getFile();
			t1.setText(path);
		}
		if(ae.getSource()==b2)
		{
			try{
			img=ImageIO.read(new File(t1.getText()));
			repaint();
			}catch(IOException ioe){}
		}
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,200,200,this);
	}
	public static void main(String ag[])
	{
		Frame f=new event7();
		f.setSize(500,500);
		f.setVisible(true);
	}
}