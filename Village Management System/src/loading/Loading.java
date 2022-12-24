package loading;

import java.awt.*;
import javax.swing.*;

import dashboard.Dashboard;
public class Loading extends JFrame implements Runnable{
	JProgressBar p; //predefined class
	Thread t; //we need to make object of thread class to implement 
	JLabel l1,l2,l3;
	//start method calls the run method and we need to override the implemented function 
	@Override
	public void run() {
		try {
			for(int i = 0; i < 101; i++) {
				int m = p.getMaximum(); //
				int n = p.getValue(); //
			    if(n < m) {	
			    	p.setValue(p.getValue() + 1);
			    }else {
			    	i = 101;
			    	setVisible(false);
			    	new Dashboard().setVisible(true);
			    }
			    Thread.sleep(10);
			}
		}catch(Exception e) {
			
		}
		
	}
  public Loading(String user){
	  //to remove duplicacy we have written user insted of UserID
	 
	  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
 		Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
 		 ImageIcon i3 = new ImageIcon(i2);
 		 l2 = new JLabel(i3);
 		l2.setBounds(0,0,600,400);
 		add(l2);
	  
	  String UserID = "User";
	  t = new Thread(this); //need to declare the object of thread class
	  setBounds(480,220,550,400);
	  getContentPane().setBackground(new Color(255,255,204));	
	     setLayout(null);
	  
	  
	 JLabel l1 = new JLabel("Gram-E");
     l1.setBounds(180,20,600,38);
     l1.setFont(new Font("Railway",Font.BOLD,32));
     l1.setForeground(new Color(51,51,51));
     l2.add(l1);
     
     p = new JProgressBar();
     p.setStringPainted(true);
     p.setBounds(130,85,250,25);
     l2.add(p);
     
    
     
     JLabel l3 = new JLabel("Welcome" + UserID);
     l3.setBounds(50,290,120,30);
     l3.setFont(new Font("Railway",Font.BOLD,16));
     l3.setForeground(new Color(102,102,102));
     l2.add(l3);
     
     t.start(); //need to start to get the threading implementation
  }
	public static void main(String[] args) {
		new Loading("").setVisible(true);
		
     
	}
	

}
