package com.Tbs.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Tbs.model.TbsPlanVo;
import com.Tbs.service.TbsPlanService;

public class TbsGuiPlanList {

	public TbsGuiPlanList() {

		JFrame frame = new JFrame("Plan List");
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 250));
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel);

		Object[] column = { "Plan Name", "Plan Code", "Plan Validity", "costPerMB", "costPerMin", "Base Cost" };
		DefaultTableModel tmodel = new DefaultTableModel(column, 0);
		TbsPlanService tbsPlanService = new TbsPlanService();
		List<TbsPlanVo> tbsPlanVosList = tbsPlanService.planListService();
		for (TbsPlanVo planVo : tbsPlanVosList) {

			Object[] data = { planVo.getPlanName(), planVo.getPlanCode(), planVo.getPlanValidity(),
					planVo.getCostPerMb(), planVo.getCostPerMin(), planVo.getBaseCost() };
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
