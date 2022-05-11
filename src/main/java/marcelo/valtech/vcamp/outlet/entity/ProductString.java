package marcelo.valtech.vcamp.outlet.entity;

public class ProductString {
	private final int sku;
	private final double price;
	private final double weight;
	private final Pants pants;
	private final Shoes shoes;
	private final Glasses glasses;
	private final Jackets jackets;
	
	
	public ProductString(int sku, double price, double weight, Pants pants, Shoes shoes, Glasses glasses,
			Jackets jackets) {
		super();
		this.sku = sku;
		this.price = price;
		this.weight = weight;
		this.pants = pants;
		this.shoes = shoes;
		this.glasses = glasses;
		this.jackets = jackets;
	}
	
	public String printPants() {
		String info = "";
		info += " SKU: " + sku;
		info += " |Price: " + price;
		info += " |Weight" + weight;
		
		if(this.pants != null) {
			info += "Pants: " + pants;
		}
		return info;
	}
	
	public String printShoes() {
		String info = "";
		info += " SKU: " + sku;
		info += " |Price: " + price;
		info += " |Weight" + weight;
		
		if(this.shoes != null) {
			info += "Shoes: " + shoes;
		}
		return info;
	}
	
	
}
