package person;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import conn.Conn;
import net.proteanit.sql.DbUtils;
public class Person extends JFrame  implements ActionListener{
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2;
	JTable table;
    int flag = 0;
	JLabel l10;
   public  Person(){
	   
	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(850, 280, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,850,280);
		add(l10);
	   
  	 setBounds(470,150,850,300);
  	// getContentPane().setBackground(new Color(255,255,204));
  	 setLayout(null);
  	 
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,400,220);
	  p.setBackground(new Color (0,0,0,0));
	  l10.add(p);
	  
  	 JLabel l1 =new JLabel("PERSON DETAILS");
  	 l1.setBounds(150,15,200,25);
  	 l1.setFont(new Font("Taboma",Font.BOLD,20));
  	 l10.add(l1);

		
  	 
  	 
  	 JLabel l2 =new JLabel("Name");
  	 l2.setBounds(30,50,200,25);
  	 l2.setFont(new Font("Taboma",Font.BOLD,18));
  	  p.add(l2);
  	 
  	 t1 = new JTextField();
  	 t1.setBounds(190,50,150,30);
  	t1.setBorder(BorderFactory.createEmptyBorder());
      p. add(t1);
       
      
       
       JLabel l4 =new JLabel("House Number");
  	 l4.setBounds(30,100,200,25);
  	 l4.setFont(new Font("Taboma",Font.BOLD,18));
  	 p. add(l4);
  	
  	 t3 = new JTextField();
  	 t3.setBounds(190,100,150,30);
  	 t3.setBorder(BorderFactory.createEmptyBorder());
      p. add(t3);
       
      
       
       
     
       
       b1= new JButton("SEARCH");
       b1.setBackground(new Color (102,102,102));
       b1.setForeground(Color.WHITE);
       b1.setBounds(150,200,100,25);
       b1.addActionListener(this);
       add(b1);
       
      b2= new JButton("ADD");
      b2.setBackground(new Color (102,102,102));
      b2.setForeground(Color.WHITE);
      b2.setBounds(280,200,80,25);
      b2.addActionListener(this);
      add(b2);
      
    
      
    
      
   }
        
   @Override
 	public void actionPerformed(ActionEvent e)
     {
 		if(e.getSource() == b1)
 		{
 			String userName = t1.getText().toString();
  			frameSecond(userName);
 			
 		}	else if(e.getSource()==b2) {
         this.setVisible(false);
         new AddPersonDetails().setVisible(true);
    	   
       }
     
     
}
       
   public void frameSecond( String userName) {
		  //setting the properties of second JFrame
		  JFrame frame2 = new JFrame("DATABASE RESULTS");
		  frame2.setLayout(new FlowLayout());
		  frame2.setSize(750, 300);
		  frame2.setLocation(450, 200);
		  
		  //setting the properties of JTable and DefaultTableModel
		  DefaultTableModel defaultTableModel = new DefaultTableModel();
		   JTable table = new JTable(defaultTableModel);
		   table.setPreferredScrollableViewportSize(new Dimension(680,150));
		   table.setFillsViewportHeight(true);
		   frame2.add(new JScrollPane(table));
		   defaultTableModel.addColumn("NAME");
		   defaultTableModel.addColumn("AADHAR_NO");
		   defaultTableModel.addColumn("DOB");
		   defaultTableModel.addColumn("PHONE_NO");
		   defaultTableModel.addColumn("QUALIFICATION");
		   defaultTableModel.addColumn("OCCUPATION");
		   defaultTableModel.addColumn("HOUSE_NO");
		   
		   try{
	            Conn c = new Conn();
	          String sql ="CALL get_person('"+t1.getText()+"','"+t3.getText()+"')";
	          
	         /* SELECT *\r\n"
              + "FROM PERSON\r\n"
        		+ "WHERE NAME='"+t1.getText()+"' AND HOUSE_NO='"+t3.getText()+"';*/
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String NAME = rs.getString("NAME");
	        String AADHAR_NO = rs.getString("AADHAR_NO");
	        String DOB = rs.getString("DOB");
	        String PHONE_NO = rs.getString("PHONE_NO");
	        String QUALIFICATION = rs.getString("QUALIFICATION");
	        String OCCUPATION = rs.getString("OCCUPATION");
	       String HOUSE_NO= rs.getString("HOUSE_NO");
	     //  if(userName.equalsIgnoreCase(HOUSE_NO)) {
	       if(true) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {NAME,AADHAR_NO,DOB,PHONE_NO,QUALIFICATION,OCCUPATION,HOUSE_NO});
	    	  // new House().setVisible(false);
	    	   frame2.setVisible(true);
	    	  
	    	   frame2.validate();
	    	   break;
	       }
	       }
	      if(flag == 0) {
	    	   JOptionPane.showMessageDialog(null, "No Such PERSON  Found");
	       }
			}
	      catch(Exception e1){
	        e1.printStackTrace();
	             }
			
	  }
	         

   
   
   
	public static void main(String[] args) {
		new Person().setVisible(true);

	}
	

}
