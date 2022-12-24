package hospital;

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

public class AddHospital extends JFrame implements ActionListener{
   JTextField t1,t2,t3,t4,t5,t6,t7; 
   JButton b1,b2;
   JLabel l10;
   
   public AddHospital() {
	   
	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(600, 540, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,600,540);
		add(l10);
	   
	   setBounds(450,120,600,540);
	  	  //getContentPane().setBackground(Color.WHITE);
	  	  setLayout(null);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,450,440);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
		  
		  JLabel l8 =new JLabel("ADD HOSPITAL DETAILS");
		  l8.setBounds(130,5,290,25);
		  l8.setFont(new Font("Taboma",Font.BOLD,20));
		  l10.add(l8);
		 
		 JLabel l1 = new JLabel("Hospital Name");
		 l1.setBounds(30,50,200,25);
		 l1.setFont(new Font("Taboma",Font.BOLD,18));
		 p.add(l1);
		 
		 t1 = new JTextField();
		   t1.setBounds(250,50,150,30);
		   t1.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t1);
		
	    /* CREATE TABLE HOSPITAL
	     (
	     HOSPITAL_NAME VARCHAR(50),
	     HOSPITAL_ID INT,
	     NO_OF_STAFF INT,
	     TYPE VARCHAR(20),
	     HEAD_AADHAR_NO CHAR(12),
	     HEAD_NAME VARCHAR(20),
	     CONTACT_NO BIGINT,
	     CONSTRAINT FK13 FOREIGN KEY(HEAD_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
	     );*/
		 
		
	    
		   JLabel l2 =new JLabel("Hospital ID");
		   l2.setBounds(30,100,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l2);
		 	 
	     t2 = new JTextField();
		   t2.setBounds(250,100,150,30);
		   t2.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t2);
	    
	     JLabel l3 =new JLabel("Number Of Staff");
		   l3.setBounds(30,150,200,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l3);
		 	 
	     t3= new JTextField();
		   t3.setBounds(250,150,150,30);
		   t3.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t3);
	   
	     JLabel l4 =new JLabel("Type");
		   l4.setBounds(30,200,200,25);
		   l4.setFont(new Font("Taboma",Font.BOLD,18));
	     p.add(l4);
		 	 
	     t4 = new JTextField();
		   t4.setBounds(250,200,150,30);
		   t4.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t4);
	     
	     JLabel l5 =new JLabel("Head Aadhar No");
		   l5.setBounds(30,250,200,25);
		   l5.setFont(new Font("Taboma",Font.BOLD,18));
	    p.add(l5);
		 	 
	    t5 = new JTextField();
		   t5.setBounds(250,250,150,30);
		   t5.setBorder(BorderFactory.createEmptyBorder());
	    p.add(t5);
		    
		  JLabel l6 =new JLabel("Head Name");
		  l6.setBounds(30,300,300,25);
		  l6.setFont(new Font("Taboma",Font.BOLD,18));
		  p.add(l6);
		 
		  t6 = new JTextField();
		  t6.setBounds(350,300,150,30);
		  t6.setBorder(BorderFactory.createEmptyBorder());
	   p.add(t6);
	   
		   JLabel l7 =new JLabel("Contact Number");
		   l7.setBounds(30,350,300,25);
		   l7.setFont(new Font("Taboma",Font.BOLD,18));
		   l7.setForeground(new Color (204,204,204));
	    p.add(l7);
		 	 
	    t7 = new JTextField();
		   t7.setBounds(250,350,150,30);
		   t7.setBorder(BorderFactory.createEmptyBorder());
	    p.add(t7);
	   
	    b1= new JButton("ADD");
	    b1.setBackground(new Color (102,102,102));
	    b1.setForeground(Color.WHITE);
	    b1.setBounds(135,425,80,25);
	    b1.addActionListener(this);
	    add(b1);
	    
	   b2= new JButton("BACK");
	   b2.setBackground(new Color (102,102,102));
	   b2.setForeground(Color.WHITE);
	   b2.setBounds(248,425,80,25);
	   b2.addActionListener(this);
	   add(b2);
   }
   
   @Override
	public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==b1) {
	         String HOSPITAL_NAME = t1.getText();
		 	  String HOSPITAL_ID = t2.getText();
		      String NO_OF_STAFF =t3.getText();
		      String TYPE =t4.getText();
		      String HEAD_AADHAR_NO =t5.getText();
		      String HEAD_NAME =t6.getText();
		      String CONTACT_NO =t7.getText();
		 	     
		      
		 		
		      String query ="insert into hospital Values('"+HOSPITAL_NAME+"','"+HOSPITAL_ID+"','"+NO_OF_STAFF+"','"+TYPE+"','"+HEAD_AADHAR_NO+"','"+HEAD_NAME+"','"+CONTACT_NO+"')";
	  	 	    
	  	 		try {
	  	 			
	  	 			Conn c = new Conn();
	  	 			
	  	 			c.s.executeUpdate(query);
	  	 			//System.out.println("okayyyy");
	  	 			JOptionPane.showMessageDialog(null, "HOSPITAL Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
	  	 			this.setVisible(false);
	  	 			
	  	 		}catch(Exception e1) {
	  	 			e1.printStackTrace();
	  	 			JOptionPane.showMessageDialog(null, "Enter correct details");
	  	 		}
		      
	  	 		
	   }else if(e.getSource()==b2) {
		   this.setVisible(false);
		   new Hospital().setVisible(true);
	   }
	}
	public static void main(String[] args) {
		try {
			new AddHospital().setVisible(true);
		}catch(Exception e) {
          e.printStackTrace();
	}

}
}

	
