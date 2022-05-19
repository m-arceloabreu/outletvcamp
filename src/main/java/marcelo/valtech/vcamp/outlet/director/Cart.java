package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class Cart {
	
	private double cartPrice;
	private int totalItens;
	private double totalWeight;
	private double totalShippingCost;
	private List<Product> produtos;
	
	ProductInventory inventory = ProductInventory.getInstance();
	
	public Cart(double cartPrice, int totalItens, double totalWeight, double totalShippingCost, List<Product> produtos) {
		super();
		this.cartPrice = cartPrice;
		this.totalItens = totalItens;
		this.totalWeight = totalWeight;
		this.totalShippingCost = totalShippingCost;
		this.produtos = produtos;
	}
	

	public double getCartPrice() {
		return cartPrice;
	}
	
	public int getTotalItens() {
		return totalItens;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
	
	public double getTotalShippingCost() {
		return totalShippingCost;
	}
	
	public List<Product> getProdutos() {
		return produtos;
	}
	
	
	@Override
	public String toString() {
		return "Cart: \nCartPrice=" + cartPrice + " \nTotalItens=" + totalItens + "\nTotalWeight=" + totalWeight
				+"\nTotalShippingCost= " + totalShippingCost + "\n Produtos=" + produtos + "\n";
	}








	
	
	
	

	

}
