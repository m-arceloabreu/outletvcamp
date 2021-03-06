package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilder;
import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Product;
//Works as a catalog
public class Director {

	public static void constructPants(ProductBuilderConcrete builder) {
		builder.setSKU(1);
		builder.setQuantity(10);
		builder.setQuantityReserved(0);
		builder.setPrice(40.00);
		builder.setWeight(1.50);
		builder.setPSize(44);
		builder.setMaterial("jeans");
	}

	public void constructShoes(ProductBuilderConcrete builder) {
		builder.setSKU(2);
		builder.setQuantity(10);
		builder.setQuantityReserved(0);
		builder.setPrice(150.00);
		builder.setWeight(2.50);
		builder.setsSize(44);
		builder.setSports("FootBall");
	}

	public void constructJacket(ProductBuilderConcrete builder) {
		builder.setSKU(3);
		builder.setQuantity(10);
		builder.setQuantityReserved(0);
		builder.setPrice(250.00);
		builder.setWeight(3.50);
		builder.setJSize("GG");
		builder.setWeather("Winter");
	}

	public void constructGlasses(ProductBuilderConcrete builder) {
		builder.setSKU(4);
		builder.setQuantity(10);
		builder.setQuantityReserved(0);
		builder.setPrice(350.00);
		builder.setWeight(0.50);
		builder.setLensType("Sun lens");
		builder.setModel("Aviator");
	}

	public List<Product> catalog = new ArrayList<>();

	public List<Product> getAllProducts() {

		return catalog;
	}

}
