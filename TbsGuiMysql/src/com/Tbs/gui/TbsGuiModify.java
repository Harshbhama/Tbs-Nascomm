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

import com.Tbs.model.TbsPlanVo;
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsPlanService;
import com.Tbs.service.TbsUserService;

public class TbsGuiModify implements ActionListener, KeyListener {

	public static JLabel label1, label2, label3, label4, label5, label6, label7, label8;
	public static JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
	public JButton modifyNameButton, modifyAgeButton, modifyDOJButton, modifyAddressButton, modifyPhoneButton,
			clearButton, backButton, modifyPlanButton;
	TbsUserService tbsUserService;
	static int x;
	public static JFrame frame;
	public static TbsUserVo tbsUserVo;
	public JPanel panel;
	int flag = 0;
	List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();

	public TbsGuiModify() {

		frame = new JFrame("Modify Record");
		panel = new JPanel();
		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiModify.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		label1 = new JLabel("Modify Customer Record");
		label2 = new JLabel("ID");
		label3 = new JLabel("Name");
		label4 = new JLabel("Age");
		label5 = new JLabel("DOJ");
		label6 = new JLabel("Address");
		label7 = new JLabel("Phone");
		label8 = new JLabel("Plan");

		label1.setFont(new Font("Aerial", Font.ITALIC, 65));
		label1.setForeground(Color.WHITE);

		label2.setFont(new Font("Aerial", Font.ITALIC, 25));
		label2.setForeground(Color.WHITE);

		label3.setFont(new Font("Aerial", Font.ITALIC, 25));
		label3.setForeground(Color.WHITE);

		label4.setFont(new Font("Aerial", Font.ITALIC, 25));
		label4.setForeground(Color.WHITE);

		label5.setFont(new Font("Aerial", Font.ITALIC, 25));
		label5.setForeground(Color.WHITE);

		label6.setFont(new Font("Aerial", Font.ITALIC, 25));
		label6.setForeground(Color.WHITE);

		label7.setFont(new Font("Aerial", Font.ITALIC, 25));
		label7.setForeground(Color.WHITE);

		label8.setFont(new Font("Aerial", Font.ITALIC, 25));
		label8.setForeground(Color.WHITE);

		label1.setBounds(250, 0, 800, 150);
		label2.setBounds(300, 140, 180, 40);
		label3.setBounds(300, 200, 180, 40);
		label4.setBounds(300, 260, 180, 40);
		label5.setBounds(300, 320, 180, 40);
		label6.setBounds(300, 380, 180, 40);
		label7.setBounds(300, 440, 180, 40);
		label8.setBounds(300, 500, 180, 40);

		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		textField5 = new JTextField();
		textField6 = new JTextField();
		textField7 = new JTextField();

		textField1.setBounds(540, 140, 300, 40);
		textField2.setBounds(540, 200, 300, 40);
		textField3.setBounds(540, 260, 300, 40);
		textField4.setBounds(540, 320, 300, 40);
		textField5.setBounds(540, 380, 300, 40);
		textField6.setBounds(540, 440, 300, 40);
		textField7.setBounds(540, 500, 300, 40);

		modifyNameButton = new JButton("Modify");
		modifyAgeButton = new JButton("Modify");
		modifyDOJButton = new JButton("Modify");
		modifyAddressButton = new JButton("Modify");
		modifyPhoneButton = new JButton("Modify");
		modifyPlanButton = new JButton("Modify");
		clearButton = new JButton("Clear");
		backButton = new JButton("Back");

		modifyNameButton.setFont(new Font("Aerial", Font.BOLD, 15));
		modifyAgeButton.setFont(new Font("Aerial", Font.BOLD, 15));
		modifyDOJButton.setFont(new Font("Aerial", Font.BOLD, 15));
		modifyAddressButton.setFont(new Font("Aerial", Font.BOLD, 15));
		modifyPhoneButton.setFont(new Font("Aerial", Font.BOLD, 15));
		clearButton.setFont(new Font("Aerial", Font.BOLD, 15));
		backButton.setFont(new Font("Aerial", Font.BOLD, 15));
		modifyPlanButton.setFont(new Font("Aerial", Font.BOLD, 15));

		modifyNameButton.setBounds(900, 200, 150, 40);
		modifyAgeButton.setBounds(900, 260, 150, 40);
		modifyDOJButton.setBounds(900, 320, 150, 40);
		modifyAddressButton.setBounds(900, 380, 150, 40);
		modifyPhoneButton.setBounds(900, 440, 150, 40);
		modifyPlanButton.setBounds(900, 500, 150, 40);
		clearButton.setBounds(400, 600, 170, 40);
		backButton.setBounds(650, 600, 170, 40);

		modifyNameButton.addActionListener(this);
		modifyAgeButton.addActionListener(this);
		modifyDOJButton.addActionListener(this);
		modifyAddressButton.addActionListener(this);
		modifyPhoneButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);
		modifyPlanButton.addActionListener(this);

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(label7);
		frame.add(label8);

		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(textField4);
		frame.add(textField5);
		frame.add(textField6);
		frame.add(textField7);

		frame.add(modifyNameButton);
		frame.add(modifyAgeButton);
		frame.add(modifyDOJButton);
		frame.add(modifyAddressButton);
		frame.add(modifyPhoneButton);
		frame.add(clearButton);
		frame.add(backButton);
		frame.add(modifyPlanButton);

