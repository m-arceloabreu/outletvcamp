package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class CartCreator {
	
	ProductInventory inventory = ProductInventory.getInstance();
	private int totalPrice;
	private int totalItens;
	private double totalWeight;
	private double totalShippingCost;
	private List<Product> produtos = new ArrayList<>();
	
	
	public Cart getResultCart() {
		return new Cart( totalPrice,  totalItens,  totalWeight,  totalShippingCost, produtos);
	}

	public void createCart() {
		int prodCode;
		int qtd;
		int resp = 1;
		Scanner sc = new Scanner (System.in);
		System.out.println("Catalogo: \n" + inventory.inventory);
		while(resp == 1) {
		System.out.println("Adicione Produto pelo SKU: ");
		prodCode = sc.nextInt();
		System.out.println("Adicione a Quantidade: ");
		qtd = sc.nextInt();
		addItemBySku(prodCode,qtd);
		System.out.println("Add item: 1  | Finish: 2");
		resp = sc.nextInt();
		cartCost();
		totalQuantity();
		cartWeight();
		shippingCost();
		
		
		}
		
	}
	
	public void addItemBySku(int sku, int qtd) {
		Product cartProduct = (inventory.getProductBySku(sku));
		inventory.changeProductFromStocktoReserved(sku, qtd);
		produtos.add(cartProduct);
	}
	
	public void cartCost() {
		for(Product p : produtos) {
			totalPrice += p.getQuantityReserved() * p.getPrice();
		}
	}
	public void totalQuantity() {
		for(Product p : produtos) {
			totalItens += p.getQuantityReserved();
		}
	}
	
	public void cartWeight() {
		for(Product p : produtos) {
			totalWeight += p.getQuantityReserved() * p.getWeight();
		}
	}
	
	public void shippingCost() {
	 Shipping shipping = ShippingFactory.chooseShipping(totalWeight);
	 totalShippingCost = shipping.deliver(totalPrice);
	}
	
}
