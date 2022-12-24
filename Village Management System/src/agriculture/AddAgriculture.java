package agriculture;

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

public class AddAgriculture extends JFrame implements ActionListener{

	JTextField t1,t2,t3,t4;
	 JButton b1,b2;
	 JLabel l10;
	 Choice c1;
		public AddAgriculture(){
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(550, 420, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,550,420);
			add(l10);
			
	   	 setBounds(450,200,550,420);
	  	 // getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	  	  
	  	 JLabel l5 =new JLabel(" ADD AGRICULTURE DETAILS ");
		  l5.setBounds(130,4,400,25);
		  l5.setFont(new Font("Taboma",Font.BOLD,20));
		  l5.setForeground(new Color(51,51,51));
		  l10.add(l5);
	  	  
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,440,330);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
		    
		  JLabel l1 =new JLabel("Aadhar Number");
		  l1.setBounds(30,50,200,25);
		  l1.setFont(new Font("Taboma",Font.BOLD,18));
		  p.add(l1);
		 
		  t1 = new JTextField();
		  t1.setBounds(250,50,150,30);
		  t1.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t1);
	     
	     JLabel l2 =new JLabel("Crop");
		   l2.setBounds(30,100,200,25);
		   l2.setFont(new Font("Taboma",Font.BOLD,18));
	      p.add(l2);
		 	 
	      t2 = new JTextField();
		   t2.setBounds(250,100,150,30);
		   t2.setBorder(BorderFactory.createEmptyBorder());
	      p.add(t2);
	     
	      JLabel l3 =new JLabel("Types");
		   l3.setBounds(30,150,200,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,18));
	      p.add(l3);
		 	
	         c1 = new Choice();
	    	 c1.add("Select");
	    	 c1.add("Rabi");
	    	 c1.add("Kharif");
	    	 
	    	 c1.setBounds(250,150,150,30);
	    	 p.add(c1);
	      
	     
	    
	      JLabel l4 =new JLabel(" Total Production(in Kg)");
		   l4.setBounds(30,200,400,25);
		   l4.setFont(new Font("Taboma",Font.BOLD,18));
	      p.add(l4);
		 	 
	      t4 = new JTextField();
		   t4.setBounds(250,200,150,30);
		   t4.setBorder(BorderFactory.createEmptyBorder());
	      p.add(t4);
	      
	      b1= new JButton("ADD");
	      b1.setBackground(new Color (102,102,102));
	      b1.setForeground(Color.WHITE);
	      b1.setBounds(180,290,80,25);
	      b1.addActionListener(this);
	      add(b1);
	      
	      b2= new JButton("BACK");
	      b2.setBackground(new Color (102,102,102));
	      b2.setForeground(Color.WHITE);
	      b2.setBounds(280,290,80,25);
	      b2.addActionListener(this);
	      add(b2);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
		          String AADHAR_NO = t1.getText();
			 	  String CROP= t2.getText();
			 	 String TYPE = c1.getSelectedItem();
			 	 String TOTAL_PRODUCTION  = t4.getText();
			      
			      
			 	     
			 		
			 		
			 		String query ="insert into AGRICULTURE Values('"+AADHAR_NO+"','"+CROP+"','"+TYPE+"','"+TOTAL_PRODUCTION+"')";
			 	    
			 		try {
			 			Conn c = new Conn();
			 			c.s.executeUpdate(query);
			 			
			 			JOptionPane.showMessageDialog(null, "Agriculture Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
			 			this.setVisible(false);
			 			
			 		}catch(Exception e1) {
			 			e1.printStackTrace();
			 			JOptionPane.showMessageDialog(null, "Enter correct details");
			 		}
		    	   
		       }else if(e.getSource()==b2) {
		    	   this.setVisible(false);
		    	   new Agriculture().setVisible(true);
		       }
			
		}

	public static void main(String[] args) {
		new AddAgriculture().setVisible(true);

	}

	
}
