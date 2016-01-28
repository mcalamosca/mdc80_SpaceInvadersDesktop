package edu.pitt.is1017.spaceinvaders;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterGUI extends JFrame {
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	public RegisterGUI() {
		
		setTitle("SpaceInvaders - Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setSize(447,355);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 325);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//Labels
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(10, 11, 162, 30);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(10, 49, 162, 30);
		panel.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(10, 90, 162, 30);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(10, 131, 162, 30);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfirmPassword.setBounds(10, 172, 162, 30);
		panel.add(lblConfirmPassword);
		
		//Text Fields
		txtFirstName = new JTextField();
		txtFirstName.setBounds(177, 17, 249, 23);
		panel.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(177, 52, 249, 23);
		panel.add(txtLastName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(177, 90, 249, 23);
		panel.add(txtEmail);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(177, 131, 249, 23);
		panel.add(txtPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(177, 172, 249, 23);
		panel.add(txtConfirmPassword);
		
		//Buttons
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(185, 237, 110, 30);
		panel.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(305, 237, 110, 30);
		panel.add(btnCancel);
		
		//Button Action Listeners
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegisterActionPerformed(e);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelActionPerformed(e);
			}
		});
		
	}
	
	private void btnCancelActionPerformed(ActionEvent evt){
		System.exit(0);
	}
	
	private void btnRegisterActionPerformed(ActionEvent evt){
		
	}
}
