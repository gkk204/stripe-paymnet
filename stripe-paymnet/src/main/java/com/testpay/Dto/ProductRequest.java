package com.testpay.Dto;

public class ProductRequest {
	
	private Long amount;
	private Long quantity;
	private String name;
	private String currency;
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public ProductRequest(Long amount, Long quantity, String name, String currency) {
		super();
		this.amount = amount;
		this.quantity = quantity;
		this.name = name;
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "ProductRequest [amount=" + amount + ", quantity=" + quantity + ", name=" + name + ", currency="
				+ currency + "]";
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	

}
