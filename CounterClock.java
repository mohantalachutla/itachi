import java.awt.*;
import java.awt.event.*;
class CounterClock extends Frame implements ActionListener
{
TextField tf;
Button b;
int s1=0,s2=0,m1=0,m2=0,h1=0,h2=0;
String flag="s1";
public void init()
{
tf=new TextField(8);
b=new Button("COUNT");
b.addActionListener(this);
add(tf);
add(b);
tf.setText("00:00:00");
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b)
setTime();
}
public void setTime()
{
switch(flag)
{
case "s1":tf.setText(String.valueOf(h2)+String.valueOf(h1)+":" +String.valueOf(m2)+String.valueOf(m1)+":"+String.valueOf(s2) +getCount());break;
case "s2":tf.setText(String.valueOf(h2)+String.valueOf(h1)+":"+String.valueOf(m2)+String.valueOf(m1)+":"+getCount()+ String.valueOf(s1));break;
case "m1":tf.setText(String.valueOf(h2)+String.valueOf(h1)+":"+ String.valueOf(m2)+getCount()+":"+String.valueOf(s2)+ String.valueOf(s1));break;
case "m2":tf.setText(String.valueOf(h2)+String.valueOf(h1)+":"+ getCount()+String.valueOf(m1)+":"+ String.valueOf(s2)+String.valueOf(s1));break;
case "h1":tf.setText(String.valueOf(h2)+getCount()+":"+ String.valueOf(m2)+String.valueOf(m1)+":"+String.valueOf(s2) +String.valueOf(s1));break;
case "h2":tf.setText(getCount()+String.valueOf(h1)+":"+ String.valueOf(m2)+String.valueOf(m1)+":"+String.valueOf(s2)+String.valueOf(s1));break;
}
}
public String getCount()
{
if(s1<16)
{
if(s1<9)
{
s1++;
flag="s1";
return String.valueOf(s1);
}
else
{flag="s1";
return getSwitch(s1);
}
}
else if(s2<16)
{
s1=0;
if(s2<9)
{
s2++;
flag="s2";
return String.valueOf(s2);
}
else
{flag="s2";
return getSwitch(s2);
}
}
else if(m1<16)
{
s2=0;
if(m1<9)
{
m1++;
flag="m1";
return String.valueOf(m1);
}
else
{flag="m1";
return getSwitch(m1);
}
}
else if(m2<16)
{
m1=0;
if(m2<9)
{
m2++;
flag="m2";
return String.valueOf(m2);
}
else
{flag="m2";
return getSwitch(m2);
}
}
else if(h1<16)
{
m2=0;
if(h1<9)
{
h1++;
flag="h1";
return String.valueOf(h1);
}
else
{flag="h1";
return getSwitch(h1);
}
}
else if(h2<16)
{
h1=0;
if(h2<9)
{
h2++;
flag="h2";
return String.valueOf(h2);
}
else
{flag="h2";
return getSwitch(h2);
}
}
else
System.exit(1);
}
public String getSwitch(int ch)
{
if(ch==10)return "A";
else if(ch==11)return "B";
else if(ch==12)return "C";
else if(ch==13)return "D";
else if(ch==14)return "E";
else return "F";
}
}