package com.Tbs.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TbsGuiHome implements ActionListener {

	JButton userLoginButton, adminLoginButton, unregisteredUserLoginButton, systemAdminLoginButton;
	public static JFrame frame;
	public static JPanel panel;
	ImageIcon image;
	JLabel imageLabel;

	public TbsGuiHome() {

		Image bg = null;
		Image title = null;

		try {

			bg = ImageIO.read(TbsGuiHome.class.getResource("look.com.ua-35320.jpg"));

			title = ImageIO.read(TbsGuiHome.class.getResource("img.png"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame = new JFrame("Telephone Billing System");

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		image = new ImageIcon(title);
		imageLabel = new JLabel(image);

		userLoginButton = new JButton("USER LOGIN");
		userLoginButton.setFont(new Font("Aerial", Font.BOLD, 15));
		userLoginButton.setHorizontalTextPosition(AbstractButton.CENTER);
		userLoginButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		adminLoginButton = new JButton("ADMIN LOGIN");
		adminLoginButton.setFont(new Font("Aerial", Font.BOLD, 15));
		adminLoginButton.setHorizontalTextPosition(AbstractButton.CENTER);
		adminLoginButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		unregisteredUserLoginButton = new JButton("UNREGISTERED USERS");
		unregisteredUserLoginButton.setFont(new Font("Aerial", Font.BOLD, 15));
		unregisteredUserLoginButton.setHorizontalTextPosition(AbstractButton.CENTER);
		unregisteredUserLoginButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		systemAdminLoginButton = new JButton("SYSTEM ADMIN LOGIN");
		systemAdminLoginButton.setFont(new Font("Aerial", Font.BOLD, 15));
		systemAdminLoginButton.setHorizontalTextPosition(AbstractButton.CENTER);
		systemAdminLoginButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		imageLabel.setBounds(250, 70, 800, 100);

		userLoginButton.setBounds(120, 380, 400, 70);
		adminLoginButton.setBounds(760, 380, 400, 70);
		unregisteredUserLoginButton.setBounds(120, 550, 400, 50);
		systemAdminLoginButton.setBounds(760, 550, 400, 50);

		userLoginButton.addActionListener(this);
		adminLoginButton.addActionListener(this);
		unregisteredUserLoginButton.addActionListener(this);
		systemAdminLoginButton.addActionListener(this);

		frame.add(imageLabel);
		frame.add(userLoginButton);
		frame.add(adminLoginButton);
		frame.add(unregisteredUserLoginButton);
		frame.add(systemAdminLoginButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == userLoginButton) {

			frame.setVisible(false);
			new TbsGuiUserLogin();

		} else if (actionEvent.getSource() == adminLoginButton) {

			frame.setVisible(false);
			new TbsGuiAdminLogin();
		} else if (actionEvent.getSource() == unregisteredUserLoginButton) {

			frame.setVisible(false);
			new TbsGuiUnregHome();

		} else {

			frame.setVisible(false);
			new TbsGuiSysAdminLogin();
		}

	}

}
