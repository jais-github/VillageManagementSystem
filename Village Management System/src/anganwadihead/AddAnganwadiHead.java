package anganwadihead;

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

public class AddAnganwadiHead extends JFrame implements ActionListener{

	 JTextField t1,t2,t3,t4;
	 JButton b1,b2;
	 JLabel l10;
	 public AddAnganwadiHead(){
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(600, 420, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,600,420);
			add(l10);
		 
	   	 setBounds(450,200,600,420);
	  	//  getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	  	  
	  	JLabel l4 =new JLabel("ADD ANGANWADI HEAD DETAILS");
		  l4.setBounds(90,5,320,25);
		  l4.setFont(new Font("Taboma",Font.BOLD,20));
		 l10. add(l4);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,430,320);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
	 
		  
		 
		    
		  JLabel l1 =new JLabel("Centre Number");
		  l1.setBounds(30,50,200,25);
		  l1.setFont(new Font("Taboma",Font.BOLD,18));
		  p.add(l1);
		 
		  t1 = new JTextField();
		   t1.setBounds(250,50,150,30);
		   t1.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t1);
		
		  
	       
	    
		   JLabel l2 =new JLabel(" Helder Name");
		   l2.setBounds(30,100,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l2);
		 	 
	     t2 = new JTextField();
		   t2.setBounds(250,100,150,30);
		   t2.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t2);
	    
	     JLabel l5 =new JLabel("Helper Aadhar No");
		   l5.setBounds(30,150,200,25);
		   l5.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l5);
		 	 
	     t4= new JTextField();
		   t4.setBounds(250,150,150,30);
		   t4.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t4);
	     
	     JLabel l3 =new JLabel("Address ");
		   l3.setBounds(30,200,200,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l3);
		 	 
	     t3= new JTextField();
		   t3.setBounds(250,200,150,30);
		   t3.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t3);
	     
	     b1= new JButton("ADD");
	     b1.setBackground(new Color (102,102,102));
	     b1.setForeground(Color.WHITE);
	     b1.setBounds(125,295,80,25);
	     b1.addActionListener(this);
	     add(b1);
	     
	    b2= new JButton("BACK");
	    b2.setBackground(new Color (102,102,102));
	    b2.setForeground(Color.WHITE);
	    b2.setBounds(265,295,80,25);
	    b2.addActionListener(this);
	    add(b2);
	 } 
	 
	 @Override
		public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b1) {
	          String CENTRE_NO = t1.getText();
	          String HELPER_NAME = t2.getText();
		 	  String HELPER_AADHAR_NO  = t4.getText();
		 	 String ADDRESS  = t3.getText();
		 	
		 	
		 	/*CREATE TABLE ANGANVADI_HEAD
		       (
		       CENTRE_NO INT PRIMARY KEY,
		       HELPER_NAME VARCHAR(30),
		       HELPER_AADHAR_NO CHAR(12),
		       ADDRESS VARCHAR(50),
		       CONSTRAINT FK11 FOREIGN KEY(HELPER_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
		       );*/
		      
		 	     
		 		
		 		
		 		String query ="insert into ANGANVADI_HEAD Values('"+CENTRE_NO+"','"+HELPER_NAME+"','"+HELPER_AADHAR_NO+"','"+ADDRESS+"')";
		 	    
		 		try {
		 			Conn c = new Conn();
		 			c.s.executeUpdate(query);
		 			
		 			JOptionPane.showMessageDialog(null, "AnganwadiHead Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
		 			this.setVisible(false);
		 			
		 		}catch(Exception e1) {
		 			e1.printStackTrace();
		 			JOptionPane.showMessageDialog(null, "Enter correct details");
		 		}
	    	   
	       }else if(e.getSource()==b2) {
	     	  this.setVisible(false);
	     	  new AnganwadiHead().setVisible(true);
	       }
			
		}
	public static void main(String[] args) {
		try {
			new AddAnganwadiHead().setVisible(true);
		}catch(Exception e) {}
	}
	

}
