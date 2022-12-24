package schoolchildren;

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
import schoolmain.School;

public class SchoolChildren extends JFrame implements ActionListener{
   JTextField t1,t2,t3,t4,t5;
   JButton b1,b2,b3;
   JLabel l10;
   int flag = 0;
	public SchoolChildren(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 280, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,280);
		add(l10);
		
   	 setBounds(450,200,550,300);
  	  //getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	  JLabel l6 =new JLabel("SCHOOL CHIILDREN DETAILS");
	  l6.setBounds(160,15,450,25);
	  l6.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l6);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,430,210);
	  p.setBackground(new Color (0,0,0,0));
	 l10. add(p);
	    
	  JLabel l1 =new JLabel("Student Name");
	  l1.setBounds(30,50,200,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,18));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(250,50,150,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
     p.add(t1);
     
	   JLabel l2 =new JLabel(" Student ID");
	   l2.setBounds(30,100,200,25);
	   l2.setFont(new Font("Taboma",Font.BOLD,18));
      p.add(l2);
	 	 
      t2 = new JTextField();
	   t2.setBounds(250,100,150,30);
	   t2.setBorder(BorderFactory.createEmptyBorder());
      p.add(t2);
     
      
     
      b1= new JButton("SEARCH");
      b1.setBackground(new Color (102,102,102));
      b1.setForeground(Color.WHITE);
      b1.setBounds(150,195,100,25);
      b1.addActionListener(this);
      add(b1);
      
     b2= new JButton("ADD");
     b2.setBackground(new Color (102,102,102));
     b2.setForeground(Color.WHITE);
     b2.setBounds(290,195,80,25);
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
  		}
     

     else if(e.getSource()==b2) {
         this.setVisible(false);
         new AddSchoolChildren().setVisible(true);
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
	   table.setPreferredScrollableViewportSize(new Dimension(700,150));
	   table.setFillsViewportHeight(true);
	   frame2.add(new JScrollPane(table));
	   defaultTableModel.addColumn("STUDENT_ID");
	   defaultTableModel.addColumn("SNAME");
	   defaultTableModel.addColumn("AADHAR_NO");
	   defaultTableModel.addColumn("GUARDIAN_NAME");
	   defaultTableModel.addColumn("SCHOOL_ID");
	   defaultTableModel.addColumn("CLASS");
	   defaultTableModel.addColumn("SECTION");
	   
	   try{
           Conn c = new Conn();
         String sql =("SELECT STUDENT_ID,SNAME,SAADHAR_NO AS AADHAR_NO,P.NAME AS GUARDIAN_NAME,SCHOOL_ID,CLASS,SECTION\r\n"
         		+ "FROM PERSON P,SCHOOL_CHILDREN SC\r\n"
         		+ "WHERE SC.GAADHAR_NO=P.AADHAR_NO AND SNAME='"+t1.getText()+"' AND STUDENT_ID='"+t2.getText()+"';");
           ResultSet rs = c.s.executeQuery(sql);
     while(rs.next()){
   	  //retrieving details from the database and storing it in the string variable
       String STUDENT_ID = rs.getString("STUDENT_ID");
      String SNAME= rs.getString("SNAME");
      String AADHAR_NO= rs.getString("AADHAR_NO");
      String GUARDIAN_NAME= rs.getString("GUARDIAN_NAME");
      String SCHOOL_ID= rs.getString("SCHOOL_ID");
      String CLASS= rs.getString("CLASS");
      String SECTION= rs.getString("SECTION");
     // if(userName.equalsIgnoreCase(STUDENTNAME)) {
      if(true) {
   	    flag = 1;
   	   defaultTableModel.addRow(new Object[] {STUDENT_ID,SNAME,AADHAR_NO,GUARDIAN_NAME,SCHOOL_ID,CLASS,SECTION});
   	  // new House().setVisible(false);
   	   frame2.setVisible(true);
   	  
   	   frame2.validate();
   	   break;
      }
      }
	if(flag == 0) {
   	   JOptionPane.showMessageDialog(null, "No Such DATA Found");
      }
		}
     catch(Exception e1){
       e1.printStackTrace();
            }
		
 }
        

	  

	
	public static void main(String[] args) {
		new SchoolChildren().setVisible(true);

	}

}
