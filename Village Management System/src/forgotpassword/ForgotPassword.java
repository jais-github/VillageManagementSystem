package forgotpassword;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conn.Conn;
import login.Login;

public class ForgotPassword extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6,l7;
       public ForgotPassword(){
    	   
    	   
    	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
   		Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
   		 ImageIcon i3 = new ImageIcon(i2);
   		 l6 = new JLabel(i3);
   		l6.setBounds(0,0,600,400);
   		add(l6);
   		
    	  setBounds(330,200,600,380); 
    	 // getContentPane().setBackground(new Color(255,255,204));
    	  
    	  setLayout(null);
    	  
    	  
    	  JPanel p = new JPanel();
    	  p.setBackground(new Color (0,0,0,0));
    	  p.setLayout(null);
    	  p.setBounds(30,30,480,295);
    	  
    	 l6. add(p);
    	 
    	 l7 = new JLabel("FORGOT PASSWORD");
         l7.setBounds(150,3,400,50);//153,0,0
    	   l7.setForeground(new Color (51,51,51));
          l7.setFont(new Font("SAN_SERIF",Font.BOLD,20));
    	  l6.add(l7);
    	  
    	  JLabel l1 = new JLabel("UserID");
    	  l1.setBounds(40,20,100,25);
    	  l1.setFont(new Font("Taboma",Font.BOLD,14));
    	  p.add(l1);
    	  
    	  
    	  t1 = new JTextField();
    	  t1.setBounds(220,20,130,25);
    	  t1.setBorder(BorderFactory.createEmptyBorder());
    	  p.add(t1);
    	  
    	  b1 = new JButton("Search");
    	  b1.setBackground(new Color (102,102,102));
    	  b1.setForeground(Color.WHITE);
    	  b1.setBounds(360,20,90,25);
    	  b1.addActionListener(this);
    	  p.add(b1);
    	  
    	  JLabel l2 = new JLabel("Name");
    	  l2.setBounds(40,60,100,25);
    	  l2.setFont(new Font("Taboma",Font.BOLD,14));
    	  p.add(l2);
    	  
    	  
    	  t2 = new JTextField();
    	  t2.setBounds(220,60,130,25);
    	  t2.setBorder(BorderFactory.createEmptyBorder());
    	  p.add(t2);
    	  
    	  JLabel l3 = new JLabel("Your Security Question");
    	  l3.setBounds(40,100,170,25);
    	  l3.setFont(new Font("Taboma",Font.BOLD,14));
    	  p.add(l3);
    	  
    	  
    	  t3 = new JTextField();
    	  t3.setBounds(220,100,130,25);
    	  t3.setBorder(BorderFactory.createEmptyBorder());
    	  p.add(t3);
    	  
    	  JLabel l4 = new JLabel("Answer");
    	  l4.setBounds(40,140,100,25);
    	  l4.setFont(new Font("Taboma",Font.BOLD,14));
    	  p.add(l4);
    	  
    	  
    	  t4 = new JTextField();
    	  t4.setBounds(220,140,130,25);
    	  t4.setBorder(BorderFactory.createEmptyBorder());
    	  p.add(t4);
    	  
    	  b2 = new JButton("Retrieve");
    	  b2.setBackground(new Color(102,102,102));
    	  b2.setForeground(Color.WHITE);
    	  b2.setBounds(360,140,90,25);
    	  b2.addActionListener(this);
    	  p.add(b2);
    	  
    	  JLabel l5 = new JLabel("Password");
    	  l5.setBounds(40,180,150,25);
    	  l5.setFont(new Font("Taboma",Font.BOLD,14));
    	  p.add(l5);
    	  
    	  
    	  t5 = new JTextField();
    	  t5.setBounds(220,180,130,27);
    	  t5.setBorder(BorderFactory.createEmptyBorder());
    	  p.add(t5);
    	  
    	  b3 = new JButton("BACK");
    	  b3.setBackground(new Color(102,102,102));
    	  b3.setForeground(Color.WHITE);
    	  b3.setBounds(150,230,90,25);
    	  b3.addActionListener(this);
    	  p.add(b3);
       }  
    	  
    	 @Override
    		public void actionPerformed(ActionEvent e) {
    		Conn c = new Conn();
       if(e.getSource()==b1) {
    	  try {
    	   String sql = "select * from FORGOT_PASSWORD where UserID = '"+t1.getText()+"'";
    	   ResultSet rs = c.s.executeQuery(sql);
    	   
    	   while(rs.next()) {
    		   t2.setText(rs.getString("Name")); //setText() is used to set some particular value in TextField
    		   t3.setText(rs.getString("YOUR_SECURITY_QUESTION")); // if you want to the value of some columns ,there is a function getString() that is present inside ResultSet class
    	   }
    	  }catch(Exception e1) {
    		  e1.printStackTrace();
    	  };
    	  
       }else if(e.getSource()==b2) {
    	   try {
        	   String sql = "select * from FORGOT_PASSWORD where Answer = '"+t4.getText()+"'  And UserID = '"+t1.getText()+"'";
        	   ResultSet rs = c.s.executeQuery(sql);
        	   
        	   while(rs.next()) {
        		  
        		   t5.setText(rs.getString("Password")); // if you want to the value of some columns ,there is a function getString() that is present inside ResultSet class
        	   }
        	  }catch(Exception e1) {
        		  e1.printStackTrace();
        	  };
    	   
       }else if(e.getSource()==b3) {
    	   this.setVisible(false);
    	   new Login().setVisible(true);
       }
    		
    	  
       }
	public static void main(String[] args) {
		new ForgotPassword().setVisible(true);

	}
	

}
