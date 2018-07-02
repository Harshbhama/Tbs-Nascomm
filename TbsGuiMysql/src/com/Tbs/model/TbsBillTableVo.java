package com.Tbs.model;

public class TbsBillTableVo {

	public float durationMin, usageMb, cost;
	public int invoice, customerId;
	public String customerName, billStatus;

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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

}
