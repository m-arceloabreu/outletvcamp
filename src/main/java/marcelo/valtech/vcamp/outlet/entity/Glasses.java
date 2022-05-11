package marcelo.valtech.vcamp.outlet.entity;

public class Glasses {
	private final String model;
	private final String lensType;
	
	
	public Glasses(String model, String lensType) {
		super();
		this.model = model;
		this.lensType = lensType;
	}

	public String getModel() {
		return model;
	}
	
	public String getLensType() {
		return lensType;
	}
	
	
}
