package com.Tbs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.Tbs.model.TbsBillHistoryVo;
import com.Tbs.model.TbsBillTableVo;
import com.Tbs.model.TbsUserVo;
import com.Tbs.service.TbsBillHistoryService;
import com.Tbs.service.TbsBillTableService;
import com.Tbs.service.TbsUserService;

public class TbsGuiUserHome implements ActionListener{

	public static JFrame frame;
	 JPanel panel;
	JLabel headingLabel;
	JButton userDetailsButton,viewBillButton,payBillButton,billHistoryButton,plansButton,logoutButton,changePasswordButton;
	int customerId;
	
	TbsUserVo tbsUserVo;
	int flag;
	
	public TbsGuiUserHome(int custId){
	
		this.customerId=custId;
		
		frame=new JFrame("User Home");
		
		Image bg=null;
		
		try {
			
			bg=ImageIO.read(TbsGuiUserHome.class.getResource("look.com.ua-35320.jpg"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
		
		frame.setContentPane(new JLabel(new ImageIcon(bg)));
		frame.setSize(1366,768);
	    
	    headingLabel=new JLabel("User Home");
	    headingLabel.setFont(new Font("Aerial",Font.ITALIC,50));
	    headingLabel.setForeground(Color.WHITE);
	    
	    userDetailsButton=new JButton("User Details");
	    userDetailsButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    viewBillButton=new JButton("View Bill");
	    viewBillButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    payBillButton=new JButton("Pay Bill");
	    payBillButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    billHistoryButton=new JButton("Bill History");
	    billHistoryButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    plansButton=new JButton("Plans");
	    plansButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    logoutButton=new JButton("Logout");
	    logoutButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    changePasswordButton=new JButton("Change Password");
	    changePasswordButton.setFont(new Font("Aerial",Font.BOLD,15));
	    
	    headingLabel.setBounds(250, 50, 800, 100);
	    
	    userDetailsButton.setBounds(350, 250, 220, 50);
	    viewBillButton.setBounds(750,250,220,50);
	    payBillButton.setBounds(350, 350, 220, 50);
	    billHistoryButton.setBounds(750,350,220,50);
	    plansButton.setBounds(350, 450, 220, 50);
	    changePasswordButton.setBounds(750,450,220,50);
	    logoutButton.setBounds(550,550,220,50);
	    
	    userDetailsButton.addActionListener(this);
		viewBillButton.addActionListener(this);
		payBillButton.addActionListener(this);
		billHistoryButton.addActionListener(this);
		plansButton.addActionListener(this);
		logoutButton.addActionListener(this);
		changePasswordButton.addActionListener(this);
		
	    frame.add(headingLabel);
	    frame.add(userDetailsButton);
	    frame.add(viewBillButton);
	    frame.add(payBillButton);
	    frame.add(billHistoryButton);
	    frame.add(plansButton);
	    frame.add(logoutButton);
	    frame.add(changePasswordButton);
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
	
		if(actionEvent.getSource()==userDetailsButton){
			
			 TbsUserService tbsUserSevice=new TbsUserService();
			 tbsUserVo=new TbsUserVo();
			 tbsUserVo = tbsUserSevice.displayProfileService(customerId);
	
			 frame.setVisible(false);
			 new TbsGuiParticularUserDetails(tbsUserVo);
				
	}
			
			
			
		
		else if(actionEvent.getSource()==viewBillButton){
			
			TbsBillTableService tbsBillTableService=new TbsBillTableService();
			List<TbsBillTableVo> tbsBillTableVosList=new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList=tbsBillTableService.billListService();
			
			if(tbsBillTableVosList.isEmpty()){
				JOptionPane.showMessageDialog(viewBillButton, "No bills due");
	
			}
			else{
				for(TbsBillTableVo billTableVo:tbsBillTableVosList){
					
					if(billTableVo.getCustomerId()==customerId && billTableVo.billStatus.equals("due")){
						new TbsGuiViewBillList(customerId);
						flag=1;
						break;
					}
					else {
						flag=2;
						
					}
				}
			}
			
			
			if(flag==2){
				JOptionPane.showMessageDialog(viewBillButton, "No bills due");
			}
			
			
			
		}
		else if(actionEvent.getSource()==payBillButton){
	

			TbsBillTableService tbsBillTableService=new TbsBillTableService();
			List<TbsBillTableVo> tbsBillTableVosList=new ArrayList<TbsBillTableVo>();
			tbsBillTableVosList=tbsBillTableService.billListService();
			
			if(tbsBillTableVosList.isEmpty()){
				JOptionPane.showMessageDialog(payBillButton, "No bills due");

			}
			
			else{
				for(TbsBillTableVo billTableVo:tbsBillTableVosList){
					
					if(billTableVo.getCustomerId()==customerId && billTableVo.billStatus.equals("due")){
						
						frame.setVisible(false);
						new TbsGuiUserPayBill(customerId);
						flag=1;
						break;
					}
					else {
						flag=2;
						
					}
				}
			}
		
			if(flag==2){
				JOptionPane.showMessageDialog(payBillButton, "No bills due");
			}
			
			
		}
		else if(actionEvent.getSource()==billHistoryButton){
			TbsBillHistoryService tbsBillHistoryService=new TbsBillHistoryService();
			List<TbsBillHistoryVo> tbsBillHistoryVosList=new ArrayList<TbsBillHistoryVo>();
			tbsBillHistoryVosList=tbsBillHistoryService.billHistoryService();
			
			if(tbsBillHistoryVosList.isEmpty()){
				JOptionPane.showMessageDialog(billHistoryButton, "No Bill History");

			}
			else{
				for(TbsBillHistoryVo billHistoryVo:tbsBillHistoryVosList){
					if(billHistoryVo.getCustomerId()==customerId){
						new TbsGuiParticularBillHistoryList(customerId);
						flag=1;
						break;
					}
					else{
						flag=2;
					}
				}
			}
			
			
			
			if(flag==2){
				JOptionPane.showMessageDialog(billHistoryButton, "No Bill History");
			}
			
			
		}
		else if(actionEvent.getSource()==plansButton){
			new TbsGuiPlanList();
		}
		else if(actionEvent.getSource()==logoutButton){
			
			frame.setVisible(false);
			new TbsGuiHome();
		}
		else{
			
			frame.setVisible(false);
			new TbsGuiChangePassword(customerId);
			
		}
		
		
	}

	
	
}
