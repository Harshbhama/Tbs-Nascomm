package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Tbs.model.TbsUserVo;

public class TbsGuiParticularUserDetails implements ActionListener, KeyListener {

	public JPanel panel;
	public static JFrame frame;
	public JLabel idLabel, nameLabel, ageLabel, dojLabel, addressLabel, phoneLabel, planLabel, headingLabel;
	public JTextField idtextField, nametextField, ageTextField, dojTextField, addressTextField, phoneTextField,
			planTextField;
	JButton backButton;
	int customerId;

	public TbsGuiParticularUserDetails(TbsUserVo tv) {

		customerId = tv.getCustomerId();

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User Profile");

		frame.setLayout(null);

		Image bg = null;

		try {
			bg = ImageIO.read(TbsGuiParticularUserDetails.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Customer Details");

		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 65));
		headingLabel.setForeground(Color.WHITE);

		idLabel = new JLabel("Customer Id");
		idLabel.setForeground(Color.WHITE);

		idLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.WHITE);

		nameLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		ageLabel = new JLabel("Age");
		ageLabel.setForeground(Color.WHITE);

		ageLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		dojLabel = new JLabel("Date Of Joining");
		dojLabel.setForeground(Color.WHITE);

		dojLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		addressLabel = new JLabel("Address");
		addressLabel.setForeground(Color.WHITE);

		addressLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		phoneLabel = new JLabel("Phone No.");
		phoneLabel.setForeground(Color.WHITE);

		phoneLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		planLabel = new JLabel("Customer Plan ");
		planLabel.setForeground(Color.WHITE);
		planLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.BOLD, 15));

		idtextField = new JTextField();
		nametextField = new JTextField();
		ageTextField = new JTextField();
		dojTextField = new JTextField();
		addressTextField = new JTextField();
		phoneTextField = new JTextField();
		planTextField = new JTextField();

		idtextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		nametextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		ageTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		dojTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		addressTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		phoneTextField.setFont(new Font("Aerial", Font.ITALIC, 20));
		planTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		idtextField.setText(String.valueOf(tv.getCustomerId()));
		nametextField.setText(String.valueOf(tv.getCustomerName()));
		ageTextField.setText(String.valueOf(tv.getCustomerAge()));
		dojTextField.setText(String.valueOf(tv.getCustomerDOJ()));
		addressTextField.setText(String.valueOf(tv.getCustomerAddress()));
		phoneTextField.setText(String.valueOf(tv.getCustomerPhone()));
		planTextField.setText(String.valueOf(tv.getPlanName()));

		headingLabel.setBounds(200, 10, 800, 90);
		idLabel.setBounds(300, 120, 180, 40);
		nameLabel.setBounds(300, 180, 180, 40);
		ageLabel.setBounds(300, 240, 180, 40);
		dojLabel.setBounds(300, 300, 180, 40);
		addressLabel.setBounds(300, 360, 180, 40);
		phoneLabel.setBounds(300, 420, 180, 40);
		planLabel.setBounds(300, 480, 180, 40);
		backButton.setBounds(500, 600, 180, 40);

		idtextField.setBounds(540, 120, 300, 40);
		nametextField.setBounds(540, 180, 300, 40);
		ageTextField.setBounds(540, 240, 300, 40);
		dojTextField.setBounds(540, 300, 300, 40);
		addressTextField.setBounds(540, 360, 300, 40);
		phoneTextField.setBounds(540, 420, 300, 40);
		planTextField.setBounds(540, 480, 300, 40);

		idtextField.setEditable(false);
		nametextField.setEditable(false);
		ageTextField.setEditable(false);
		dojTextField.setEditable(false);
		addressTextField.setEditable(false);
		phoneTextField.setEditable(false);
		planTextField.setEditable(false);

		backButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(idLabel);
		frame.add(idtextField);
		frame.add(nameLabel);
		frame.add(nametextField);
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
		frame.add(backButton);

		frame.addKeyListener(this);
		idtextField.addKeyListener(this);
		nametextField.addKeyListener(this);
		ageTextField.addKeyListener(this);
		dojTextField.addKeyListener(this);
		addressTextField.addKeyListener(this);
		phoneTextField.addKeyListener(this);
		planTextField.addKeyListener(this);

		backButton.addKeyListener(this);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(1366, 768);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		frame.setVisible(false);
		new TbsGuiUserHome(customerId);

	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {

		if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.setVisible(false);
			new TbsGuiUserHome(customerId);
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
