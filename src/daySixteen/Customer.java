package daySixteen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Customer extends Day16 {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Customer frame = new Customer();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	

	/**
	 * Create the frame.
	 */
	public Customer() {
		setTitle("Customer");
		
		// in.setTitle("New Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCustomer = new JLabel("Welcome, Please select the option");
		
		JButton btnNewAccount = new JButton("New Account");
		btnNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				 
				NewAccount frame = new NewAccount();
				frame.setVisible(true);
				 
				 
				 
				
				 
				 
			}
			 
		});
		
		JButton btnAccountDetails = new JButton("Account Details");
		btnAccountDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAccount vw= new ViewAccount();
				vw.setVisible(true);
			}
		});
		
		JButton btnWithdrawal = new JButton("Withdrawal");
		btnWithdrawal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				WithdrawAccount wa=new WithdrawAccount();
				wa.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(btnWithdrawal)
					.addGap(143))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addComponent(btnNewAccount)
					.addContainerGap(237, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCustomer, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAccountDetails))
					.addGap(41))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(lblCustomer, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAccountDetails)
						.addComponent(btnNewAccount))
					.addGap(26)
					.addComponent(btnWithdrawal)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
