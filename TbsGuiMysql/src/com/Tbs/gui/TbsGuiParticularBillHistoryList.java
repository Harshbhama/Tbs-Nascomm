package com.Tbs.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Tbs.model.TbsBillHistoryVo;
import com.Tbs.service.TbsBillHistoryService;

public class TbsGuiParticularBillHistoryList {

	public TbsGuiParticularBillHistoryList(int custId) {

		JFrame frame = new JFrame("Bill History");
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1000, 500));

		Object[] column = { "Customer ID", "Customer Name", "Payment Mode", "Amount", "Date" };

		DefaultTableModel tmodel = new DefaultTableModel(column, 0);
		TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();
		List<TbsBillHistoryVo> tbsBillHistoryVosList = tbsBillHistoryService.particularBillHistoryService(custId);
		for (TbsBillHistoryVo billHistoryVo : tbsBillHistoryVosList) {

			Object[] data = { billHistoryVo.getCustomerId(), billHistoryVo.getCustomerName(),
					billHistoryVo.getPaymentMode(), billHistoryVo.getAmount(), billHistoryVo.getPaymentDate() };
			tmodel.addRow(data);

		}

		JTable table = new JTable(tmodel);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setFocusable(true);
		frame.requestFocus();
		frame.setVisible(true);
	}

}
