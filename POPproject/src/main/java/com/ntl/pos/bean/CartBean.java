package com.ntl.pos.bean;

import java.util.Date;

public class CartBean {
	private int cartID;
	private int userId;
	private int foodId;
	private String Type;
	private int quantity;
	private double cost;
	private Date orderDate;
	
	public CartBean() {
		
	}
	/**
	 * @param email
	 * @param foodId
	 * @param quantity
	 */
	public CartBean(int foodId, int quantity) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
	}
	/**
	 * @param cartID
	 * @param email
	 * @param foodId
	 * @param type
	 * @param quantity
	 * @param cost
	 * @param orderDate
	 */
	public CartBean(int cartID, int userId, int foodId, String type, int quantity, double cost, Date orderDate) {
		super();
		this.cartID = cartID;
		this.userId = userId;
		this.foodId = foodId;
		this.Type = type;
		this.quantity = quantity;
		this.cost = cost;
		this.orderDate = orderDate;
	}
	/**
	 * @return the cartID
	 */
	public int getCartID() {
		return cartID;
	}
	/**
	 * @param cartID the cartID to set
	 */
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	
	/**
	 * @return the foodId
	 */
	public int getFoodId() {
		return foodId;
	}
	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartBean [cartID=" + cartID + ", userId=" + userId + ", foodId=" + foodId + ", Type=" + Type
				+ ", quantity=" + quantity + ", cost=" + cost + ", orderDate=" + orderDate + "]";
	}
	
}
