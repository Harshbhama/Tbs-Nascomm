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

import com.Tbs.model.TbsBillHistoryVo;
import com.Tbs.service.TbsBillHistoryService;

public class TbsGuiCash implements ActionListener, KeyListener {

	JFrame frame;
	JButton confirmButton, backButton;
	JLabel headingLabel, payableLabel, confirmLabel;
	float payable;
	int customerId;

	public TbsGuiCash(int customerId, float payable) {

		this.customerId = customerId;
		this.payable = payable;

		Image bg = null;

		try {
			bg = ImageIO.read(TbsGuiCash.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame = new JFrame("Pay in cash");
		frame.setSize(1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JLabel(new ImageIcon(bg)));

		headingLabel = new JLabel("Paying through cash");
		payableLabel = new JLabel("Payable amount is " + payable);
		confirmLabel = new JLabel("Confirm if cash is collected");

		confirmButton = new JButton("Confirm");
		backButton = new JButton("Back");

		headingLabel.setFont(new Font("Serif", Font.ITALIC, 65));
		headingLabel.setBounds(250, 40, 800, 100);
		headingLabel.setForeground(Color.WHITE);

		payableLabel.setFont(new Font("Serif", Font.ITALIC, 35));
		payableLabel.setBounds(350, 140, 800, 100);
		payableLabel.setForeground(Color.WHITE);

		confirmLabel.setFont(new Font("Aeriel", Font.ITALIC, 35));
		confirmLabel.setBounds(500, 240, 800, 100);
		confirmLabel.setForeground(Color.WHITE);

		confirmButton.setBounds(640, 340, 140, 50);
		backButton.setBounds(640, 600, 140, 50);

		confirmButton.addActionListener(this);
		backButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(payableLabel);
		frame.add(confirmLabel);
		frame.add(confirmButton);
		frame.add(backButton);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == confirmButton) {

			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
			TbsBillHistoryVo tbsBillHistoryVo = new TbsBillHistoryVo();

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

			tbsBillHistoryVo.setAmount(payable);

			tbsBillHistoryVo.setCustomerId(customerId);
			tbsBillHistoryVo.setPaymentMode("Cash");
			tbsBillHistoryVo.setPaymentDate(dateFormat.format(date));
			int x = tbsBillHistoryService.payBillService(tbsBillHistoryVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(confirmButton, "Paid");
				frame.setVisible(false);
				new TbsGuiAdminHome();

			}
		} else {
			frame.setVisible(false);
			new TbsGuiPayBill();
		}

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {

			frame.setVisible(false);
			new TbsGuiPayBill();

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

	public static void main(String args[]) {
		new TbsGuiCash(2, 457f);
	}

}
