package marcelo.valtech.vcamp.outlet.entity;

import java.util.ArrayList;

import java.util.List;

public class Catalog {

	public List<Product> catalogList = new ArrayList<>();
	
	 
	public List<Product> getAllProducts() {
		return catalogList;
	}
}
