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

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class signin extends JFrame {

	protected static final Component NULL = null;
	private JPanel contentPane;
	JTextField stf1;
	private JPasswordField spf1;
	String saccount, account, spassword,sql,find_account,accountdum,password;
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					signin frame = new signin();
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
	public signin() {
		
		con = (Connection) MysqlCon.dbconnect();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//EXIT_ON_CLOSE
		setBounds(100, 100, 559, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Account No");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(35, 104, 102, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(35, 152, 102, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("SignIn to Bank Account");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_3.setBounds(143, 27, 239, 35);
		contentPane.add(lblNewLabel_2_3);
		
		JButton sb1 = new JButton("Signin");
		sb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
				saccount = stf1.getText();
				spassword = spf1.getText();
//				System.out.print(saccount);
//				System.out.print(spassword);
				sql = "SELECT * FROM logindb WHERE account_no =" + saccount +" and password="+ spassword;        
			    PreparedStatement ps = con.prepareStatement(sql);
			    //ps.setString(1, "John Smith");
			    //ps.executeQuery();
			    
			    ResultSet rs = (ResultSet) ps.executeQuery();
			    //System.out.print(rs);
//			    System.out.print(rs);
			    //List<String> matchingNames = new ArrayList<>();
		    while (rs.next())
			    {
			         account = Integer.toString(rs.getInt("account_no"));
			         //System.out.print(account);
			         
			         password =  rs.getString("password");
//					    	withdraw w = new withdraw();
//					    	w.setVisible(true);
//			         close();
			         
			         dispose();
			         newframe signinp = new newframe();
							signinp.setVisible(true);
			        
				        	 
				         
			         
			         //System.out.print(password);
			        // accountdum = Integer.toString(account);
			         
			         //System.out.print(account);
			        // name = rs.getString("name");
			         //dtf1.setText(name);
					 //dtf2.setText(accountdum); //convert int to string
			         
			        // System.out.print(name);
			         
			    }       
				//UIManager.put("OptionPane.minimumSize",new Dimension(200,100)); 
				//JOptionPane.showMessageDialog(NULL,"Successfully Login.","Alert",JOptionPane.WARNING_MESSAGE);
		    
				}
				catch(Exception e4) {
					e4.printStackTrace();
				}
				
			}
		});
		sb1.setFont(new Font("Tahoma", Font.BOLD, 16));
		sb1.setBounds(156, 217, 97, 25);
		contentPane.add(sb1);
		
		JButton sb2 = new JButton("Cancle");
		sb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				create c = new create();
				c.setVisible(true);
			}
		});
		sb2.setFont(new Font("Tahoma", Font.BOLD, 16));
		sb2.setBounds(285, 217, 97, 25);
		contentPane.add(sb2);
		
		stf1 = new JTextField();
		stf1.setFont(new Font("Tahoma", Font.BOLD, 16));
		stf1.setBounds(156, 104, 226, 35);
		contentPane.add(stf1);
		stf1.setColumns(10);
		
		spf1 = new JPasswordField();
		spf1.setFont(new Font("Tahoma", Font.BOLD, 16));
		spf1.setBounds(156, 154, 226, 35);
		contentPane.add(spf1);
	}
	public void close(){
		 
		 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
		 
		 }

}
