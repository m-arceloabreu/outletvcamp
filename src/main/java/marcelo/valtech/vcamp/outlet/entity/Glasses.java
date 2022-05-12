package marcelo.valtech.vcamp.outlet.entity;

public class Glasses extends Product{
	private final String lensType;
	private final String model;
	
	public Glasses(int sku, double price, double weight, String lensType, String model) {
		super(sku, price, weight);
		this.lensType = lensType;
		this.model = model;
	}

	public String getLensType() {
		return lensType;
	}

	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		return "Glasses ["+ super.toString() + " |LensType=" + lensType + ", |Model=" + model +  "]\n";
	}

}
