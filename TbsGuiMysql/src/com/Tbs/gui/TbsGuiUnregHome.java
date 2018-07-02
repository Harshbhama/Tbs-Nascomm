package com.Tbs.gui;

import java.awt.Color;
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

public class TbsGuiUnregHome implements ActionListener {

	public JPanel panel;
	public JFrame frame;
	JLabel headingLabel;

	JButton planButton, homeButton;

	public TbsGuiUnregHome() {

		frame = new JFrame("Unregistered User Home");

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiUnregHome.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Unregistered User Home");

		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 50));
		headingLabel.setForeground(Color.WHITE);

		planButton = new JButton("Plans");
		planButton.setFont(new Font("Aerial", Font.BOLD, 15));
		planButton.setHorizontalTextPosition(AbstractButton.CENTER);
		planButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		homeButton = new JButton("Home");
		homeButton.setFont(new Font("Aerial", Font.BOLD, 15));
		homeButton.setHorizontalTextPosition(AbstractButton.CENTER);
		homeButton.setVerticalTextPosition(AbstractButton.BOTTOM);

		headingLabel.setBounds(250, 50, 800, 100);
		planButton.setBounds(350, 350, 220, 50);
		homeButton.setBounds(750, 350, 220, 50);

		planButton.addActionListener(this);
		homeButton.addActionListener(this);

		frame.add(planButton);
		frame.add(homeButton);
		frame.add(headingLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == planButton) {
			new TbsGuiPlanList();
		} else {
			frame.setVisible(false);
			new TbsGuiHome();
		}
	}

}
