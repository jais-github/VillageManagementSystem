package panchayat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import conn.Conn;

public class Panchayat extends JFrame implements ActionListener {
 JTextField t1,t2;
 JButton b1,b2;
 JLabel l10;
  int flag = 0;
	public Panchayat(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(600, 280, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,600,280);
		add(l10);
	
		
   	 setBounds(450,200,600,280);
  	  //getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	 JLabel l3 =new JLabel("PANCHAYAT DETAILS");
	  l3.setBounds(130,15,400,25);
	  l3.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l3);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,480,200);
	  p.setBackground(new Color (0,0,0,0));
	  l10.add(p);
	    
	  JLabel l1 =new JLabel("Name");
	  l1.setBounds(30,50,250,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,17));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(290,50,150,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
     p.add(t1);
     
	   JLabel l2 =new JLabel("House Number");
	   l2.setBounds(30,100,200,25);
	   l2.setFont(new Font("Taboma",Font.BOLD,17));
      p.add(l2);
	 	 
      t2 = new JTextField();
	   t2.setBounds(290,100,150,30);
	   t2.setBorder(BorderFactory.createEmptyBorder());
      p.add(t2);
     
     
      
      b1= new JButton("Search");
      b1.setBackground(new Color (102,102,102));
      b1.setForeground(Color.WHITE);
      b1.setBounds(180,190,80,25);
      b1.addActionListener(this);
      add(b1);
      
      b2= new JButton("ADD");
      b2.setBackground(new Color (102,102,102));
      b2.setForeground(Color.WHITE);
      b2.setBounds(280,190,80,25);
      b2.addActionListener(this);
      add(b2);
      
    }
	
	@Override
 	public void actionPerformed(ActionEvent e)
     {
 		if(e.getSource() == b1) {
 			
 			 String userName = t1.getText().toString();//getting text of username text field and storing it in a String variable
             frameSecond(userName);//passing the text value to frameSecond method
  
         }
         if (e.getSource() == b2) {
        	 this.setVisible(false);
				new AddPanchayat().setVisible(true);//resetting the value of username text field
         }
 		}
 		
	public void frameSecond( String userName) {
		  //setting the properties of second JFrame
		  JFrame frame2 = new JFrame("DATABASE RESULTS");
		  frame2.setLayout(new FlowLayout());
		  frame2.setSize(750, 350);
		  frame2.setLocation(550, 200);

		  //setting the properties of JTable and DefaultTableModel
		  DefaultTableModel defaultTableModel = new DefaultTableModel();
		   JTable table = new JTable(defaultTableModel);
		   table.setPreferredScrollableViewportSize(new Dimension(680,150));
		   table.setFillsViewportHeight(true);
		   frame2.add(new JScrollPane(table));
		   defaultTableModel.addColumn("NAME");
		   defaultTableModel.addColumn("AADHAR_NO_OF_MEMBER");
		   defaultTableModel.addColumn("DESIGNATION");
		   
		   try{
	            Conn c = new Conn();
	          String sql =("SELECT NAME,AADHAR_NO_OF_MEMBER,DESIGNATION\r\n"
	          		+ "FROM PERSON P,PANCHAYAT PA\r\n"
	          		+ "WHERE PA.AADHAR_NO_OF_MEMBER=P.AADHAR_NO AND P.NAME='"+t1.getText()+"'AND P.HOUSE_NO='"+t2.getText()+"';");
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String NAME = rs.getString("NAME");
	       String AADHAR_NO_OF_MEMBER= rs.getString("AADHAR_NO_OF_MEMBER");
	       String DESIGNATION= rs.getString("DESIGNATION");
	       if(userName.equalsIgnoreCase(NAME)) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {NAME,AADHAR_NO_OF_MEMBER,DESIGNATION});
	    	  // new House().setVisible(false);
	    	   frame2.setVisible(true);
	    	  
	    	   frame2.validate();
	    	   break;
	       }
	       }
	      if(flag == 0) {
	    	   JOptionPane.showMessageDialog(null, "No Such DATA  Found");
	       }
			}
	      catch(Exception e1){
	        e1.printStackTrace();
	             }
			
	  
	         
}
	
	public static void main(String[] args) {
		new Panchayat().setVisible(true);

	}

}
