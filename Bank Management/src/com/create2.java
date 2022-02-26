package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class create2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					create2 frame = new create2();
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
	public create2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(299, 39, 116, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Withdraw");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(176, 145, 107, 25);
		contentPane.add(btnNewButton);
		
		JButton btnPin = new JButton("Pin");
		btnPin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPin.setBounds(176, 260, 97, 25);
		contentPane.add(btnPin);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeposit.setBounds(430, 145, 97, 25);
		contentPane.add(btnDeposit);
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBalance.setBounds(430, 260, 97, 25);
		contentPane.add(btnBalance);
	}

}
