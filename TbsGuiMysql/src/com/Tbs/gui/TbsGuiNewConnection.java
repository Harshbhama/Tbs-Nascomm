package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.Tbs.dao.TbsUserDao;
import com.Tbs.model.TbsPlanVo;
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsPlanService;
import com.Tbs.service.TbsUserService;

public class TbsGuiNewConnection implements ActionListener, KeyListener {

	public static JLabel headingLabel, idLabel, nameLabel, ageLabel, addressLabel, phoneLabel, planLabel, passwordLabel,
			confirmPasswordLabel;
	public JTextField idTextField, nameTextField, ageTextField, planCodeTextField, addressTextField, phoneTextField;
	public JButton submitButton, clearButton, backButton, checkPlanButton;

	JFrame frame;
	JPasswordField passwordField9, passwordField8;
	ImageIcon image;
	JLabel imageLabel;

	public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();

	public TbsGuiNewConnection() {

		frame = new JFrame("New Connection");
		frame.setSize(1366, 768);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiNewConnection.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));

		headingLabel = new JLabel("New Connection Registration");
		headingLabel.setForeground(Color.WHITE);

		idLabel = new JLabel("ID");
		nameLabel = new JLabel("Name");
		ageLabel = new JLabel("Age");

		addressLabel = new JLabel("Address");
		phoneLabel = new JLabel("Phone");
		passwordLabel = new JLabel("Password");
		confirmPasswordLabel = new JLabel("Confirm Password");
		planLabel = new JLabel("Plan");

		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 35));
		idLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		nameLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		ageLabel.setFont(new Font("Aerial", Font.ITALIC, 25));

		addressLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		phoneLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		planLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		passwordLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		confirmPasswordLabel.setFont(new Font("Aerial", Font.ITALIC, 25));

		headingLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);
		nameLabel.setForeground(Color.WHITE);
		ageLabel.setForeground(Color.WHITE);

		addressLabel.setForeground(Color.WHITE);
		phoneLabel.setForeground(Color.WHITE);
		planLabel.setForeground(Color.WHITE);
		passwordLabel.setForeground(Color.WHITE);
		confirmPasswordLabel.setForeground(Color.WHITE);

		headingLabel.setBounds(100, 30, 500, 50);
		idLabel.setBounds(400, 140, 200, 30);
		nameLabel.setBounds(400, 190, 200, 30);
		ageLabel.setBounds(400, 240, 200, 30);
		addressLabel.setBounds(400, 290, 200, 30);
		phoneLabel.setBounds(400, 340, 200, 30);
		passwordLabel.setBounds(400, 390, 200, 30);
		confirmPasswordLabel.setBounds(400, 440, 300, 30);
		planLabel.setBounds(400, 490, 200, 30);

		idTextField = new JTextField();
		nameTextField = new JTextField();
		ageTextField = new JTextField();
		planCodeTextField = new JTextField();
		addressTextField = new JTextField();
		phoneTextField = new JTextField();
		passwordField8 = new JPasswordField();
		passwordField9 = new JPasswordField();

		idTextField.setBounds(690, 140, 200, 30);
		idTextField.setText(String.valueOf(new TbsUserDao().generateCustomerId()));
		idTextField.setEditable(false);
		nameTextField.setBounds(690, 190, 200, 30);
		ageTextField.setBounds(690, 240, 200, 30);
		addressTextField.setBounds(690, 290, 200, 30);
		phoneTextField.setBounds(690, 340, 200, 30);
		passwordField8.setBounds(690, 390, 200, 30);
		passwordField9.setBounds(690, 440, 200, 30);
		planCodeTextField.setBounds(690, 490, 200, 30);

		submitButton = new JButton("Submit");
		clearButton = new JButton("Clear");
		backButton = new JButton("Back");
		checkPlanButton = new JButton("Plans");

		submitButton.setFont(new Font("Aerial", Font.BOLD, 15));
		clearButton.setFont(new Font("Aerial", Font.BOLD, 15));
		backButton.setFont(new Font("Aerial", Font.BOLD, 15));
		checkPlanButton.setFont(new Font("Aerial", Font.BOLD, 15));

		checkPlanButton.setBounds(380, 600, 100, 30);
		submitButton.setBounds(500, 600, 100, 30);
		clearButton.setBounds(620, 600, 100, 30);
		backButton.setBounds(740, 600, 100, 30);

		submitButton.addActionListener(this);
		clearButton.addActionListener(this);
		backButton.addActionListener(this);
		checkPlanButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(idLabel);
		frame.add(nameLabel);
		frame.add(ageLabel);
		frame.add(addressLabel);
		frame.add(phoneLabel);
		frame.add(planLabel);
		frame.add(passwordLabel);
		frame.add(confirmPasswordLabel);

		frame.add(idTextField);
		frame.add(nameTextField);
		frame.add(ageTextField);
		frame.add(planCodeTextField);
		frame.add(addressTextField);
		frame.add(phoneTextField);
		frame.add(passwordField8);
		frame.add(passwordField9);

		frame.add(submitButton);
		frame.add(clearButton);
		frame.add(backButton);
		frame.add(checkPlanButton);

		idTextField.addKeyListener(this);
		nameTextField.addKeyListener(this);
		ageTextField.addKeyListener(this);
		addressTextField.addKeyListener(this);
		phoneTextField.addKeyListener(this);
		planCodeTextField.addKeyListener(this);
		passwordField8.addKeyListener(this);
		passwordField9.addKeyListener(this);

		submitButton.addKeyListener(this);
		clearButton.addKeyListener(this);
		backButton.addKeyListener(this);
		checkPlanButton.addKeyListener(this);

		frame.addKeyListener(this);

		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.requestFocus();
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == submitButton) {
			TbsPlanService tbsPlanService = new TbsPlanService();
			TbsUserService tbsUserService = new TbsUserService();
			TbsUserVo tbsUserVo = new TbsUserVo();
			if (nameTextField.getText().equals("") || ageTextField.getText().equals("")
					|| addressTextField.getText().equals("") || phoneTextField.getText().equals("")
					|| planCodeTextField.getText().equals("") || passwordField8.getPassword().equals("")
					|| passwordField9.getPassword().equals("")) {
				JOptionPane.showMessageDialog(submitButton, "Please enter all details");
			} else {
				tbsUserVo.setCustomerId(Integer.parseInt(idTextField.getText()));
				tbsUserVo.setCustomerName(nameTextField.getText());
				tbsUserVo.setCustomerAge(Integer.parseInt(ageTextField.getText()));
				tbsUserVo.setCustomerDOJ(dateFormat.format(date));
				tbsUserVo.setCustomerAddress(addressTextField.getText());
				tbsUserVo.setCustomerPhone(Long.parseLong(phoneTextField.getText()));
				tbsUserVo.setPlanCode(Long.parseLong(planCodeTextField.getText()));

				List<TbsPlanVo> tbsPlanVosList = tbsPlanService.planListService();
				for (TbsPlanVo planVo : tbsPlanVosList) {
					if (planVo.planCode == tbsUserVo.planCode) {
						tbsUserVo.setPlanName(planVo.getPlanName());
					}
				}

				if (String.valueOf(passwordField8.getPassword()).equals(String.valueOf(passwordField9.getPassword()))) {

					tbsUserVo.setUserPassword(String.valueOf(passwordField8.getPassword()));
					int x = tbsUserService.newConnectionService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(submitButton, "Data Saved Successfully");
					}
				} else {
					JOptionPane.showMessageDialog(submitButton, "Password does not match");
				}
			}

		} else if (actionEvent.getSource() == clearButton) {

			System.out.println(nameTextField.getText()); // name
			System.out.println(ageTextField.getText()); // age
			System.out.println(addressTextField.getText()); // address
			System.out.println(phoneTextField.getText()); // phone

			System.out.println(String.valueOf(passwordField8.getPassword())); // pass
			System.out.println(String.valueOf(passwordField9.getPassword())); // con
																				// pass
			System.out.println(planCodeTextField.getText()); // plan

			idTextField.setText("");
			nameTextField.setText("");
			ageTextField.setText("");
			planCodeTextField.setText("");
			addressTextField.setText("");
			phoneTextField.setText("");

		}

		else if (actionEvent.getSource() == backButton) {
			frame.setVisible(false);
			new TbsGuiSysAdminHome();
		} else {
			new TbsGuiPlanList();
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			TbsPlanService tbsPlanService = new TbsPlanService();
			TbsUserService tbsUserService = new TbsUserService();
			TbsUserVo tbsUserVo = new TbsUserVo();
			if (nameTextField.getText().equals("") || ageTextField.getText().equals("")
					|| addressTextField.getText().equals("") || phoneTextField.getText().equals("")
					|| planCodeTextField.getText().equals("") || passwordField8.getPassword().equals("")
					|| passwordField9.getPassword().equals("")) {
				JOptionPane.showMessageDialog(submitButton, "Please enter all details");
			} else {
				tbsUserVo.setCustomerId(Integer.parseInt(idTextField.getText()));
				tbsUserVo.setCustomerName(nameTextField.getText());
				tbsUserVo.setCustomerAge(Integer.parseInt(ageTextField.getText()));
				tbsUserVo.setCustomerDOJ(dateFormat.format(date));
				tbsUserVo.setCustomerAddress(addressTextField.getText());
				tbsUserVo.setCustomerPhone(Long.parseLong(phoneTextField.getText()));
				tbsUserVo.setPlanCode(Long.parseLong(planCodeTextField.getText()));

				List<TbsPlanVo> tbsPlanVosList = tbsPlanService.planListService();
				for (TbsPlanVo planVo : tbsPlanVosList) {
					if (planVo.planCode == tbsUserVo.planCode) {
						tbsUserVo.setPlanName(planVo.getPlanName());
					}
				}

				if (String.valueOf(passwordField8.getPassword()).equals(String.valueOf(passwordField9.getPassword()))) {

					tbsUserVo.setUserPassword(String.valueOf(passwordField8.getPassword()));
					int x = tbsUserService.newConnectionService(tbsUserVo);
					if (x > 0) {
						JOptionPane.showMessageDialog(submitButton, "Data Saved Successfully");
					}
				} else {
					JOptionPane.showMessageDialog(submitButton, "Password does not match");
				}
			}

		} else if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiSysAdminHome();
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
