package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class deposit extends JFrame {

	private JPanel contentPane;
	private JTextField dtf2;
	private JTextField dtf3;
	
	String sql,find_account,name,accountdum;
	String account,amount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit frame = new deposit();
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
	public deposit() {
		
		con = (Connection) MysqlCon.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 414);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Deposit");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(207, 13, 106, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Account no");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(49, 87, 91, 22);
		contentPane.add(lblNewLabel_1_1);
		
		dtf2 = new JTextField();
		dtf2.setFont(new Font("Tahoma", Font.BOLD, 16));
		dtf2.setColumns(10);
		dtf2.setBounds(164, 87, 255, 31);
		contentPane.add(dtf2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amount");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(49, 138, 78, 22);
		contentPane.add(lblNewLabel_1_2);
		
		dtf3 = new JTextField();
		dtf3.setFont(new Font("Tahoma", Font.BOLD, 16));
		dtf3.setColumns(10);
		dtf3.setBounds(164, 138, 255, 31);
		contentPane.add(dtf3);
		
		JButton db1 = new JButton("Deposit");
		db1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				
				amount = dtf3.getText();
				account = dtf2.getText();
				//System.out.print(account+amount);
				PreparedStatement pst = con.prepareStatement("select amount from deposit where account_no ="+account);
//				PreparedStatement ps = con.prepareStatement(sql);
//				PreparedStatement pst = con.prepareStatement("Insert into deposit values(?,?)");
				ResultSet rs = (ResultSet) pst.executeQuery();
//				pst.setInt(1,Integer.parseInt(account));
//				pst.setInt(2,Integer.parseInt(amount));
//				pst.executeUpdate();
				 while (rs.next())
				    {
				       int  amount1= rs.getInt("amount");
				         //System.out.print(amount1);
				         PreparedStatement pst12 = con.prepareStatement("update deposit set amount="+(amount1+Integer.parseInt(amount))+" where account_no ="+account);
				         pst12.executeUpdate();
				         JOptionPane.showMessageDialog(null, "Your money deposit successfully  balence is="+ (amount1+Integer.parseInt(amount))); 
				         
				    }
//				JOptionPane.showMessageDialog(null, "You created account successfully");

				}
				catch(Exception e) {
					System.out.print(e);
				}
			}
		});
		db1.setFont(new Font("Tahoma", Font.BOLD, 16));
		db1.setBounds(164, 224, 118, 25);
		contentPane.add(db1);
		
		JButton db2 = new JButton("Cancel");
		db2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				newframe n = new newframe();
				n.setVisible(true);
			}
		});
		db2.setFont(new Font("Tahoma", Font.BOLD, 16));
		db2.setBounds(301, 224, 118, 25);
		contentPane.add(db2);
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
