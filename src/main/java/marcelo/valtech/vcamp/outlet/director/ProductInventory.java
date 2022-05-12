package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilder;
import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Product;

public final class ProductInventory {
	
	
	private static volatile  ProductInventory prodInve;
	

	
	public static List<Product> inventory = new ArrayList<Product>();
	private static int prodQuantity = 0;
	
	private ProductInventory() {}
	
	public static ProductInventory getInstance( ) {
		if(prodInve != null) {
			return prodInve;
		}
		synchronized(ProductInventory.class){
			if(prodInve ==  null) {
				prodInve = new ProductInventory();
				return prodInve;
			}
			return prodInve;
		}
	}
	
	public static List<Product> addToInventory(List<Product> list1) {
		for (Product product : list1) {
			inventory.add(product);
		}
		return inventory;
	}
	public Product getProductBySku(int sku) {
		System.out.println(inventory.get(sku-1));
		return inventory.get(sku-1);
	}
	
	public void getProductQuantity(int sku) {
		int skuu = sku -1;
		Stream<Product> stream = inventory.stream().filter(prod -> prod.getSku() == sku);
		int productQuantity = stream.toList().get(skuu).getQuantity();
		System.out.println(productQuantity);
	}
	
	public List<Product> removeProductFromStock(int sku , int quantity) {
			for(Product p : inventory) {
				if(p.getSku() == sku && p.getQuantity() >= quantity) {
					p.setQuantity(p.getQuantity() - quantity);
				}
			}
			return inventory;
		}
	}