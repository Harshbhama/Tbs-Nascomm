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

public class TbsGuiAdminHome implements ActionListener {

	public static JFrame frame;
	JPanel panel;
	JLabel headingLabel;
	JButton modifyButton, removeButton, customerDetailsButton, customerListbutton, viewBillButton, payBillButton,
			plansButton, generateBillButton, billListButton, billHistoryButton, customerBillHistoryButton, logoutButton;

	public TbsGuiAdminHome() {

		frame = new JFrame("Admin Home");

		Image bg = null;

		try {
			bg = ImageIO.read(TbsGuiAdminHome.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Admin Home");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 50));
		headingLabel.setForeground(Color.WHITE);

		modifyButton = new JButton("Modify Customer Record");
		modifyButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		removeButton = new JButton("Remove Connection");
		removeButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		customerDetailsButton = new JButton("Customer Details");
		customerDetailsButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		customerListbutton = new JButton("Customer List");
		customerListbutton.setFont(new Font("Aerial", Font.ITALIC, 15));

		viewBillButton = new JButton("View Bill");
		viewBillButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		payBillButton = new JButton("Pay Bill");
		payBillButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		plansButton = new JButton("Plans");
		plansButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		generateBillButton = new JButton("Generate Bill");
		generateBillButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		billListButton = new JButton("Bill List");
		billListButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		billHistoryButton = new JButton("Bill History");
		billHistoryButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		customerBillHistoryButton = new JButton("Customer Bill History");
		customerBillHistoryButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Aerial", Font.ITALIC, 15));

		modifyButton.addActionListener(this);
		removeButton.addActionListener(this);
		customerDetailsButton.addActionListener(this);
		customerListbutton.addActionListener(this);
		viewBillButton.addActionListener(this);
		payBillButton.addActionListener(this);
		plansButton.addActionListener(this);
		generateBillButton.addActionListener(this);
		billListButton.addActionListener(this);
		billHistoryButton.addActionListener(this);
		customerBillHistoryButton.addActionListener(this);
		logoutButton.addActionListener(this);

		headingLabel.setBounds(250, 50, 800, 100);
		modifyButton.setBounds(350, 200, 220, 50);
		removeButton.setBounds(750, 200, 220, 50);
		customerDetailsButton.setBounds(350, 280, 220, 50);
		customerListbutton.setBounds(750, 280, 220, 50);
		viewBillButton.setBounds(350, 360, 220, 50);
		payBillButton.setBounds(750, 360, 220, 50);
		plansButton.setBounds(350, 440, 220, 50);
		generateBillButton.setBounds(750, 440, 220, 50);
		billListButton.setBounds(350, 520, 220, 50);
		billHistoryButton.setBounds(750, 520, 220, 50);
		customerBillHistoryButton.setBounds(350, 600, 220, 50);
		logoutButton.setBounds(750, 600, 220, 50);

		frame.add(headingLabel);
		frame.add(modifyButton);
		frame.add(removeButton);
		frame.add(customerDetailsButton);
		frame.add(customerListbutton);
		frame.add(viewBillButton);
		frame.add(payBillButton);
		frame.add(plansButton);
		frame.add(generateBillButton);
		frame.add(billListButton);
		frame.add(billHistoryButton);
		frame.add(customerBillHistoryButton);
		frame.add(logoutButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == modifyButton) {

			frame.setVisible(false);
			new TbsGuiModify();

		}

		else if (actionEvent.getSource() == removeButton) {

			frame.setVisible(false);
			new TbsGuiDelete();

		}

		else if (actionEvent.getSource() == customerDetailsButton) {

			frame.setVisible(false);
			new TbsGuiCustDetails();

		}

		else if (actionEvent.getSource() == customerListbutton) {
			new TbsGuiList();
		}

		else if (actionEvent.getSource() == viewBillButton) {

			frame.setVisible(false);
			new TbsGuiViewBill();
		}

		else if (actionEvent.getSource() == payBillButton) {

			frame.setVisible(false);
			new TbsGuiPayBill();

		}

		else if (actionEvent.getSource() == plansButton) {
			new TbsGuiPlanList();
		}

		else if (actionEvent.getSource() == generateBillButton) {

			frame.setVisible(false);
			new TbsGuiGenerateBill();

		}

		else if (actionEvent.getSource() == billListButton) {
			new TbsGuiBillList();
		}

		else if (actionEvent.getSource() == billHistoryButton) {
			new TbsGuiBillHistoryList();
		}

		else if (actionEvent.getSource() == customerBillHistoryButton) {

			frame.setVisible(false);
			new TbsGuiParicularBillHistory();

		}

		else {

			frame.setVisible(false);
			new TbsGuiHome();
		}

	}

}
