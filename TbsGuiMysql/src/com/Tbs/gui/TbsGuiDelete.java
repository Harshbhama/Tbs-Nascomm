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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Tbs.service.TbsUserService;

public class TbsGuiDelete implements ActionListener, KeyListener {

	public static JLabel headingLabel, idLabel;
	public static JTextField idTextField;
	public static JButton removeButton, backButton;
	public static JFrame frame;
	public JPanel panel;
	int x;

	public TbsGuiDelete() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Delete Record");

		frame.setLayout(null);

		Image bg = null;
		try {
			bg = ImageIO.read(TbsGuiDelete.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366, 768);

		headingLabel = new JLabel("Remove Customer Record");
		headingLabel.setFont(new Font("Aerial", Font.ITALIC, 65));
		idLabel = new JLabel("Customer ID");
		idLabel.setFont(new Font("Aerial", Font.ITALIC, 25));
		removeButton = new JButton("Remove");
		removeButton.setFont(new Font("Aerial", Font.ITALIC, 25));
		backButton = new JButton("Back");
		backButton.setFont(new Font("Aerial", Font.ITALIC, 25));

		idTextField = new JTextField();
		idTextField.setFont(new Font("Aerial", Font.ITALIC, 20));

		headingLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);

		headingLabel.setBounds(250, 50, 800, 100);

		idLabel.setBounds(300, 320, 150, 40);
		removeButton.setBounds(400, 450, 130, 50);
		backButton.setBounds(580, 450, 130, 50);

		idTextField.setBounds(490, 320, 400, 40);

		removeButton.addActionListener(this);
		backButton.addActionListener(this);

		frame.add(headingLabel);
		frame.add(idLabel);
		frame.add(idTextField);
		frame.add(removeButton);

		frame.add(backButton);

		idTextField.addKeyListener(this);
		removeButton.addKeyListener(this);
		backButton.addKeyListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == removeButton) {

			TbsUserService tbsUserSevice = new TbsUserService();
			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(removeButton, "Please enter customer ID");
			} else {
				x = tbsUserSevice.deleteRecordService(Integer.parseInt(idTextField.getText()));
				if (x > 0) {
					JOptionPane.showMessageDialog(removeButton, "Record removed Successfully");
					frame.setVisible(false);
					new TbsGuiAdminHome();
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

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(removeButton, "Please enter customer ID");
			} else {
				x = tbsUserService.deleteRecordService(Integer.parseInt(idTextField.getText()));
				if (x > 0) {
					JOptionPane.showMessageDialog(removeButton, "Record removed Successfully");
					frame.setVisible(false);
					new TbsGuiAdminHome();
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
