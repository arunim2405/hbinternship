package dayFifteen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Calculator extends JFrame {
	String si=null,so,sf=null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 54, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnClr = new JButton("Clr");
		btnClr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setText("0");
				si=null;
				sf=null;
				so=null;
			}
		});
		GridBagConstraints gbc_btnClr = new GridBagConstraints();
		gbc_btnClr.insets = new Insets(0, 0, 5, 5);
		gbc_btnClr.gridx = 3;
		gbc_btnClr.gridy = 2;
		contentPane.add(btnClr, gbc_btnClr);
		
		JButton button = new JButton("9");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("9");
				}
				else
				{
					lblNewLabel.setText(s1+"9");
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 4;
		contentPane.add(button, gbc_button);
		
		JButton button_1 = new JButton("8");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("8");
				}
				else
				{
					lblNewLabel.setText(s1+"8");
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 4;
		contentPane.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("7");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("7");
				}
				else
				{
					lblNewLabel.setText(s1+"7");
				}
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 5;
		gbc_button_2.gridy = 4;
		contentPane.add(button_2, gbc_button_2);
		
		JButton button_10 = new JButton("+");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(si==null)
				{
				si=lblNewLabel.getText();
				so="+";
				lblNewLabel.setText(" ");
				}
				if(si!=null)
				{
						sf=lblNewLabel.getText();
						double d;
						d=Double.parseDouble(si)+Double.parseDouble(sf);
						lblNewLabel.setText(" ");
						si=String.valueOf(d);
					
				}
			}
			
		});
		GridBagConstraints gbc_button_10 = new GridBagConstraints();
		gbc_button_10.insets = new Insets(0, 0, 5, 5);
		gbc_button_10.gridx = 6;
		gbc_button_10.gridy = 4;
		contentPane.add(button_10, gbc_button_10);
		
		JButton btnSqrt = new JButton("Sqrt");
		btnSqrt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double d,s;
				d=Double.parseDouble(lblNewLabel.getText());
				
				 s=Math.sqrt(d);
				 lblNewLabel.setText(String.valueOf(s));
			}
		});
		GridBagConstraints gbc_btnSqrt = new GridBagConstraints();
		gbc_btnSqrt.insets = new Insets(0, 0, 5, 5);
		gbc_btnSqrt.gridx = 7;
		gbc_btnSqrt.gridy = 4;
		contentPane.add(btnSqrt, gbc_btnSqrt);
		
		JButton btnTan = new JButton("Tan");
		btnTan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double d,b,s;
				d=Double.parseDouble(lblNewLabel.getText());
				 b = Math.toRadians(d);
				 s=Math.tan(b);
				 lblNewLabel.setText(String.valueOf(s));
			}
		});
		GridBagConstraints gbc_btnTan = new GridBagConstraints();
		gbc_btnTan.insets = new Insets(0, 0, 5, 5);
		gbc_btnTan.gridx = 8;
		gbc_btnTan.gridy = 4;
		contentPane.add(btnTan, gbc_btnTan);
		
		JButton button_3 = new JButton("6");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("6");
				}
				else
				{
					lblNewLabel.setText(s1+"6");
				}
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 5;
		contentPane.add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("5");
				}
				else
				{
					lblNewLabel.setText(s1+"5");
				}
			}
		
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 4;
		gbc_button_4.gridy = 5;
		contentPane.add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("4");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("4");
				}
				else
				{
					lblNewLabel.setText(s1+"4");
				}
			}
		});
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 5;
		gbc_button_5.gridy = 5;
		contentPane.add(button_5, gbc_button_5);
		
		JButton button_11 = new JButton("-");
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(si==null)
				{
				si=lblNewLabel.getText();
				so="-";
				lblNewLabel.setText(" ");
				}
				if(si!=null)
				{
						sf=lblNewLabel.getText();
						double d;
						d=Double.parseDouble(si)-Double.parseDouble(sf);
						lblNewLabel.setText(" ");
						si=String.valueOf(d);
					
				}
			}
		});
		GridBagConstraints gbc_button_11 = new GridBagConstraints();
		gbc_button_11.insets = new Insets(0, 0, 5, 5);
		gbc_button_11.gridx = 6;
		gbc_button_11.gridy = 5;
		contentPane.add(button_11, gbc_button_11);
		
		JButton button_14 = new JButton("%");
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(si==null)
				{
				si=lblNewLabel.getText();
				so="%";
				lblNewLabel.setText(" ");
				}
				if(si!=null)
				{
						sf=lblNewLabel.getText();
						double d;
						d=Double.parseDouble(si)%Double.parseDouble(sf);
						lblNewLabel.setText(" ");
						si=String.valueOf(d);
					
				}
			}
		});
		GridBagConstraints gbc_button_14 = new GridBagConstraints();
		gbc_button_14.insets = new Insets(0, 0, 5, 5);
		gbc_button_14.gridx = 7;
		gbc_button_14.gridy = 5;
		contentPane.add(button_14, gbc_button_14);
		
		JButton button_6 = new JButton("3");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("3");
				}
				else
				{
					lblNewLabel.setText(s1+"3");
				}
			}
		});
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 3;
		gbc_button_6.gridy = 6;
		contentPane.add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("2");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("2");
				}
				else
				{
					lblNewLabel.setText(s1+"2");
				}
			}
		});
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 4;
		gbc_button_7.gridy = 6;
		contentPane.add(button_7, gbc_button_7);
		
		JButton button_8 = new JButton("1");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("1");
				}
				else
				{
					lblNewLabel.setText(s1+"1");
				}
			}
		});
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 5;
		gbc_button_8.gridy = 6;
		contentPane.add(button_8, gbc_button_8);
		
		JButton button_12 = new JButton("*");
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(si==null)
				{
				si=lblNewLabel.getText();
				so="*";
				lblNewLabel.setText(" ");
				}
				if(si!=null)
				{
						sf=lblNewLabel.getText();
						double d;
						d=Double.parseDouble(si)*Double.parseDouble(sf);
						lblNewLabel.setText(" ");
						si=String.valueOf(d);
					
				}
			}
		});
		GridBagConstraints gbc_button_12 = new GridBagConstraints();
		gbc_button_12.insets = new Insets(0, 0, 5, 5);
		gbc_button_12.gridx = 6;
		gbc_button_12.gridy = 6;
		contentPane.add(button_12, gbc_button_12);
		
		JButton btnSin = new JButton("Sin");
		btnSin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double d,b,s;
				d=Double.parseDouble(lblNewLabel.getText());
				 b = Math.toRadians(d);
				 s=Math.sin(b);
				 lblNewLabel.setText(String.valueOf(s));
			}
		});
		GridBagConstraints gbc_btnSin = new GridBagConstraints();
		gbc_btnSin.insets = new Insets(0, 0, 5, 5);
		gbc_btnSin.gridx = 7;
		gbc_btnSin.gridy = 6;
		contentPane.add(btnSin, gbc_btnSin);
		
		JButton button_9 = new JButton("0");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("0");
				}
				else
				{
					lblNewLabel.setText(s1+"0");
				}
			}
		});
		
		JButton button_16 = new JButton("=");
		button_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sf=lblNewLabel.getText();
				if(so=="+")
				{
					double d;
					d=Double.parseDouble(si)+Double.parseDouble(sf);
					lblNewLabel.setText(String.valueOf(d));
				}
				else if(so=="-")
				{
					double d;
					d=Double.parseDouble(si)-Double.parseDouble(sf);
					lblNewLabel.setText(String.valueOf(d));
				}
				else if(so=="*")
				{
					double d;
					d=Double.parseDouble(si)*Double.parseDouble(sf);
					lblNewLabel.setText(String.valueOf(d));
				}
				else if(so=="/")
				{
					double d;
					d=Double.parseDouble(si)/Double.parseDouble(sf);
					lblNewLabel.setText(String.valueOf(d));
				}
				else if(so=="%")
				{
					double d;
					d=Double.parseDouble(si)%Double.parseDouble(sf);
					lblNewLabel.setText(String.valueOf(d));
				}
			}
		});
		GridBagConstraints gbc_button_16 = new GridBagConstraints();
		gbc_button_16.insets = new Insets(0, 0, 0, 5);
		gbc_button_16.gridx = 3;
		gbc_button_16.gridy = 7;
		contentPane.add(button_16, gbc_button_16);
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.insets = new Insets(0, 0, 0, 5);
		gbc_button_9.gridx = 4;
		gbc_button_9.gridy = 7;
		contentPane.add(button_9, gbc_button_9);
		
		JButton button_15 = new JButton(".");
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s1=lblNewLabel.getText();
				if(s1=="0")
				{
					lblNewLabel.setText("0.");
				}
				else
				{
					lblNewLabel.setText(s1+".");
				}
			}
		});
		GridBagConstraints gbc_button_15 = new GridBagConstraints();
		gbc_button_15.insets = new Insets(0, 0, 0, 5);
		gbc_button_15.gridx = 5;
		gbc_button_15.gridy = 7;
		contentPane.add(button_15, gbc_button_15);
		
		JButton button_13 = new JButton("/");
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(si==null)
				{
				si=lblNewLabel.getText();
				so="/";
				lblNewLabel.setText(" ");
				}
				if(si!=null)
				{
						sf=lblNewLabel.getText();
						double d;
						d=Double.parseDouble(si)/Double.parseDouble(sf);
						lblNewLabel.setText(" ");
						si=String.valueOf(d);
					
				}
			}
		});
		GridBagConstraints gbc_button_13 = new GridBagConstraints();
		gbc_button_13.insets = new Insets(0, 0, 0, 5);
		gbc_button_13.gridx = 6;
		gbc_button_13.gridy = 7;
		contentPane.add(button_13, gbc_button_13);
		
		JButton btnCos = new JButton("Cos");
		btnCos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double d,b,s;
				d=Double.parseDouble(lblNewLabel.getText());
				 b = Math.toRadians(d);
				 s=Math.cos(b);
				 lblNewLabel.setText(String.valueOf(s));
			}
		});
		GridBagConstraints gbc_btnCos = new GridBagConstraints();
		gbc_btnCos.insets = new Insets(0, 0, 0, 5);
		gbc_btnCos.gridx = 7;
		gbc_btnCos.gridy = 7;
		contentPane.add(btnCos, gbc_btnCos);
	}

}
