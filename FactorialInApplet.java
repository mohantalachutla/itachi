import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="FactorialInApplet.java" width=500 height=500>
</applet>*/
public class FactorialInApplet extends Applet implements ActionListener
{
TextField tf1,tf2;
Button b;
public void init()
{
setLayout(new FlowLayout());
Label l1=new Label("number");
Label l2=new Label("factorial");
tf1=new TextField(6);
tf2=new TextField(6);
b=new Button("compute");
b.addActionListener(this);
add(l1);
add(tf1);
add(l2);
add(tf2);
add(b);
}
public void actionPerformed(java.awt.event.ActionEvent ae)
{
if(ae.getSource()==b)
{
int num=Integer.parseInt(tf1.getText());
tf2.setText(String.valueOf(factorial(num)));
}
}
public int factorial(int num)
{
if(num==0||num==1)
return 1;
else
return num*factorial(num-1);
}
}