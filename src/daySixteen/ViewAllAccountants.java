package daySixteen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Window.Type;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllAccountants extends Accountant {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewAllAccounts frame = new ViewAllAccounts();
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
	public ViewAllAccountants() {
		
		String[] columnNames = {"Name", "Accountant ID", "Salary",""};
		setTitle("All Accountants");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection conn=null;
				try {
					((DefaultTableModel)table.getModel()).setRowCount(0);
					
					conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
					String sql = "SELECT * FROM accountantdetails";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next())
					{
					
					String name = rs.getString("name");
					int accountantid = rs.getInt("accountantid");
					int salary = rs.getInt("salary");
					//int balance = rs.getInt("balance"); 
					model.addRow(new Object[]{name,accountantid, salary});
					
					
					}
				} catch (SQLException e) {
					
					System.out.println(e);
				}
			
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(159)
					.addComponent(btnRefresh))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(btnRefresh)
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(202))
		);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(model);
		//		table.setModel(new DefaultTableModel(
		//			new Object[][] {
		//			},
		//			new String[] {
		//				"Name", "Age", "Pan Card No", "Balance"
		//			}
		//		)); 
				table.getColumnModel().getColumn(0).setPreferredWidth(232);
				table.getColumnModel().getColumn(1).setPreferredWidth(105);
				table.getColumnModel().getColumn(2).setPreferredWidth(147);
				table.getColumnModel().getColumn(3).setPreferredWidth(138);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				table.setFillsViewportHeight(true);
		contentPane.setLayout(gl_contentPane);
	}
}
