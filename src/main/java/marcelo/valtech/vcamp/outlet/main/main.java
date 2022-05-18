package marcelo.valtech.vcamp.outlet.main;

import java.util.ArrayList;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.director.BackOffice;
import marcelo.valtech.vcamp.outlet.director.Cart;
import marcelo.valtech.vcamp.outlet.director.CartCreator;
import marcelo.valtech.vcamp.outlet.director.Director;
import marcelo.valtech.vcamp.outlet.director.Order;
import marcelo.valtech.vcamp.outlet.director.OrderList;
import marcelo.valtech.vcamp.outlet.director.ProductInventory;
import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jacket;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class main { 
	public static void main(String[] args) {
		Director director = new Director();
		
		ProductInventory inventory =  ProductInventory.getInstance();
		
		ProductBuilderConcrete  prodBuilder = new ProductBuilderConcrete();
		

		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		director.catalog.add(pants);
		
		director.constructShoes(prodBuilder);
		Shoes shoes = prodBuilder.getResultShoes();
		director.catalog.add(shoes);
		
		director.constructJacket(prodBuilder);
		Jacket jacket = prodBuilder.getResultJacket();
		director.catalog.add(jacket);
		
		director.constructGlasses(prodBuilder);
		Glasses glasses = prodBuilder.getResultGlasses();
		director.catalog.add(glasses);
		
		inventory.addToInventory(director.catalog);

		System.out.println("--------------------");
		CartCreator createCart= new CartCreator();
		createCart.createCart();
		Cart cart = createCart.getResultCart();
		
		System.out.println(cart.toString());
		System.out.println("----------------------");
		
		
		OrderList orderList = OrderList.getInstance();
		BackOffice bO = new BackOffice();

		orderList.observers.add(bO); 
		Order order = new Order(cart, "paid");
	}
	
	

}
