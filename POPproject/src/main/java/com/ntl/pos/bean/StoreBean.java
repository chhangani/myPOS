package com.ntl.pos.bean;

public class StoreBean {
   private int storeID;
   private String name;
   private String street;
   private String mobileNo;
   private String city;
   private String state;
   private String pincode;
   
   public StoreBean(){
	   
   }

   public StoreBean(int storeID, String name, String street, String mobileNo, String city, String state,
		            String pincode) {
	super();
	this.storeID = storeID;
	this.name = name;
	this.street = street;
	this.mobileNo = mobileNo;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
   }

	public int getStoreID() {
		return storeID;
	}
	
	public void setStoreID(int i) {
		this.storeID = i;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPincode() {
		return pincode;
	}
	
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "StoreBean [storeID=" + storeID + ", name=" + name + ", street=" + street + ", mobileNo=" + mobileNo
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	   
}
