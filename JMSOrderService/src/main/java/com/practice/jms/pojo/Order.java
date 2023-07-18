package com.practice.jms.pojo;

public class Order {
	
	private long orderId;
	private String orderName;
	private String orderDescription;
	
	
	public Order() {
	}
	
	public Order(long orderId, String orderName, String orderDescription) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDescription = orderDescription;
	}

	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderDescription=" + orderDescription
				+ "]";
	}
	
	

}
