import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class singleroom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_6;
	private JComboBox comboBox;
	private JLabel lblNewLabel_7;
	private JComboBox comboBox_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JButton btnNewButton_1;
	private JComboBox comboBox_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					singleroom frame = new singleroom();
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
	public singleroom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("BOOKING");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		lblNewLabel.setBounds(197, 34, 131, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CHECK IN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(26, 132, 71, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CHECKOUT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(26, 161, 71, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(52, 213, 45, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("PHONE NUMBER");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(10, 249, 90, 13);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("EMAIL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(41, 295, 45, 13);
		contentPane.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(95, 129, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(95, 158, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(107, 210, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(110, 246, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(113, 292, 192, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		lblNewLabel_6 = new JLabel("DAYS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(294, 150, 45, 13);
		contentPane.add(lblNewLabel_6);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setBounds(362, 146, 43, 21);
		contentPane.add(comboBox);

		lblNewLabel_7 = new JLabel("TYPE");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(294, 184, 45, 13);
		contentPane.add(lblNewLabel_7);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"NIL", "AC", "NON-AC", "SUIT ROOM"}));
		comboBox_1.setBounds(362, 180, 61, 21);
		contentPane.add(comboBox_1);

		btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dashboard newframe = new dashboard();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(77, 415, 85, 21);
		contentPane.add(btnNewButton);

		lblNewLabel_8 = new JLabel("NO OF COTS");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(26, 83, 71, 13);
		contentPane.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("NO OF ROOMS");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_9.setBounds(268, 83, 71, 13);
		contentPane.add(lblNewLabel_9);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2"}));
		comboBox_2.setBounds(107, 79, 55, 21);
		contentPane.add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "DORMITORY", "SUIT ROOM"}));
		comboBox_3.setBounds(362, 79, 114, 21);
		contentPane.add(comboBox_3);

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"NIL", "FOOD INCLUDED", "EXCLUDED"}));
		comboBox_4.setBounds(362, 245, 114, 21);
		contentPane.add(comboBox_4);

		JLabel lblNewLabel_11 = new JLabel("FOOD");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_11.setBounds(294, 249, 45, 13);
		contentPane.add(lblNewLabel_11);

		btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel","root","sonali123");
					String sql="INSERT INTO room( NOOFCOTS, NOOFROOMS,CHECKIN,CHECKOUT,NAME,PHONENUMBER,EMAIL,TYPE,FOOD) VALUES(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, Integer.parseInt(comboBox_2.getSelectedItem().toString()));
					pstmt.setInt(2, Integer.parseInt(comboBox_3.getSelectedItem().toString()));
					pstmt.setString(3, textField.getText());
					pstmt.setString(4, textField_1.getText());
					pstmt.setString(5, textField_2.getText());
					pstmt.setString(6, textField_3.getText());
					pstmt.setString(7, textField_4.getText());
					pstmt.setString(8, comboBox_1.getSelectedItem().toString());
					pstmt.setString(9, comboBox_4.getSelectedItem().toString());
					pstmt.executeUpdate();

					JOptionPane.showMessageDialog(btnNewButton_1, "Submitted Successfully");
				} catch (Exception e1) {
					 System.out.print(e1);
                	 JOptionPane.showMessageDialog(null, "Error while establishing connection failed","warning",JOptionPane.INFORMATION_MESSAGE);
                 
				}
			}
		});
		btnNewButton_1.setBounds(243, 415, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("DATE");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10.setBounds(294, 117, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(372, 110, 96, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
