import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class offers extends JFrame {

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
					offers frame = new offers();
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
	public offers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EXCLUSIVE OFFERS");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(151, 26, 242, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SUMMER EDITION SUPER OFFERS");
		lblNewLabel_1.setBounds(53, 80, 201, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DELUXE DOUBLE ROOM FOR TWO NIGHTS WITH AMENITIES:");
		lblNewLabel_2.setBounds(27, 103, 293, 28);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText("4999/-");
		textField.setBounds(330, 108, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DOUBLE ROOM FOR TWO NIGHTS WITH AMENITIES AND ALSO DORMITORY:");
		lblNewLabel_3.setBounds(27, 175, 380, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setText("10000/-");
		textField_1.setBounds(330, 195, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(27, 123, 25, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(27, 194, 25, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dashboard newframe =new dashboard();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnNewButton.setBounds(91, 232, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BOOK NOW");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( rdbtnNewRadioButton.isSelected()||rdbtnNewRadioButton_1.isSelected()){
				JOptionPane.showMessageDialog(null,"Booked","table",JOptionPane.INFORMATION_MESSAGE);
			}
				else{
					JOptionPane.showMessageDialog(null,"Error while establishing ","warning",JOptionPane.INFORMATION_MESSAGE);
					}
				StringBuilder selectedItems = new StringBuilder();
				if (rdbtnNewRadioButton.isSelected()) selectedItems.append("DELUXE DOUBLE ROOM FOR TWO NIGHTS WITH AMENITIES:, ").append(textField.getText()).append(", ");
				if (rdbtnNewRadioButton_1.isSelected()) selectedItems.append("DOUBLE ROOM FOR TWO NIGHTS WITH AMENITIES AND ALSO DORMITORY:, ").append(textField_1.getText()).append(", ");
				
				if (selectedItems.length() > 0) {
					selectedItems.setLength(selectedItems.length() - 2); 

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel","root","sonali123");
						String sql = "INSERT INTO offers (offers) VALUES (?)";
						
						try (PreparedStatement pstmt = con.prepareStatement(sql)) {
							for (String item : selectedItems.toString().split(", ")) {
								pstmt.setString(1, item);
								pstmt.addBatch();
							}
							pstmt.executeBatch();
							JOptionPane.showMessageDialog(btnNewButton_1, "Submitted Successfully");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton_1, "Error while establishing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No offers selected", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(268, 232, 104, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(null);
		lblNewLabel_4.setBounds(10, 0, 439, 276);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DATE");
		lblNewLabel_5.setBounds(275, 80, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(330, 77, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	
	}}
