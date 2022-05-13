package marcelo.valtech.vcamp.outlet.shipping;

import marcelo.valtech.vcamp.outlet.director.Cart;

public class ShippingFactory {
	

	public static Shipping chooseShipping(double weight) {
		
		if(weight >= 10) {
			return new Road();
		}
		
		return new Aero();
	} 
}
