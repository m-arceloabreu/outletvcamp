package marcelo.valtech.vcamp.outlet.entity;

public class Pants {
	private final int psize;
	private final String material;
	
	public Pants(int psize, String material) {
		super();
		this.psize = psize;
		this.material = material;
	}
	

	public int getPsize() {
		return psize;
	}

	public String getMaterial() {
		return material;
	}
}
