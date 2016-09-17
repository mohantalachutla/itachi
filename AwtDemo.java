import java.awt.*;
import java.applet.Applet;
/*
<applet code="AwtDemo.class" width=200 height=60>
</applet>
*/
public class AwtDemo extends Applet
{
public void init()
{
Label l=new Label("first name:");
TextField tf=new TextField("enter first name");
Button b=new Button("submit");
Checkbox cb=new Checkbox("accept terms & conditions");
Choice ch=new Choice();
ch.add("a.p");
ch.add("telangana");
CheckboxGroup cbg=new CheckboxGroup();
Checkbox cg1=new Checkbox("male",cbg,false);
Checkbox cg2=new Checkbox("female",cbg,false);
Checkbox cg3=new Checkbox("i dont know",cbg,false);
//Panel p=new Panel();
//p.setSize(200,200);
//p.setVisible(true);
setLayout(new FlowLayout());
add(l);
add(tf);
add(ch);
add(cg1);
add(cg2);
add(cg3);
add(cb);
add(b);
}
}