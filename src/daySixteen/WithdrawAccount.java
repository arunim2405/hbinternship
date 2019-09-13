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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawAccount extends Customer {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WithdrawAccount frame = new WithdrawAccount();
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
	public WithdrawAccount() {
		setTitle("Withdraw Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWithdrawFromAccount = new JLabel("Withdraw from Account");
		
		JLabel lblPanCardNumber = new JLabel("Pan Card Number");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAmountToWithdraw = new JLabel("Amount to withdraw");
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setColumns(10);
		
		JLabel lblBalanceAfterWithdrawal = new JLabel("Balance after Withdrawal");
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("");
		
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
				int wAmount=Integer.parseInt(textField_1.getText());;
				String sql2 = "SELECT * FROM customerdetails WHERE pancard=?";
				PreparedStatement stmt2;
			      try {
					stmt2 = conn.prepareStatement(sql2);
					  stmt2.setInt(1,panCardNo);
					  ResultSet rs = stmt2.executeQuery();
					  if(rs.next())
				      {
						  lblNewLabel.setText(" ");
				    	 
				    	  int balance=rs.getInt("balance");
				    	  if(wAmount > balance)
				    	   {
				    		   System.out.println("Not Enough Balance!");
				    		   lblNewLabel.setText("Not Enough Balance!");
				    	   }
				    	   else
				    	   {
				    		   int  newbalance= balance-wAmount;
				    		   String sql3="UPDATE customerdetails SET balance=? WHERE pancard=?";
				    		   PreparedStatement stmt3;
				    		      stmt3 = conn.prepareStatement(sql3);
				    		      stmt3.setInt(1, newbalance);
				    		      stmt3.setInt(2, panCardNo);
				    		      stmt3.executeUpdate();    		 
				    		      label.setText(Integer.toString(newbalance));
				    		      System.out.println("New Balance is : " + newbalance);
				    		      stmt3.close();
				    	   }
				    	  rs.close();
				  		stmt2.close();
				  		conn.close();
				      }
					  else
					  {
						  lblNewLabel.setText("Account Not Found!");
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBalanceAfterWithdrawal)
									.addGap(18)
									.addComponent(label))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblPanCardNumber)
										.addComponent(lblAmountToWithdraw, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(156)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel))
								.addComponent(btnSubmit)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(lblWithdrawFromAccount, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(136, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWithdrawFromAccount, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPanCardNumber)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmountToWithdraw, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBalanceAfterWithdrawal)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(9)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}

}
