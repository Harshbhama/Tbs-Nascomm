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

import com.Tbs.model.TbsUserVo;

import com.Tbs.service.TbsUserService;

public class TbsGuiChangePassword implements ActionListener, KeyListener {

	public static JFrame frame;
	public JPanel panel;
	JLabel headingLabel, passwordLabel, confirmPasswordLabel;
	JButton changeButton, clearButton, backButton;
	JPasswordField passwordField, confirmPasswordField;
	int customerId;

	public TbsGuiChangePassword(int customerId) {

		this.customerId = customerId;

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Change Password");

		frame.setLayout(null);

		Image bg = null;

		try {
			bg = ImageIO.read(TbsGuiChangePassword.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Change Password");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 50));
		headingLabel.setForeground(Color.white);

		passwordLabel = new JLabel("New Password");
		passwordLabel.setFont(new Font("Aerial", Font.BOLD, 20));
		confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Aerial", Font.BOLD, 20));
		changeButton = new JButton("Change");
		changeButton.setFont(new Font("Aerial", Font.BOLD, 15));
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.BOLD, 15));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.BOLD, 15));

		passwordField = new JPasswordField();
		confirmPasswordField = new JPasswordField();
		passwordField.setFont(new Font("Aerial", Font.ITALIC, 20));
		confirmPasswordField.setFont(new Font("Aerial", Font.ITALIC, 20));

		headingLabel.setBounds(250, 40, 800, 100);
		passwordLabel.setBounds(250, 250, 200, 40);
		confirmPasswordLabel.setBounds(250, 320, 250, 40);
		changeButton.setBounds(400, 450, 140, 50);
		clearButton.setBounds(580, 450, 140, 50);
		backButton.setBounds(760, 450, 140, 50);
		passwordField.setBounds(550, 250, 400, 40);
		confirmPasswordField.setBounds(550, 320, 400, 40);

		changeButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);

		headingLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.WHITE);
		confirmPasswordLabel.setForeground(Color.WHITE);

		frame.add(headingLabel);
		frame.add(passwordLabel);
		frame.add(passwordField);
		frame.add(confirmPasswordLabel);
		frame.add(confirmPasswordField);
		frame.add(changeButton);
		frame.add(clearButton);
		frame.add(backButton);
		passwordField.addKeyListener(this);
		confirmPasswordField.addKeyListener(this);
		changeButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		backButton.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == changeButton) {

			TbsUserService tbsUserService = new TbsUserService();
			TbsUserVo tbsUserVo = new TbsUserVo();

			tbsUserVo.setUserPassword(String.valueOf(passwordField.getPassword()));
			tbsUserVo.setCustomerId(customerId);

			if (String.valueOf(passwordField.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(changeButton, "Please enter new password");
			} else {

				if (String.valueOf(passwordField.getPassword())
						.equals(String.valueOf(confirmPasswordField.getPassword()))) {
					int x = tbsUserService.modifyCustomerPasswordService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(changeButton, "Password changed successfully");
						frame.setVisible(false);
						new TbsGuiUserHome(customerId);
					}
				} else {
					JOptionPane.showMessageDialog(changeButton, "Password does not match");
				}

			}

		} else if (actionEvent.getSource() == clearButton) {
			passwordField.setText("");
			confirmPasswordField.setText("");
		} else {

			frame.setVisible(false);
			new TbsGuiUserHome(customerId);
		}

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {

			TbsUserService tbsUserService = new TbsUserService();
			TbsUserVo tbsUserVo = new TbsUserVo();

			tbsUserVo.setUserPassword(String.valueOf(passwordField.getPassword()));
			tbsUserVo.setCustomerId(customerId);

			if (String.valueOf(passwordField.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(changeButton, "Please enter new password");
			} else {

				if (String.valueOf(passwordField.getPassword())
						.equals(String.valueOf(confirmPasswordField.getPassword()))) {
					int x = tbsUserService.modifyCustomerPasswordService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(changeButton, "Password changed successfully");
						frame.setVisible(false);
						new TbsGuiUserHome(customerId);
					}
				} else {
					JOptionPane.showMessageDialog(changeButton, "Password does not match");
				}

			}

		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiUserHome(customerId);
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
