package lpg;

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

public class LPG extends JFrame implements ActionListener{
  JTextField t1,t2,t3;
  JButton b1,b2;
  JLabel l10;
  int flag = 0;
	public LPG(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 280, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,280);
		add(l10);
		
   	 setBounds(450,200,550,290);
  	  //getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	 JLabel l4 =new JLabel("LPG DETAILS");
	  l4.setBounds(130,5,200,25);
	  l4.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l4);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,430,200);
	  p.setBackground(new Color (0,0,0,0));
	  l10. add(p);
	    
	  JLabel l1 =new JLabel("Name");
	  l1.setBounds(30,50,200,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,18));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(250,50,150,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
     p.add(t1);
     
	  
     
      JLabel l3 =new JLabel("House Number");
	   l3.setBounds(30,100,200,25);
	   l3.setFont(new Font("Taboma",Font.BOLD,18));
      p.add(l3);
	 	 
      t3= new JTextField();
	   t3.setBounds(250,100,150,30);
	   t3.setBorder(BorderFactory.createEmptyBorder());
      p.add(t3);
    
      
      b1= new JButton("SEARCH");
      b1.setBackground(new Color (102,102,102));
      b1.setForeground(Color.WHITE);
      b1.setBounds(170,180,100,25);
      b1.addActionListener(this);
      add(b1);
      
      b2= new JButton("ADD");
      b2.setBackground(new Color (102,102,102));
      b2.setForeground(Color.WHITE);
      b2.setBounds(290,180,80,25);
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
      		}else if(e.getSource()==b2) {
      				this.setVisible(false);
      				new AddLPG().setVisible(true);
      			}}
 		
 		
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
 			   defaultTableModel.addColumn("CONNECTION_ID");
 			  defaultTableModel.addColumn("AADHAR_NO");
 			 defaultTableModel.addColumn("AGENCY_NAME");
 			   
 			   
 			  try{
 		            Conn c = new Conn();
 		          String sql =("SELECT NAME,CONNECTION_ID,P.AADHAR_NO AS AADHAR_NO,AGENCY_NAME\r\n"
 		          		+ "FROM LPG L,PERSON P\r\n"
 		          		+ "WHERE P.AADHAR_NO=L.AADHAR_NO AND P.NAME='"+t1.getText()+"' AND P.HOUSE_NO='"+t3.getText()+"';\r\n"
 		          		+ "");
 		            ResultSet rs = c.s.executeQuery(sql);
 		           while(rs.next()){
 		        	   
 		        	  //retrieving details from the database and storing it in the string variable
 		            String NAME = rs.getString("NAME");
 		           String CONNECTION_ID= rs.getString("CONNECTION_ID");
 		          String AADHAR_NO= rs.getString("AADHAR_NO");
 		         String AGENCY_NAME= rs.getString("AGENCY_NAME");
 		          // if(userName.equalsIgnoreCase(NAME)) {
 		         if(true) {
 		      	    flag = 1;
 		      	   defaultTableModel.addRow(new Object[] {NAME,CONNECTION_ID,AADHAR_NO,AGENCY_NAME});
 		      	 
 		      	   // new House().setVisible(false);
 		      	   frame2.setVisible(true);
 		      	  
 		      	   frame2.validate();
 		      	   break;
 		         }
 		         }
 		          if(flag == 0) {
 		      	   JOptionPane.showMessageDialog(null, "No Such NAME Found");
 		         }
 		  		}
 		        catch(Exception e1){
 		          e1.printStackTrace();
 		               }
 		  		
 		    }
 		           

	
	public static void main(String[] args) {
		new LPG().setVisible(true);

	}

}
