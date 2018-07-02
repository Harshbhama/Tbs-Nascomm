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

import com.Tbs.model.TbsBillHistoryVo;
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsBillHistoryService;
import com.Tbs.service.TbsUserService;

public class TbsGuiParicularBillHistory implements ActionListener, KeyListener {

	public JPanel panel;
	public JFrame frame;
	public JLabel headingLabel, idLabel;
	public JTextField idTextField;
	public JButton viewButton, backButton, button3;

	public TbsGuiParicularBillHistory() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Delete Record");

		frame.setLayout(null);

		Image bg = null;

		try {
			bg = ImageIO.read(TbsGuiParicularBillHistory.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Customer Bill History");
		headingLabel.setFont(new Font("Serif", Font.ITALIC, 65));
		idLabel = new JLabel("Customer ID");
		idLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		viewButton = new JButton("View");
		viewButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		idTextField = new JTextField();
		idTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		headingLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);

		headingLabel.setBounds(250, 50, 800, 100);

		idLabel.setBounds(300, 320, 150, 40);
		viewButton.setBounds(400, 450, 130, 50);
		backButton.setBounds(580, 450, 130, 50);

		idTextField.setBounds(490, 320, 400, 40);

		viewButton.addActionListener(this);
		backButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(idLabel);
		frame.add(idTextField);
		frame.add(viewButton);

		frame.add(backButton);

		idTextField.addKeyListener(this);
		viewButton.addKeyListener(this);
		backButton.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == viewButton) {
			int flag = 0;

			TbsUserService tbsUserService = new TbsUserService();
			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			List<TbsBillHistoryVo> tbsBillHistoryVosList = new ArrayList<TbsBillHistoryVo>();

			tbsUserVosList = tbsUserService.displayRecordService();
			tbsBillHistoryVosList = tbsBillHistoryService.billHistoryService();
			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(viewButton, "Please enter customer ID");
			} else {

				for (TbsBillHistoryVo billHistoryVo : tbsBillHistoryVosList) {
					if (billHistoryVo.getCustomerId() == Integer.parseInt(idTextField.getText())) {
						flag = 4;
						break;
					} else {
						flag = 3;
					}
				}

				if (flag == 3) {
					for (TbsUserVo userVo : tbsUserVosList) {
						if (userVo.getCustomerId() == Integer.parseInt(idTextField.getText())) {
							flag = 1;
							break;
						} else {
							flag = 2;
						}
					}

					if (flag == 1) {
						JOptionPane.showMessageDialog(viewButton, "No bill history");
					} else if (flag == 2) {
						JOptionPane.showMessageDialog(viewButton, "Customer not found");

					}

				} else if (flag == 4) {
					new TbsGuiParticularBillHistoryList(Integer.parseInt(idTextField.getText()));

				}

			}

		}

		else {
			frame.setVisible(false);
			new TbsGuiAdminHome();
		}
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
			int flag = 0;

			TbsUserService tbsUserService = new TbsUserService();
			TbsBillHistoryService tbsBillHistoryService = new TbsBillHistoryService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			List<TbsBillHistoryVo> tbsBillHistoryVosList = new ArrayList<TbsBillHistoryVo>();

			tbsUserVosList = tbsUserService.displayRecordService();
			tbsBillHistoryVosList = tbsBillHistoryService.billHistoryService();
			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(viewButton, "Please enter customer ID");
			} else {

				for (TbsBillHistoryVo billHistoryVo : tbsBillHistoryVosList) {
					if (billHistoryVo.getCustomerId() == Integer.parseInt(idTextField.getText())) {
						flag = 4;
						break;
					} else {
						flag = 3;
					}
				}

				if (flag == 3) {
					for (TbsUserVo userVo : tbsUserVosList) {
						if (userVo.getCustomerId() == Integer.parseInt(idTextField.getText())) {
							flag = 1;
							break;
						} else {
							flag = 2;
						}
					}

					if (flag == 1) {
						JOptionPane.showMessageDialog(viewButton, "No bill history");
					} else if (flag == 2) {
						JOptionPane.showMessageDialog(viewButton, "Customer not found");

					}

				} else if (flag == 4) {
					new TbsGuiParticularBillHistoryList(Integer.parseInt(idTextField.getText()));

				}

			}
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiAdminHome();
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
