package com.ntl.pos.bean;

public class FoodBean {
	   private int foodId;
	   private String name;
	   private String type;
	   private String foodSize;
	   private int quantity;
	   private int price;
       private int storeId;
	   public FoodBean(){
		   
	   }
	public FoodBean(int foodId, String name, String type, String foodSize, int quantity,int price, int storeId) {
		super();
		this.foodId = foodId;
		this.name = name;
		this.type = type;
		this.foodSize = foodSize;
		this.quantity = quantity;
		this.price = price;
		this.storeId = storeId;
	}
	@Override
	public String toString() {
		return "FoodBean [foodId=" + foodId + ", name=" + name + ", type=" + type + ", foodSize=" + foodSize
				+ ", quantity=" + quantity + ", price=" + price + ", storeId=" + storeId + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFoodSize() {
		return foodSize;
	}
	public void setFoodSize(String foodSize) {
		this.foodSize = foodSize;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int i) {
		this.quantity = i;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	  
	   
}
