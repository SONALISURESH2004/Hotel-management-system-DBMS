import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class features extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCheckBox chckbxMiniTheater;
    private JCheckBox chckbxSpa;
    private JCheckBox chckbxGym;
    private JCheckBox chckbxSports;
    private JCheckBox chckbxSwimmingPool;
    private JCheckBox chckbxMiniPark;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
			try {
				features frame = new features();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}});
	}

	/**
	 * Create the frame.
	 */
	public features() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RELAXATION AND ENTERTAINMENT");
		lblNewLabel.setBounds(101, 37, 243, 31);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		contentPane.add(lblNewLabel);
		
		chckbxMiniTheater = new JCheckBox("MINI THEATER");
		chckbxMiniTheater.setBounds(35, 84, 109, 21);
		contentPane.add(chckbxMiniTheater);
		
		chckbxSpa = new JCheckBox("SPA");
		chckbxSpa.setBounds(35, 139, 60, 21);
		contentPane.add(chckbxSpa);
		
		chckbxGym = new JCheckBox("GYM");
		chckbxGym.setBounds(35, 195, 60, 21);
		contentPane.add(chckbxGym);
		
		chckbxSports = new JCheckBox("SPORTS");
		chckbxSports.setBounds(241, 84, 79, 21);
		contentPane.add(chckbxSports);
		
		chckbxSwimmingPool = new JCheckBox("SWIMMING POOL");
		chckbxSwimmingPool.setBounds(241, 139, 128, 21);
		contentPane.add(chckbxSwimmingPool);
		
		chckbxMiniPark = new JCheckBox("MINI PARK");
		chckbxMiniPark.setBounds(241, 195, 128, 21);
		contentPane.add(chckbxMiniPark);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(87, 232, 85, 21);
		btnBack.addActionListener(e -> {
			try {
				dashboard newframe = new dashboard();
				newframe.setVisible(true);
				dispose();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(btnBack, "Error while navigating back", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		contentPane.add(btnBack);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(220, 232, 85, 21);
		btnSubmit.addActionListener(e -> {
			StringBuilder selectedItems = new StringBuilder();
			if (chckbxMiniTheater.isSelected()) selectedItems.append("MINI THEATER, ");
			if (chckbxSpa.isSelected()) selectedItems.append("SPA, ");
			if (chckbxGym.isSelected()) selectedItems.append("GYM, ");
			if (chckbxSports.isSelected()) selectedItems.append("SPORTS, ");
			if (chckbxSwimmingPool.isSelected()) selectedItems.append("SWIMMING POOL, ");
			if (chckbxMiniPark.isSelected()) selectedItems.append("MINI PARK, ");
			
			if (selectedItems.length() > 0) {
				selectedItems.setLength(selectedItems.length() - 2); 

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel","root","sonali123");
					String sql = "INSERT INTO features (features) VALUES (?)";
					
					try (PreparedStatement pstmt = con.prepareStatement(sql)) {
						for (String item : selectedItems.toString().split(", ")) {
							pstmt.setString(1, item);
							pstmt.addBatch();
						}
						pstmt.executeBatch();
						JOptionPane.showMessageDialog(btnSubmit, "Submitted Successfully");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(btnSubmit, "Error while establishing connection: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No features selected", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		contentPane.add(btnSubmit);
	}
}
