package com.Tbs.model;

public class TbsUserVo {

	public int customerId, customerAge;
	public String customerName, customerAddress, customerDOJ, planName, userPassword, paymentMode, paymentDate;
	public float durationMin, usageMb;
	public long planCode;

	public long getPlanCode() {
		return planCode;
	}

	public void setPlanCode(long planCode) {
		this.planCode = planCode;
	}

	public float getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(float durationMin) {
		this.durationMin = durationMin;
	}

	public float getUsageMb() {
		return usageMb;
	}

	public void setUsageMb(float usageMb) {
		this.usageMb = usageMb;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public long customerPhone;
	public float amount;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerDOJ() {
		return customerDOJ;
	}

	public void setCustomerDOJ(String customerDOJ) {
		this.customerDOJ = customerDOJ;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(long l) {
		this.customerPhone = l;
	}

}
