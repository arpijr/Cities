package com.arpi.model;

public class Cost {

	private Integer distance;
	private Integer higwayFee;
	private Integer duty;

	
	public Cost(int  distance, int higwayFee, int duty) {
		this.distance = distance;
		this.higwayFee = higwayFee;
		this.duty = duty;
	}


	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getHigwayFee() {
		return higwayFee;
	}

	public void setHigwayFee(Integer higwayFee) {
		this.higwayFee = higwayFee;
	}

	public Integer getDuty() {
		return duty;
	}

	public void setDuty(Integer duty) {
		this.duty = duty;
	}


}
