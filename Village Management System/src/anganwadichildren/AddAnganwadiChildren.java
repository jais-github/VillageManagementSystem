package anganwadichildren;

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

public class AddAnganwadiChildren extends  JFrame implements ActionListener{

	 JTextField t1,t2,t3,t4;
	 JButton b1,b2;
	 JLabel l10;
	 public AddAnganwadiChildren(){
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(600, 390, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,600,390);
			add(l10);
		 
	   	 setBounds(450,200,600,390);
	  	  //getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	  	  
	  	 JLabel l5 =new JLabel(" ADD ANGANWADI CHILDREN ");
		  l5.setBounds(130,5,400,25);
		  l5.setFont(new Font("Taboma",Font.BOLD,20));
		  l10.add(l5);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,430,300);
		  p.setBackground(new Color (0,0,0,0));
		 l10. add(p);
		  
		  JLabel l1 =new JLabel("Birth Certificate Number");
		  l1.setBounds(30,50,400,25);
		  l1.setFont(new Font("Taboma",Font.BOLD,18));
		  p.add(l1);
		 
		  t1 = new JTextField();
		  t1.setBounds(300,50,150,30);
		  t1.setBorder(BorderFactory.createEmptyBorder());
	    p.add(t1);
	    
	    
	   
		   JLabel l2 =new JLabel("Name");
		   l2.setBounds(30,100,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l2);
		 	 
	     t2 = new JTextField();
		   t2.setBounds(300,100,150,30);
		   t2.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t2);
	    
	     JLabel l3 =new JLabel("Guardian Aadhar Number ");
		   l3.setBounds(30,150,400,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,17));
	     p.add(l3);
		 	 
	     t3= new JTextField();
		   t3.setBounds(300,150,150,30);
		   t3.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t3);
	   
	     JLabel l4 =new JLabel("Centre Number");
		   l4.setBounds(30,200,200,25);
		   l4.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l4);
		 	 
	     t4 = new JTextField();
		   t4.setBounds(300,200,150,30);
		   t4.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t4);
	     
	    
	     b1= new JButton("ADD");
	     b1.setBackground(new Color (102,102,102));
	     b1.setForeground(Color.WHITE);
	     b1.setBounds(258,275,80,25);
	     b1.addActionListener(this);
	     add(b1);
	     
	    b2= new JButton("BACK");
	    b2.setBackground(new Color (102,102,102));
	    b2.setForeground(Color.WHITE);
	    b2.setBounds(135,275,80,25);
	    b2.addActionListener(this);
	    add(b2);
	 }
	 
	 @Override
		public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b1) {
	         String BIRTH_CERTIFICATE_NO  = t1.getText();
	         String CNAME =t2.getText();
		 	 String GAADHAR_NO =t3.getText() ;  
		 	 String CENTRE_NO =t4.getText();
		 		
		 	/* CREATE TABLE ANGANVADI_CHILDREN
			    (
			    BIRTH_CERTIFICATE_NO VARCHAR(30) PRIMARY KEY,
			    CNAME VARCHAR(30),
			    GAADHAR_NO CHAR(12),
			    CENTRE_NO INT,
			    CONSTRAINT FK12 FOREIGN KEY(GAADHAR_NO) REFERENCES PERSON(AADHAR_NO),
			    CONSTRAINT FK14 FOREIGN KEY(CENTRE_NO) REFERENCES ANGANVADI_HEAD(CENTRE_NO)
			    );*/
		 	 
		 		String query ="insert into ANGANVADI_CHILDREN Values('"+BIRTH_CERTIFICATE_NO+"','"+CNAME+"','"+GAADHAR_NO+"','"+CENTRE_NO+"')";
		 	    
		 		try {
		 			Conn c = new Conn();
		 			c.s.executeUpdate(query);
		 			
		 			JOptionPane.showMessageDialog(null, " ANGANVADI CHILDREN Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
		 			this.setVisible(false);
		 			
		 		}catch(Exception e1) {
		 			e1.printStackTrace();
		 			JOptionPane.showMessageDialog(null, "Enter correct details");
		 		}
		 }else if(e.getSource()==b2) {
			 this.setVisible(false);
			 new AnganwadiChildren().setVisible(true);
		 }
		}
	public static void main(String[] args) {
   
		try {
			new AddAnganwadiChildren().setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	

}
