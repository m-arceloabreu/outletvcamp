package marcelo.valtech.vcamp.outlet.main;

import java.util.ArrayList;
import java.util.Scanner;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.director.BackOffice;
import marcelo.valtech.vcamp.outlet.director.Cart;
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

	/// CREATING A CART
		OrderList orderList = OrderList.getInstance();
		BackOffice bO = new BackOffice();
		orderList.observers.add(bO);
		int i = 0;
		int sku;
		int qtd;
		int option = 1;
		Cart cart = new Cart();
		System.out.println("Catalog: \n"+ inventory.inventory);
		System.out.println("---------------------------------");
		Scanner sc = new Scanner(System.in);
		while(i==0) {
			System.out.println("Add item: 1  | RemoveItem: 2 |Finish: 3");
			option = sc.nextInt();
			if(option == 1) {
				System.out.println("Adicione Produto pelo SKU: ");
				sku = sc.nextInt();
				System.out.println("Adicione a Quantidade: ");
				qtd = sc.nextInt();
			cart.addItem(sku, qtd);
			i = 0;
		}else if(option == 2) {
				System.out.println("Remover Produto pelo SKU: ");
				sku = sc.nextInt();
				System.out.println("Remover a Quantidade: ");
				qtd = sc.nextInt();
			cart.removeItem(sku, qtd);
			i = 0;
			}
			else {
				i =1;
			}
			
		}
		cart.getTotal();
		cart.getWeight();
		cart.totalQuantity();
		cart.shippingCost();
		System.out.println("Order Status: \n1- Pending \n2-Paid \n3-Shipped \n4-Completed \n5-Cancelled");
		int op = sc.nextInt();
		Order order1 = new Order();
		String status = order1.setStatus(op, cart);
		Order order = new Order(cart, status);
		
//-----------------------------------------------------------------
		//Order order1 = new Order(cart);
	}
	
	

}
