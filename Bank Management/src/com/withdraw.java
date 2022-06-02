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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
	static Connection con = null;
	public static void DBop(int account,int amount) {
		con = (Connection) MysqlCon.dbconnect();
		try {
			PreparedStatement pst = con.prepareStatement("select amount from deposit where account_no ="+account);
			ResultSet rs = (ResultSet) pst.executeQuery();
			while (rs.next())
		    {
		       int  amount1= rs.getInt("amount");
//		         System.out.print(amount1);
		         if(amount<=amount1) {
		        	 PreparedStatement pst12 = con.prepareStatement("update deposit set amount="+(amount1-amount)+" where account_no ="+account);
		        	 pst12.executeUpdate();
		        	 JOptionPane.showMessageDialog(null, "Your money withdrown successfully Remaining balence is="+ (amount1-amount)); 
		        	 
		         }else {
		        	 JOptionPane.showMessageDialog(null, "Unsufficient Balence !!!"); 
		        	 
		         }
		         
		    }
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
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
				String account = withdrawac.getText();
				int val = 0;
				
				try {// if is number
				    val = Integer.parseInt(amount.getText());
				} catch (NumberFormatException e) {
				    // else then do blah
					JOptionPane.showMessageDialog(null, "Enter Valid Amount"); 					
					return;
				}
				
				
//				String regex = "^[0-9]+$";
//				 account=withdrawac.getText();
//				Pattern pattern = Pattern.compile(regex);
//				Matcher matcher = pattern.matcher(account);
//				System.out.println(!matcher.matches());
//				if(matcher.matches()) {
//					JOptionPane.showMessageDialog(null, "Enter Valid Amount"); 					
//					return;
//				}else 
				if  (val<0) {
					JOptionPane.showMessageDialog(null, "Enter Valid Amount"); 					
					return;
				}else {
					 account=withdrawac.getText();
					 
					 withdraw.DBop(Integer.parseInt(account),val);
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
