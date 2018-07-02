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

import com.Tbs.service.TbsAdminService;

public class TbsGuiAdminLogin implements ActionListener, KeyListener {

	public static JFrame frame;
	public JPanel panel;
	JLabel headingLabel, phoneLabel, passwordLabel;
	public static JTextField phoneTextField;
	public static JPasswordField passwordField;
	JButton loginButton, clearButton, homeButton;

	public TbsGuiAdminLogin() {

		frame = new JFrame("Admin Login");

		frame.setSize(1366, 768);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiAdminLogin.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		frame.setContentPane(new JLabel(new ImageIcon(bg)));

		headingLabel = new JLabel("Admin  LOGIN");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 50));
		headingLabel.setForeground(Color.WHITE);

		phoneLabel = new JLabel("Admin Phone");
		phoneLabel.setFont(new Font("Aerial", Font.ITALIC, 20));
		phoneLabel.setForeground(Color.WHITE);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Aerial", Font.ITALIC, 20));
		passwordLabel.setForeground(Color.WHITE);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		phoneTextField = new JTextField();
		passwordField = new JPasswordField();

		headingLabel.setBounds(250, 50, 800, 100);
		phoneLabel.setBounds(300, 250, 140, 40);
		passwordLabel.setBounds(300, 320, 140, 40);

		loginButton.setBounds(400, 450, 120, 50);
		clearButton.setBounds(580, 450, 130, 50);
		homeButton.setBounds(760, 450, 130, 50);

		phoneTextField.setBounds(480, 250, 500, 40);
		passwordField.setBounds(480, 320, 500, 40);

		loginButton.addActionListener(this);
		clearButton.addActionListener(this);
		homeButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(phoneLabel);
		frame.add(passwordLabel);
		frame.add(loginButton);
		frame.add(clearButton);
		frame.add(homeButton);
		frame.add(phoneTextField);
		frame.add(passwordField);

		phoneTextField.addKeyListener(this);
		passwordField.addKeyListener(this);
		loginButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		homeButton.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == loginButton) {

			TbsAdminService tbsAdminService = new TbsAdminService();

			if (phoneTextField.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(loginButton, "Please enter login details");

			} else {
				int x = tbsAdminService.adminHomeService(Long.parseLong(phoneTextField.getText()),
						String.valueOf(passwordField.getPassword()));
				if (x <= 0) {
					JOptionPane.showMessageDialog(loginButton, "Phone and password does not match");
				}
			}

		}

		else if (actionEvent.getSource() == clearButton) {
			phoneTextField.setText("");
			passwordField.setText("");
		} else {

			phoneTextField.setText("");
			passwordField.setText("");
			frame.setVisible(false);
			new TbsGuiHome();
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
			TbsAdminService tbsAdminService = new TbsAdminService();

			if (phoneTextField.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(loginButton, "Please enter login details");

			} else {
				int x = tbsAdminService.adminHomeService(Long.parseLong(phoneTextField.getText()),
						String.valueOf(passwordField.getPassword()));
				if (x <= 0) {
					JOptionPane.showMessageDialog(loginButton, "Phone and password does not match");
				}
			}
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			phoneTextField.setText("");
			passwordField.setText("");
			TbsGuiAdminLogin.frame.setVisible(false);
			new TbsGuiHome();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
