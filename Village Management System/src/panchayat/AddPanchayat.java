package panchayat;

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

public class AddPanchayat extends JFrame implements ActionListener{

	JTextField t1,t2;
	 JButton b1,b2;
	 Choice c1;
	 JLabel l10;
		public AddPanchayat(){
			
			 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
				Image i2 = i1.getImage().getScaledInstance(550, 290, Image.SCALE_DEFAULT);
				 ImageIcon i3 = new ImageIcon(i2);
				 l10 = new JLabel(i3);
				l10.setBounds(0,0,550,290);
				add(l10);
			
	   	 setBounds(450,200,550,290);
	  	 // getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	  	  
	  	 JLabel l3 =new JLabel("ADD PANCHAYAT DETAILS ");
		  l3.setBounds(130,15,400,25);
		  l3.setFont(new Font("Taboma",Font.BOLD,20));
		 l10. add(l3);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,500,200);
		  p.setBackground(new Color (0,0,0,0));
		 l10. add(p);
		    
		  JLabel l1 =new JLabel("Aadhar Number of Member");
		  l1.setBounds(30,50,250,25);
		  l1.setFont(new Font("Taboma",Font.BOLD,17));
		  p.add(l1);
		 
		  t1 = new JTextField();
		  t1.setBounds(270,50,150,30);
		  t1.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t1);
	     
	     JLabel l2 =new JLabel("Designation");
		   l2.setBounds(30,100,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,17));
	      p.add(l2);
		 	 
	      
	      c1 = new Choice();
	       c1.add("select");
	       c1.add("Mukhiya");
	       c1.add("Ward member");
	       c1.add("Sarpanch");
	       c1.add("");
	       c1.setBounds(270,100,150,30);
	       p.add(c1);
	      
	      
	     
	     
	      
	      b1= new JButton("ADD");
	      b1.setBackground(new Color (102,102,102));
	      b1.setForeground(Color.WHITE);
	      b1.setBounds(180,190,80,25);
	      b1.addActionListener(this);
	      add(b1);
	      
	      b2= new JButton("BACK");
	      b2.setBackground(new Color (102,102,102));
	      b2.setForeground(Color.WHITE);
	      b2.setBounds(290,190,80,25);
	      b2.addActionListener(this);
	      add(b2);
	     
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
		          String AADHAR_NO_OF_MEMBER = t1.getText();
			 	  String DESIGNATION  = c1.getSelectedItem();			 	
			      
			      
			 	     
			 	String query ="insert into PANCHAYAT Values('"+AADHAR_NO_OF_MEMBER+"','"+DESIGNATION+"')";
			 	    
			 		try {
			 			Conn c = new Conn();
			 			c.s.executeUpdate(query);
			 			
			 			JOptionPane.showMessageDialog(null, "PANCHAYAT Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
			 			this.setVisible(false);
			 			
			 		}catch(Exception e1) {
			 			e1.printStackTrace();
			 			JOptionPane.showMessageDialog(null, "Enter correct details");
			 		}
		    	   
		       }else if(e.getSource()==b2) {
		    	   this.setVisible(false);
		    	   new Panchayat().setVisible(true);
		       }
			
		}

	public static void main(String[] args) {
		
		new AddPanchayat().setVisible(true);
	}

	

}
