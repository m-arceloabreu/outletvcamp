package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private String status;
	private Cart cart;
	private double totalPrice;
	
	ProductInventory inventory = ProductInventory.getInstance();
	
	
	public void Order(Cart cart1,String status) {
		this.totalPrice = cart1.getTotalShippingCost() + cart1.getCartPrice();
		this.cart = cart1;
		this.status = setStatus(cart1, status);
		
	}
	
	public String setStatus(Cart cart1, String status) {
		int resp = 1;
	
		while( resp == 1) {
		if(status == "paid") {
			inventory.removeProductFromStock();
			System.out.println("Waitng to be Shipped");
			resp  = 2 ;
			return status ="paid";
		}
		if(status == "pending") {
			System.out.println("Waiting to be paid");
			resp  = 2 ;
			return status ="pending";
		}
		if(status =="shipped") {
			inventory.removeProductFromStock();
			System.out.println("Shipped by: " + cart1.getShippingType());
			resp  = 2 ;
			return status ="shipped";
			
		}
		if(status =="completed") {
			inventory.removeProductFromStock();
			System.out.println("Product Deliverd");
			resp  = 2 ;
			return status ="completed";
		}
		else {
			resp  = 1 ;
			
		}
		
		}
		return status;
	}


	@Override
	public String toString() {
		return "Order [status=" + status + ", cart=" + cart + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
	
}
