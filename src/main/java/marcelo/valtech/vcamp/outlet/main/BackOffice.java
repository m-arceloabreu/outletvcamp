package marcelo.valtech.vcamp.outlet.main;

import java.util.ArrayList;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.director.Cart;
import marcelo.valtech.vcamp.outlet.director.CartCreator;
import marcelo.valtech.vcamp.outlet.director.Director;
import marcelo.valtech.vcamp.outlet.director.Order;
import marcelo.valtech.vcamp.outlet.director.ProductInventory;
import marcelo.valtech.vcamp.outlet.entity.Product;

public class BackOffice {
	public static void main(String[] args) {
		Director director = new Director();
		
		ProductInventory inventory =  ProductInventory.getInstance();
		
		ProductBuilderConcrete  prodBuilder = new ProductBuilderConcrete();
		

		director.constructPants(prodBuilder);
		Product pants = prodBuilder.getResultPants();
		director.catalog.add(pants);
		
		director.constructShoes(prodBuilder);
		Product shoes = prodBuilder.getResultShoes();
		director.catalog.add(shoes);
		
		director.constructJacket(prodBuilder);
		Product jacket = prodBuilder.getResultJacket();
		director.catalog.add(jacket);
		
		director.constructGlasses(prodBuilder);
		Product glasses = prodBuilder.getResultGlasses();
		director.catalog.add(glasses);
		
		inventory.addToInventory(director.catalog);
		
		
		System.out.println("--------------------");
		CartCreator createCart= new CartCreator();
		createCart.createCart();
		Cart cart = createCart.getResultCart();
		System.out.println(cart.toString());
		System.out.println("----------------------");
		Order order = new Order();
		order.Order(cart, order.setStatus(cart, "paid"));
		System.out.println(order.toString());
	}
	
	

}
