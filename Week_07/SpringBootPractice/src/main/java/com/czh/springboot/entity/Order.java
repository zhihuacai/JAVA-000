package com.czh.springboot.entity;

import java.util.Date;

public class Order {

	private int orderUserId; 
	private float totalPrice;
	private float discountAmount;
	private float actualPayAmount;
	private int shopId;
	private int productId;
	private String reciever;
	private int deliverAgentId;
	private String deliverType;
	private int addressId;
	private int payTransactionId; 
	private Date orderTime;
	private Date payTime;
	private Date deliverTime;
	
	@Override
	public String toString() {
		return "Order [orderUserId=" + orderUserId + ", totalPrice=" + totalPrice + ", discountAmount=" + discountAmount
				+ ", actualPayAmount=" + actualPayAmount + ", shopId=" + shopId + ", productId=" + productId
				+ ", reciever=" + reciever + ", deliverAgentId=" + deliverAgentId + ", deliverType=" + deliverType
				+ ", addressId=" + addressId + ", payTransactionId=" + payTransactionId + ", orderTime=" + orderTime
				+ ", payTime=" + payTime + ", deliverTime=" + deliverTime + "]";
	}
	
	
	public int getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public float getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}
	public float getActualPayAmount() {
		return actualPayAmount;
	}
	public void setActualPayAmount(float actualPayAmount) {
		this.actualPayAmount = actualPayAmount;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public int getDeliverAgentId() {
		return deliverAgentId;
	}
	public void setDeliverAgentId(int deliverAgentId) {
		this.deliverAgentId = deliverAgentId;
	}
	public String getDeliverType() {
		return deliverType;
	}
	public void setDeliverType(String deliverType) {
		this.deliverType = deliverType;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getPayTransactionId() {
		return payTransactionId;
	}
	public void setPayTransactionId(int payTransactionId) {
		this.payTransactionId = payTransactionId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	
	
	
}
