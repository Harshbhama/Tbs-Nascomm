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

import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsBillTableService;
import com.Tbs.service.TbsUserService;

public class TbsGuiGenerateBill implements ActionListener, KeyListener {

	public JFrame frame;
	public JPanel panel;
	JLabel headingLabel, customerIdLabel, durationLabel, usageLabel;
	JButton generateButton, clearButton, backButton;
	JTextField customerIdTextField, duationTextField, usageTextField;

	public TbsGuiGenerateBill() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Credit Card");
		frame.setLayout(null);

		Image bg = null;

		try {
			bg = ImageIO.read(TbsGuiGenerateBill.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Generate Bill");
		headingLabel.setFont(new Font("Serif", Font.ITALIC, 65));
		customerIdLabel = new JLabel("Customer ID");
		customerIdLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		durationLabel = new JLabel("Duration in minute");
		durationLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		usageLabel = new JLabel("Usage in Mbs");
		usageLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		generateButton = new JButton("Generate");
		generateButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		customerIdTextField = new JTextField();
		duationTextField = new JTextField();
		usageTextField = new JTextField();

		headingLabel.setBounds(250, 40, 800, 100);

		customerIdLabel.setBounds(350, 250, 160, 40);
		durationLabel.setBounds(300, 320, 250, 40);
		usageLabel.setBounds(350, 390, 160, 40);
		generateButton.setBounds(400, 550, 140, 50);
		clearButton.setBounds(580, 550, 140, 50);
		backButton.setBounds(760, 550, 140, 50);
		customerIdTextField.setBounds(550, 250, 400, 40);
		duationTextField.setBounds(550, 320, 400, 40);
		usageTextField.setBounds(550, 390, 400, 40);
		customerIdTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		duationTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		usageTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		generateButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);

		frame.add(headingLabel);

		frame.add(customerIdLabel);
		frame.add(customerIdTextField);
		frame.add(durationLabel);
		frame.add(duationTextField);
		frame.add(usageLabel);
		frame.add(usageTextField);
		frame.add(generateButton);
		frame.add(clearButton);
		frame.add(backButton);
		headingLabel.setForeground(Color.WHITE);
		customerIdLabel.setForeground(Color.WHITE);
		durationLabel.setForeground(Color.WHITE);
		usageLabel.setForeground(Color.WHITE);

		customerIdTextField.addKeyListener(this);
		duationTextField.addKeyListener(this);
		usageTextField.addKeyListener(this);
		generateButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		backButton.addKeyListener(this);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == generateButton) {
			int flag = 0;
			TbsUserService tbsUserService = new TbsUserService();
			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserVo tbsUserVo = new TbsUserVo();
			List<TbsUserVo> list = new ArrayList<TbsUserVo>();

			list = tbsUserService.displayRecordService();

			if (customerIdTextField.getText().equals("") || duationTextField.getText().equals("")
					|| usageTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(generateButton, "Please enter all details ");

			} else {
				for (TbsUserVo t : list) {
					if (Integer.parseInt(customerIdTextField.getText()) == t.getCustomerId()) {
						flag = 1;
						break;

					} else {
						flag = 2;
					}

				}

				if (flag == 1) {
					tbsUserVo.setCustomerId(Integer.parseInt(customerIdTextField.getText()));
					tbsUserVo.setDurationMin(Float.parseFloat(duationTextField.getText()));
					tbsUserVo.setUsageMb(Float.parseFloat(usageTextField.getText()));
					int x = tbsBillTableService.generateBillService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(generateButton, "Bill generated successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(generateButton, "Customer not found");
				}

			}

		} else if (actionEvent.getSource() == clearButton) {
			customerIdTextField.setText("");
			duationTextField.setText("");
			usageTextField.setText("");

		} else {
			frame.setVisible(false);
			new TbsGuiAdminHome();
		}

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
			int flag = 0;
			TbsUserService tbsUserService = new TbsUserService();
			TbsBillTableService tbsBillTableService = new TbsBillTableService();
			TbsUserVo tbsUserVo = new TbsUserVo();
			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();

			tbsUserVosList = tbsUserService.displayRecordService();

			if (customerIdTextField.getText().equals("") || duationTextField.getText().equals("")
					|| usageTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(generateButton, "Please enter all details ");

			} else {
				for (TbsUserVo userVo : tbsUserVosList) {
					if (Integer.parseInt(customerIdTextField.getText()) == userVo.getCustomerId()) {
						flag = 1;
						break;

					} else {
						flag = 2;
					}

				}

				if (flag == 1) {
					tbsUserVo.setCustomerId(Integer.parseInt(customerIdTextField.getText()));
					tbsUserVo.setDurationMin(Float.parseFloat(duationTextField.getText()));
					tbsUserVo.setUsageMb(Float.parseFloat(usageTextField.getText()));
					int x = tbsBillTableService.generateBillService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(generateButton, "Bill generated successfully");
					}
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(generateButton, "Customer not found");
				}

			}
		} else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiAdminHome();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
