package com.Tbs.model;

public class TbsPlanVo {

	public String planName;
	public long planCode;
	public int planValidity;
	public float costPerMb, costPerMin, baseCost;

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public long getPlanCode() {
		return planCode;
	}

	public void setPlanCode(long planCode) {
		this.planCode = planCode;
	}

	public int getPlanValidity() {
		return planValidity;
	}

	public void setPlanValidity(int planValidity) {
		this.planValidity = planValidity;
	}

	public float getCostPerMb() {
		return costPerMb;
	}

	public void setCostPerMb(float costPerMb) {
		this.costPerMb = costPerMb;
	}

	public float getCostPerMin() {
		return costPerMin;
	}

	public void setCostPerMin(float costPerMin) {
		this.costPerMin = costPerMin;
	}

	public float getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(float baseCost) {
		this.baseCost = baseCost;
	}

}
