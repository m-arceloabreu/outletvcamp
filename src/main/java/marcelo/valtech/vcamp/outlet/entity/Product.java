package marcelo.valtech.vcamp.outlet.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Product {
	private final int sku;
	private final double price;
	private final double weight;
	private final Pants pants;
	private final Shoes shoes;
	private final Glasses glasses;
	private final Jackets jackets;
	
	
	
	
	public Product(int sku, double price, double weight, Pants pants, Shoes shoes, Glasses glasses, Jackets jackets) {
		super();
		this.sku = sku;
		this.price = price;
		this.weight = weight;
		this.pants = pants;
		this.shoes = shoes;
		this.glasses = glasses;
		this.jackets = jackets;
	}
	
	public int getSku() {
		return sku;
	}
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}
	public Pants getPants() {
		return pants;
	}
	public Shoes getShoes() {
		return shoes;
	}

	public Glasses getGlasses() {
		return glasses;
	}

	public Jackets getJackets() {
		return jackets;
	}
	

	
	
	
}
