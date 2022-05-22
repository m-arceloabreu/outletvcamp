package marcelo.valtech.vcamp.outlet.shipping;

import marcelo.valtech.vcamp.outlet.director.Cart;


//This class implements the Shipping class and return the cost of using AERO as a shippingType
//It's also returns the description of the ShippingType
public class Aero implements Shipping {

	public double shippingCost = 0;

	@Override
	public Double deliver(double preco, int qtd) {

		if (preco <= 799) {
			shippingCost = 7.99;
		}

		return shippingCost;
	}

	@Override
	public String description() {

		return "Aero";
	}
}
