package marcelo.valtech.vcamp.outlet.entity;

public class Shoes extends Product {
	private final int sSize;
	private final String sports;
	
	public Shoes(int sku, double price, double weight, int sSize, String sports) {
		super(sku, price, weight);
		this.sSize = sSize;
		this.sports = sports;
	}

	public int getsSize() {
		return sSize;
	}

	public String getSports() {
		return sports;
	}
	
	@Override
	public String toString() {
		return "Shoes ["+ super.toString() + " |ShoedSize=" + sSize + ", |Sports=" + sports +  "]\n";
	}
	
}
