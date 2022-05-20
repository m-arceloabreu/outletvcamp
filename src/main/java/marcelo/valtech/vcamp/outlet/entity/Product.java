package marcelo.valtech.vcamp.outlet.entity;

public abstract class Product {

	private final int sku;
	public int quantity;
	public int quantityReserved;
	private final double price;
	private final double weight;

	public Product(int sku, int quantity, int quantityReserved, double price, double weight) {
		this.sku = sku;
		this.quantity = quantity;
		this.price = price;
		this.weight = weight;
		this.quantityReserved = quantityReserved;

	}

	public int getSku() {
		return sku;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getQuantityReserved() {
		return quantityReserved;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setQuantityReserved(int qtd) {
		this.quantityReserved = qtd;
	}

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "SKU: " + sku + " |Quantity: " + quantity + " |QuantityReserved: " + quantityReserved + ", |Price="
				+ price + ", |Weight=" + weight;
	}

}
