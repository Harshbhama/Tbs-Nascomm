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

public class TbsGuiPayBill implements ActionListener, KeyListener {

	public JPanel panel;
	public JFrame frame;
	public JLabel headingLabel, idLabel, label3, heading1Label;
	public JTextField idTextField;
	public JButton creditCardButton, debitCardButton, backButton, cashButton;
	int flag = 0;
	int flag1 = 0;
	public float payable;

	public TbsGuiPayBill() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Change Password");

		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiPayBill.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		heading1Label = new JLabel("Select Mode Of Payment");
		heading1Label.setForeground(Color.WHITE);
		heading1Label.setFont(new Font("Serif", Font.ITALIC, 35));
		headingLabel = new JLabel("Pay Bill");
		headingLabel.setFont(new Font("Serif", Font.ITALIC, 65));
		idLabel = new JLabel("Customer ID");
		idLabel.setFont(new Font("Serif", Font.ITALIC, 35));
		idLabel.setForeground(Color.WHITE);

		creditCardButton = new JButton("Credit Card");
		creditCardButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		debitCardButton = new JButton("Debit Card");
		debitCardButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.BOLD, 15));
		cashButton = new JButton("Cash");
		cashButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		idTextField = new JTextField();
		idTextField.setBounds(550, 230, 300, 40);

		headingLabel.setBounds(250, 40, 800, 100);
		heading1Label.setBounds(500, 350, 800, 100);
		idLabel.setBounds(300, 200, 200, 100);

		creditCardButton.setBounds(250, 450, 250, 50);
		debitCardButton.setBounds(550, 450, 250, 50);
		backButton.setBounds(600, 650, 140, 50);
		cashButton.setBounds(850, 450, 250, 50);

		creditCardButton.addActionListener(this);
		debitCardButton.addActionListener(this);
		backButton.addActionListener(this);
		cashButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(heading1Label);
		frame.add(idLabel);
		frame.add(creditCardButton);
		frame.add(debitCardButton);
		frame.add(backButton);
		frame.add(cashButton);
		frame.add(idTextField);

		idTextField.addKeyListener(this);

		headingLabel.setForeground(Color.WHITE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == creditCardButton) {

			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserService tbsUserService = new TbsUserService();

			List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList = tbsBillTableService.billListService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(creditCardButton, "Please enter customer ID");
			} else {

				for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
					if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
							&& billTableVo.getBillStatus().equals("due")) {

						payable += billTableVo.getCost();
					}
					continue;
				}

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
						JOptionPane.showMessageDialog(creditCardButton, "No bill due");

					} else {
						for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
							if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
									&& billTableVo.getBillStatus().equals("due")) {
								flag = 1;
								break;
							} else {
								flag = 2;
							}
						}
					}

					if (flag == 1) {
						frame.setVisible(false);

						new TbsGuiCreditCard(Integer.parseInt(idTextField.getText()), payable);
					} else if (flag == 2) {
						JOptionPane.showMessageDialog(creditCardButton, "No bill due");
					}
				} else if (flag1 == 2) {
					JOptionPane.showMessageDialog(creditCardButton, "Customer not found");

				}

			}

		} else if (actionEvent.getSource() == debitCardButton) {

			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserService tbsUserService = new TbsUserService();

			List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList = tbsBillTableService.billListService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(debitCardButton, "Please enter customer ID");

			} else {

				for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
					if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
							&& billTableVo.getBillStatus().equals("due")) {

						payable += billTableVo.getCost();
					}
					continue;
				}

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
						JOptionPane.showMessageDialog(debitCardButton, "No bill due");

					} else {
						for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
							if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
									&& billTableVo.getBillStatus().equals("due")) {
								flag = 1;
								break;
							} else {
								flag = 2;
							}
						}
					}

					if (flag == 1) {
						frame.setVisible(false);

						new TbsGuiDebitCard(Integer.parseInt(idTextField.getText()), payable);
					} else if (flag == 2) {
						JOptionPane.showMessageDialog(debitCardButton, "No bill due");
					}
				} else if (flag1 == 2) {
					JOptionPane.showMessageDialog(debitCardButton, "Customer not found");

				}

			}
		}

		else if (actionEvent.getSource() == cashButton) {

			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserService tbsUserService = new TbsUserService();

			List<TbsBillTableVo> tbsBillTableVosList = new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList = tbsBillTableService.billListService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(debitCardButton, "Please enter customer ID");

			} else {

				for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
					if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
							&& billTableVo.getBillStatus().equals("due")) {

						payable += billTableVo.getCost();
					}
					continue;
				}

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
						JOptionPane.showMessageDialog(debitCardButton, "No bill due");

					} else {
						for (TbsBillTableVo billTableVo : tbsBillTableVosList) {
							if (billTableVo.getCustomerId() == Integer.parseInt(idTextField.getText())
									&& billTableVo.getBillStatus().equals("due")) {
								flag = 1;
								break;
							} else {
								flag = 2;
							}
						}
					}

					if (flag == 1) {
						frame.setVisible(false);

						new TbsGuiCash(Integer.parseInt(idTextField.getText()), payable);
					} else if (flag == 2) {
						JOptionPane.showMessageDialog(debitCardButton, "No bill due");
					}
				} else if (flag1 == 2) {
					JOptionPane.showMessageDialog(debitCardButton, "Customer not found");

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

		if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {

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
