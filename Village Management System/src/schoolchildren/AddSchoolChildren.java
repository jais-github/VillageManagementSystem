package schoolchildren;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conn.Conn;

public class AddSchoolChildren  extends JFrame implements ActionListener{

	 JTextField t1,t2,t3,t4,t5,t6,t9,t11;
	   JButton b1,b2;
	   Choice c1;
	   JLabel l10;
		public AddSchoolChildren(){
			
			 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
				Image i2 = i1.getImage().getScaledInstance(550, 520, Image.SCALE_DEFAULT);
				 ImageIcon i3 = new ImageIcon(i2);
				 l10 = new JLabel(i3);
				l10.setBounds(0,0,550,520);
				add(l10);
			
	   	 setBounds(450,150,550,520);
	  	  //getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	  	  
	  	  JLabel l6 =new JLabel("ADD SCHOOL CHIILDREN DETAILS ");
		  l6.setBounds(110,5,450,25);
		  l6.setFont(new Font("Taboma",Font.BOLD,20));
		  l10.add(l6);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,500,440);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
		    
		  JLabel l1 =new JLabel("Student ID");
		  l1.setBounds(30,50,200,25);
		  l1.setFont(new Font("Taboma",Font.BOLD,18));
		  p.add(l1);
		 
		  t1 = new JTextField();
		  t1.setBounds(250,50,150,30);
		  t1.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t1);
	     
	     
	     
	     JLabel l7 =new JLabel("Student Name");
		   l7.setBounds(30,100,200,25);
		   l7.setFont(new Font("Taboma",Font.BOLD,18));
	      p.add(l7);
		 	 
	      t6 = new JTextField();
		   t6.setBounds(250,100,150,30);
		   t6.setBorder(BorderFactory.createEmptyBorder());
	      p.add(t6);
	      
	     JLabel l2 =new JLabel("Student Aadhar Number");
		   l2.setBounds(30,150,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,18));
	      p.add(l2);
		 	 
	      t2 = new JTextField();
		   t2.setBounds(250,150,150,30);
		   t2.setBorder(BorderFactory.createEmptyBorder());
	      p.add(t2);
	     
	      JLabel l3 =new JLabel("Guardian Aadhar Number ");
		   l3.setBounds(30,200,200,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,17));
	      p.add(l3);
		 	 
	      t3= new JTextField();
		   t3.setBounds(250,200,150,30);
		   t3.setBorder(BorderFactory.createEmptyBorder());
	      p.add(t3);
	    
	      JLabel l4 =new JLabel("School ID");
		   l4.setBounds(30,250,200,25);
		   l4.setFont(new Font("Taboma",Font.BOLD,18));
	      p.add(l4);
		 	 
	     /* t9 = new JTextField();
		   t9.setBounds(250,250,150,30);
		   t9.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t9);*/
	     
	      
	     c1 =new Choice();
	      c1.add("select");
	      c1.add("123");
	      c1.setBounds(250,250,150,30);
	      p.add(c1);
	     
	      
	      JLabel l5 =new JLabel("Class");
		   l5.setBounds(30,300,200,25);
		   l5.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l5);
		 	 
	     t5 = new JTextField();
		   t5.setBounds(250,300,150,30);
		   t5.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t5);
	     
	     JLabel l11 =new JLabel("Section");
		   l11.setBounds(30,350,200,25);
		   l11.setFont(new Font("Taboma",Font.BOLD,18));
		   l11.setForeground(new Color (204,204,204));
	     p.add(l11);
		 	 
	     t11 = new JTextField();
		   t11.setBounds(250,350,150,30);
		   t11.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t11);
	     
	     
	     b1= new JButton("ADD");
	     b1.setBackground(new Color (102,102,102));
	      b1.setForeground(Color.WHITE);
	      b1.setBounds(150,425,80,25);
	      b1.addActionListener(this);
	      add(b1);
	      
	     b2= new JButton("BACK");
	     b2.setBackground(new Color (102,102,102));
	     b2.setForeground(Color.WHITE);
	     b2.setBounds(250,425,80,25);
	     b2.addActionListener(this);
	     add(b2);
	      
	      
	      
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
		          String STUDENT_ID = t1.getText();
		          String SNAME = t6.getText();
			 	  String SAADHAR_NO  = t2.getText();
			 	 String GAADHAR_NO  = t3.getText();
			 	String SCHOOL_ID  = c1.getSelectedItem();
			 	String CLASS  = t5.getText();
			 	String SECTION  = t11.getText();
			 	
			      
			 	/*CREATE TABLE SCHOOL_CHILDREN
			     (
			     STUDENT_ID INT PRIMARY KEY,
			     SNAME VARCHAR(20),
			     SAADHAR_NO CHAR(12),
			     GAADHAR_NO CHAR(12),
			     SCHOOL_ID INT,
			     CLASS INT,
			     SECTION CHAR(1),
			     CONSTRAINT FK8 FOREIGN KEY(SAADHAR_NO) REFERENCES PERSON(AADHAR_NO),
			     CONSTRAINT FK9 FOREIGN KEY(GAADHAR_NO) REFERENCES PERSON(AADHAR_NO),
			     CONSTRAINT FK10 FOREIGN KEY(SCHOOL_ID) REFERENCES SCHOOL(SCHOOL_ID)
			     );*/
			 	     
			 		
			 		
			 		String query ="insert into SCHOOL_CHILDREN Values('"+STUDENT_ID+"','"+SNAME+"','"+SAADHAR_NO+"','"+GAADHAR_NO+"','"+SCHOOL_ID+"','"+CLASS+"','"+SECTION+"')";
			 	    
			 		try {
			 			Conn c = new Conn();
			 			c.s.executeUpdate(query);
			 			
			 			JOptionPane.showMessageDialog(null, "SchoolChildren Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
			 			this.setVisible(false);
			 			
			 		}catch(Exception e1) {
			 			e1.printStackTrace();
			 			JOptionPane.showMessageDialog(null, "Enter correct details");
			 		}
		    	   
		       }else if(e.getSource()==b2) {
		    	   this.setVisible(false);
		    	   new SchoolChildren().setVisible(true);
		       }
			
		}

	public static void main(String[] args) {
		new AddSchoolChildren().setVisible(true);

	}

	
}