		modifyNameButton.addKeyListener(this);
		modifyAgeButton.addKeyListener(this);
		modifyDOJButton.addKeyListener(this);
		modifyAddressButton.addKeyListener(this);
		modifyPhoneButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		backButton.addKeyListener(this);

		textField1.addKeyListener(this);
		textField2.addKeyListener(this);
		textField3.addKeyListener(this);
		textField4.addKeyListener(this);
		textField5.addKeyListener(this);
		textField6.addKeyListener(this);
		textField7.addKeyListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == modifyNameButton) {

			tbsUserService = new TbsUserService();
			tbsUserVo = new TbsUserVo();
			tbsUserVosList = tbsUserService.displayRecordService();
			if (textField1.getText().equals("") && textField2.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField2.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer Name");
			} else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(textField1.getText())) {
						flag = 1;
						break;
					} else {
						flag = 2;
					}
				}

				if (flag == 1) {
					tbsUserVo.setCustomerId(Integer.parseInt(textField1.getText()));
					tbsUserVo.setCustomerName(textField2.getText());
					x = tbsUserService.modifyNameService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(modifyNameButton, "Name modified Successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(modifyNameButton, "Customer not found");
				}

			}

		} else if (actionEvent.getSource() == modifyAgeButton) {
			tbsUserService = new TbsUserService();
			tbsUserVo = new TbsUserVo();
			tbsUserVosList = tbsUserService.displayRecordService();
			if (textField1.getText().equals("") && textField3.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField3.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer Age");
			} else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(textField1.getText())) {
						flag = 1;
						break;
					} else {
						flag = 2;
					}
				}

				if (flag == 1) {

					tbsUserVo.setCustomerId(Integer.parseInt(textField1.getText()));
					tbsUserVo.setCustomerAge(Integer.parseInt(textField3.getText()));
					x = tbsUserService.modifyAgeService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(modifyAgeButton, "Age modified Successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(modifyNameButton, "Customer not found");
				}

			}

		} else if (actionEvent.getSource() == modifyDOJButton) {
			tbsUserService = new TbsUserService();
			tbsUserVo = new TbsUserVo();
			tbsUserVosList = tbsUserService.displayRecordService();
			if (textField1.getText().equals("") && textField4.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField4.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer DOJ");
			}

			else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(textField1.getText())) {
						flag = 1;
						break;
					} else {
						flag = 2;
					}
				}

				if (flag == 1) {

					tbsUserVo.setCustomerId(Integer.parseInt(textField1.getText()));
					tbsUserVo.setCustomerDOJ(textField4.getText());
					x = tbsUserService.modifyDOJService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(modifyDOJButton, "DOJ modified Successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(modifyNameButton, "Customer not found");
				}

			}

		} else if (actionEvent.getSource() == modifyAddressButton) {
			tbsUserService = new TbsUserService();
			tbsUserVo = new TbsUserVo();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (textField1.getText().equals("") && textField5.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField5.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer Address");
			} else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(textField1.getText())) {
						flag = 1;
						break;
					} else {
						flag = 2;
					}
				}

				if (flag == 1) {

					tbsUserVo.setCustomerId(Integer.parseInt(textField1.getText()));
					tbsUserVo.setCustomerAddress(textField5.getText());
					x = tbsUserService.modifyAddressService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(modifyAddressButton, "Address modified Successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(modifyNameButton, "Customer not found");
				}

			}

		} else if (actionEvent.getSource() == modifyPhoneButton) {
			tbsUserService = new TbsUserService();
			tbsUserVo = new TbsUserVo();
			tbsUserVosList = tbsUserService.displayRecordService();

			if (textField1.getText().equals("") && textField6.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField6.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer Phone");
			} else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(textField1.getText())) {
						flag = 1;
						break;
					} else {
						flag = 2;
					}
				}

				if (flag == 1) {
					tbsUserVo.setCustomerId(Integer.parseInt(textField1.getText()));
					tbsUserVo.setCustomerPhone(Long.parseLong(textField6.getText()));
					x = tbsUserService.modifyPhoneService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(modifyPhoneButton, "Phone modified Successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(modifyNameButton, "Customer not found");
				}

			}

		}

		else if (actionEvent.getSource() == clearButton) {

			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			textField5.setText("");
			textField6.setText("");
			textField7.setText("");

		}

		else if (actionEvent.getSource() == modifyPlanButton) {
			tbsUserService = new TbsUserService();
			TbsPlanService tbsPlanService = new TbsPlanService();
			tbsUserVo = new TbsUserVo();
			tbsUserVosList = tbsUserService.displayRecordService();
			if (textField1.getText().equals("") && textField7.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField1.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter customer ID");
			} else if (textField7.getText().equals("")) {
				JOptionPane.showMessageDialog(modifyNameButton, "Please enter Plan");
			} else {

				for (TbsUserVo userVo : tbsUserVosList) {
					if (userVo.getCustomerId() == Integer.parseInt(textField1.getText())) {
						flag = 1;
						break;
					} else {
						flag = 2;
					}
				}

				if (flag == 1) {
					tbsUserVo.setCustomerId(Integer.parseInt(textField1.getText()));
					// tv.setPlanCode(Long.parseLong(t7.getText()));

					List<TbsPlanVo> l = tbsPlanService.planListService();
					for (TbsPlanVo l1 : l) {
						if (l1.getPlanCode() == Integer.parseInt(textField7.getText())) {
							tbsUserVo.setPlanName(l1.getPlanName());
						}
					}
					x = tbsUserService.modifyPlanService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(modifyPlanButton, "Plan modified successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(modifyNameButton, "Customer not found");
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
