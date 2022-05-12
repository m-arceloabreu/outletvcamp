package marcelo.valtech.vcamp.outlet.shipping;

import marcelo.valtech.vcamp.outlet.director.Cart;

public class ShippingFactory {
	

	public static Shipping chooseShipping(double weight) {
		Cart cart = new Cart();
		if(cart.getTotalWeight() <= 10) {
			return new Road();
		}
		
		return new Aero();
	} 
}
