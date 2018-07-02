package com.Tbs.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Tbs.model.TbsBillTableVo;
import com.Tbs.service.TbsBillTableService;

public class TbsGuiViewBillList {

	public TbsGuiViewBillList(int custId) {

		JFrame frame = new JFrame("View Bill");
		JPanel panel = new JPanel();

		panel.setPreferredSize(new Dimension(1000, 500));
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);

		Object[] column = { "Min Duration", "Mb Usage", "Cost", "Invoice No", "Customer Name", "Customer ID",
				"Bill Status" };

		DefaultTableModel tmodel = new DefaultTableModel(column, 0);
		TbsBillTableService tbsBillTableService = new TbsBillTableService();

		List<TbsBillTableVo> tbsBillTableVosList = tbsBillTableService.viewBillService(custId);

		for (TbsBillTableVo billTableVo : tbsBillTableVosList) {

			Object[] data = { billTableVo.getDurationMin(), billTableVo.getUsageMb(), billTableVo.getCost(), billTableVo.getInvoice(),
					billTableVo.getCustomerName(), billTableVo.getCustomerId(), billTableVo.getBillStatus() };
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
