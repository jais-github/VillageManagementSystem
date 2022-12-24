package lpg;

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

public class AddLPG extends JFrame implements ActionListener{

	JTextField t1,t2,t3;
	  JButton b1,b2;
	  JLabel l10;
	  Choice c1;
	
	  public AddLPG(){
		  
		  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,600,350);
			add(l10);
		  
		   	 setBounds(450,200,600,350);
		  	  //getContentPane().setBackground(new Color(255,255,204));
		  	  setLayout(null);
		  	  
		  	 JLabel l4 =new JLabel("ADD LPG DETAILS");
			  l4.setBounds(130,5,200,25);
			  l4.setFont(new Font("Taboma",Font.BOLD,20));
			  l10.add(l4);
		  	  
		  	 JPanel p = new JPanel();
			  p.setLayout(null);
			  p.setBounds(30,30,440,250);
			  p.setBackground(new Color (0,0,0,0));
			  l10.add(p);
			    
			  JLabel l1 =new JLabel("Connection Id");
			  l1.setBounds(30,50,200,25);
			  l1.setFont(new Font("Taboma",Font.BOLD,18));
			  p.add(l1);
			 
			  t1 = new JTextField();
			  t1.setBounds(250,50,150,30);
			  t1.setBorder(BorderFactory.createEmptyBorder());
		     p.add(t1);
		     
			   JLabel l2 =new JLabel("Aadhar Number");
			   l2.setBounds(30,100,200,25);
			   l2.setFont(new Font("Taboma",Font.BOLD,18));
		      p.add(l2);
			 	 
		      t2 = new JTextField();
			   t2.setBounds(250,100,150,30);
			   t2.setBorder(BorderFactory.createEmptyBorder());
		      p.add(t2);
		     
		      JLabel l3 =new JLabel("Agency Name");
			   l3.setBounds(30,150,200,25);
			   l3.setFont(new Font("Taboma",Font.BOLD,18));
		      p.add(l3);
			 	 
		      c1 = new Choice();
		       c1.add("Select");
		       c1.add("Indane");
		       c1.add("Hp");
		       c1.add("Bharat");
		       
		       c1.setBounds(250,150,150,30);
		       p.add(c1);
		      
		      
		    
		      
		      b1= new JButton("ADD");
		      b1.setBackground(new Color (102,102,102));
		      b1.setForeground(Color.WHITE);
		      b1.setBounds(140,240,80,25);
		      b1.addActionListener(this);
		      add(b1);
		      
		      b2= new JButton("BACK");
		      b2.setBackground(new Color (102,102,102));
		      b2.setForeground(Color.WHITE);
		      b2.setBounds(240,240,80,25);
		      b2.addActionListener(this);
		      add(b2);
  }


		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==b1) {
		          String CONNECTION_ID = t1.getText();
			 	  String AADHAR_NO  = t2.getText();
			      String AGENCY_NAME = c1.getSelectedItem();
			 	     
			 		
			 		
			 		String query ="insert into LPG Values('"+CONNECTION_ID+"','"+AADHAR_NO+"','"+AGENCY_NAME+"')";
			 	    
			 		try {
			 			Conn c = new Conn();
			 			c.s.executeUpdate(query);
			 			
			 			JOptionPane.showMessageDialog(null, "LPG Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
			 			this.setVisible(false);
			 			
			 		}catch(Exception e1) {
			 			e1.printStackTrace();
			 			JOptionPane.showMessageDialog(null, "Enter correct details");
			 		}
			}else if(e.getSource()==b2){
				this.setVisible(false);
				new LPG().setVisible(true);
			}
			
		}
	  
	public static void main(String[] args) {
		
		new AddLPG().setVisible(true);
	}



}
