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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accountant extends Customer {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Accountant frame = new Accountant();
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
	public Accountant() {
		setTitle("Accountant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAccountant = new JLabel("Accountant");
		
		JButton btnNewCustomerAccount = new JButton("New Customer Account");
		btnNewCustomerAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewAccount frame = new NewAccount();
				frame.setVisible(true);
			}
		});
		
		JButton btnViewParticularCustomer = new JButton("View Particular Customer Account");
		btnViewParticularCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAccount vw= new ViewAccount();
				vw.setVisible(true);
			}
		});
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				WithdrawAccount wa=new WithdrawAccount();
				wa.setVisible(true);
				
			}
		});
		
		JButton btnAddBalanceTo = new JButton("Add Balance to Customer Account");
		btnAddBalanceTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddBal ab=new AddBal();
				ab.setVisible(true);
			}
		});
		
		JButton btnDeleteACutomer = new JButton("Delete a Cutomer Account");
		btnDeleteACutomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DeleteAccount da=new DeleteAccount();
				da.setVisible(true);
			}
		});
		
		JButton btnViewAllCustomer = new JButton("View All Customer Accounts");
		btnViewAllCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAllAccounts vaa=new ViewAllAccounts();
				vaa.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewCustomerAccount)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(lblAccountant)
									.addContainerGap(188, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddBalanceTo)
										.addComponent(btnViewParticularCustomer)
										.addComponent(btnViewAllCustomer))
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnWithdraw)
							.addContainerGap(335, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDeleteACutomer)
							.addContainerGap(255, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAccountant)
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewCustomerAccount)
						.addComponent(btnViewParticularCustomer))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnWithdraw)
						.addComponent(btnAddBalanceTo))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteACutomer)
						.addComponent(btnViewAllCustomer))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
