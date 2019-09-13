package dayTwenty;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;

public class ChatServer extends JFrame {
	
	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private JButton btnConnect;

   static ServerSocket ssckt;  
   static Socket sckt;  
    static InputStream dtinpt;  
    static OutputStream dtotpt;  
    static PrintWriter pw;
    static int flag=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ChatServer frame = new ChatServer();
					frame.setVisible(true);
			        
					//        String msgin = ""; 
				          
				         

					                       
				                              // reading from keyboard (keyRead object)
				
				      
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static InputStream gettext1()
	{
		String str;
		str=textField_1.getText();
		InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		return stream;
	}
	public ChatServer() {
		JProgressBar progressBar = new JProgressBar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblServer = new JLabel("Server");		
		textField = new JTextField();
		textField.setColumns(10);		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override			
			public void mouseClicked(MouseEvent arg0) {
				try
				{ 	
					progressBar.setIndeterminate(true);
					ssckt = new ServerSocket(1201);  
		        sckt = new Socket();
					
					sckt=ssckt.accept();
				//	progressBar.setIndeterminate(false);
					System.out.println("Connected! from server");
					flag=1;				        
			            dtinpt = new DataInputStream(sckt.getInputStream());  
				            dtotpt = new DataOutputStream(sckt.getOutputStream());  				         
//				 ServerSocket sersock = new ServerSocket(3000);
//			      System.out.println("Server  ready for chatting");
//			      Socket sock = sersock.accept( );  
//			    InputStreamReader in=  new InputStreamReader(gettext1());
//			      BufferedReader keyRead = new BufferedReader(in);		                     
//			      OutputStream ostream = sock.getOutputStream(); 
//			      pwrite = new PrintWriter(ostream, true);
//			       istream = sock.getInputStream();
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
		});
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				//	InputStream is;
					
					 pw=new PrintWriter(dtotpt);
			    String msgout = textField_1.getText();  
			        textField.setText("\n"+textField.getText()+"\nServer: " +msgout);
			        pw.println(textField_1.getText());  
			        pw.flush();
		      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(dtinpt));
//			      String receiveMessage, sendMessage=null; 
//			      sendMessage =textField_1.getText(); 
//			      textField.setText("Server: "+sendMessage); 
//			      receiveMessage = receiveRead.readLine();
//			     
//			      
//			        if((receiveMessage = receiveRead.readLine()) != null)  
//			        {
//			           textField.setText("Client: "+receiveMessage);        
//			        }         
//			     
//			        pwrite.println(sendMessage);        
//			        textField.setText("Server: "+sendMessage); 
//			        pwrite.flush();
			        String msgin="";
			        System.out.print("waiting");
			        
			      
		                msgin =receiveRead.readLine();  
		                textField.setText("\n"+textField.getText()+" Server: " +textField_1.getText().trim()+" \n Client:"+msgin);  
		            
			      
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_1)
									.addGap(18)
									.addComponent(btnNewButton))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(159)
							.addComponent(lblServer, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConnect))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(119)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServer, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConnect))
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
