package marcelo.valtech.vcamp.outlet.entity;

public class Jacket extends Product {
	private final String weather;
	private final String jSize;
	
	public Jacket(int sku, double price, double weight, String weather, String jSize) {
		super(sku, price, weight);
		this.weather = weather;
		this.jSize = jSize;
	}

	public String getWeather() {
		return weather;
	}

	public String getjSize() {
		return jSize;
	}
	
	@Override
	public String toString() {
		return "Jacket ["+ super.toString() + " |JacketSize=" + jSize + ", |Weather=" + weather +  "]\n";
	}
	
	
	
	
	
	
}