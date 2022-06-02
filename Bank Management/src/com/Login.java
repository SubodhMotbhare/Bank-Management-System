package com;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;



public class Login extends JFrame {

	
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf4;
	private JTextField tf5;
	ButtonGroup bg = new ButtonGroup();
	ButtonGroup bg1 = new ButtonGroup();
	Choice day,month,year;
	JRadioButton rb3,rb2,rb1,rb4,rb5;
	String Gen,dob,name,pan,mobile,gmail,pass,actype,city,confirm,password;
	int numbers;
	String namev, panv, gmailv, mobilev, cityv, passwordv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	Connection con = null;
	private JTextField tf6;
	private JPasswordField pf1;
	public static boolean onlyDigits(String str, int n)
	    {
	        for (int i = 0; i < n; i++) {
	            if (Character.isDigit(str.charAt(i))) {
	                return true;
	            }
	            else {
	                return false;
	            }
	        }
	        return false;
	    }
	public Login() {
		setBackground(new Color(244, 164, 96));
		
		con = (Connection) MysqlCon.dbconnect();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 646);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create  Account");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 13, 703, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGmail.setBounds(24, 270, 86, 22);
		contentPane.add(lblGmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		//lblNewLabel_1_1.setPlaceholder("example@gmail.com");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(24, 75, 75, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DOB");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(24, 199, 86, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Pan No");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(24, 113, 75, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Account Type");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(24, 233, 126, 24);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Gender");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(24, 148, 86, 26);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Mobile No");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(24, 313, 97, 34);
		contentPane.add(lblNewLabel_1_6);
		
		 day = new Choice();
		 day.setFont(new Font("Dialog", Font.BOLD, 16));
		for(int i=1;i<=31;i++)
		day.add(String.valueOf(i));
		day.setBounds(173, 194, 86, 27);
		contentPane.add(day);
	
		JButton b1 = new JButton("Create");
		b1.setBackground(new Color(102, 205, 170));
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
						
				
				dob = day.getSelectedItem() + month.getSelectedItem() + year.getSelectedItem();
				
				if(rb1.isSelected())
					Gen="Male";
				else if(rb2.isSelected())
					Gen="Female";
				else
					Gen="other";
				
				if(rb4.isSelected())
					actype="Savings";
				else
					actype="Current";
				
				name = tf1.getText();
				pan = tf2.getText();
				if(pan.length()!=10) {
					JOptionPane.showMessageDialog(null, "Pan Number Must be 10 digit"); 
					return;
				}
				gmail = tf4.getText();
				String regex = "^(.+)@(.+)$";
				 
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(gmail);
				if(!matcher.matches()) {
					JOptionPane.showMessageDialog(null, "Enter Valid Email Address"); 					
					return;
				}
				mobile = tf5.getText();
				String regexMobile = "[0-9]+";
				Pattern patternMobile = Pattern.compile(regexMobile);
				Matcher matcherMobile = patternMobile.matcher(mobile);
				if(!matcherMobile.matches()) {
					JOptionPane.showMessageDialog(null, "Number Must Contains Numbers"); 					
					return;
				}
				if(mobile.length()!=10) {
					JOptionPane.showMessageDialog(null, "Mobile Number Must be 10 digit"); 
					return;
				}
				city = tf6.getText();
				password = pf1.getText();
				if(password.length()!=4) {
					JOptionPane.showMessageDialog(null, "Password Must be 4 digit"); 
					return;
				}
				Random r = new Random();
				numbers = 1000000000 + (int)(r.nextDouble() * 999999999);
				PreparedStatement pst = con.prepareStatement("Insert into logindb(name, pan, Gender, dob, actype, gmail, mobile, city, password, account_no)values(?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, pan);
				pst.setString(3, Gen);
				pst.setString(4, dob);
				pst.setString(5, actype);
				pst.setString(6, gmail);
				pst.setString(7, mobile);
				pst.setString(8, city);
				pst.setString(9, password);
				pst.setInt(10, numbers);
				pst.executeUpdate();
				PreparedStatement pst12 = con.prepareStatement("Insert into deposit values(?,?)");
				pst12.setInt(1,numbers);
				pst12.setInt(2,0);
				pst12.executeUpdate();
				JOptionPane.showMessageDialog(null, "You created account successfully"+ numbers); 
				}
			
			catch(Exception e2) {
				e2.printStackTrace(); // It prints the exception
			} 
				
			
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 18));
		b1.setBounds(173, 518, 132, 34);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Cancel");
		b2.setBackground(new Color(255, 0, 0));
		b2.setFont(new Font("Tahoma", Font.BOLD, 18));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				create c = new create();
				c.setVisible(true);
				
				
			}
		});
		b2.setBounds(358, 518, 148, 34);
		contentPane.add(b2);
		
		
		
		
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.BOLD, 16));
		tf1.setBounds(173, 63, 333, 34);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.BOLD, 16));
		tf2.setColumns(10);
		tf2.setBounds(173, 108, 333, 32);
		contentPane.add(tf2);
		
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Tahoma", Font.BOLD, 16));
		tf4.setColumns(10);
		tf4.setBounds(173, 268, 333, 32);
		contentPane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Tahoma", Font.BOLD, 16));
		tf5.setColumns(10);
		tf5.setBounds(174, 313, 333, 34);
		contentPane.add(tf5);
		
		 rb1 = new JRadioButton("Male");
		rb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		rb1.setBounds(173, 149, 86, 25);
		bg.add(rb1);
		contentPane.add(rb1);
		
		 rb2 = new JRadioButton("Female");
		rb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		rb2.setBounds(300, 149, 105, 25);
		bg.add(rb2);
		contentPane.add(rb2);
		
		 rb3 = new JRadioButton("Other");
		rb3.setFont(new Font("Tahoma", Font.BOLD, 16));
		rb3.setBounds(431, 149, 75, 25);
		bg.add(rb3);
		contentPane.add(rb3);
		
		 rb4 = new JRadioButton("Savings");
		rb4.setFont(new Font("Tahoma", Font.BOLD, 16));
		rb4.setBounds(173, 233, 150, 25);
		bg1.add(rb4);
		contentPane.add(rb4);
		
		 rb5 = new JRadioButton("Current");
		rb5.setFont(new Font("Tahoma", Font.BOLD, 16));
		rb5.setBounds(358, 233, 148, 25);
		bg1.add(rb5);
		contentPane.add(rb5);
		
		JLabel lnm = new JLabel("City");
		lnm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lnm.setBounds(24, 362, 105, 32);
		contentPane.add(lnm);
		
		 month = new Choice();
		 month.setFont(new Font("Dialog", Font.BOLD, 16));
		for(int i=1;i<=12;i++)
			month.add(String.valueOf(i));
		month.setBounds(304, 194, 101, 27);
		contentPane.add(month);	
	
		 year = new Choice();
		 year.setFont(new Font("Dialog", Font.BOLD, 16));
		for(int i=2010;i>=1980;i--)
			year.add(String.valueOf(i));
		year.setBounds(431, 194, 75, 27);
		contentPane.add(year);
		
		tf6 = new JTextField();
		tf6.setFont(new Font("Tahoma", Font.BOLD, 16));
		tf6.setColumns(10);
		tf6.setBounds(174, 360, 333, 34);
		contentPane.add(tf6);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(24, 410, 105, 36);
		contentPane.add(lblPassword);
		
		pf1 = new JPasswordField();
		pf1.setFont(new Font("Tahoma", Font.BOLD, 16));
		pf1.setBounds(173, 412, 333, 34);
		contentPane.add(pf1);
	}
}
