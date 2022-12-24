package anganwadihead;

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

public class AnganwadiHead extends JFrame implements ActionListener {
  JTextField t1,t2,t3;
  JButton b1,b2;
  int flag = 0;
  JLabel l10;
	public AnganwadiHead(){
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 280, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,280);
		add(l10);
		
   	 setBounds(450,200,550,280);
  	  //getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	JLabel l4 =new JLabel("ANGANWADI HEAD DETAILS");
	  l4.setBounds(90,5,270,25);
	  l4.setFont(new Font("Taboma",Font.BOLD,19));
	 l10. add(l4);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,430,220);
	  p.setBackground(new Color (0,0,0,0));
	 l10. add(p);
	  
	    
	  JLabel l1 =new JLabel("Centre Number");
	  l1.setBounds(30,50,200,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,18));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(250,50,150,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
    p.add(t1);
    
   /* JLabel l2 =new JLabel(" Holder Name");
	   l2.setBounds(30,100,200,25);
	   l2.setFont(new Font("Taboma",Font.PLAIN,18));
  p.add(l2);
	 	 
  t2 = new JTextField();
	   t2.setBounds(250,100,150,30);
	   t2.setBorder(BorderFactory.createEmptyBorder());
  p.add(t2);*/
 
    
   
     
     b1= new JButton("Search");
     b1.setBackground(new Color (102,102,102));
     b1.setForeground(Color.WHITE);
     b1.setBounds(125,180,80,25);
     b1.addActionListener(this);
     add(b1);
     
    b2= new JButton("ADD");
    b2.setBackground(new Color (102,102,102));
    b2.setForeground(Color.WHITE);
    b2.setBounds(288,180,80,25);
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
         new AddAnganwadiHead().setVisible(true);
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
		   defaultTableModel.addColumn("CENTRE_NO");
		   defaultTableModel.addColumn("HELPER_NAME");
		   defaultTableModel.addColumn("HELPER_AADHAR_NO");
		   defaultTableModel.addColumn("ADDRESS");
		
		  /* CREATE TABLE ANGANVADI_HEAD
		   (
		   CENTRE_NO INT PRIMARY KEY,
		   HELPER_NAME VARCHAR(30),
		   HELPER_AADHAR_NO CHAR(12),
		   ADDRESS VARCHAR(50),
		   CONSTRAINT FK11 FOREIGN KEY(HELPER_AADHAR_NO) REFERENCES PERSON(AADHAR_NO)
		   );*/
		   
		   try{
	            Conn c = new Conn();
	          String sql =("SELECT *\r\n"
	          		+ "FROM ANGANVADI_HEAD\r\n"
	          		+ "WHERE CENTRE_NO='"+t1.getText()+"';");
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String CENTRE_NO = rs.getString("CENTRE_NO");
	       String HELPER_NAME= rs.getString("HELPER_NAME");
	       String HELPER_AADHAR_NO= rs.getString("HELPER_AADHAR_NO");
	       String ADDRESS= rs.getString("ADDRESS");
	      // if(userName.equalsIgnoreCase(CENTRENAME)) {
	       if(true) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {CENTRE_NO,HELPER_NAME,HELPER_AADHAR_NO,ADDRESS});
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
		try {
		new AnganwadiHead().setVisible(true);

	}catch(Exception e) {
		e.printStackTrace();
	}

}
}
