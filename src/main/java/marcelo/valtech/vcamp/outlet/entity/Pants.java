package marcelo.valtech.vcamp.outlet.entity;

public class Pants extends Product{
	private final int pantSize;
	private final String material;
	
	
	public Pants(int sku, double price, double weight, int pantSize2, String material) {
		super(sku, price, weight);
		this.pantSize = pantSize2;
		this.material = material;
	}

	public int getPantSize() {
		return pantSize;
	}


	public String getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "Pants ["+ super.toString() + " |PantSize=" + pantSize + ", |material=" + material +  "]\n";
	}

	
	
	
	

}
