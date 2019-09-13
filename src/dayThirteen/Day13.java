package dayThirteen;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class Day13 extends JFrame implements ActionListener {
	  JTextField tf; JLabel l; JButton b;  
	    Day13(){  
	        tf=new JTextField();  
	        tf.setBounds(50,50, 150,20);  
	        l=new JLabel();  
	        l.setBounds(50,100, 250,20);      
	        b=new JButton("My name is Arunim");  
	        b.setBounds(50,150,330,30);  
	        b.addActionListener(this);    
	        add(b);add(tf);add(l);    
	        setSize(400,400);  
	        setLayout(null);  
	        setVisible(true);  
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	public static void main (String[] args)
	{
		System.out.println("Hello World using Swing!");
		  new Day13();
		  
	  
	    }  
		
	

	
	 public void actionPerformed(ActionEvent e) {  
	        try{  
	        String host=tf.getText();  
	        String ip=java.net.InetAddress.getByName(host).getHostAddress();  
	        l.setText("IP of "+host+" is: "+ip);  
	        }catch(Exception ex){System.out.println(ex);} 
}
}
