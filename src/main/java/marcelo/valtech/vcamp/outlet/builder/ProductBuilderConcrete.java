package marcelo.valtech.vcamp.outlet.builder;

import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jacket;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class ProductBuilderConcrete implements ProductBuilder {
	private  int sku;
	private  double price;
	private  double weight;
	private int pantSize;
	private String material;
	private int sSize;
	private String sports;
	private String jSize;
	private String weather;
	private String lensType;
	private String model;
	
	
	@Override
	public ProductBuilder setSKU(int sku) {
		this.sku = sku;
		return this;
	}

	@Override
	public ProductBuilder setPrice(double price) {
		this.price = price;
		return this;
	}

	@Override
	public ProductBuilder setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	@Override
	public ProductBuilder setPSize(int pantSize) {
		this.pantSize = pantSize;
		return this;
	}

	@Override
	public ProductBuilder setMaterial(String material) {
		this.material = material;
		return this;
	}
	@Override
	public ProductBuilder setsSize(int sSize) {
		this.sSize = sSize;
		return this;
	}

	@Override
	public ProductBuilder setSports(String sports) {
		this.sports = sports;
		return this;
	}
	
	@Override
	public ProductBuilder setJSize(String jSize) {
		this.jSize = jSize;
		return this;
	}
	@Override
	public ProductBuilder setWeather(String weather) {
		this.weather = weather;
		return this;
	}
	@Override
	public ProductBuilder setLensType(String lensType) {
		this.lensType = lensType;
		return this;
	}

	@Override
	public ProductBuilder setModel(String model) {
		this.model = model;
		return null;
	}
	
	
	
	public Pants getResultPants() {
		return new Pants(sku, price, weight, pantSize, material);
	}
	public Shoes getResultShoes() {
		return new Shoes(sku, price, weight, sSize, sports);
	}
	public Jacket getResultJacket() {
		return new Jacket(sku, price, weight, weather, jSize);
	}
	public Glasses getResultGlasses() {
		return new Glasses(sku, price, weight, lensType, model);
	}

	

	

	

	
}
