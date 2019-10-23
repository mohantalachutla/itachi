import java.awt.*;
import java.applet.*;
/*<applet code="States.class" width=500 height=500>
</applet>*/
public class States extends Applet
{
String msg1,msg2,msg3,msg4;
public void init()
{
msg1="in init...";
//repaint();
}
public void start()
{
msg2="in start...";
//repaint();
}
public void stop()
{
msg3="idle state";
//repaint();
}
public void destroy()
{
msg4="terminated state";
//repaint();
}
public void paint(Graphics g)
{
g.drawString(msg1,100,100);
g.drawString(msg2,100,100);
g.drawString(msg3,100,100);
g.drawString(msg4,100,100);
}
}