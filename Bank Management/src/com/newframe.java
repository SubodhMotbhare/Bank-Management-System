package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class newframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newframe frame = new newframe();
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
	public newframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				deposit d = new deposit();
				d.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(145, 98, 132, 51);
		contentPane.add(btnNewButton);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				balance bl = new balance();
				bl.setVisible(true);
			}
		});
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBalance.setBounds(145, 213, 123, 51);
		contentPane.add(btnBalance);
		
		JButton btnNewButton_2 = new JButton("withdraw");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				withdraw wdraw = new withdraw();
				wdraw.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(518, 213, 132, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnPin = new JButton("Pin");
		btnPin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pin p = new pin();
				p.setVisible(true);
				
						
			}
		});
		btnPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPin.setBounds(518, 98, 132, 51);
		contentPane.add(btnPin);
		
		JButton btnSignout = new JButton("signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				create c = new create();
				c.setVisible(true);
			}
		});
		btnSignout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignout.setBounds(324, 300, 123, 59);
		contentPane.add(btnSignout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 33, 722, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Services");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(292, 0, 103, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JButton d = new JButton("");
		d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit d = new deposit();
				d.setVisible(true);
			}
		});
		d.setIcon(new ImageIcon(getClass().getResource("/deposit1.png")));
		d.setBounds(73, 98, 60, 51);
		contentPane.add(d);
		
		JButton w = new JButton("");
//		w.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				withdraw wdraw = new withdraw();
//				wdraw.setVisible(true);
//				
//			}
//		});
		
		w.setIcon(new ImageIcon(getClass().getResource("/withdraw.png")));
		w.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw wdraw = new withdraw();
				wdraw.setVisible(true);
				
			}
		});
		w.setBounds(446, 213, 60, 51);
		contentPane.add(w);
		
		
		JButton b = new JButton("");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balance bl = new balance();
				bl.setVisible(true);
			}
			
		});
		
		b.setIcon(new ImageIcon(getClass().getResource("/balance.png")));
		b.setBounds(73, 213, 60, 51);
		contentPane.add(b);
		
		JButton p = new JButton("");
		p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pin p = new pin();
				p.setVisible(true);
			}
		});
		p.setIcon(new ImageIcon(getClass().getResource("/pin.png")));
		p.setBounds(447, 98, 59, 51);
		contentPane.add(p);
		
		JButton s = new JButton("");
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create c1 = new create();
				c1.setVisible(true);			
			}
		});
		s.setIcon(new ImageIcon(getClass().getResource("/signout.png")));
		s.setBounds(242, 308, 70, 51);
		contentPane.add(s);
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
