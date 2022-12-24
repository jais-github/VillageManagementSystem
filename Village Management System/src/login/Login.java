package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.*;

import conn.Conn;
import forgotpassword.ForgotPassword;
import loading.Loading;

public class Login extends JFrame implements ActionListener{
	JTextField t1,t2;
	JLabel l1,l2;
JButton b1,b2,b3;
	public Login(){
	//setSize(400,400);
	//setLocation(400,200);
		
		
	try {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l1 = new JLabel(i3);
		l1.setBounds(0,0,600,400);
		add(l1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	setLayout(null);  //by default border layout
	//getContentPane().setBackground(new Color(255,255,204));
	setBounds(450,180,600,400);
	
	
	
	
	 l2 = new JLabel("Gram-E");
    l2.setBounds(180,10,400,50);//153,0,0
    l2.setForeground(new Color (51,51,51));
    l2.setFont(new Font("SAN_SERIF",Font.BOLD,40));
    l1.add(l2);
    
	/*JPanel p1 = new JPanel(); //created an object of JPanel to create division(panel) on the frame// 
	p1.setBackground(new Color(255,153,0));
	p1.setBounds(0,60,400,355);
	p1.setLayout(null);
	add(p1);*/
	
	
	/*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
	  Image i2 = i1.getImage(.getScaledInstance(200,200,Image.SCALE_DEFAULT);
	  ImageIcon i3 = new ImageIcon(i2);
	  JLabel l1 = new JLabel(i1);
	l1.setBounds(100,120,200,200);
	p1.add(l1);*/
	
	JPanel p2 = new JPanel();
	p2.setBackground(new Color(0,0,0,0));//255,153,0
	p2.setLayout(null);
    p2.setBounds(150,50,450,320);
   l1. add(p2);
    
    JLabel l3 = new JLabel("UserID");
    l3.setBounds(60,20,100,25);
    l3.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
    p2.add(l3);
    
    t1 = new JTextField();// object of text field
	t1.setBounds(60,60,250,30);
	t1.setBorder(BorderFactory.createEmptyBorder()); //will remove the border of textfield
	p2.add(t1);
	
	 JLabel l4 = new JLabel("Password");
     l4.setBounds(60,110,100,25);
     l4.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
     p2.add(l4);
	    
	 t2 = new JPasswordField();// object of Password field to hide the text of the user
	 t2.setBounds(60,150,250,30);
	 t2.setBorder(BorderFactory.createEmptyBorder()); //will remove the border of textfield
	 p2.add(t2);
	 
	 b1 = new JButton("Login");
	 b1.setBounds(60,200,130,30);
	 b1.setBackground(new Color(102,102,102));
	 b1.setForeground(Color.WHITE);
	 b1.setBorder(BorderFactory.createEmptyBorder());
	 b1.addActionListener(this);
	 p2.add(b1);
	 
	/* JButton b2 = new JButton("UserID");
	 b2.setBounds(230,200,130,30);
	 b2.setBorder(BorderFactory.createEmptyBorder());
	 p2.add(b2);*/
	 
	  b2 = new JButton("Forget Password");
	 b2.setBounds(60,250,160,30);
	 b2.setBackground(new Color(102,102,102));
	 b2.setForeground(Color.WHITE);
	 b2.setBorder(BorderFactory.createEmptyBorder());
	 b2.addActionListener(this);
	 p2.add(b2);
	 
	/* b3 = new JButton("Add Person");
	 b3.setBounds(260,250,160,30);
	 b3.setBackground(new Color(133,193,233));		
	 b3.setForeground(Color.WHITE);
	 b3.setBorder(BorderFactory.createEmptyBorder());
	 b3.addActionListener(this);
	 p2.add(b3);*/
	
	/* JLabel l5 = new JLabel("Invalid Credentials");
	 l5.setForeground(Color.RED);
	 l5.setBounds(310,250,200,100);
	 p2.add(l5);*/
	 
	 
    setVisible(true);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
   if(e.getSource()==b1) {	
	   try {
		   String UserID = t1.getText();
		   String Password = t2.getText();
		   String sql ="Select * from Login where UserID = '"+UserID+"' AND Password = '"+Password+"'";
		   
		   Conn  c = new Conn(); 
		   ResultSet rs = c.s.executeQuery(sql);  //executequery function returns the Resultset class object
	   
	       if(rs.next()) {   
	    	   this.setVisible(false);
	    	   new Loading(UserID).setVisible(true);
	       }else {
	    	   JOptionPane.showMessageDialog(null, "Invalid Credentials");
	       }
	   }catch(Exception e1) {
		   e1.printStackTrace();
	   }
   }else if(e.getSource()==b2) {
	   this.setVisible(false);
	   new ForgotPassword().setVisible(true);
   }/*else if(e.getSource()==b3){
	   new Person().setVisible(true);
   }*/
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new Login();
	}
	
}
