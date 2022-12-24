package person;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import conn.Conn;

public class AddPersonDetails extends JFrame  implements ActionListener{

	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2;
	Choice c1,c2;
	JLabel l10;
	public  AddPersonDetails(){
		
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(850, 530, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,850,530);
			add(l10);
		
	  	 setBounds(470,150,850,530);
	  	 //getContentPane().setBackground(new Color(255,255,204));
	  	 setLayout(null);
	  	 
	  	 JPanel p = new JPanel();
		  p.setLayout(null);
		  p.setBounds(30,30,440,440);
		  p.setBackground(new Color (0,0,0,0));
		  l10.add(p);
		  
	  	 JLabel l1 =new JLabel("ADD PERSON DETAILS");
	  	 l1.setBounds(100,6,250,25);
	  	 l1.setFont(new Font("Taboma",Font.BOLD,20));
	  	 l10.add(l1);

			
	  	 
	  	 
	  	 JLabel l2 =new JLabel("Name");
	  	 l2.setBounds(30,50,200,25);
	  	 l2.setFont(new Font("Taboma",Font.BOLD,18));
	  	p. add(l2);
	  	 
	  	 t1 = new JTextField();
	  	 t1.setBounds(220,50,150,30);
	  	t1.setBorder(BorderFactory.createEmptyBorder());
	     p.add(t1);
	       
	       JLabel l3 =new JLabel("Aadhar");
	  	   l3.setBounds(30,100,200,25);
	  	   l3.setFont(new Font("Taboma",Font.BOLD,18));
	  	    p.add(l3);
	  	 
	  	     t2 = new JTextField();
	  	     t2.setBounds(220,100,150,30);
	  	     t2.setBorder(BorderFactory.createEmptyBorder());
	         p.add(t2);
	       
	           JLabel l4 =new JLabel("DOB");
	  	       l4.setBounds(30,150,200,25);
	  	       l4.setFont(new Font("Taboma",Font.BOLD,18));
	  	       p.add(l4);
	  	
	  	      t3 = new JTextField();
	  	      t3.setBounds(220,150,150,30);
	          t3.setBorder(BorderFactory.createEmptyBorder());
	          p.add(t3);
	       
	         JLabel l5 =new JLabel("Phone");
	    	 l5.setBounds(30,200,200,25);
	    	 l5.setFont(new Font("Taboma",Font.BOLD,18));
	         p.add(l5);
	    	 
	    	 t4 = new JTextField();
	    	 t4.setBounds(220,200,150,30);
	    	 t4.setBorder(BorderFactory.createEmptyBorder());
	         p.add(t4);
	         
	       // JComboBox cb1 = new JComboBox();
	         
	         JLabel l6 =new JLabel("Qualification");
	    	 l6.setBounds(30,250,200,25);
	    	 l6.setFont(new Font("Taboma",Font.BOLD,18));
	    	 p.add(l6);
	    	 
	    	
	    	  c1 = new Choice();
	    	 c1.add("Select");
	    	 c1.add("10thpass");
	    	 c1.add("12thpass");
	    	 c1.add("BA");
	    	 c1.add("B.Ed");
	    	 c1.add("BCom.");
	    	 c1.add("BTech.");
	    	 c1.setBounds(230,250,150,40);
	    	 
	    	 p.add(c1);
	    	 
	    	
	         
	         JLabel l7 =new JLabel("Occupation");
	    	 l7.setBounds(30,300,200,25);
	    	 l7.setFont(new Font("Taboma",Font.BOLD,18));
	    	 p.add(l7);
	    	 
	    	  c2 = new Choice();
	    	 c2.add("Select");
	    	 c2.add("Farmer");
	    	 c2.add("Teacher");
	    	 c2.add("Buisnessman");
	    	 c2.add("Contractor");
	    	 c2.add("Engineer");
	    	 c2.add("Doctor");
	    	 c2.setBounds(230,300,150,40); 
	    	 
	    	 p.add(c2);
	    	 
	    	
	         
	         JLabel l8 =new JLabel("House Number");
	    	 l8.setBounds(30,350,200,25);
	    	 l8.setFont(new Font("Taboma",Font.BOLD,18));
	    	 l8.setForeground(new Color (204,204,204));
	    	 p.add(l8);
	    	 
	    	 t7 = new JTextField();
	    	 t7.setBounds(220,350,150,30);
	    	 t7.setBorder(BorderFactory.createEmptyBorder());
	         p.add(t7);
	         
	         b1= new JButton("ADD");
	         b1.setBackground(new Color (102,102,102));
	         b1.setForeground(Color.WHITE);
	         b1.setBounds(100,405,80,25);
	         b1.addActionListener(this);
	         p.add(b1);
	         
	        b2= new JButton("BACK");
	        b2.setBackground(new Color (102,102,102));
	        b2.setForeground(Color.WHITE);
	        b2.setBounds( 255,405,80,25);
	        b2.addActionListener(this);          
	        p.add(b2);
	        
	      
	        
	      
	          
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1) {
	          String Name = t1.getText();
		 	  String Aadhar= t2.getText();
		 	  String DOB  = t3.getText();
		   	  String Phone = t4.getText();
		 	  String Qualification = c1.getSelectedItem();
		 	  String Occupation = c2.getSelectedItem();
		 	  String HouseNumber = t7.getText();
		 		
		 		
		 		String query ="insert into Person Values('"+Name+"','"+Aadhar+"','"+DOB+"','"+Phone+"','"+Qualification+"','"+Occupation+"','"+HouseNumber+"')";
		 	    
		 		try {
		 			Conn c = new Conn();
		 			c.s.executeUpdate(query);
		 			
		 			JOptionPane.showMessageDialog(null, "Person Details Added Successfully"); //first argument is formatting so did null for that and second argument is the message that is supposed to display
		 			this.setVisible(false);
		 			
		 		}catch(Exception e1) {
		 			e1.printStackTrace();
		 		}
	    	   
	       }else if(e.getSource()==b2) {
	    	   this.setVisible(false);
	    	   new Person().setVisible(true);
	       }
	     
	}

	public static void main(String[] args) {
    
		new AddPersonDetails().setVisible(true);

	}

	
}
