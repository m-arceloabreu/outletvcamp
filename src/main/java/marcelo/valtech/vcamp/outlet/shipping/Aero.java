package marcelo.valtech.vcamp.outlet.shipping;

import marcelo.valtech.vcamp.outlet.director.Cart;

public class Aero implements Shipping{

public double shippingCost = 0;
	
	@Override
	public Double deliver(double preco) {
		Cart cart = new Cart();
		
		if(cart.getTotalPrice() <= 799) {
			shippingCost = 7.99;
		}
		else {
		shippingCost = cart.getTotalPrice() * 0.01;
		}
		return shippingCost;
	}
}
