import java.awt.*;
import java.awt.event.*;
public class event5 extends Frame implements KeyListener
{
	String msg="press key";
	public event5()
	{
		Font ff=new Font("Arial",Font.BOLD,36);
		setFont(ff);
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent ke)
	{
		msg="Key Pressed...";
		repaint();
	}
	public void keyReleased(KeyEvent ke)
	{
		msg="Key Released...";
		repaint();	
	}
	public void keyTyped(KeyEvent ke)
	{
		char c;
		c=ke.getKeyChar();
		msg="You Typed "+c+" ....";
		repaint();
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,150,150);
	}
	public static void main(String ag[])
	{
		Frame f=new event5();
		f.setSize(300,300);
		f.setVisible(true);
	}
}