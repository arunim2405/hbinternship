package dayTwenty;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ChatClient extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField textField_1;
	private JButton btnConnect;
	//static InputStream istream;
	static PrintWriter pwrite;
	static OutputStream ostream;
	static Socket sock ;
	static InputStream	 istream;
	static int flag=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient frame = new ChatClient();
					frame.setVisible(true);
					
							
						
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public static String gettext1()
	{
		String str;
		str=textField_1.getText();
		
		//InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		//System.out.println(stream);
		return str;
	}
	public ChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClient = new JLabel("Client");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 try {
					sock = new Socket("127.0.0.1", 1201);
					System.out.println("Connected! from from Client");
					flag=1;
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			
		});

		JButton btnSend = new JButton("Send");
	
		btnSend.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
				
					  ostream =  sock.getOutputStream(); 
					  pwrite = new PrintWriter(ostream, true);

	                // receiving from server ( receiveRead  object)
					 istream =  sock.getInputStream();
//System.out.println("Start the chitchat, type and press Enter key");

   



String sendMessage =textField_1.getText();  
textField.setText("\n"+textField.getText()+"\nClient: " +sendMessage);   // keyboard reading
//byte[] buff= sendMessage.getBytes();
//ostream.write(buff, 0, buff.length);

pwrite.println(sendMessage);  
pwrite.flush();  
	
try {
	String msgin = "";  
	//while(!msgin.equals("Exit")&&flag==1)  
	  System.out.print(".");
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
	    msgin= receiveRead.readLine();  
	    textField.setText("\n"+textField.getText().trim()+"\n Server:"+msgin);  
	    
	 
     // reading from keyboard (keyRead object)
	// BufferedReader keyRead = new BufferedReader(new InputStreamReader(gettext1()));
    // sending to client (pwrite object)
	
	
	}catch(Exception e)
	{
	}
//if((receiveMessage = receiveRead.readLine()) != null) //receive from server
//{
//	textField.setText("Server: " +receiveMessage);
//System.out.println(receiveMessage); // displaying at DOS prompt
//}   


					}catch (Exception e)
				{
						e.printStackTrace();
				}
			}
		});
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(178)
					.addComponent(lblClient)
					.addGap(18)
					.addComponent(btnConnect)
					.addContainerGap(112, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSend))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblClient)
						.addComponent(btnConnect))
					.addGap(39)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
