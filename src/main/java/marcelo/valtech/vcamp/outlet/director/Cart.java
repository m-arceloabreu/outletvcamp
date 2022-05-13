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
	private List<Product> produtos ;
	

	
	public Cart(int totalPrice, int totalItens, double totalWeight, double totalShippingCost, List<Product> produtos) {
		super();
		this.totalPrice = totalPrice;
		this.totalItens = totalItens;
		this.totalWeight = totalWeight;
		this.totalShippingCost = totalShippingCost;
		this.produtos = produtos;
	}



	@Override
	public String toString() {
		return "Cart: \nTotalPrice=" + totalPrice + " \nTotalItens=" + totalItens + "\nTotalWeight=" + totalWeight
				+ "\n TotalShippingCost=" + totalShippingCost + "\n Produtos=" + produtos + "\n";
	}








	
	
	
	

	

}
