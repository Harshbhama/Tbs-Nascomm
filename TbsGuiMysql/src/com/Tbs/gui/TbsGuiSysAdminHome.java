package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TbsGuiSysAdminHome implements ActionListener {

	public static JFrame frame;
	JLabel headingLabel;
	JButton newConnectionButton, logoutButton;
	JPanel panel;

	public TbsGuiSysAdminHome() {

		frame = new JFrame("System Admin Home");

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiSysAdminHome.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("System Admin Home");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 50));
		headingLabel.setForeground(Color.WHITE);

		newConnectionButton = new JButton("New Connection");
		newConnectionButton.setFont(new Font("Aerial", Font.BOLD, 15));

		logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Aerial", Font.BOLD, 15));

		headingLabel.setBounds(250, 50, 800, 100);
		newConnectionButton.setBounds(350, 350, 220, 50);
		logoutButton.setBounds(750, 350, 220, 50);

		newConnectionButton.addActionListener(this);
		logoutButton.addActionListener(this);

		frame.add(newConnectionButton);
		frame.add(logoutButton);
		frame.add(headingLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == newConnectionButton) {

			frame.setVisible(false);
			new TbsGuiNewConnection();

		} else {
			frame.setVisible(false);
			new TbsGuiHome();
		}
	}
}
