package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;

import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class Order {
	
	private String status;
	private Cart cart;
	private double totalPrice;
	private String shippingType; 
	
 ProductInventory inventory = ProductInventory.getInstance();
 OrderList orderList = OrderList.getInstance();
	
	public  Order(Cart cart1,String status) {
		this.totalPrice = cart1.getCartPrice() + cart1.getTotalShippingCost();
		this.cart = cart1;
		this.status = status;
		shippingType = shippingType();
		
		orderList.addOrder(this);
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getStatus() {
		return status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public String getShippingType() {
		return shippingType;
	}
	
	public String shippingType() {
		Shipping shipping = ShippingFactory.chooseShipping(cart.getTotalWeight());
		shippingType = shipping.description();
		return shippingType;
	}

	@Override
	public String toString() {
		return "Order [status=" + status +"ShippingType: "+shippingType+", Cart=\n" + cart + ", totalPrice=" + totalPrice + "]\n";
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
	
}
