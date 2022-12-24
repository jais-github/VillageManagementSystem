package agriculture;

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

public class Agriculture extends JFrame implements ActionListener{
 JTextField t1,t2,t3,t4;
 JButton b1,b2;
 JLabel l10;
 int flag = 0;
	public Agriculture(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 290, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,290);
		add(l10);
		
   	 setBounds(450,200,550,290);
  	  //getContentPane().setBackground(new Color(255,255,204));
  	  setLayout(null);
  	  
  	 JLabel l5 =new JLabel("AGRICULTURE DETAILS");
	  l5.setBounds(130,4,400,25);
	  l5.setFont(new Font("Taboma",Font.BOLD,20));
	  l10.add(l5);
  	  
  	 JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,30,430,200);
	  p.setBackground(new Color (0,0,0,0));
	  l10.add(p);
	    
	  JLabel l1 =new JLabel("NAME");
	  l1.setBounds(30,50,200,25);
	  l1.setFont(new Font("Taboma",Font.BOLD,18));
	  p.add(l1);
	 
	  t1 = new JTextField();
	  t1.setBounds(250,50,150,30);
	  t1.setBorder(BorderFactory.createEmptyBorder());
     p.add(t1);
     
	   JLabel l2 =new JLabel("HOUSE NUMBER");
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
      b1.setBounds(200,190,100,25);
      b1.addActionListener(this);
      add(b1);
      
      b2= new JButton("ADD");
      b2.setBackground(new Color (102,102,102));
      b2.setForeground(Color.WHITE);
      b2.setBounds(320,190,80,25);
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
          new AddAgriculture().setVisible(true);
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
		   defaultTableModel.addColumn("AADHAR_NO");
		   defaultTableModel.addColumn("CROP");
		   defaultTableModel.addColumn("TYPE");
		   defaultTableModel.addColumn("TOTAL_PRODUCTION");
		   
		   try{
	            Conn c = new Conn();
	          String sql =("SELECT NAME,A.AADHAR_NO,CROP,TYPE,TOTAL_PRODUCTION\r\n"
	          		+ "FROM AGRICULTURE A,PERSON P\r\n"
	          		+ "WHERE A.AADHAR_NO=P.AADHAR_NO AND P.NAME='"+t1.getText()+"' AND P.HOUSE_NO='"+t2.getText()+"';\r\n"
	          		+ "\r\n"
	          		+ "");
	            ResultSet rs = c.s.executeQuery(sql);
	      while(rs.next()){
	    	  //retrieving details from the database and storing it in the string variable
	        String NAME = rs.getString("NAME");
	       String AADHAR_NO= rs.getString("AADHAR_NO");
	       String CROP= rs.getString("CROP");
	       String TYPE= rs.getString("TYPE");
	       String TOTAL_PRODUCTION= rs.getString("TOTAL_PRODUCTION");
	     //  if(userName.equalsIgnoreCase(HOUSENUMBER)) {
	       if(true) {
	    	    flag = 1;
	    	   defaultTableModel.addRow(new Object[] {NAME,AADHAR_NO,CROP,TYPE,TOTAL_PRODUCTION});
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
	  	
     new Agriculture().setVisible(true);
	}

}
