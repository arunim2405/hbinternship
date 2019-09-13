package dayFourteen;
import java.awt.*;  
import java.awt.event.*;  
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Day14p2 extends JFrame {
	public Day14p2() {
	}
	private static final ActionListener ActionListener = null;
	int value=0;
	private JPanel contentPane;
    JFrame f= new JFrame("Menu and MenuItem Example");  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Day14p2 frame = new Day14p2();
					frame.setVisible(true);
					frame.Dday14p2();
				    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 */
	
	 JMenuItem i1=new JMenuItem("Item 1"); 
	 
	 
	 
	@SuppressWarnings("unchecked")
	public  void Dday14p2() {
		JLabel lblNewLabel = new JLabel("New label");
		setTitle("Hi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenu menu=new JMenu("Menu");  
       JMenu submenu=new JMenu("Sub Menu");  
       
//       i1.addMouseListener(new MouseAdapter() {
//    	   @Override
//       	public void mouseClicked(MouseEvent arg0) {
//       		
//       		
//       		lblNewLabel.setText("First");
//       		System.out.println("Surpri2se!");
//       		
//       	}
    //   });
   i1.addMouseListener(new MouseAdapter()
		   {
	   public void mouseClicked(MouseEvent arg0)
	   {
		   System.out.println("Working");
	   }
	});  
	
       JMenuItem   i2=new JMenuItem("Item 2");  
       JMenuItem   i3=new JMenuItem("Item 3");  
       JMenuItem  i4=new JMenuItem("Item 4");  
       JMenuItem  i5=new JMenuItem("Item 5");  
       JMenuBar mb=new JMenuBar();  
       menu.add(i1); menu.add(i2); menu.add(i3);  
       submenu.add(i4); submenu.add(i5);  
       menu.add(submenu);  
     mb.add(menu);  
//       f.setJMenuBar(mb);  
//       f.setSize(400,400);  
//       f.getContentPane().setLayout(null);  
//       f.setVisible(true);  
		
		JMenuBar menuBar = new JMenuBar();
		
		setJMenuBar(mb);
		setSize(400,400);  
        getContentPane().setLayout(null);  
        setVisible(true);  
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[32px][145px][11px][30px][71px]", "[14px][][14px][174px][23px]"));
		JProgressBar progressBar = new JProgressBar();
		JButton btnThisButtonDoes = new JButton("This Button Does Nothing!");
		btnThisButtonDoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Surprise!");
				value+=10;
				progressBar.setValue(value);
				progressBar.setToolTipText(Integer.toString(value)+ "%");
			}
		});
		
		JLabel label = new JLabel("");
		panel.add(label, "flowx,cell 4 1");
		
		JLabel lblEnterYourBirthdate = new JLabel("Enter your Birthdate");
		panel.add(lblEnterYourBirthdate, "cell 1 2,alignx left,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 3,grow");
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
	//	progressBar.setToolTipText(Integer.toString(value)+ "%");
		
		
		progressBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Workingpbar");
			}
		});
		
		panel.add(progressBar, "cell 1 3,alignx left,aligny center");
		
		JList list_1 = new JList();
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"12", "13", "15", "String"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list_1, "cell 3 3,alignx left,aligny center");
		
		JLabel lblMyFirstSwing = new JLabel("Birthday Notifier");
		panel.add(lblMyFirstSwing, "cell 4 3,alignx left,aligny top");
		panel.add(btnThisButtonDoes, "cell 1 4 3 1,alignx left,aligny top");
		
		panel.add(lblNewLabel, "cell 4 1");
		
		
		
	}
   
	public void actionPerformed(ActionEvent e) {    
		if(e.getSource()==i1)    
		{
			System.out.println("Working");
		}
			
	}
	


}
