package about;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame{
	String s1;
	JLabel l3;
	public About() {
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(850, 490, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l3 = new JLabel(i3);
		l3.setBounds(0,0,850,490);
		add(l3);
		
	setBounds(450,200,850,490);
	  getContentPane().setBackground(Color.WHITE);
	  setLayout(null);
	  
	  JLabel l1 = new JLabel("ABOUT");
	 
	  l1.setBounds(350, 10,400, 80);
	  l1.setForeground(Color.black);
	  l1.setFont(new Font ("Tahoma",Font.BOLD,30));
	 l3. add(l1);
	 
	  s1="Gram-E  is  a  Desktop  application.  which  is  to  be  used  by  the  Head  of  the Village(Mukhiya).  This  application  will  give  you  the  information  about  the people  and    the  activities  that  are  performed  in  day  to  day  life.Once  he/she  sign  in  into    this  they  will  see  a  dashboard  with  various modules  displayed  there  .He/she  can  view  then  view  any  module and can see the details. \r\n"
	  		+ "";
	  TextArea t1 = new TextArea(s1,10,40,Scrollbar.VERTICAL);
	  t1.setEditable(false);
	  
	  t1.setBounds(220,100,450,300);
	 l3. add(t1); 
	  
	  
	}
	public static void main(String[] args) {
		new About().setVisible(true);
		

	}

}
