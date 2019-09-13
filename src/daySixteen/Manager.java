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

public class Manager extends Day16 {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Manager frame = new Manager();
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
	public Manager() {
		setTitle("Manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblManager = new JLabel("Manager");
		
		JButton btnAccountantControls = new JButton("Accountant Controls");
		btnAccountantControls.setToolTipText("Click this button to open Options as an Accountant");
		btnAccountantControls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Accountant acx=new Accountant();
				acx.setVisible(true);
			}
		});
		
		JButton btnNewAccountant = new JButton("New Accountant");
		btnNewAccountant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddAccountant aan = new AddAccountant();
				aan.setVisible(true);
			}
		});
		
		JButton btnDeleteAccountant = new JButton("Delete Accountant");
		btnDeleteAccountant.setToolTipText("");
		btnDeleteAccountant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DeleteAccountant da=new DeleteAccountant();
				da.setVisible(true);
			}
		});
		
		JButton btnViewAllAccountants = new JButton("View All Accountants");
		btnViewAllAccountants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ViewAllAccountants vaa=new ViewAllAccountants();
				vaa.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(179)
					.addComponent(lblManager)
					.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAccountantControls)
						.addComponent(btnDeleteAccountant))
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnViewAllAccountants)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewAccountant)
							.addGap(87))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblManager)
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAccountantControls)
						.addComponent(btnNewAccountant))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteAccountant)
						.addComponent(btnViewAllAccountants))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
