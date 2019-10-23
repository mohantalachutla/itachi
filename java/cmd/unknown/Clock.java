import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="Clock" width=1000 height=1000></applet>*/
class Clock extends Applet
{
public void paint(Graphics g)
	{
		g.drawOval(670,330,220,220);
	}

	/*public String msg;
	public int mx,my;
	public Clock()
	{
		addMouseListener(this);
	}
	public void mousePressed(MouseEvent me)
	{
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
	}
	public void mouseExited(MouseEvent me)
	{
	}
	public void mouseDragged(MouseEvent me)
	{
	}
	public void mouseMoved(MouseEvent me)
	{
	}
	public void mouseClicked(MouseEvent me)
	{
	}*/
}