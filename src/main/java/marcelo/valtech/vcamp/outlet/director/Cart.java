package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class Cart {
	
	private List<Product> products = new ArrayList<>();
	
	ProductInventory inventory = ProductInventory.getInstance();
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void  addItem(int sku ,int qtd) {
		for(Product p : inventory.inventory) {
			if(p.getSku() == sku &&p.getQuantity() < qtd) {
				System.out.println("We don't have this amount");
			}else if(p.getSku() == sku && p.getQuantity() >= qtd) {
				inventory.changeProductFromStocktoReserved(sku, qtd);
				Product cartProduct = (inventory.getProductBySku(sku));
				products.add(cartProduct);
			}
		}
	}
	
	public List<Product> removeItem(int sku, int qtd) {
		for (Product p : products) {
			if(p.getSku() == sku && p.getQuantityReserved() == qtd) {
				products.remove(p);
				break;
			}

		if(p.getSku() == sku && p.getQuantityReserved() > qtd) {
			p.setQuantityReserved(p.getQuantityReserved() - qtd);
			p.setQuantity(p.getQuantity() + qtd);
		}
	}
	return products;
	}
	
	
	public double getTotal() {
		double cartValue = 0;
		for(Product p : products) {
			cartValue += (p.getQuantityReserved()) * (p.getPrice());
		}
		return cartValue;
	}
	
	public int totalQuantity() {
		int totalQuantity = 0; 
		for(Product p : products) {
			totalQuantity += (p.getQuantityReserved());
		}
		return totalQuantity;
	}
	
	public Double getWeight() {
		double totalWeight = 0.0;
		for(Product p : products) {
			totalWeight +=  (p.getQuantityReserved() * p.getWeight());
		}
		return totalWeight;
	}
	public double shippingCost() {
		double totalShippingCost = 0;
		 Shipping shipping = ShippingFactory.chooseShipping(getWeight());
		 totalShippingCost = shipping.deliver(getTotal(), totalQuantity());
		 return totalShippingCost;
		}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}
	
	








	
	
	
	

	

}
