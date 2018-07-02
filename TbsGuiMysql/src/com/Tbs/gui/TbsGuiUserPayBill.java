package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Tbs.model.TbsBillTableVo;
import com.Tbs.service.TbsBillTableService;

public class TbsGuiUserPayBill implements ActionListener, KeyListener {

	public static JFrame frame;
	public JPanel panel;
	public JLabel headingLabel, heading1Label, payableLabel, voucherLabel;
	public JButton creditCardButton, debitCardButton, backButton, applyButton, removeButton;
	public static JTextField voucherTextField;
	static int customerId;
	public float payable = 0;

	public TbsGuiUserPayBill(int customerId) {

		TbsGuiUserPayBill.customerId = customerId;

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Change Password");

		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiUserPayBill.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
		TbsBillTableService tbsBillTableService = new TbsBillTableService();
		tbsBillTableVosList = tbsBillTableService.billListService();

		for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
			if (billTableVo.getCustomerId() == customerId && billTableVo.getBillStatus().equals("due")) {

				payable += billTableVo.getCost();
			}
			continue;
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Pay Bill");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 65));
		heading1Label = new JLabel("Select Mode Of Payment");
		heading1Label.setForeground(Color.WHITE);
		heading1Label.setFont(new Font("Aerial", Font.ITALIC, 35));
		payableLabel = new JLabel("Payable amount is " + payable);
		payableLabel.setForeground(Color.WHITE);
		payableLabel.setFont(new Font("Serif", Font.ITALIC, 35));
		voucherLabel = new JLabel("Have any voucher?");
		voucherLabel.setForeground(Color.WHITE);
		voucherLabel.setFont(new Font("Aerial", Font.BOLD, 15));

		voucherTextField = new JTextField();
		voucherTextField.setBounds(1070, 80, 150, 20);

		creditCardButton = new JButton("Credit Card");
		creditCardButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		debitCardButton = new JButton("Debit Card");
		debitCardButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.BOLD, 20));
		applyButton = new JButton("Apply");
		applyButton.setFont(new Font("Aerial", Font.BOLD, 15));
		removeButton = new JButton("Remove");
		removeButton.setFont(new Font("Aerial", Font.BOLD, 15));

		headingLabel.setBounds(250, 40, 800, 100);
		payableLabel.setBounds(250, 130, 800, 100);
		voucherLabel.setBounds(900, 40, 800, 100);
		heading1Label.setBounds(500, 300, 800, 100);
		creditCardButton.setBounds(340, 400, 250, 50);
		debitCardButton.setBounds(740, 400, 250, 50);
		backButton.setBounds(600, 600, 140, 50);
		applyButton.setBounds(1230, 80, 100, 25);
		removeButton.setBounds(1230, 80, 100, 25);

		creditCardButton.addActionListener(this);
		debitCardButton.addActionListener(this);
		backButton.addActionListener(this);
		applyButton.addActionListener(this);
		removeButton.addActionListener(this);
		removeButton.setVisible(false);

		frame.add(headingLabel);
		frame.add(heading1Label);
		frame.add(payableLabel);
		frame.add(voucherLabel);
		frame.add(creditCardButton);
		frame.add(debitCardButton);
		frame.add(backButton);
		frame.add(voucherTextField);
		frame.add(applyButton);
		frame.add(removeButton);

		frame.addKeyListener(this);
		creditCardButton.addKeyListener(this);
		debitCardButton.addKeyListener(this);
		backButton.addKeyListener(this);

		headingLabel.setForeground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == creditCardButton) {
			frame.setVisible(false);
			new TbsGuiUserCreditCard(customerId, payable);
		} else if (actionEvent.getSource() == debitCardButton) {
			frame.setVisible(false);
			new TbsGuiUserDebitCard(customerId, payable);
		}

		else if (actionEvent.getSource() == backButton) {

			frame.setVisible(false);
			new TbsGuiUserHome(customerId);

		}

		else if (actionEvent.getSource() == applyButton) {

			if (voucherTextField.getText().equals("tbs100")) {
				payable = payable - 100f;
				payableLabel.setVisible(false);
				payableLabel.setText("Payable amount is " + payable);
				payableLabel.setVisible(true);
				JOptionPane.showMessageDialog(debitCardButton, "Bingo! code is applied");

				applyButton.setVisible(false);
				removeButton.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(debitCardButton, "Invalid Voucher Code!", "", JOptionPane.ERROR_MESSAGE);

			}

		}

		else if (actionEvent.getSource() == removeButton) {

			if (voucherTextField.getText().equals("tbs100")) {
				voucherTextField.setText("");
				payable += 100;
				payableLabel.setVisible(false);
				payableLabel.setText("Payable amount is " + payable);
				payableLabel.setVisible(true);
				removeButton.setVisible(false);
				applyButton.setVisible(true);

			}

		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiUserHome(customerId);
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
