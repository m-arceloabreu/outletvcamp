package marcelo.valtech.vcamp.outlet.entity;



public class Product {
	private final int sku;
	private final double price;
	private final double weight;
	private final Pants pants;
	private final Shoes shoes;
	
	
	
	
	public Product(int sku, double price, double weight, Pants pants, Shoes shoes) {
		super();
		this.sku = sku;
		this.price = price;
		this.weight = weight;
		this.pants = pants;
		this.shoes = shoes;
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
}
