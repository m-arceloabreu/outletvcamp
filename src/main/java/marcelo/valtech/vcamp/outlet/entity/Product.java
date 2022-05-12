package marcelo.valtech.vcamp.outlet.entity;

public abstract class Product {
	
	private final  int sku;
	public  int quantity;
	private final  double price;
	private final  double weight;
	
	
	public Product( int sku,int quantity, double price, double weight ) {
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
		this.weight = weight;
		
	}
	public int getSku() {
		return sku;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return  "SKU: "+ sku +" |Quantity: "+ quantity +", |Price=" + price + ", |Weight=" + weight ;
	}
	
	
	
	

		
		
	}

