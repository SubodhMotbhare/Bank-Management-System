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
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class withdraw extends JFrame {

	private JPanel contentPane;
	private JTextField withdrawac;
	private JTextField amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw frame = new withdraw();
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
	public withdraw() {
		con = (Connection) MysqlCon.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Withdraw");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(252, 13, 103, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(72, 71, 117, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(72, 159, 103, 31);
		contentPane.add(lblNewLabel_1_1);
		
		withdrawac = new JTextField();
		withdrawac.setFont(new Font("Tahoma", Font.BOLD, 16));
		withdrawac.setBounds(208, 71, 234, 31);
		contentPane.add(withdrawac);
		withdrawac.setColumns(10);
		
		amount = new JTextField();
		amount.setFont(new Font("Tahoma", Font.BOLD, 16));
		amount.setColumns(10);
		amount.setBounds(208, 160, 234, 31);
		contentPane.add(amount);
		
		JButton withdrawbtn = new JButton("Withdraw");
		withdrawbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String accountNo = withdrawac.getText();
				int Orgamount = Integer.parseInt(amount.getText());
				try {
					PreparedStatement pst = con.prepareStatement("select amount from deposit where account_no ="+accountNo);
					ResultSet rs = (ResultSet) pst.executeQuery();
					while (rs.next())
				    {
				       int  amount1= rs.getInt("amount");
				         System.out.print(amount1);
				         if(Orgamount<=amount1) {
				        	 PreparedStatement pst12 = con.prepareStatement("update deposit set amount="+(amount1-Orgamount)+" where account_no ="+accountNo);
				        	 pst12.executeUpdate();
				        	 JOptionPane.showMessageDialog(null, "Your money withdrown successfully Remaining balence is="+ (amount1-Orgamount)); 
				        	 
				         }
				         
				    }
				}catch(Exception e) {
					System.out.print(e);
				}
				
			}
		});
		withdrawbtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		withdrawbtn.setBounds(194, 217, 143, 31);
		contentPane.add(withdrawbtn);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				newframe d = new newframe();
				d.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(349, 217, 111, 31);
		contentPane.add(btnCancel);
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }
}
