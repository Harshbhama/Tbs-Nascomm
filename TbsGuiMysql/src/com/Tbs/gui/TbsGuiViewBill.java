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
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsBillTableService;
import com.Tbs.service.TbsUserService;

public class TbsGuiViewBill implements ActionListener, KeyListener {

	public JPanel panel;
	public JFrame frame;
	public JLabel headingLabel, idLabel;
	public JTextField idTextField;
	public JButton viewButton, clearButton, backButton;

	public TbsGuiViewBill() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("View Bill");

		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiViewBill.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("View Bill");
		headingLabel.setFont(new Font("Serif", Font.ITALIC, 65));
		idLabel = new JLabel("Customer ID");
		idLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		viewButton = new JButton("View");
		viewButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		idTextField = new JTextField();

		headingLabel.setBounds(250, 50, 800, 100);

		idLabel.setBounds(300, 320, 150, 40);
		viewButton.setBounds(350, 450, 130, 50);
		clearButton.setBounds(520, 450, 130, 50);
		backButton.setBounds(680, 450, 130, 50);

		idTextField.setBounds(490, 320, 400, 40);
		idTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		viewButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);

		headingLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);

		frame.add(headingLabel);
		frame.add(idLabel);
		frame.add(idTextField);
		frame.add(viewButton);
		frame.add(clearButton);
		frame.add(backButton);

		idTextField.addKeyListener(this);
		viewButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		backButton.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == viewButton) {
			int flag = 0;
			int flag1 = 0;

			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserService tbsUserService = new TbsUserService();
			List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList = tbsBillTableService.billListService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(viewButton, "Please enter customer ID");
			}

			else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(idTextField.getText())) {
						flag1 = 1;
						break;
					} else {
						flag1 = 2;
					}
				}

				if (flag1 == 1) {

					if (tbsBillTableVosList.isEmpty()) {
						flag = 2;
					}

					else {
						for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
							if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
									&& billTableVo.billStatus.equals("due")) {
								flag = 1;
								break;
							} else {
								flag = 3;
							}
						}

					}
				}

				else if (flag1 == 2) {
					JOptionPane.showMessageDialog(viewButton, "Customer not found");

				}

				if (flag == 2) {
					JOptionPane.showMessageDialog(viewButton, "No due bills");
				}

				else if (flag == 1) {
					new TbsGuiViewBillList(Integer.parseInt(idTextField.getText()));
				}

				if (flag == 3) {
					JOptionPane.showMessageDialog(viewButton, "No due bills");

				}
			}

		} else if (actionEvent.getSource() == clearButton) {
			idTextField.setText("");
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
			int flag1 = 0;

			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserService tbsUserService = new TbsUserService();
			List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList = tbsBillTableService.billListService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(viewButton, "Please enter customer ID");
			}

			else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(idTextField.getText())) {
						flag1 = 1;
						break;
					} else {
						flag1 = 2;
					}
				}

				if (flag1 == 1) {

					if (tbsBillTableVosList.isEmpty()) {
						flag = 2;
					}

					else {
						for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
							if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
									&& billTableVo.billStatus.equals("due")) {
								flag = 1;
								break;
							} else {
								flag = 3;
							}
						}

					}
				}

				else if (flag1 == 2) {
					JOptionPane.showMessageDialog(viewButton, "Customer not found");

				}

				if (flag == 2) {
					JOptionPane.showMessageDialog(viewButton, "No due bills");
				}

				else if (flag == 1) {
					new TbsGuiViewBillList(Integer.parseInt(idTextField.getText()));
				}

				if (flag == 3) {
					JOptionPane.showMessageDialog(viewButton, "No due bills");

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
