package com.Tbs.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.Tbs.model.TbsBillHistoryVo;

import com.Tbs.service.TbsBillHistoryService;

public class TbsGuiDebitCard extends TbsGuiUserDebitCard implements ActionListener, KeyListener {

	public TbsGuiDebitCard(int customerId, float payable) {
		super(customerId, payable);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == payButton) {

			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
			TbsBillHistoryVo tbsBillHistoryVo = new TbsBillHistoryVo();
			DateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yy");
			Date date = new Date();

			tbsBillHistoryVo.setAmount(payable);

			tbsBillHistoryVo.setCustomerId(customerId);
			tbsBillHistoryVo.setPaymentMode("Debit Card");
			tbsBillHistoryVo.setPaymentDate(dateFormat.format(date));
			int x = tbsBillHistoryService.payBillService(tbsBillHistoryVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(payButton, "Congratulations");
				frame.setVisible(false);

				new TbsGuiAdminHome();
			}
		} else if (e.getSource() == clearButton) {
			cardNumberTextField.setText("");
			expiryDateTextField.setText("");
			cvvTextField.setText("");
		} else {
			frame.setVisible(false);
			new TbsGuiPayBill();
		}
	}

	public void keyPressed(KeyEvent keyEvent) {
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {

			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
			TbsBillHistoryVo tbsVo = new TbsBillHistoryVo();

			DateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yy");
			Date date = new Date();

			tbsVo.setAmount(payable);

			tbsVo.setCustomerId(customerId);
			tbsVo.setPaymentMode("Debit Card");
			tbsVo.setPaymentDate(dateFormat.format(date));
			int x = tbsBillHistoryService.payBillService(tbsVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(payButton, "Congratulations");
				frame.setVisible(false);

				new TbsGuiAdminHome();
			}
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiPayBill();
		}
	}

}
