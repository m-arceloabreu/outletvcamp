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
	private String shippingType;
	private List<Product> produtos ;
	
	ProductInventory inventory = ProductInventory.getInstance();
	
	public Cart(double cartPrice, int totalItens, double totalWeight, double totalShippingCost,String shippingType, List<Product> produtos) {
		super();
		this.cartPrice = cartPrice;
		this.totalItens = totalItens;
		this.totalWeight = totalWeight;
		this.totalShippingCost = totalShippingCost;
		this.shippingType =  shippingType;
		this.produtos = produtos;
	}
	
	


	public double getCartPrice() {
		return cartPrice;
	}




	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
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




	public double getTotalShippingCost() {
		return totalShippingCost;
	}




	public void setTotalShippingCost(double totalShippingCost) {
		this.totalShippingCost = totalShippingCost;
	}




	public String getShippingType() {
		return shippingType;
	}




	public void setShippingType(String shippingType) {
		this.shippingType = shippingType;
	}




	public List<Product> getProdutos() {
		return produtos;
	}




	public void setProdutos(List<Product> produtos) {
		this.produtos = produtos;
	}




	@Override
	public String toString() {
		return "Cart: \nCartPrice=" + cartPrice + " \nTotalItens=" + totalItens + "\nTotalWeight=" + totalWeight
				+"\nShippingType= "+shippingType +"\nTotalShippingCost= " + totalShippingCost + "\n Produtos=" + produtos + "\n";
	}








	
	
	
	

	

}
