package firstpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import login.Login;

public class firstpage  extends JFrame implements Runnable{
	Thread t1;
	JLabel l1;
    firstpage(){
    	
    	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BG/village.JPG"));
    	Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
    	 ImageIcon i3 = new ImageIcon(i2);
    	 l1 = new JLabel(i3);
    	//l1.setBounds(100,120,500,400);
    	add(l1);
    	
    	
    	
    	JLabel l8 =new JLabel("Gram-E ");
   	  l8.setBounds(20,130,550,150);
   	  //l8.setBackground(new Color(130,5,200,25));
   	  l8.setForeground(new Color (51,51,51));
   	  l8.setFont(new Font("Taboma",Font.BOLD,100));
   	  l8.setLayout(null);
   	  l1.add(l8);
   	  
    	setBounds(250,100,700,500);
    	
    	/*getContentPane().setBackground(new Color(255,255,204));
    	  setLayout(null);*/
    	
    	 
      	  
    	setUndecorated(true);
    	t1 =new Thread(this);
    	t1.start();
    }
    @Override
	public void run() {
    	try {
		Thread.sleep(6000);		
		this.setVisible(false);
		
		new Login().setVisible(true);
	}catch(Exception e) {};
    }
    
	public static void main(String[] args) {
		firstpage frame = new firstpage();
	
		
		 
     		frame.setVisible(true);
		
		int x = 1;
		for(int i=1; i <= 500; i+=7 ,x+=9) {
			frame.setLocation(740 -(x +1)/2, 350 - (i/2));
			frame.setSize(x +2, i); //+1
			try {
				Thread.sleep(20);
			}catch(Exception e) {};
		}
		frame.setVisible(true);

	}
	

}
