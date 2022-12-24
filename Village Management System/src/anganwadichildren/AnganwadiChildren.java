package anganwadichildren;

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

public class AnganwadiChildren extends JFrame implements ActionListener{
   JTextField t1,t2,t3,t4;
   JButton b1,b2;
   JLabel l10;
   int flag = 0;
	public AnganwadiChildren(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 290, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,290);
		add(l10);
		
   	 setBounds(450,200,550,290);
  	 // getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	 JLabel l5 =new JLabel("ANGANWADI CHILDREN ");
	  l5.setBounds(130,5,400,25);
	  l5.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l5);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,500,200);
	  p.setBackground(new Color (0,0,0,0));
	  l10.add(p);
	    
	  
    
	   JLabel l2 =new JLabel("Name");
	   l2.setBounds(30,50,200,25);
	   l2.setFont(new Font("Taboma",Font.BOLD,18));
     p.add(l2);
	 	 
     t2 = new JTextField();
	   t2.setBounds(250,50,150,30);
	   t2.setBorder(BorderFactory.createEmptyBorder());
     p.add(t2);
    
    
   
     JLabel l4 =new JLabel("Centre Number");
	   l4.setBounds(30,100,200,25);
	   l4.setFont(new Font("Taboma",Font.BOLD,18));
     p.add(l4);
	 	 
     t4 = new JTextField();
	   t4.setBounds(250,100,150,30);
	   t4.setBorder(BorderFactory.createEmptyBorder());
     p.add(t4);
     
    
     b1= new JButton("Search");
     b1.setBackground(new Color (102,102,102));
     b1.setForeground(Color.WHITE);
     b1.setBounds(155,175,80,25);
     b1.addActionListener(this);
     add(b1);
     
    b2= new JButton("ADD");
    b2.setBackground(new Color (102,102,102));
    b2.setForeground(Color.WHITE);
    b2.setBounds(288,175,80,25);
    b2.addActionListener(this);
    add(b2);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
 		{
			String userName = t2.getText().toString();
  			frameSecond(userName);	
 		}else if(e.getSource()==b2) {
 	         this.setVisible(false);
 	         new AddAnganwadiChildren().setVisible(true);
 		}
	}
	
	
	public void frameSecond( String userName) {
		  //setting the properties of second JFrame
		  JFrame frame2 = new JFrame("DATABASE RESULTS");
		  frame2.setLayout(new FlowLayout());
		  frame2.setSize(440, 350);
		  frame2.setLocation(550, 200);

		  //setting the properties of JTable and DefaultTableModel
		  DefaultTableModel defaultTableModel = new DefaultTableModel();
		   JTable table = new JTable(defaultTableModel);
		   table.setPreferredScrollableViewportSize(new Dimension(350,150));
		   table.setFillsViewportHeight(true);
		   frame2.add(new JScrollPane(table));
		   defaultTableModel.addColumn("BIRTH_CERTIFICATE_NO");
		   defaultTableModel.addColumn("CNAME");
		   defaultTableModel.addColumn("GUARDIAN_NAME");
		   defaultTableModel.addColumn("CENTRE_NO");
		   
		   try{
	            Conn c = new Conn();
	          String sql =("SELECT BIRTH_CERTIFICATE_NO,CNAME,P.NAME AS GUARDIAN_NAME,CENTRE_NO\r\n"
	          		+ "FROM PERSON P,ANGANVADI_CHILDREN AC\r\n"
	          		+ "WHERE AC.GAADHAR_NO=P.AADHAR_NO AND CNAME='"+t2.getText()+"' AND CENTRE_NO='"+t4.getText()+"';");
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String BIRTH_CERTIFICATE_NO = rs.getString("BIRTH_CERTIFICATE_NO");
	       String CNAME= rs.getString("CNAME");
	       String GUARDIAN_NAME= rs.getString("GUARDIAN_NAME");
	       String CENTRE_NO= rs.getString("CENTRE_NO");
	      // if(userName.equalsIgnoreCase(NAME)) {
	       if(true) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {BIRTH_CERTIFICATE_NO,CNAME,GUARDIAN_NAME,CENTRE_NO});
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
		new AnganwadiChildren().setVisible(true);
	}
	

}
