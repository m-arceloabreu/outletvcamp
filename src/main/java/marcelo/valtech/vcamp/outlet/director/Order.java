package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;

import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class Order {
	
	private double totalPrice;
	private double totalWeight;
	private double totalQuantity;
	private double totalShippingCost;
	private double cartPrice;
	private String status;
	private Cart cart;
	 String shippingType; 
	
 ProductInventory inventory = ProductInventory.getInstance();
 OrderList orderList = OrderList.getInstance();
	public Order() {}
	public  Order(Cart cart1, String status) {
		
		this.cart = cart1;
		this.cartPrice = this.cart.getTotal();
		this.totalWeight = this.cart.getWeight();
		this.totalQuantity = this.cart.totalQuantity();
		this.totalShippingCost = this.cart.shippingCost();
		this.totalPrice = cartPrice + totalShippingCost;
		this.shippingType = shippingType;
		this.status = status;
		
		shippingType = shippingType();
		orderList.addOrder(this);
	}
	
	public Cart getCart() {
		return cart;
	}
	public String getStatus() {
		return status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public String shippingType() {
		Shipping shipping = ShippingFactory.chooseShipping(cart.getWeight());
		shippingType = shipping.description();
		return shippingType;
	}
	
	public String setStatus(int op, Cart cart) {
		int op2 = 1;
		while ( op2 == 1) {
		if(op == 1) {
			status = "pending";	
			return status;
		}
		if(op == 2) {
			status = "paid";
			System.out.println("Waiting to be shipped!");
			return status;
		}
		if(op == 3) {
			status = "shipped";
		System.out.println("Already on Board!");
		return status;
		}
		if(op == 4) {
			status = "completed";
		System.out.println("Products delivered!");
		return status;
		}
		if(op == 5) {
			status = "cancelled";
			System.out.println("Order Cancelled!");
			return status;
		}
		else {
			op2 = 2;
		}
		}
		return status;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Order [totalPrice=" + totalPrice + ", \ntotalWeight=" + totalWeight + ", \ntotalQuantity=" + totalQuantity
				+ ", \ntotalShippingCost=" + totalShippingCost + ",\n cartPrice=" + cartPrice + ",\n status=" + status
				+ ",\n cart=" + cart + ",\n shippingType=" + shippingType + "]";
	}

	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
}
