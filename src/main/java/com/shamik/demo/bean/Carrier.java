package com.shamik.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Carrier {
	@Id
	private int carrierId;
	private String clintId;
	public int getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}
	public String getClintId() {
		return clintId;
	}
	public void setClintId(String clintId) {
		this.clintId = clintId;
	}
	@Override
	public String toString() {
		return "Carrier [carrierId=" + carrierId + ", clintId=" + clintId + "]";
	}
	
	
}