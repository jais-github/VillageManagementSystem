package house;

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
import net.proteanit.sql.DbUtils;

public class House extends JFrame implements ActionListener{
	JTextField t1,t2;
	JButton b1,b2;
	int flag = 0;
	JLabel l1,l2,l3;
  //	JTable table;
   public House(){
	   
	   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(600, 250, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l3 = new JLabel(i3);
		l3.setBounds(0,0,600,250);
		add(l3);
	   
	  setBounds(450,180,610,280);
	 // getContentPane().setBackground(new Color(255,255,204));
	  setLayout(null);
	  
	  JLabel l1 =new JLabel("HOUSE DETAILS");
 	  l1.setBounds(220,30,200,25);
 	  l1.setFont(new Font("Taboma",Font.BOLD,20));
 	 l1.setForeground(new Color (51,51,51));
 	  l3.add(l1);
	
	  JPanel p = new JPanel();
	  p.setLayout(null);
	  p.setBounds(30,40,400,150);
	  p.setBackground(new Color (0,0,0,0));
	 l3. add(p);
	  
	  
	  JLabel l2 =new JLabel("House Number");
 	  l2.setBounds(30,50,200,25);
 	  l2.setFont(new Font("Taboma",Font.BOLD,18));
 	  p.add(l2);
 	 
 	  t1 = new JTextField();
 	  t1.setBounds(180,50,150,30);
 	  t1.setBorder(BorderFactory.createEmptyBorder());
      p. add(t1);
       
	  
       
      b1 = new JButton("Search");
      b1.setBackground(new Color (102,102,102));
 	  b1.setForeground(Color.WHITE);
 	  b1.setBounds(280,94,90,25);
 	 b1.addActionListener(this);
 	  p.add(b1);
 	  
 	 b2 = new JButton("ADD");
 	 b2.setBackground(new Color (102,102,102));
	  b2.setForeground(Color.WHITE);
	  b2.setBounds(150,94,90,25);
	 b2.addActionListener(this);
	  p.add(b2);
 	  
 	  
 	 
	  
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
      				new ADDHOUSE().setVisible(true);
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
	   defaultTableModel.addColumn("HOUSE_NO");
	   defaultTableModel.addColumn("ADDRESS");
	   defaultTableModel.addColumn("NO_OF_PEOPLE");
	   
		try{
            Conn c = new Conn();
         
            String sql =("SELECT H.HOUSE_NO,ADDRESS,COUNT(P.HOUSE_NO) AS NO_OF_PEOPLE\r\n"
            		+ "FROM HOUSE H,PERSON P\r\n"
            		+ "WHERE H.HOUSE_NO=P.HOUSE_NO AND H.HOUSE_NO='"+t1.getText()+"'\r\n"
            		+ "GROUP BY P.HOUSE_NO;");
            ResultSet rs = c.s.executeQuery(sql);
      while(rs.next()){
    	  
    	  //retrieving details from the database and storing it in the string variable
       String HOUSE_NO = rs.getString("HOUSE_NO");
       String ADDRESS= rs.getString("Address");
       String NO_OF_PEOPLE= rs.getString("NO_OF_PEOPLE");
    	 
       
     //if(userName.equalsIgnoreCase(HOUSENUMBER)) {
    	 if(true) {
    	  
    	    flag = 1;
    	   // System.out.println("in if");
    	   defaultTableModel.addRow(new Object[] {HOUSE_NO,ADDRESS,NO_OF_PEOPLE});
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
		new House().setVisible(true);
	}catch(Exception e2) {
		e2.printStackTrace();
	}
	

}
}
