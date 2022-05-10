package marcelo.valtech.vcamp.outlet.builder;

import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class ProductBuilder implements Builder{
	private  int sku;
	private  double price;
	private  double weight;
	private  Pants pants;
	private  Shoes shoes;

	@Override
	public void setSKU(int sku) {
		this.sku = sku;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
		
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;
		
	}

	@Override
	public void setPants(Pants pants) {
		this.pants = pants;
		
	}

	@Override
	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	
	public Product getResult() {
		return new Product(sku, price, weight, pants, shoes);
	}
}
