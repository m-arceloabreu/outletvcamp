package marcelo.valtech.vcamp.outlet.entity;

public class Shoes {
	private final int sSize;
	private final String sports;
	
	
	public Shoes(int sSize, String sports) {
		super();
		this.sSize = sSize;
		this.sports = sports;
	}
	
	public int getsSize() {
		return sSize;
	}
	public String getSports() {
		return sports;
	}
}
