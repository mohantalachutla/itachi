import java.awt.*;
import java.awt.event.*;
public class event6 extends Frame implements MouseListener,MouseMotionListener
{
	String msg;
	int mx,my;
	public event6()
	{
		Font ff=new Font("Arial",Font.BOLD,36);
		setFont(ff);
		addMouseListener(this);
	}
	public void mousePressed(MouseEvent me)
	{
		mx=me.getX();
		my=me.getY();
		msg="Mouse Pressed at ("+mx+","+my+")";
		repaint();
	}
	public void mouseReleased(MouseEvent me)
	{
		mx=me.getX();
		my=me.getY();
		msg="Mouse Released at ("+mx+","+my+")";
		repaint();
	}
	public void mouseEntered(MouseEvent me)
	{
		mx=200;
		my=200;
		msg="Mouse Entered at ("+mx+","+my+")";
		repaint();
	}
	public void mouseExited(MouseEvent me)
	{
		mx=200;
		my=200;
		msg="Mouse Exited at ("+mx+","+my+")";
		repaint();
	}
	public void mouseDragged(MouseEvent me)
	{
		mx=200;
		my=200;
		msg="Mouse Draged at ("+mx+","+my+")";
		repaint();
	}
	public void mouseMoved(MouseEvent me)
	{
		mx=200;
		my=200;
		msg="Mouse Moved at ("+mx+","+my+")";
		repaint();
	}
	public void mouseClicked(MouseEvent me)
	{
	}
	public void paint(Graphics g)
	{
		g.drawString(msg,mx,my);
	}
	public static void main(String ag[])
	{
		Frame f=new event6();
		f.setSize(500,500);
		f.setVisible(true);
	}
}