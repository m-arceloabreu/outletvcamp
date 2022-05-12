package marcelo.valtech.vcamp.outlet.builder;

public interface ProductBuilder {
	
	ProductBuilder setSKU(int sku);
	ProductBuilder setPrice(double price);
	ProductBuilder setWeight(double weight);
	ProductBuilder setPSize(int pantSize);
	ProductBuilder setMaterial(String material);
	ProductBuilder setsSize(int sSize);
	ProductBuilder setSports(String sports);
	ProductBuilder setJSize(String jSize);
	ProductBuilder setWeather(String weather);
	ProductBuilder setLensType(String lensType);
	ProductBuilder setModel(String model);
	
}
