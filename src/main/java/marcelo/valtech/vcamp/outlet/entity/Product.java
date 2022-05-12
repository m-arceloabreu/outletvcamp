package marcelo.valtech.vcamp.outlet.entity;

public abstract class Product {
	
	private final int sku;
	private final double price;
	private final double weight;
	
	
	public Product( int sku, double price, double weight ) {
		this.sku = sku;
		this.price = price;
		this.weight = weight;
		
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
	
	@Override
	public String toString() {
		return  "SKU: "+ sku + ", |Price=" + price + ", |Weight=" + weight ;
	}
	
	
	

		
		
	}

