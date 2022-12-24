package dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import about.About;
import agriculture.Agriculture;
import anganwadi.Anganwadi;
import anganwadichildren.AnganwadiChildren;
import anganwadihead.AnganwadiHead;
import bank.Bank;
import hospital.Hospital;
import house.House;
import lpg.LPG;
import panchayat.Panchayat;
import pds.PDS;
import person.Person;



public class Dashboard extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
	JLabel l6;
      public Dashboard(){
    	  
    	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
     		Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
     		 ImageIcon i3 = new ImageIcon(i2);
     		 l6 = new JLabel(i3);
     		l6.setBounds(0,0,1400,700);
     		add(l6);
     		
    	  setExtendedState(JFrame.MAXIMIZED_BOTH);//will extends the size to full screen
    	 // getContentPane().setBackground(new Color(255,255,204));
    	  setLayout(null);
    	  
    	  
    	  JPanel p1 = new JPanel();
    	  p1.setLayout(null);
    	  p1.setBounds(0,0,1800,65);
    	  p1.setBackground(new Color(0,0,0,0));
         l6. add(p1);     
    	  
         
    	  
          JLabel l3 = new JLabel("Dashboard");
          l3.setBackground(new Color(0,0,0,0));
          l3.setFont(new Font("Tahoma",Font.BOLD,30));
          // l3.setForeground(new Color(255,204,0));
          l3.setBounds(570,7,180,50);
          l6.add(l3);
          
          JPanel p2 = new JPanel();
    	  p2.setLayout(null);
    	  p2.setBounds(0,65,300,900);
    	  p2.setBackground(new Color(0,0,0,0));
          l6.add(p2); 
          
          
          b1 = new JButton("HOUSE");
          b1.setBackground(new Color(102,102,102));
          b1.setFont(new Font("Tahoma",Font.BOLD,16));
          b1.setForeground(new Color(255,255,255));
          b1.setMargin( new Insets(0,0,0,180));;
          b1.setBounds(0,50,250,40);
          b1.addActionListener(this);
          p2.add(b1);
          
          b2 = new JButton("PERSON");
          b2.setBackground(new Color(102,102,102));
          b2.setFont(new Font("Tahoma",Font.BOLD,15));
          b2.setForeground(new Color(255,255,255));
          b2.setMargin(new Insets(0,0,0,180));
          b2.setBounds(0,100,250,40);
          b2.addActionListener(this);
          p2.add(b2);
          
           b3 = new JButton("PDS");
          b3.setBackground(new Color(102,102,102));
          b3.setFont(new Font("Tahoma",Font.BOLD,16));
          b3.setForeground(new Color(255,255,255));
          b3.setMargin(new Insets(0,0,0,190));
          b3.setBounds(0,150,250,40);
          b3.addActionListener(this);
          p2.add(b3);
          
          b4 = new JButton("LPG");
          b4.setBackground(new Color(102,102,102));
          b4.setFont(new Font("Tahoma",Font.BOLD,16));
          b4.setForeground(new Color(255,255,255));
          b4.setMargin(new Insets(0,0,0,190));
          b4.setBounds(0,200,250,40);
          b4.addActionListener(this);
          p2.add(b4);
          
          b5 = new JButton("BANK");
          b5.setBackground(new Color(102,102,102));
          b5.setFont(new Font("Tahoma",Font.BOLD,16));
          b5.setForeground(new Color(255,255,255));
          b5.setMargin(new Insets(0,0,0,180));
          b5.setBounds(0,250,250,40);
          b5.addActionListener(this);
          p2.add(b5);
          
          b6 = new JButton("AGRICULTURE");
          b6.setBackground(new Color(102,102,102));
          b6.setFont(new Font("Tahoma",Font.BOLD,14));
          b6.setForeground(new Color(255,255,255));
          b6.setMargin(new Insets(0,0,0,140));
          b6.setBounds(0,300,250,40);
          b6.addActionListener(this);
          p2.add(b6);
          
           b7 = new JButton("PANCHAYAT");
          b7.setBackground(new Color(102,102,102));
          b7.setFont(new Font("Tahoma",Font.BOLD,16));
          b7.setForeground(new Color(255,255,255));
          b7.setMargin(new Insets(0,0,0,140));
          b7.setBounds(0,350,250,40);
          b7.addActionListener(this);
          p2.add(b7);
          
          
         
          b9 = new JButton("SCHOOL");
          b9.setBackground(new Color(102,102,102));
          b9.setFont(new Font("Tahoma",Font.BOLD,16));
          b9.setForeground(new Color(255,255,255));
          b9.setMargin(new Insets(0,0,0,160));
          b9.setBounds(0,400,250,40);
          b9.addActionListener(this);
          p2.add(b9);
          
          b10 = new JButton("ANGANWADI ");
          b10.setBackground(new Color(102,102,102));
          b10.setFont(new Font("Tahoma",Font.BOLD,15));
          b10.setForeground(new Color(255,255,255));
          b10.setMargin(new Insets(0,0,0,140));
          b10.setBounds(0,455,250,40);
          b10.addActionListener(this);
          p2.add(b10);
          
          
          
           b12 = new JButton("HOSPITAL");
          b12.setBackground(new Color(102,102,102));
          b12.setFont(new Font("Tahoma",Font.BOLD,16));
          b12.setForeground(new Color(255,255,255));
          b12.setMargin(new Insets(0,0,0,140));
          b12.setBounds(0,515,250,40);
          b12.addActionListener(this);
          p2.add(b12);
          
        
          
          b13 = new JButton("ABOUT");
          b13.setBackground(new Color(102,102,102));
          b13.setFont(new Font("Tahoma",Font.BOLD,16));
          b13.setForeground(new Color(255,255,255));
          b13.setMargin(new Insets(0,0,0,140));
          b13.setBounds(0,570,250,40);
          b13.addActionListener(this);
          p2.add(b13);
          
          
    	  /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
    	  Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT );
    	  ImageIcon i3 =new ImageIcon(i2);
    	  JLabel l1 = new JLabel(i3);
    	  l1.setBounds(0,0,1950,1000);
    	  add(l1);*/
    	  
          
         /* JLabel l4 = new JLabel("Village Management System");
          l4.setBounds(600,100,1000,70);
          l4.setForeground(Color.WHITE);
          l4.setFont(new Font("Tahoma",Font.PLAIN,55));
          l1.add(l4);*/
          
    	  
      }
      
      

	@Override
  	public void actionPerformed(ActionEvent e) {
  		if(e.getSource()== b1) {
  			new House().setVisible(true);
  		}else if(e.getSource()== b2) {
  			new Person().setVisible(true);
  		}else if(e.getSource()== b3) {
  			new PDS().setVisible(true);
  		}else if(e.getSource()== b4) {
  			new LPG().setVisible(true);
  		}else if(e.getSource()== b5) {
  			new Bank().setVisible(true);
  		}else if(e.getSource()== b6) {
  			new Agriculture().setVisible(true);
  		}else if(e.getSource()== b7) {
  			new Panchayat().setVisible(true);
  		}else if(e.getSource()== b9) {
  			new schoolmain.School().setVisible(true);
  		}
  		else if(e.getSource()== b10) {
  			new Anganwadi().setVisible(true);
  		}else if(e.getSource()== b11) {
  			new AnganwadiChildren().setVisible(true);
  		}else if(e.getSource()== b12) {
  			new Hospital().setVisible(true);
  		}else if(e.getSource()== b13) {
  			new About().setVisible(true);
  		}
  		
  	}
      
	public static void main(String[] args) {
		
      new Dashboard().setVisible(true);
	}
	

}
