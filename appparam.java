import java.awt.*;
import java.applet.*;
/*<applet code="appparam.class" width=500 height=500>
<param name="font1" value="Garamond"></param>
<param name="siz" value="36"></param>
<param name="img" value="riya.jpg"></param>
</applet>*/
public class appparam extends Applet
{
	Image img;
	public void init()
	{
		setBackground(Color.CYAN);
		setForeground(Color.BLUE);
		String ff=getParameter("font1");
		String sz=getParameter("siz");
		int len=Integer.parseInt(sz);
		Font f1=new Font(ff,Font.BOLD,len);
		setFont(f1);
		img=getImage(getDocumentBase(),getParameter("img"));
	}
	public void paint(Graphics g)
	{
		g.drawString("Hello World",200,200);
		g.drawImage(img,200,250,this);		
	}
}
