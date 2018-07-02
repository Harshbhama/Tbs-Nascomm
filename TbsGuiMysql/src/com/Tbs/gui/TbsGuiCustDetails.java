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
import javax.swing.JTextField;

import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsUserService;

public class TbsGuiCustDetails implements ActionListener, KeyListener {

	JLabel headingLabel, customerIdLabel, detailsLabel, idLabel, nameLabel, ageLabel, dojLabel, addressLabel,
			phoneLabel, planLabel;
	JTextField customerIdTextField, idTextField, nameTextField, ageTextField, dojTextField, addressTextField,
			phoneTextField, planTextField;
	public static JButton viewButton, backButton;
	public JFrame frame;

	public TbsGuiCustDetails() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiCustDetails.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setTitle("View Record");
		headingLabel = new JLabel("View Customer Details");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 40));
		headingLabel.setForeground(Color.WHITE);
		customerIdLabel = new JLabel("Customer ID");
		customerIdLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		customerIdLabel.setForeground(Color.WHITE);
		customerIdTextField = new JTextField();
		viewButton = new JButton("View");
		viewButton.addActionListener(this);
		viewButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		detailsLabel = new JLabel("Customer Details");
		detailsLabel.setFont(new Font("Aerial", Font.ITALIC, 40));
		detailsLabel.setForeground(Color.WHITE);
		idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		idLabel.setForeground(Color.WHITE);
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		nameLabel.setForeground(Color.WHITE);
		ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		ageLabel.setForeground(Color.WHITE);
		dojLabel = new JLabel("DOJ");
		dojLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		dojLabel.setForeground(Color.WHITE);
		addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		addressLabel.setForeground(Color.WHITE);
		phoneLabel = new JLabel("Mobile No");
		phoneLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		phoneLabel.setForeground(Color.WHITE);
		planLabel = new JLabel("Customer Plan");
		planLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		planLabel.setForeground(Color.WHITE);

		idTextField = new JTextField();
		nameTextField = new JTextField();
		ageTextField = new JTextField();
		dojTextField = new JTextField();
		addressTextField = new JTextField();
		phoneTextField = new JTextField();
		planTextField = new JTextField();

		customerIdTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		idTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		nameTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		ageTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		dojTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		addressTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		phoneTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		planTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		headingLabel.setBounds(50, 40, 600, 50);
		customerIdLabel.setBounds(120, 130, 200, 40);
		detailsLabel.setBounds(850, 40, 500, 50);
		customerIdTextField.setBounds(300, 130, 200, 40);

		idLabel.setBounds(800, 130, 200, 40);
		nameLabel.setBounds(800, 200, 200, 40);
		ageLabel.setBounds(800, 270, 200, 40);
		dojLabel.setBounds(800, 340, 200, 40);
		addressLabel.setBounds(800, 410, 200, 40);
		phoneLabel.setBounds(800, 480, 200, 40);
		planLabel.setBounds(750, 550, 200, 40);

		idTextField.setBounds(950, 130, 300, 40);
		nameTextField.setBounds(950, 200, 300, 40);
		ageTextField.setBounds(950, 270, 300, 40);
		dojTextField.setBounds(950, 340, 300, 40);
		addressTextField.setBounds(950, 410, 300, 40);
		phoneTextField.setBounds(950, 480, 300, 40);
		planTextField.setBounds(950, 550, 300, 40);

		viewButton.setBounds(130, 250, 150, 50);
		backButton.setBounds(350, 250, 150, 50);

		viewButton.addActionListener(this);

		frame.add(idLabel);
		frame.add(idTextField);
		frame.add(nameLabel);
		frame.add(nameTextField);
		frame.add(ageLabel);
		frame.add(ageTextField);
		frame.add(dojLabel);
		frame.add(dojTextField);
		frame.add(addressLabel);
		frame.add(addressTextField);
		frame.add(phoneLabel);
		frame.add(phoneTextField);
		frame.add(planLabel);
		frame.add(planTextField);

		idTextField.setEditable(false);
		nameTextField.setEditable(false);
		ageTextField.setEditable(false);
		dojTextField.setEditable(false);
		addressTextField.setEditable(false);
		phoneTextField.setEditable(false);
		planTextField.setEditable(false);

		frame.add(headingLabel);
		frame.add(customerIdLabel);
		frame.add(customerIdTextField);
		frame.add(viewButton);
		frame.add(backButton);
		frame.add(detailsLabel);

		customerIdTextField.addKeyListener(this);
		idTextField.addKeyListener(this);
		viewButton.addKeyListener(this);
		backButton.addKeyListener(this);

		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == viewButton) {
			TbsUserService tbsUserService = new TbsUserService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();

			if (customerIdTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(viewButton, "Please enter customer ID");
			} else {
				tbsUserVosList = tbsUserService.customerDetailsService(Integer.parseInt(customerIdTextField.getText()));
				for (TbsUserVo userVo : tbsUserVosList) {

					idTextField.setText(String.valueOf(userVo.getCustomerId()));
					nameTextField.setText(userVo.getCustomerName());
					ageTextField.setText(String.valueOf(userVo.getCustomerAge()));
					dojTextField.setText(userVo.getCustomerDOJ());
					addressTextField.setText(userVo.getCustomerAddress());
					phoneTextField.setText(String.valueOf(userVo.getCustomerPhone()));
					planTextField.setText(userVo.getPlanName());
				}
			}

		} else {

			frame.setVisible(false);
			new TbsGuiAdminHome();
		}

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
			TbsUserService tbsUserService = new TbsUserService();

			List<TbsUserVo> tbsUserVosList = new ArrayList<TbsUserVo>();

			if (customerIdTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(viewButton, "Please enter customer ID");
			} else {
				tbsUserVosList = tbsUserService.customerDetailsService(Integer.parseInt(customerIdTextField.getText()));
				for (TbsUserVo tbsUserVo : tbsUserVosList) {

					idTextField.setText(String.valueOf(tbsUserVo.getCustomerId()));
					nameTextField.setText(tbsUserVo.getCustomerName());
					ageTextField.setText(String.valueOf(tbsUserVo.getCustomerAge()));
					dojTextField.setText(tbsUserVo.getCustomerDOJ());
					addressTextField.setText(tbsUserVo.getCustomerAddress());
					phoneTextField.setText(String.valueOf(tbsUserVo.getCustomerPhone()));
					planTextField.setText(tbsUserVo.getPlanName());
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
