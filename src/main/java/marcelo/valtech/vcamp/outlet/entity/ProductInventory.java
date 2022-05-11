package marcelo.valtech.vcamp.outlet.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.List;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilder;

public final class ProductInventory {
	
	public static int qtd = 10;



	Catalog catalog;
	private static  ProductInventory prodInve;
	
	 public static List<Product> inventory = new ArrayList<>();
	public static Map<Integer, Product> invent = new HashMap<Integer, Product>();
	 
	 
	

	
	private ProductInventory () { }
	//private ProductInventory(int qtd, int sku, double price, double weight) {}
	
	
	public static ProductInventory getInstance() {
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
	
	public static  void getProductQuantity(int sku) {
		
		 Integer keyToSearch = inventory.get(sku - 1).getSku();
		
		if(invent.containsKey(keyToSearch)){
			System.out.println(invent.get(sku-1));
		}
	}				
	
	public  static Map<Integer, Product> allInventory(List<Product> lista1) {
		int qtd = 10;
		for (int i =0 ;i < lista1.size(); i++) {
			invent.put(qtd, lista1.get(i));
			System.out.println("QTD: "+ qtd + " |Product: "+ lista1.get(i));
		}
		System.out.println("------------");
		return invent;
	}
	
	
}
