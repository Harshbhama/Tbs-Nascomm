package com.Tbs.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Tbs.model.TbsUserVo;

import com.Tbs.service.TbsUserService;

public class TbsGuiList {

	public TbsGuiList() {

		JFrame frame = new JFrame("Customer List");
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 250));
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);

		Object[] column = { "Customer ID", "Customer Name", "Customer Age", "Customer DOJ", "Customer Address",
				"Customer Phone", "Customer Plan" };
		DefaultTableModel tmodel = new DefaultTableModel(column, 0);
		TbsUserService tbsUserService = new TbsUserService();
		List<TbsUserVo> tbsUserVosList = tbsUserService.displayRecordService();
		for (TbsUserVo userVo : tbsUserVosList) {

			Object[] data = { userVo.getCustomerId(), userVo.getCustomerName(), userVo.getCustomerAge(),
					userVo.getCustomerDOJ(), userVo.getCustomerAddress(), userVo.getCustomerPhone(),
					userVo.getPlanName() };
			tmodel.addRow(data);

		}

		JTable table = new JTable(tmodel);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		frame.add(panel);
		frame.pack();
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		frame.setVisible(true);
	}

}
