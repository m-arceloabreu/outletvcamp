package marcelo.valtech.vcamp.outlet.main;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilder;
import marcelo.valtech.vcamp.outlet.director.Director;
import marcelo.valtech.vcamp.outlet.entity.Product;

public class test {
	public static void main(String[] args) {
	
			Director director = new Director();
			
			ProductBuilder builder = new ProductBuilder();
			
			
			director.buildPants(builder);
			Product pants = builder.getResult();
			System.out.println(pants.getSku());
			
			director.buildShoes(builder);
			Product shoes = builder.getResult();
			System.out.println(shoes.getSku());
		}
	}

