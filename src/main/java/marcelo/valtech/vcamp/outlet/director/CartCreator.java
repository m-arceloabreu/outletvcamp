package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class CartCreator {
	
	ProductInventory inventory = ProductInventory.getInstance();
	Cart cart;
	
	   
	   int totalItens;
	   double totalWeight; 
	   double totalShippingCost; 
	   String shippingType; 
	   List<Product> produtos = new ArrayList<>();
	  double cartValue = 0;
	  
	  
	  
	  public Cart getResultCart() { 
		  return new Cart( cartValue, totalItens,
				  totalWeight, totalShippingCost,shippingType, produtos); 
		  }
	 

	public void createCart() {
		int i = 0;
		int sku;
		int qtd;
		int resp = 1; 
		Scanner sc = new Scanner (System.in);
		System.out.println("Catalogo: \n" + inventory.inventory);
		while(i == 0) {
		System.out.println("Add item: 1  | RemoveItem: 2 |Finish: 3");
		resp = sc.nextInt();
	
		if(resp == 1) {
				System.out.println("Adicione Produto pelo SKU: ");
				sku = sc.nextInt();
				System.out.println("Adicione a Quantidade: ");
				qtd = sc.nextInt();
			addItemBySku(sku, qtd);
			i = 0;
		}else if(resp == 2) {
				System.out.println("Remover Produto pelo SKU: ");
				sku = sc.nextInt();
				System.out.println("Remover a Quantidade: ");
				qtd = sc.nextInt();
			removeProductBySku(sku, qtd);
			i = 0;
			}
			else {
				i =1;
			}
		}

		 cartCost();
		 totalQuantity();
		 cartWeight();
		 shippingCost();
	}

	
	
public List<Product> addItemBySku(int sku, int qtd) {

		inventory.changeProductFromStocktoReserved(sku, qtd);
		Product cartProduct = (inventory.getProductBySku(sku));
		produtos.add(cartProduct);
		return produtos;
	}
public List<Product> removeProductBySku(int sku, int qtd){
	for (Product p : produtos) {
		if(p.getSku() == sku && p.getQuantityReserved() == qtd) {
			produtos.remove(p);
		}
		else if(p.getSku() == sku && p.getQuantityReserved() > qtd) {
			p.setQuantityReserved(p.getQuantityReserved() - qtd);
			p.setQuantity(p.getQuantity() + qtd);
		}
	}
	return produtos;
}
public double cartCost() {
	cartValue = 0;
	for(Product p : produtos) {
		cartValue += (p.getQuantityReserved()) * (p.getPrice());
	}
	return cartValue;

}
public int totalQuantity() {
	for(Product p : produtos) {
		totalItens += (p.getQuantityReserved());
	}
	return totalItens;
}

public Double cartWeight() {
	for(Product p : produtos) {
		totalWeight +=  (p.getQuantityReserved() * p.getWeight());
	}
	return totalWeight;
}

public double shippingCost() {
 Shipping shipping = ShippingFactory.chooseShipping(totalWeight);
 totalShippingCost = shipping.deliver(cartValue, totalItens);
 return totalShippingCost;
}


	
	
	
	
	
	

	
	
	
	
}
