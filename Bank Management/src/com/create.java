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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class create extends JFrame {

	private JPanel contentPane;
	//private JLabel lblNewLabel,lblNewLabel_1;
	String spassword,saccount,account,password;
	public static signin s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create frame = new create();
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
	private JLabel lblNewLabel_2;
	public create() {
		con = (Connection) MysqlCon.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // DISPOSE_ON_CLOSE
		setBounds(100, 100, 830, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Bank Management System");
		l1.setBackground(new Color(153, 255, 255));
		l1.setFont(new Font("Tahoma", Font.BOLD, 30));
		l1.setBounds(179, 24, 448, 66);
		contentPane.add(l1);
		
		JButton b1 = new JButton("Create Account");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				l.setVisible(true);
			}
		});
		b1.setFont(new Font("Tahoma", Font.BOLD, 22));
		b1.setBounds(136, 209, 220, 72);
		contentPane.add(b1);
		
		JButton b4 = new JButton("Signin");
		b4.setBackground(SystemColor.inactiveCaptionBorder);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				s = new signin();
				s.setVisible(true);
				
				
				
			}
		});
		b4.setFont(new Font("Tahoma", Font.BOLD, 22));
		b4.setBounds(556, 199, 163, 82);
		contentPane.add(b4);
	}
	
	 public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
