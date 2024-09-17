import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SignInpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInpage frame = new SignInpage();
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
	public SignInpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN IN");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(198, 43, 71, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(100, 95, 45, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(198, 94, 157, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					llogin newframe =new llogin();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(84, 210, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  try {
		            	Class.forName("com.mysql.cj.jdbc.Driver");
		            	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel","root","sonali123");
		            			 String sql = "INSERT INTO table2 (NAME, PHONENUMBER, EMAIL) VALUES (?, ?, ?)";
		                    PreparedStatement pstmt = con.prepareStatement(sql);
		                    pstmt.setString(1, textField.getText());
		                    pstmt.setString(2, textField_2.getText());
		                    pstmt.setString(3, textField_1.getText());
		                    pstmt.executeUpdate();
		                     System.out.println("Details Updated");
		                     JOptionPane.showMessageDialog(null, "Signed Successfully","table",JOptionPane.INFORMATION_MESSAGE);
		                 } 
		                 catch(Exception s) {
		                	 System.out.print(s);
		                	 JOptionPane.showMessageDialog(null, "Error while establishing connection failed","warning",JOptionPane.INFORMATION_MESSAGE);
		                 
		                 }
				  
				dashboard db= new dashboard();
				db.setVisible(true);
			
			}});
		btnNewButton_1.setBounds(298, 210, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel_2.setBounds(100, 159, 45, 28);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 161, 185, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PHONE NUMBER");
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		lblNewLabel_4.setBounds(58, 136, 117, 13);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 132, 157, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\sonali suresh\\Downloads\\ab29b44c5fd552b3ab2c7d8c5ce385e4.jpg"));
		lblNewLabel_3.setBounds(0, 0, 446, 263);
		contentPane.add(lblNewLabel_3);
	}
}
