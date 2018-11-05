package com.ntl.pos.bean;

public class CreditCardBean {
   String CreditCardNumber;
   String validFrom;
   String validTo;
   int balance;
   int userId;
   public CreditCardBean(){
	   
   }
	/**
	 * @param creditCardNumber
	 * @param validFrom
	 * @param validTo
	 * @param balance
	 * @param userId
	 */
	public CreditCardBean(String creditCardNumber, String validFrom, String validTo, int balance, int userId) {
		super();
		CreditCardNumber = creditCardNumber;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.balance = balance;
		this.userId = userId;
	}
	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	/**
	 * @return the validFrom
	 */
	public String getValidFrom() {
		return validFrom;
	}
	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	/**
	 * @return the validTo
	 */
	public String getValidTo() {
		return validTo;
	}
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
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
   
}
