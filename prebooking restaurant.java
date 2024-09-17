
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class restaurant extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				restaurant frame = new restaurant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public restaurant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RESTAURANT");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(168, 7, 157, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RESERVATIONS");
		lblNewLabel_1.setBounds(80, 50, 95, 13);
		contentPane.add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("COUPLES MEAL");
		rdbtnNewRadioButton.setBounds(36, 83, 122, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("KIDS MEAL");
		rdbtnNewRadioButton_1.setBounds(230, 83, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("FAMILY MEAL");
		rdbtnNewRadioButton_2.setBounds(36, 139, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton_3 = new JButton("SUBMIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (rdbtnNewRadioButton.isSelected() || rdbtnNewRadioButton_1.isSelected() || rdbtnNewRadioButton_2.isSelected()) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel","root","sonali123");
						String sql = "INSERT INTO reservation (FAMILYMEAL, KIDSMEAL, COUPLESMEAL) VALUES (?, ?, ?)";
						
						try (PreparedStatement pstmt = con.prepareStatement(sql)) {
							// Get the selected value from the combo box for each meal type
							String familyMeal = rdbtnNewRadioButton_2.isSelected() ? comboBox_1.getSelectedItem().toString() : ""; 
							String kidsMeal = rdbtnNewRadioButton_1.isSelected() ? comboBox_2.getSelectedItem().toString() : ""; 
							String couplesMeal = rdbtnNewRadioButton.isSelected() ? comboBox.getSelectedItem().toString() : ""; 
							
							pstmt.setString(1, familyMeal);
							pstmt.setString(2, kidsMeal);
							pstmt.setString(3, couplesMeal);
							
							pstmt.executeUpdate();
							JOptionPane.showMessageDialog(btnNewButton_3, "Submitted Successfully");
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton_3, "Error while establishing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No meal type selected", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(266, 198, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dashboard newframe =new dashboard();
					newframe.setVisible(true);
					dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton_4,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_4.setBounds(96, 198, 85, 21);
		contentPane.add(btnNewButton_4);
		
		comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(168, 83, 46, 21);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(145, 139, 46, 21);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6"}));
		comboBox_2.setBounds(347, 83, 39, 21);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 447, 263);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\sonali suresh\\Downloads\\Download free image of Background of beige watercolor with color stains in simple style by Nunny about ig plain story background, watercolor backgrounds, plain background, plain nude color background, and .jpeg"));
		lblNewLabel_2.setBounds(0, 0, 447, 263);
		contentPane.add(lblNewLabel_2);
	}

}
