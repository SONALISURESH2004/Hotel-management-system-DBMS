import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.Statement;
public class llogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldName;
    private JTextField textFieldPhoneNumber;
    private JTextField textFieldOtp;
    private String generatedOtp;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    llogin frame = new llogin();
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
    public llogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("welcome");
        lblTitle.setBounds(185, 36, 100, 13);
        lblTitle.setFont(new Font("Yu Gothic", Font.BOLD, 12));
        contentPane.add(lblTitle);

        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(61, 77, 100, 13);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 10));
        contentPane.add(lblName);

        JLabel lblPhoneNumber = new JLabel("PHONE NUMBER");
        lblPhoneNumber.setBounds(33, 123, 100, 13);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 10));
        contentPane.add(lblPhoneNumber);

        JLabel lblOtp = new JLabel("OTP");
        lblOtp.setBounds(87, 167, 100, 13);
        lblOtp.setFont(new Font("Tahoma", Font.BOLD, 10));
        contentPane.add(lblOtp);

        textFieldName = new JTextField();
        textFieldName.setBounds(162, 74, 96, 19);
        contentPane.add(textFieldName);
        textFieldName.setColumns(10);

        textFieldPhoneNumber = new JTextField();
        textFieldPhoneNumber.setBounds(162, 120, 96, 19);
        contentPane.add(textFieldPhoneNumber);
        textFieldPhoneNumber.setColumns(10);

        textFieldOtp = new JTextField();
        textFieldOtp.setBounds(162, 167, 96, 19);
        contentPane.add(textFieldOtp);
        textFieldOtp.setColumns(10);

        JButton btnGenerateOtp = new JButton("Generate OTP");
        btnGenerateOtp.setBounds(307, 116, 120, 21);
        contentPane.add(btnGenerateOtp);

        JButton btnSignIn = new JButton("SIGN IN");
        btnSignIn.setBounds(76, 214, 85, 21);
        contentPane.add(btnSignIn);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(275, 214, 85, 21);
        contentPane.add(btnLogin);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sonali suresh\\Downloads\\282de5039d624eda2f9d7ff462d79e22.jpg"));
        lblNewLabel.setBounds(0, 10, 436, 253);
        contentPane.add(lblNewLabel);

        btnGenerateOtp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatedOtp = generateOTP(5);
                textFieldOtp.setText(generatedOtp);

                String apiKey = "gZOoMQ7fFVWE9LKASUITnx6etPq3JGb1lspCcd4HY0rB2hm8iNEwoKX9UpTkJzCmOnjVQR7Sg1baqHPA";
                String number = textFieldPhoneNumber.getText();
                String a = textFieldPhoneNumber.getText().trim();
                if (number.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a phone number");
                    return;
                }


                try {
                    otp("Hey this message is sent using Java code. Your OTP is " + generatedOtp, number, apiKey);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               SignInpage si =new SignInpage();
               si.setVisible(true);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String enteredOtp = textFieldOtp.getText();

       
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
            	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managementhotel","root","sonali123");
                 Statement stmt=con.createStatement();
                 String sql="Select * from table1 where NAME='"+textFieldName.getText()+"' and PHONENUMBER='" +textFieldPhoneNumber.getText()+"' ";
                 ResultSet rs=stmt.executeQuery(sql);

                 if ( textFieldOtp.getText().equals(generatedOtp) && rs.next()) {
                     System.out.println("OTP Verified");
                     JOptionPane.showMessageDialog(null, "Logged Successfully","table",JOptionPane.INFORMATION_MESSAGE);
                     dashboard db=new dashboard();
                     db.setVisible(true);
            
                 } else {
                     System.out.println("Invalid OTP");
                 }}
                 catch(Exception s) {
                	 System.out.print(s);
                 }
                    
            }
            
        });
    }

    public static void otp(String message, String number, String apiKey) throws Exception {
        String sendId = "FSTSMS";
        String language = "english";
        String route = "p";

        message = URLEncoder.encode(message, "UTF-8");   

        String myUrl = "https://www.fast2sms.com/dev/bulk?authorization=" + apiKey +
                       "&sender_id=" + sendId + "&message=" + message + "&language=" + language + 
                       "&route=" + route + "&numbers=" + number;
        URL url = new URL(myUrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("cache-control", "no-cache");
        System.out.println("Wait..........");
        int responseCode = con.getResponseCode();
        System.out.println("Response Code  : " + responseCode);

        StringBuffer response = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            response.append(line);
        }
        System.out.println(response);
    }

    public static String generateOTP(int otpLength) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < otpLength; i++) {
            sb.append(random.nextInt(10));
        }
        String otp = sb.toString();
        return otp;
    }
