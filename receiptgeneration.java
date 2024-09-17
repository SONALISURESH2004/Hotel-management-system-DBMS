import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class output extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnNewButton_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    output frame = new output();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public output() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(900, 550, 850, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Generate Details");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel", "root", "sonali123");
                    Statement st = con.createStatement();
                    String sql = "SELECT DISTINCT * FROM room "
                               + "NATURAL JOIN reservation "
                               + "NATURAL JOIN offers "
                               + "NATURAL JOIN features";

                    PreparedStatement pts = con.prepareStatement(sql);
                    ResultSet rs = pts.executeQuery();

                    DefaultTableModel dt = (DefaultTableModel) table.getModel();
                    dt.setRowCount(0);
                    while (rs.next()) {
                        Object o[] = { rs.getString("NOOFCOTS"), rs.getString("NOOFROOMS"), rs.getString("CHECKIN"),
                                       rs.getString("CHECKOUT"), rs.getString("NAME"), rs.getString("PHONENUMBER"),
                                       rs.getString("EMAIL"), rs.getString("TYPE"), rs.getString("FOOD"),
                                       rs.getString("FAMILYMEAL"), rs.getString("KIDSMEAL"), rs.getString("COUPLESMEAL"),
                                       rs.getString("offers"), rs.getString("features") };
                        dt.addRow(o);
                    }
                    con.close(); // Close the connection
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(btnNewButton, "Receipt is generated,payment will be mailed soon.");
                try {
				 thankyou newframe =new thankyou();
					newframe.setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
				catch(Exception a)
				{
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",JOptionPane.INFORMATION_MESSAGE);
					
				}
            }
        });

        btnNewButton.setBounds(50, 27, 144, 21);
        contentPane.add(btnNewButton);

        // Initialize the table
        table = new JTable();
        DefaultTableModel dt = new DefaultTableModel();
        table.setModel(dt);

   
        dt.addColumn("NOOFCOTS");
        dt.addColumn("NOOFROOMS");
        dt.addColumn("CHECKIN");
        dt.addColumn("CHECKOUT");
        dt.addColumn("NAME");
        dt.addColumn("PHONENUMBER");
        dt.addColumn("EMAIL");
        dt.addColumn("TYPE");
        dt.addColumn("FOOD");
        dt.addColumn("FAMILYMEAL");
        dt.addColumn("KIDSMEAL");
        dt.addColumn("COUPLESMEAL");
        dt.addColumn("offers");
        dt.addColumn("features");

        // ScrollPane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(29, 58, 797, 495);
        contentPane.add(scrollPane);
        
        btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dashboard db= new dashboard();
				db.setVisible(true);
        	}
        });
        btnNewButton_1.setBounds(704, 27, 85, 21);
        contentPane.add(btnNewButton_1);
    }
}
