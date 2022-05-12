package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class Cart {
	
	private int totalPrice;
	private int totalItens;
	private double totalWeight;
	private double totalShippingCost;
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(int totalItens) {
		this.totalItens = totalItens;
	}
	
	

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}



	ProductInventory inventory =  ProductInventory.getInstance();
	Director catalog = new Director();
	
	
	List<Product> cart = new ArrayList<>();
	
	public void viewCart() {
;		Scanner sc = new Scanner(System.in);
		int prodCode = 0;
		int qtd = 0;
		int resp = 1;
		System.out.println("Catalogo Disponivel: "+ inventory.inventory);
		System.out.println("Your Cart: " + cart);
		while( resp == 1) {
		System.out.println("AddItem: Type the SKU:  ");
		prodCode = sc.nextInt();
		System.out.println("Set Quantity: ");
		qtd = sc.nextInt();
		
		addItembySku(prodCode, qtd);
		
		System.out.println("Add more: 1 | Finish: 2");
		resp = sc.nextInt();
		}
		System.out.println("Final Cart: " + cart);
		cartCost();
		totalQuantity();
		cartWeight();
		
		Shipping shipping =  ShippingFactory.chooseShipping(totalWeight);
		totalShippingCost = shipping.deliver(totalPrice);
		System.out.println(totalPrice +  " " + totalItens +" Preço da Entrega: " + totalShippingCost);
	}

	public void addItembySku(int sku, int qtd) {
		Product cartProduct = (inventory.getProductBySku(sku));
		cartProduct.setQuantity(qtd);
		cart.add(cartProduct);
	}
	
	public void cartCost() {
		for(Product p : cart) {
			totalPrice += p.getQuantity() * p.getPrice();
		}
	}
	public void totalQuantity() {
		for(Product p : cart) {
			totalItens += p.getQuantity();
		}
	}
	
	public void cartWeight() {
		for(Product p : cart) {
			totalWeight += p.getQuantity() * p.getWeight();
		}
	}

}
