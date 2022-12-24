package anganwadi;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import anganwadichildren.AnganwadiChildren;
import anganwadihead.AnganwadiHead;

public class Anganwadi extends JFrame implements ActionListener{
	JButton b1,b2;
	JLabel l10;
	public Anganwadi(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
		Image i2 = i1.getImage().getScaledInstance(550, 270, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
		 l10 = new JLabel(i3);
		l10.setBounds(0,0,550,270);
		add(l10);
		
	   	 setBounds(490,210,550,270);
	  	 // getContentPane().setBackground(new Color(255,255,204));
	  	  setLayout(null);
	 
	  	  
	  	 b1= new JButton("ANGANWADI HEAD");
	  	 b1.setBackground(new Color (153,153,153));
	       b1.setForeground(Color.WHITE);
	       b1.setBounds(70,50,180,65);
	       b1.addActionListener(this);
	      // b1.setBackground(new Color (0,0,0));
	       add(b1);
	       
	      b2= new JButton("ANGANWADI CHILDREN ");
	      b2.setBackground(new Color (153,153,153));
	      b2.setForeground(Color.WHITE);
	      b2.setBounds(290,50,190,65);
	     // b2.setBackground(new Color (0,0,0,0));
	      b2.addActionListener(this);
	      add(b2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			this.setVisible(false);
			new AnganwadiHead().setVisible(true);
		}else if(e.getSource() == b2) {
			this.setVisible(false);
			new AnganwadiChildren().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		
        new Anganwadi().setVisible(true);
   
	}

	

}


