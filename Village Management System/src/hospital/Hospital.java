package hospital;

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

public class Hospital extends JFrame implements ActionListener {
   JTextField t1,t2,t3,t4,t5,t6,t7;
   JButton b1,b2;
   JLabel l10;
   int flag = 0;
	public Hospital(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 290, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,290);
		add(l10);
		
   	 setBounds(450,200,550,290);
  	  //getContentPane().setBackground(Color.WHITE);
  	  setLayout(null);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,430,200);
	  p.setBackground(new Color (0,0,0,0));
	  l10.add(p);
	  
	  JLabel l8 =new JLabel("HOSPITAL DETAILS");
	  l8.setBounds(130,5,200,25);
	  l8.setFont(new Font("Taboma",Font.BOLD,18));
	  l10.add(l8);
	 
	    
	  JLabel l1 =new JLabel("Hospital Name");
	  l1.setBounds(30,50,200,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,18));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(200,50,120,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
    p.add(t1);
    
	  
   
    b1= new JButton("Search");
    b1.setBackground(new Color (102,102,102));
    b1.setForeground(Color.WHITE);
    b1.setBounds(268,130,80,25);
    b1.addActionListener(this);
    add(b1);
    
   b2= new JButton("ADD");
   b2.setBackground(new Color (102,102,102));
   b2.setForeground(Color.WHITE);
   b2.setBounds(165,130,80,25);
   b2.addActionListener(this);
   add(b2);
   
    }
	
	/* CREATE TABLE HOSPITAL
    (
    HOSPITAL_NAME VARCHAR(50),
    HOSPITAL_ID INT,
    NO_OF_STAFF INT,
    TYPE VARCHAR(20),
    HEAD_AADHAR_NO CHAR(12),
    HEAD_NAME VARCHAR(20),
    CONTACT_NO BIGINT,
    CONSTRAINT FK13 FOREIGN KEY(HEAD_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
    );*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
 		{
			
			String userName = t1.getText().toString();
  			frameSecond(userName);
 			

 		}else if(e.getSource()==b2) {
 			this.setVisible(false);
 			new AddHospital().setVisible(true);
 			
 		}
		
	}
	
	public void frameSecond( String userName) {
		  //setting the properties of second JFrame
		  JFrame frame2 = new JFrame("DATABASE RESULTS");
		  frame2.setLayout(new FlowLayout());
		  frame2.setSize(720, 300);
		  frame2.setLocation(300, 200);

		  //setting the properties of JTable and DefaultTableModel
		  DefaultTableModel defaultTableModel = new DefaultTableModel();
		   JTable table = new JTable(defaultTableModel);
		   table.setPreferredScrollableViewportSize(new Dimension(690,150));
		   table.setFillsViewportHeight(true);
		   frame2.add(new JScrollPane(table));
		   defaultTableModel.addColumn("HOSPITAL_NAME");
		   defaultTableModel.addColumn("HOSPITAL_ID");
		   defaultTableModel.addColumn("NO_OF_STAFF");
		   defaultTableModel.addColumn("TYPE");
		   defaultTableModel.addColumn("HEAD_AADHAR_NO");
		   defaultTableModel.addColumn("CONTACT_NO");
		
		  /* CREATE TABLE HOSPITAL
		   (
		   HOSPITAL_NAME VARCHAR(50),
		   HOSPITAL_ID INT,
		   NO_OF_STAFF INT,
		   TYPE VARCHAR(20),
		   HEAD_AADHAR_NO CHAR(12),
		   HEAD_NAME VARCHAR(20),
		   CONTACT_NO BIGINT,
		   CONSTRAINT FK13 FOREIGN KEY(HEAD_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
		   );*/
		   
		   try{
	            Conn c = new Conn();
	          String sql = ("SELECT *\r\n"
	             		+ "FROM HOSPITAL\r\n"
	             		+ "WHERE HOSPITAL_NAME='"+t1.getText()+"'; ");
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String HOSPITAL_NAME = rs.getString("HOSPITAL_NAME");
	       String HOSPITAL_ID= rs.getString("HOSPITAL_ID");
	       String NO_OF_STAFF= rs.getString("NO_OF_STAFF");
	       String TYPE= rs.getString("TYPE");
	       String HEAD_AADHAR_NO= rs.getString("HEAD_AADHAR_NO");
	       String HEAD_NAME= rs.getString("HEAD_NAME");
	       String CONTACT_NO= rs.getString("CONTACT_NO");
	      
	       if(true) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {HOSPITAL_NAME,HOSPITAL_ID,NO_OF_STAFF,TYPE,HEAD_AADHAR_NO,HEAD_NAME,CONTACT_NO});
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
		new Hospital().setVisible(true);
	}
	
}
