package marcelo.valtech.vcamp.outlet.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jackets;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class ProductBuilderString implements Builder{
	private  int sku;
	private  double price;
	private  double weight;
	private  Pants pants;
	private  Shoes shoes;
	private Jackets jackets;
	private Glasses glasses;

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
	
	@Override
	public void setGlasses(Glasses glasses) {
		this.glasses = glasses;
	}

	@Override
	public void setJackets(Jackets jackets) {
		this.jackets = jackets;

	}
	public Product getResult() {
		return new Product(sku, price, weight, pants, shoes, glasses, jackets);
	}
	
	


}
