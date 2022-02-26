package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class pin extends JFrame {

	private JPanel contentPane;
	private JPasswordField newpassword;
	private JPasswordField old;
	String changep,accountp,opassword,newp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pin frame = new pin();
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
	private JTextField ac;
	public pin() {
		
		con = (Connection) MysqlCon.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(136, 24, 170, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(30, 206, 125, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel oldpass = new JLabel("Old Password");
		oldpass.setFont(new Font("Tahoma", Font.BOLD, 16));
		oldpass.setBounds(30, 152, 125, 28);
		contentPane.add(oldpass);
		
		newpassword = new JPasswordField();
		newpassword.setBounds(183, 203, 210, 36);
		contentPane.add(newpassword);
		
		old = new JPasswordField();
		old.setBounds(183, 150, 210, 35);
		contentPane.add(old);
		
		JButton pinsave = new JButton("Save");
		pinsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				accountp = ac.getText();
				//String opass = old.getText();
				newp = newpassword.getText();
				
				//oldpass = 
//				System.out.print(accountp);
//				System.out.print(opass);
//				System.out.print(newp);
			PreparedStatement pst12 = con.prepareStatement("update logindb set password="+ newp +" where account_no ="+accountp );
	        	 pst12.executeUpdate();
        	 JOptionPane.showMessageDialog(null, "Your password is changed successfully"+ (newp)); 
//	        	 
			}
				catch(Exception e5) {
					System.out.print(e5);;
					
				}
			}
			
		});
		pinsave.setForeground(Color.BLACK);
		pinsave.setFont(new Font("Tahoma", Font.BOLD, 16));
		pinsave.setBounds(183, 267, 97, 25);
		contentPane.add(pinsave);
		
		JButton pincancle = new JButton("Cancel");
		pincancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				newframe n = new newframe();
				n.setVisible(true);
			}
		});
		pincancle.setFont(new Font("Tahoma", Font.BOLD, 16));
		pincancle.setBounds(296, 267, 97, 25);
		contentPane.add(pincancle);
		
		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccountNo.setBounds(30, 94, 125, 28);
		contentPane.add(lblAccountNo);
		
		ac = new JTextField();
		ac.setFont(new Font("Tahoma", Font.BOLD, 16));
		ac.setBounds(183, 92, 213, 34);
		contentPane.add(ac);
		ac.setColumns(10);
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
