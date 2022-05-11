package marcelo.valtech.vcamp.outlet.main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import marcelo.valtech.vcamp.outlet.builder.Builder;
import marcelo.valtech.vcamp.outlet.builder.ProductBuilder;
import marcelo.valtech.vcamp.outlet.builder.ProductBuilderString;
import marcelo.valtech.vcamp.outlet.director.Director;
import marcelo.valtech.vcamp.outlet.entity.Catalog;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.ProductInventory;

public class test {
	public static void main(String[] args) {
	
			Director director = new Director();
			Catalog catalog = new Catalog();
			ProductInventory prodInventory = ProductInventory.getInstance();
			ProductBuilder builder = new ProductBuilder();
			ProductBuilderString builder1 = new ProductBuilderString();
			
			
			director.buildPants(builder);
			Product pants = builder1.getResult();
			catalog.catalogList.add(pants);
			
			director.buildShoes(builder);
			Product shoes = builder1.getResult();
			catalog.catalogList.add(shoes);
			

			
			director.buildGlasses(builder);
			Product glasses = builder1.getResult();
			catalog.catalogList.add(glasses);
			

			
			director.buildJackets(builder);
			Product jackets = builder1.getResult();
			catalog.catalogList.add(jackets);
			

			System.out.println("-----------------");
			System.out.println(catalog.getAllProducts());
			//System.out.println(catalog.getAllProducts());
			
			System.out.println("-----------------");
			
			
			
			
			
		}

	}

