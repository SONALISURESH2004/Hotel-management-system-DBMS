import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;

public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ROOMS AVAILABLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					singleroom newframe =new singleroom();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(42, 38, 163, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESTAURANT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					restaurant newframe =new restaurant();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_1.setBounds(249, 38, 163, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXCLUSIVE OFFERS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					offers newframe =new offers();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_2.setBounds(42, 111, 163, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("EXTERNAL FEATURES");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					features newframe =new features();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_3.setBounds(234, 111, 178, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("OTHERS");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					issues newframe =new issues();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_4.setBounds(193, 175, 85, 21);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("\r\nDASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(181, 10, 179, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("BACK");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SignInpage newframe =new SignInpage();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton_5.setBounds(75, 216, 85, 21);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 =new JButton("NEXT");
		btnNewButton_6.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					try {
						output newframe =new output();
						newframe.setVisible(true);
						SwingUtilities.windowForComponent(btnNewButton).dispose();
						}
					catch(Exception a)
					{
						JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
						
					}
			}
		});
		btnNewButton_6.setBounds(311, 232, 85, 21);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setBounds(0, 10, 447, 263);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\sonali suresh\\Downloads\\787b21c0e6ef258b214187528ac39c12.jpg"));
		lblNewLabel_2.setBounds(0, 10, 447, 253);
		contentPane.add(lblNewLabel_2);
	}
}
