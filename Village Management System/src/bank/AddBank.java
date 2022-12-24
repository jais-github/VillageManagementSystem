package bank;

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


public class AddBank extends JFrame implements ActionListener{
JTextField t1,t2,t3;
JButton b1,b2;
JLabel l10;
	public AddBank(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 290, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,290);
		add(l10);
		
   	 setBounds(450,200,550,290);
  	  //getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	 JLabel l3 =new JLabel("ADD BANK DETAILS ");
	  l3.setBounds(130,5,290,25);
	  l3.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l3);
	 
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,430,200);
	  p.setBackground(new Color (0,0,0,0));
	 l10. add(p);
	    
	  JLabel l1 =new JLabel("ACCOUNT NUMBER");
	  l1.setBounds(30,50,200,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,18));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(250,50,150,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
      p.add(t1);
      
      JLabel l2 =new JLabel("AADHAR NUMBER");
	   l2.setBounds(30,100,200,25);
	   l2.setFont(new Font("Taboma",Font.BOLD,18));
     p.add(l2);
	 	 
     t2 = new JTextField();
	   t2.setBounds(250,100,150,30);
	   t2.setBorder(BorderFactory.createEmptyBorder());
     p.add(t2);
     
     JLabel l4 =new JLabel("BANK NAME");
	   l4.setBounds(30,150,200,25);
	   l4.setFont(new Font("Taboma",Font.BOLD,18));
    p.add(l4);
	 	 
    t3 = new JTextField();
	   t3.setBounds(250,150,150,30);
	   t3.setBorder(BorderFactory.createEmptyBorder());
    p.add(t3);
    
    
    
    b1= new JButton("ADD");
    b1.setBackground(new Color (102,102,102));
    b1.setForeground(Color.WHITE);
    b1.setBounds(180,220,80,25);
     b1.addActionListener(this);
    add(b1);
    
    b2= new JButton("BACK");
    b2.setBackground(new Color (102,102,102));
    b2.setForeground(Color.WHITE);
    b2.setBounds(290,220,80,25);
    b2.addActionListener(this);
    add(b2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b1) {
	         String ACCOUNT_NUMBER= t1.getText();
		 	  String AADHAR_NO= t2.getText();
		      String BANK_NAME=t3.getText();
		
		      String query ="insert into BANK Values('"+ACCOUNT_NUMBER+"','"+AADHAR_NO+"','"+BANK_NAME+"')";
                	
		      try {
		 			Conn c = new Conn();
		 			c.s.executeUpdate(query);
		 			
		 			JOptionPane.showMessageDialog(null, "BANK Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
		 			this.setVisible(false);
		 			
		 		}catch(Exception e1) {
		 			e1.printStackTrace();
		 			}
		      }else if(e.getSource()==b2) {
		 			this.setVisible(false);
		 			new Bank().setVisible(true);
		 		}
		 }
	
	public static void main(String[] args) {
	       new AddBank().setVisible(true);		

		}



	

	}