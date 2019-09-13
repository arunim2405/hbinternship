package dayFifteen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class Day15p2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Day15p2 frame = new Day15p2();
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
	public Day15p2() {
		setTitle("Welcome to Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnItem = new JMenu("item3");
		menuBar.add(mnItem);
		
		JMenuItem mntmItem_2 = new JMenuItem("item4");
		mnItem.add(mntmItem_2);
		
		JMenu mnItem_1 = new JMenu("item5");
		mnItem.add(mnItem_1);
		
		JCheckBoxMenuItem chckbxmntmCb = new JCheckBoxMenuItem("cb1");
		mnItem_1.add(chckbxmntmCb);
		
		JCheckBoxMenuItem chckbxmntmCb_1 = new JCheckBoxMenuItem("cb2");
		mnItem_1.add(chckbxmntmCb_1);
		
		JMenuItem mntmItem_1 = new JMenuItem("Item2");
		mntmItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Working1");
			}
		});
		menuBar.add(mntmItem_1);
		
		JMenuItem mntmItem = new JMenuItem("Item1");
		menuBar.add(mntmItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(new GridLayout());
		
		JList list = new JList();
	
		//scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"hi", "bye", "hello", "io", "oio", "ipipipi", "jopujoh", "igblv", "hihh", "pppp", "yyy", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//	scrollPane.setViewportView(list);
		scrollPane.setMinimumSize(new Dimension(100, 50));
			contentPane.add(list, "cell 0 0,alignx left,growy");
			
		
	}

}
