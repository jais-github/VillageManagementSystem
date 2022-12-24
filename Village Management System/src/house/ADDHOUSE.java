package house;


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

public class ADDHOUSE extends JFrame implements ActionListener {

	JTextField t1,t2;
	JButton b1,b2;
	JLabel l10;
	public ADDHOUSE(){
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(790, 270, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,790,270);
			add(l10);
		
		setBounds(450,180,800,300);
		//getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel l1= new JLabel("ADD HOUSE DETAILS");
		l1.setBounds(220,8,400,25);
		l1.setFont(new Font("Taboma",Font.BOLD,20));
	 	 l10. add(l1);
	 	  
	 	  
	 	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,40,380,200);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
		  
		  JLabel l2 =new JLabel("House Number");
	 	  l2.setBounds(30,50,200,25);
	 	  l2.setFont(new Font("Taboma",Font.BOLD,18));
	 	  p.add(l2);
	 	 
	 	  t1 = new JTextField();
	 	  t1.setBounds(180,50,150,30);
	 	  t1.setBorder(BorderFactory.createEmptyBorder());
	      p. add(t1);
	       
		   JLabel l3 =new JLabel("Address");
		   l3.setBounds(30,100,200,25);
		   l3.setFont(new Font("Taboma",Font.BOLD,18));
	       p.add(l3);
		 	 
	       t2 = new JTextField();
	 	   t2.setBounds(180,100,150,30);
	 	  t2.setBorder(BorderFactory.createEmptyBorder());
	       p.add(t2);
	       
	       b1 = new JButton("ADD");
	       b1.setBackground(new Color (102,102,102));
	 	  b1.setForeground(Color.WHITE);
	 	  b1.setBounds(80,160,90,25);
	 	  b1.addActionListener(this);
	 	  p.add(b1);
	 	  
	 	  b2 = new JButton("BACK");
	 	 b2.setBackground(new Color (102,102,102));
	 	  b2.setForeground(Color.WHITE);
	 	  b2.setBounds(200,160,90,25);
	 	  b2.addActionListener(this);
	 	  p.add(b2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
            String HouseNumber = t1.getText();
  	 	        String Address = t2.getText();
  	 		
  	 		
  	 		String query ="insert into HOUSE Values('"+HouseNumber+"','"+Address+"')";
  	 	    
  	 		try {
  	 			Conn c = new Conn();
  	 			c.s.executeUpdate(query);
  	 			
  	 			JOptionPane.showMessageDialog(null, "HOUSE Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
  	 			this.setVisible(false);
  	 			
  	 		}catch(Exception e1) {
  	 			e1.printStackTrace();
  	 			JOptionPane.showMessageDialog(null, "Enter correct details");
  	 		}
      	   
         }else if(e.getSource()==b2) {
        	 this.setVisible(false);
        	 new House().setVisible(true);
        	 
         }
		
	}
	public static void main(String[] args) {
		
     try {
    	 new ADDHOUSE().setVisible(true);
     }catch(Exception e2) {
    	 e2.printStackTrace();
     }
	}
	

}
