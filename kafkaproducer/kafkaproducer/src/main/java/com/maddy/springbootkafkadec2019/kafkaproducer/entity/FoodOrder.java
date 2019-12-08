package com.maddy.springbootkafkadec2019.kafkaproducer.entity;

public class FoodOrder {

	private int amount;

	private String name;

	public FoodOrder(int amount, String name) {
		super();
		this.amount = amount;
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public String getName() {
		return name;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FoodOrder [amount=" + amount + ", name=" + name + "]";
	}

}
