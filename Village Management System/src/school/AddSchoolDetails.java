package school;

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

public class AddSchoolDetails extends JFrame implements ActionListener{

	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	 JButton b1,b2;
	 JLabel l10;
	 
	 public AddSchoolDetails(){
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(550,570, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,550,570);
			add(l10);
		 
	   	 setBounds(450,150,550,570);
	  	 // getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	  	  
	  	 JLabel l8 =new JLabel("ADD SCHOOL DETAILS ");
		  l8.setBounds(150,5,340,25);
		  l8.setFont(new Font("Taboma",Font.BOLD,20));
		  l10.add(l8);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,500,470);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
		    
		  JLabel l1 =new JLabel("School ID");
		  l1.setBounds(30,50,200,25);
		  l1.setFont(new Font("Taboma",Font.BOLD,18));
		  p.add(l1);
		 
		  t1 = new JTextField();
		  t1.setBounds(210,50,150,30);
		  t1.setBorder(BorderFactory.createEmptyBorder());
	      p.add(t1);
	    
		   JLabel l2 =new JLabel(" School Name");
		   l2.setBounds(30,100,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,18));
	       p.add(l2);
		 	
	       
	      t2 = new JTextField();
		   t2.setBounds(210,100,150,30);
		   t2.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t2);
	       
	       JLabel l3 =new JLabel("Principal Name ");
		   l3.setBounds(30,150,200,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,17));
	       p.add(l3);
	  	 	 
	       t3= new JTextField();
		   t3.setBounds(210,150,150,30);
		   t3.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t3);
	       
	       JLabel l9 =new JLabel("Principal Aadhar No");
		   l9.setBounds(30,200,200,25);
		   l9.setFont(new Font("Taboma",Font.BOLD,17));
	       p.add(l9);
	  	 	 
	       t8= new JTextField();
		   t8.setBounds(210,200,150,30);
		   t8.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t8);
	   
	       JLabel l4 =new JLabel("Number Of Staff");
		   l4.setBounds(30,250,200,25);
		   l4.setFont(new Font("Taboma",Font.BOLD,18));
	       p.add(l4);
		 	 
	       t4 = new JTextField();
		   t4.setBounds(210,250,150,30);
		   t4.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t4);
	     
	       JLabel l5 =new JLabel("Email ID");
		   l5.setBounds(30,300,200,25);
		   l5.setFont(new Font("Taboma",Font.BOLD,18));
	       p.add(l5);
		 	 
	       t5 = new JTextField();
		   t5.setBounds(210,300,150,30);
		   t5.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t5);
		    
		   JLabel l6 =new JLabel("Contact Number");
		   l6.setBounds(30,350,200,25);
		   l6.setFont(new Font("Taboma",Font.BOLD,18));
		   l6.setForeground(new Color (204,204,204));
		   p.add(l6);
		 
		   t6 = new JTextField();
		   t6.setBounds(210,350,150,30);
		   t6.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t6);
	   
		   JLabel l7 =new JLabel(" Address");
		   l7.setBounds(30,400,200,25);
		   l7.setFont(new Font("Taboma",Font.BOLD,18));
		   l7.setForeground(new Color (204,204,204));
	       p.add(l7);
		 	 
	       t7 = new JTextField();
		   t7.setBounds(210,400,150,30);
		   t7.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t7);
	   
	       
	       b1= new JButton("ADD");
	       b1.setBackground(new Color (102,102,102));
	       b1.setForeground(Color.WHITE);
	       b1.setBounds(120,467,80,25);
	       b1.addActionListener(this);
	       add(b1);
	       
	      b2= new JButton("BACK");
	      b2.setBackground(new Color (102,102,102));
	      b2.setForeground(Color.WHITE);
	      b2.setBounds(270,467,80,25);
	      b2.addActionListener(this);
	      add(b2);
	      
	       
	      
	 }
	 
	 @Override
		public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b1) {
	          String SCHOOL_ID = t1.getText();
		 	  String SNAME  = t2.getText();
		 	  String PRINCIPAL_NAME= t3.getText();
		 	 String PRINCIPAL_AADHAR_NO= t8.getText();
		 	String NO_OF_STAFF  = t4.getText();
		 	String EMAIL_ID  = t5.getText();
		 	String CONTACT_NO = t6.getText();
		 	String ADDRESS  = t7.getText();
		 	
		      
		 
		 /*	CREATE TABLE SCHOOL
		 	(
		 	SCHOOL_ID INT PRIMARY KEY,
		 	SNAME VARCHAR(20),
		 	PRINCIPAL_NAME VARCHAR(30),
		 	PRINCIPAL_AADHAR_NO CHAR(12),
		 	NO_OF_STAFF INT,
		 	EMAIL_ID VARCHAR(30),
		 	CONTACT_NO BIGINT,
		 	ADDRESS VARCHAR(50),
		 	CONSTRAINT FK7 FOREIGN KEY(PRINCIPAL_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
		 	);*/
		 		
		 		
		 		String query ="insert into School Values('"+SCHOOL_ID+"','"+SNAME+"','"+PRINCIPAL_NAME+"','"+PRINCIPAL_AADHAR_NO+"','"+NO_OF_STAFF+"','"+EMAIL_ID+"','"+CONTACT_NO+"','"+ADDRESS+"')";
		 	    
		 		try {
		 			Conn c = new Conn();
		 			c.s.executeUpdate(query);
		 			
		 			JOptionPane.showMessageDialog(null, "School Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
		 			this.setVisible(false);
		 			
		 		}catch(Exception e1) {
		 			e1.printStackTrace();
		 			JOptionPane.showMessageDialog(null, "Enter correct details");
		 		}
	    	   
	       }else if(e.getSource()==b2) {
	    	   this.setVisible(false);
	    	   new SchoolDetails().setVisible(true);
	       }
		}
	 
	public static void main(String[] args) {
		new AddSchoolDetails().setVisible(true);


	}

	

}
