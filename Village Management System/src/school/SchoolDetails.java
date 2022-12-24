package school;

import java.awt.Choice;
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
import house.House;

public class SchoolDetails extends JFrame implements ActionListener{
 JTextField t1,t2,t3,t4,t5,t6,t7;
 JButton b1,b2,b3;
 JLabel l10;
 int flag = 0;
	public SchoolDetails(){
		
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
			Image i2 = i1.getImage().getScaledInstance(550, 280, Image.SCALE_DEFAULT);
			 ImageIcon i3 = new ImageIcon(i2);
			 l10 = new JLabel(i3);
			l10.setBounds(0,0,550,280);
			add(l10);
		
   	 setBounds(450,190,550,300);
  	 // getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	 JLabel l8 =new JLabel("SCHOOL DETAILS");
	  l8.setBounds(190,19,190,22);
	  l8.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l8);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,410,200);
	  p.setBackground(new Color (0,0,0,0));
	  l10.add(p);
	    
	 
    
	   JLabel l2 =new JLabel(" School Name");
	   l2.setBounds(30,50,200,25);
	   l2.setFont(new Font("Taboma",Font.PLAIN,18));
       p.add(l2);
	 	 
       
       
       
       t2 = new JTextField();
	   t2.setBounds(210,50,150,30);
	   t2.setBorder(BorderFactory.createEmptyBorder());
       p.add(t2);
    
      
   
       
       b1= new JButton("SEARCH");
       b1.setBackground(new Color (102,102,102));
       b1.setForeground(Color.WHITE);
       b1.setBounds(240,150,90,25);
       b1.addActionListener(this);
       add(b1);
       
      b2= new JButton("ADD");
      b2.setBackground(new Color (102,102,102));
      b2.setForeground(Color.WHITE);
      b2.setBounds(120,150,100,25);
      b2.addActionListener(this);
      add(b2);
       
    
       
       
     
   
    }
	
	@Override
 	public void actionPerformed(ActionEvent e)
     {
 		if(e.getSource() == b1)
 		{
 			
 			String userName = t2.getText().toString();
  			frameSecond(userName);

	    	        
       }else if(e.getSource()==b2) {
        this.setVisible(false);
        new AddSchoolDetails().setVisible(true);
    	   
       }
 		
     
     
}
	
	public void frameSecond( String userName) {
		  //setting the properties of second JFrame
		  JFrame frame2 = new JFrame("DATABASE RESULTS");
		  frame2.setLayout(new FlowLayout());
		  frame2.setSize(1300, 230);
		  frame2.setLocation(60, 200);
		  
		//setting the properties of JTable and DefaultTableModel
		  DefaultTableModel defaultTableModel = new DefaultTableModel();
		   JTable table = new JTable(defaultTableModel);
		   table.setPreferredScrollableViewportSize(new Dimension(1200,150));
		   table.setFillsViewportHeight(true);
		   frame2.add(new JScrollPane(table));
		   defaultTableModel.addColumn("SCHOOL_ID");
		   defaultTableModel.addColumn("SNAME");
		   defaultTableModel.addColumn("PRINCIPAL_NAME");
		   defaultTableModel.addColumn("PRINCIPAL_AADHAR_NO");
		   defaultTableModel.addColumn("NO_OF_STAFF");
		   defaultTableModel.addColumn("EMAIL_ID");
		   defaultTableModel.addColumn("CONTACT_NO");
		   defaultTableModel.addColumn("ADDRESS");
		   
		   
		   /*CREATE TABLE SCHOOL
		   (
		   SCHOOL_ID INT PRIMARY KEY,
		   SNAME VARCHAR(20),
		   PRINCIPAL_NAME VARCHAR(30),
		   PRINCIPAL_AADHAR_NO CHAR(12),
		   NO_OF_STAFF INT,
		   EMAIL_ID VARCHAR(30),
		   CONTACT_NO BIGINT,
		   ADDRESS VARCHAR(50),
		   CONSTRAINT FK7 FOREIGN KEY(PRINCIPAL_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
		   );*/

		   try{
	            Conn c = new Conn();
	          String sql =("SELECT *\r\n"
	          		+ "FROM SCHOOL\r\n"
	          		+ "WHERE SNAME='"+t2.getText()+"';\r\n"
	          		+ "");
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String SCHOOL_ID = rs.getString("SCHOOL_ID");
	        String SNAME = rs.getString("SNAME");
	        String PRINCIPAL_NAME = rs.getString("PRINCIPAL_NAME");
	        String  PRINCIPAL_AADHAR_NO= rs.getString("PRINCIPAL_AADHAR_NO");
	        String  NO_OF_STAFF= rs.getString("NO_OF_STAFF");
	        String  EMAIL_ID= rs.getString("EMAIL_ID");
	        String  CONTACT_NO= rs.getString("CONTACT_NO");
	        String  ADDRESS= rs.getString("ADDRESS");
	      
	      // if(userName.equalsIgnoreCase(NAME)) {
	        if(true) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {SCHOOL_ID,SNAME,PRINCIPAL_NAME,PRINCIPAL_AADHAR_NO,NO_OF_STAFF,EMAIL_ID,CONTACT_NO,ADDRESS});
	    	  // new House().setVisible(false);
	    	   frame2.setVisible(true);
	    	  
	    	   frame2.validate();
	    	   break;
	       }
	       }
	      if(flag == 0) {
	    	   JOptionPane.showMessageDialog(null, "No Such School Found");
	       }
			}
	      catch(Exception e1){
	        e1.printStackTrace();
	             }
			
	  
		  
	}
	
	public static void main(String[] args) {
		new SchoolDetails().setVisible(true);

	}

}
