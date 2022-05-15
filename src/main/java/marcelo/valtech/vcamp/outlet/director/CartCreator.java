package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class CartCreator {
	
	ProductInventory inventory = ProductInventory.getInstance();
	private double totalPrice; 
	private double cartPrice;
	private int totalItens;
	private double totalWeight;
	private double totalShippingCost;
	private String shippingType;
	private List<Product> produtos = new ArrayList<>();

	
	
	public Cart getResultCart() {
		return new Cart( cartPrice,  totalItens,  totalWeight,  totalShippingCost,shippingType, produtos);
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
		}
		cartCost();
		totalQuantity();
		cartWeight();
		shippingCost();
		totalPriceCalc();
	}
	
public List<Product> addItemBySku(int sku, int qtd) {
		
		inventory.changeProductFromStocktoReserved(sku, qtd);
		Product cartProduct = (inventory.getProductBySku(sku));
		produtos.add(cartProduct);
		return produtos;
	}
	
	public void cartCost() {
		for(Product p : produtos) {
			cartPrice += (p.getQuantityReserved()) * (p.getPrice());
		}

	}
	public void totalQuantity() {
		for(Product p : produtos) {
			totalItens += (p.getQuantityReserved());
		}
	}
	
	public void cartWeight() {
		for(Product p : produtos) {
			totalWeight +=  (p.getQuantityReserved() * p.getWeight());
		}
	}
	
	public void shippingCost() {
	 Shipping shipping = ShippingFactory.chooseShipping(totalWeight);
	 totalShippingCost = shipping.deliver(cartPrice, totalItens);
	 shippingType = shipping.description();
	}

	public double getCartPrice() {
		return cartPrice;
	}


	public double getTotalShippingCost() {
		return totalShippingCost;
	}
	
	
	public void totalPriceCalc() {
		totalPrice = totalShippingCost + cartPrice;
	}

	
	
	
	
	
	

	
	
	
	
}
