package com.ntl.pos.bean;

import java.util.Date;

public class OrderBean {
	   private int orderId;
	   private int userId;
	   private Date OrderDate;
	   private int storeID;
	   private int cartId;
	   private double totalPrice;
	   private String orderStatus;
	   private String street;
	   private String city;
	   private String state;
	   private String pincode;
	   private String mobileNo;
	   
	   public OrderBean(){
		   
	   }
	   
	/**
	 * @param orderId
	 * @param userId
	 * @param orderDate
	 * @param storeID
	 * @param cartId
	 * @param totalPrice
	 * @param orderStatus
	 * @param street
	 * @param city
	 * @param state
	 * @param pincode
	 * @param mobileNo
	 */
	   public OrderBean(int orderId, int userId, Date orderDate, int storeID, int cartId, double totalPrice,
			String orderStatus, String street, String city, String state, String pincode, String mobileNo) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		OrderDate = orderDate;
		this.storeID = storeID;
		this.cartId = cartId;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
		return OrderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	/**
	 * @return the storeID
	 */
	public int getStoreID() {
		return storeID;
	}

	/**
	 * @param storeID the storeID to set
	 */
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pincode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", userId=" + userId + ", OrderDate=" + OrderDate + ", storeID="
				+ storeID + ", cartId=" + cartId + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", mobileNo="
				+ mobileNo + "]";
	}
	
}
