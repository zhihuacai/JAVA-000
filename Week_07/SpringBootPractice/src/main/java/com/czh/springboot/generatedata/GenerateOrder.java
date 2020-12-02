package com.czh.springboot.generatedata;

import java.util.Random;

import com.czh.springboot.entity.Order;

public class GenerateOrder {
	
	static Random random = new Random();
	private static String[] recievers = new String[]{"reciever0","reciever1","reciever2","reciever3","reciever4","reciever5","reciever6","reciever7",
			"reciever8","reciever9","reciever10","reciever11","reciever12","reciever13","reciever14","reciever15","reciever16","reciever17","reciever18","reciever19","reciever20","reciever21"};
	private static float[] discount = new float[] {0f,0.1f,0.2f,0f,0.3f,0f,0.4f,0f,0.5f,0f,0.05f,0f,0.45f,0.15f,0f,0.25f,0.35f,0f,0.45f};
	
	public static Order generateData()
	{
		Order order = new Order();
		int orderUserId = random.nextInt(20);
		order.setOrderUserId(orderUserId);
		
		float totalPrice = (float) (random.nextInt(10000)*0.1);
		order.setTotalPrice(totalPrice);
		
		int index = random.nextInt(17);
		
		float discountAmount = totalPrice * discount[index];
		order.setDiscountAmount(discountAmount);
		
		float actualPayAmount = totalPrice - discountAmount;
		order.setActualPayAmount(actualPayAmount);

		int shopId = random.nextInt(50);
		order.setShopId(shopId);
		
		int productId = random.nextInt(200);
		order.setProductId(productId);	
		
		index = random.nextInt(20);
		String reciever = recievers[index];
		order.setReciever(reciever);
		
		int addressId = random.nextInt(30);
		order.setAddressId(addressId);		
		
		//System.out.println(order);
		
		return order;
	}
	
	
	public static void main(String [] args) {
		
		GenerateOrder.generateData();
	}
	

}
