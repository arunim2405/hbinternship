package daySixteen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAccount extends Customer {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewAccount frame = new ViewAccount();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ViewAccount() {
		setTitle("Account Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAccountDetails = new JLabel("Account Details");
		
		JLabel lblEnterPanCard = new JLabel("Enter Pan Card Number");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblAge = new JLabel("Age");
		
		JLabel lblBalance = new JLabel("Balance");
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection conn=null;
				try {
					conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				PreparedStatement stmt;								
				int panCardNo;				
				panCardNo=Integer.parseInt(textField.getText());
				String sql2 = "SELECT * FROM customerdetails WHERE pancard=?";
				PreparedStatement stmt2;
			      try {
					stmt2 = conn.prepareStatement(sql2);
					  stmt2.setInt(1,panCardNo);
					  ResultSet rs = stmt2.executeQuery();
					  if(rs.next())
				      {
						  String name=rs.getString("name");
				    	  int age=rs.getInt("age");
				    	  int balance=rs.getInt("balance");
				    	  label.setText(name);
				    	  label_1.setText(Integer.toString(age));
				    	  label_2.setText(Integer.toString(balance));
				    	  
				      }
					  else
					  {
						  label_3.setText("Account Not Found!");
						  label.setText("");
				    	  label_1.setText("");
				    	  label_2.setText("");
						  
					  }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(lblEnterPanCard))
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
							.addComponent(btnSubmit)
							.addGap(28))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addGap(18)
									.addComponent(label))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAge)
									.addGap(18)
									.addComponent(label_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBalance)
									.addGap(18)
									.addComponent(label_2)))
							.addContainerGap(349, Short.MAX_VALUE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(165)
					.addComponent(lblAccountDetails)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAccountDetails, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPanCard)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSubmit))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBalance)
						.addComponent(label_2))
					.addGap(30)
					.addComponent(label_3)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
