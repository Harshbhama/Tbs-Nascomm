package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.Tbs.model.TbsBillHistoryVo;
import com.Tbs.service.TbsBillHistoryService;

public class TbsGuiUserCreditCard implements ActionListener, KeyListener {

	public JLabel headingLabel, cardNumberLabel, expiryDateLabel, cvvLabel, payableLabel;
	public JTextField cardNumberTextField, expiryDateTextField, cvvTextField;
	public float payable;
	public JButton payButton, clearButton, backButton;
	public JFrame frame;
	public int customerId;

	public TbsGuiUserCreditCard(int customerId, float payable) {

		this.customerId = customerId;
		this.payable = payable;

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Credit Card");

		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiUserCreditCard.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		payableLabel = new JLabel("Payable amount is " + payable);
		payableLabel.setForeground(Color.WHITE);
		payableLabel.setFont(new Font("Serif", Font.ITALIC, 35));

		headingLabel = new JLabel("Paying through Credit Card");
		headingLabel.setFont(new Font("Serif", Font.ITALIC, 65));
		cardNumberLabel = new JLabel("Card Number");
		cardNumberLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		expiryDateLabel = new JLabel("Expiry Date");
		expiryDateLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		cvvLabel = new JLabel("CVV No.");
		cvvLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		payButton = new JButton("Pay");
		payButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		cardNumberTextField = new JTextField();
		expiryDateTextField = new JTextField();
		cvvTextField = new JTextField();
		cardNumberTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		expiryDateTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		cvvTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		headingLabel.setBounds(250, 40, 800, 100);
		payableLabel.setBounds(350, 140, 800, 100);
		cardNumberLabel.setBounds(350, 250, 160, 40);
		expiryDateLabel.setBounds(350, 320, 160, 40);
		cvvLabel.setBounds(350, 390, 160, 40);
		payButton.setBounds(400, 550, 140, 50);
		clearButton.setBounds(580, 550, 140, 50);
		backButton.setBounds(760, 550, 140, 50);
		cardNumberTextField.setBounds(550, 250, 400, 40);
		expiryDateTextField.setBounds(550, 320, 400, 40);
		cvvTextField.setBounds(550, 390, 400, 40);

		payButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);

		headingLabel.setForeground(Color.WHITE);
		cardNumberLabel.setForeground(Color.WHITE);
		expiryDateLabel.setForeground(Color.WHITE);
		cvvLabel.setForeground(Color.WHITE);

		frame.add(headingLabel);
		frame.add(payableLabel);
		frame.add(cardNumberLabel);
		frame.add(cardNumberTextField);
		frame.add(expiryDateLabel);
		frame.add(expiryDateTextField);
		frame.add(cvvLabel);
		frame.add(cvvTextField);
		frame.add(payButton);
		frame.add(clearButton);
		frame.add(backButton);

		frame.addKeyListener(this);
		cardNumberTextField.addKeyListener(this);
		expiryDateTextField.addKeyListener(this);
		cvvTextField.addKeyListener(this);
		payButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		backButton.addKeyListener(this);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == payButton) {

			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
			TbsBillHistoryVo tbsBillHistoryVo = new TbsBillHistoryVo();

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

			tbsBillHistoryVo.setAmount(payable);

			tbsBillHistoryVo.setCustomerId(customerId);
			tbsBillHistoryVo.setPaymentMode("Credit Card");
			tbsBillHistoryVo.setPaymentDate(dateFormat.format(date));
			int x = tbsBillHistoryService.payBillService(tbsBillHistoryVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(payButton, "Congratulations");
				frame.setVisible(false);
				new TbsGuiUserHome(customerId);
			}
		} else if (actionEvent.getSource() == clearButton) {
			cardNumberTextField.setText("");
			expiryDateTextField.setText("");
			cvvTextField.setText("");
		} else {
			frame.setVisible(false);
			new TbsGuiUserPayBill(customerId);
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
			TbsBillHistoryVo tbsBillHistoryVo = new TbsBillHistoryVo();

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

			tbsBillHistoryVo.setAmount(payable);

			tbsBillHistoryVo.setCustomerId(customerId);
			tbsBillHistoryVo.setPaymentMode("Credit Card");
			tbsBillHistoryVo.setPaymentDate(dateFormat.format(date));
			int x = tbsBillHistoryService.payBillService(tbsBillHistoryVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(payButton, "Congratulations");
				frame.setVisible(false);
				new TbsGuiUserHome(customerId);
			}
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiUserPayBill(customerId);
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
