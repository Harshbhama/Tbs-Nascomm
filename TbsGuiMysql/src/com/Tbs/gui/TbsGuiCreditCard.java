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

public class TbsGuiCreditCard extends TbsGuiUserCreditCard implements ActionListener, KeyListener {

	public TbsGuiCreditCard(int customerId, float payable) {
		super(customerId, payable);
	}

	public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public static Date date = new Date();

	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == payButton) {

			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
			TbsBillHistoryVo tbsVo = new TbsBillHistoryVo();

			tbsVo.setAmount(payable);

			tbsVo.setCustomerId(customerId);
			tbsVo.setPaymentMode("Credit Card");
			tbsVo.setPaymentDate(String.valueOf(dateFormat.format(date)));
			int x = tbsBillHistoryService.payBillService(tbsVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(payButton, "Congratulations");
				frame.setVisible(false);
				// TbsGuiUserHome.f.setVisible(false);
				new TbsGuiAdminHome();
			}
		} else if (actionEvent.getSource() == clearButton) {
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
			TbsBillHistoryVo tbsBillHistoryVo = new TbsBillHistoryVo();

			tbsBillHistoryVo.setAmount(payable);

			tbsBillHistoryVo.setCustomerId(customerId);
			tbsBillHistoryVo.setPaymentMode("Credit Card");
			tbsBillHistoryVo.setPaymentDate(String.valueOf(dateFormat.format(date)));
			int x = tbsBillHistoryService.payBillService(tbsBillHistoryVo);
			if (x > 0) {

				JOptionPane.showMessageDialog(payButton, "Congratulations");
				frame.setVisible(false);
				// TbsGuiUserHome.f.setVisible(false);
				new TbsGuiAdminHome();
			}
		}

		else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiPayBill();

		}

	}

}
