package marcelo.valtech.vcamp.outlet.main;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.director.Cart;
import marcelo.valtech.vcamp.outlet.director.Director;
import marcelo.valtech.vcamp.outlet.director.ProductInventory;
import marcelo.valtech.vcamp.outlet.entity.Product;

public class main {
	public static void main(String[] args) {
		Director director = new Director();
		
		ProductInventory inventory =  ProductInventory.getInstance();
		
		ProductBuilderConcrete  prodBuilder = new ProductBuilderConcrete();
		

		director.constructPants(prodBuilder);
		Product pants = prodBuilder.getResultPants();
		director.catalog.add(pants);
		//System.out.println("Pants created: " + pants.toString());
		
		director.constructShoes(prodBuilder);
		Product shoes = prodBuilder.getResultShoes();
		director.catalog.add(shoes);
		//System.out.println("Shoes created: " + shoes.toString());
		
		director.constructJacket(prodBuilder);
		Product jacket = prodBuilder.getResultJacket();
		director.catalog.add(jacket);
		//System.out.println("Jacket created: " + jacket.toString());
		
		director.constructGlasses(prodBuilder);
		Product glasses = prodBuilder.getResultGlasses();
		director.catalog.add(glasses);
		//System.out.println("Glasses created: " + glasses.toString());
		
		//System.out.println("------------------");
		//System.out.println("Catalog: \n"+ director.catalog);
		//System.out.println("------------------");
		inventory.addToInventory(director.catalog);
		//System.out.println(inventory.inventory);
		
		//System.out.println("------------------");
		//inventory.getProductQuantity(1);
		//inventory.getProductBySku(2);
		//System.out.println("------DEPOIS DE REMOVIDO DO ESTOQUE------------");
		
		//inventory.removeProductFromStock(1, 3);
		Cart cart = new Cart();
		cart.viewCart();
		
	
	}
	
	

}
