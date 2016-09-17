import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
public class swingex extends JFrame implements ActionListener
{
	JTextField jp;
	JTable jtab;
	JList jl;
	JComboBox jco;
	JPanel jp1,jp2,jp3;
	JTabbedPane jtp;
	JButton jb;
	JTree jt;
	DefaultMutableTreeNode R,s1,c11;
	JScrollPane jsp;
	JFileChooser jfc;
	public swingex()
	{
		String cols[]={"RollNo","Name","Branch"};
		String data[][]={
					{"1234","abc","IT"},
					{"1248","xyz","ECE"}};
		jp1=new JPanel();
		jp=new JTextField(20);
		jb=new JButton("Browse");
		jb.addActionListener(this);
		jp1.add(jb);
		jt=new JTree();
		R=new DefaultMutableTreeNode("GF");
		//jt.add(R);
		s1=new DefaultMutableTreeNode("SF1");
		R.add(s1);
		c11=new DefaultMutableTreeNode("CSF1");
		s1.add(c11);
		jp1.add(jp);
		jp1.add(jt);
		jp2=new JPanel();
		
		String cities[]={"HYD","BLR","CCU","VTZ"};
		jl=new JList(cities);
		jp2.add(jl);
		jtab=new JTable(data,cols);
		jp2.add(jtab);
		jp3=new JPanel();
		jco=new JComboBox();
		jco.addItem("HYD");
		jco.addItem("BLR");
		jco.addItem("CCU");
		jco.addItem("VTZ");
		jp3.add(jco);
		
		jtp=new JTabbedPane();
		jsp=new JScrollPane(jp1);
		jtp.addTab("Page 1",jsp);
		jtp.addTab("Page 2",jp2);
		jtp.addTab("Page 3",jp3);
		add(jtp);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==jb)
		{
			jfc=new JFileChooser();
			int ret=jfc.showOpenDialog(this);
			if(ret==JFileChooser.APPROVE_OPTION)
			{
			java.io.File file1=jfc.getSelectedFile();
			java.io.File direc=jfc.getCurrentDirectory();
			jp.setText(direc+file1.getName());
			}
		}	
	}
	public static void main(String args[])
	{
		JFrame jf=new swingex();
		jf.setSize(300,300);
		jf.setVisible(true);
	}
}