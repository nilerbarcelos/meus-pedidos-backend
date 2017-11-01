package com.nilerbarcelos.model;

public class Profitability {

	private double itemValue;
	private double productValue;

	public String calculate() {
		if (this.itemValue > this.productValue)
			return "Rentabilidade Ótima";
		else if (this.productValue - (this.productValue * 0.10) < this.itemValue)
			return "Rentabilidade Boa";
		else
			return "Rentabilidade Ruim";
	}

	public double getItemPrice() {
		return itemValue;
	}

	public void setItemPrice(double itemPrice) {
		this.itemValue = itemPrice;
	}

	public double getProductPrice() {
		return productValue;
	}

	public void setProductPrice(double productPrice) {
		this.productValue = productPrice;
	}

}
