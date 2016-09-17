import java.awt.Graphics;
import java.applet.Applet;
/*
<applet code="AppletDemo.class" width=200 height=60>
</applet>
*/
public class AppletDemo extends Applet
{
public void paint(Graphics g)
{
g.drawString("hello world...",200,100);
}
}