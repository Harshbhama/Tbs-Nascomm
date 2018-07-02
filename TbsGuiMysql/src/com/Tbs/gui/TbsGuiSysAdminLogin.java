package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.Tbs.service.TbsSystemAdminService;

public class TbsGuiSysAdminLogin implements ActionListener, KeyListener {

	public JPanel panel;
	public static JFrame frame;
	JLabel headingLabel, phoneLabel, passwordLabel;
	public static JTextField phoneTextField;
	public static JPasswordField PasswordField;
	JButton loginButton, clearButton, homeButton;

	public TbsGuiSysAdminLogin() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("TELEPHONE BILLING SYSTEM");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiSysAdminLogin.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("System Admin Login");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 50));
		headingLabel.setForeground(Color.WHITE);

		phoneLabel = new JLabel("System Admin Phone");
		phoneLabel.setFont(new Font("Aerial", Font.BOLD, 20));
		phoneLabel.setForeground(Color.WHITE);

		passwordLabel = new JLabel("System Admin Password");
		passwordLabel.setFont(new Font("Aerial", Font.BOLD, 20));
		passwordLabel.setForeground(Color.WHITE);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Aerial", Font.BOLD, 15));

		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.BOLD, 15));

		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Aerial", Font.BOLD, 15));

		phoneTextField = new JTextField();
		PasswordField = new JPasswordField();

		headingLabel.setBounds(250, 50, 800, 100);
		phoneLabel.setBounds(300, 250, 300, 40);
		passwordLabel.setBounds(300, 320, 300, 40);
		loginButton.setBounds(400, 450, 120, 50);
		clearButton.setBounds(580, 450, 130, 50);
		homeButton.setBounds(760, 450, 130, 50);
		phoneTextField.setBounds(600, 250, 450, 40);
		PasswordField.setBounds(600, 320, 450, 40);

		loginButton.addActionListener(this);
		clearButton.addActionListener(this);
		homeButton.addActionListener(this);

		frame.add(loginButton);
		frame.add(clearButton);
		frame.add(phoneTextField);
		frame.add(homeButton);
		frame.add(PasswordField);
		frame.add(headingLabel);
		frame.add(phoneLabel);
		frame.add(passwordLabel);

		phoneTextField.addKeyListener(this);
		PasswordField.addKeyListener(this);
		loginButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		homeButton.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == loginButton) {

			TbsSystemAdminService tbsSystemAdminService = new TbsSystemAdminService();

			if (phoneTextField.getText().equals("") || String.valueOf(PasswordField.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(loginButton, "Please enter login details");

			} else {
				int x = tbsSystemAdminService.systemAdminHomeService(Long.parseLong(phoneTextField.getText()),
						String.valueOf(PasswordField.getPassword()));
				if (x <= 0) {
					JOptionPane.showMessageDialog(loginButton, "Phone and password does not match");
				}
			}

		} else if (actionEvent.getSource() == clearButton) {
			phoneTextField.setText("");
			PasswordField.setText("");
		} else {

			phoneTextField.setText("");
			PasswordField.setText("");
			frame.setVisible(false);
			new TbsGuiHome();
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {

			TbsSystemAdminService tbsSystemAdminService = new TbsSystemAdminService();

			if (phoneTextField.getText().equals("") || String.valueOf(PasswordField.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(loginButton, "Please enter login details");

			} else {
				int x = tbsSystemAdminService.systemAdminHomeService(Long.parseLong(phoneTextField.getText()),
						String.valueOf(PasswordField.getPassword()));
				if (x <= 0) {
					JOptionPane.showMessageDialog(loginButton, "Phone and password does not match");
				}
			}
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			phoneTextField.setText("");
			PasswordField.setText("");
			frame.setVisible(false);
			new TbsGuiHome();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
