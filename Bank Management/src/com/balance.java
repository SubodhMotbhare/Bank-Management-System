package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class balance extends JFrame {

	private JPanel contentPane;
	private JTextField abalance;
	String accountb,sql,balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balance frame = new balance();
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
	private JTextField balancetextfield;
	public balance() {
		
		con = (Connection) MysqlCon.dbconnect();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 355);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setForeground(Color.GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(54, 61, 84, 31);
		contentPane.add(lblNewLabel);
		
		abalance = new JTextField();
		abalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		abalance.setBounds(196, 61, 220, 31);
		contentPane.add(abalance);
		abalance.setColumns(10);
		
		JButton showbtn = new JButton("Show");
		showbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				accountb = abalance.getText();
				sql = "SELECT * FROM deposit WHERE account_no =" + accountb ;        
			    PreparedStatement ps = con.prepareStatement(sql);
			    ResultSet rs = (ResultSet) ps.executeQuery();
		    while (rs.next())
			    {
			         balance = Integer.toString(rs.getInt("amount"));
			         balancetextfield.setText(balance);
			    }     
				}
				catch(Exception e6) {
					System.out.print(e6.getMessage());
				}
			}
		});
		showbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		showbtn.setBounds(54, 196, 97, 37);
		contentPane.add(showbtn);
		
		JButton resetbtn = new JButton("Reset");
		resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balancetextfield.setText("");
				abalance.setText("");
				
			}
		});
		resetbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		resetbtn.setBounds(196, 196, 97, 37);
		contentPane.add(resetbtn);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBalance.setBounds(54, 129, 84, 31);
		contentPane.add(lblBalance);
		
		balancetextfield = new JTextField();
		balancetextfield.setFont(new Font("Tahoma", Font.BOLD, 16));
		balancetextfield.setColumns(10);
		balancetextfield.setBounds(196, 129, 220, 31);
		contentPane.add(balancetextfield);
		
		JButton backbtn = new JButton("Back");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				newframe nf= new newframe();
				nf.setVisible(true);
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		backbtn.setBounds(319, 197, 97, 36);
		contentPane.add(backbtn);
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
