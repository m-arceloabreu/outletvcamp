package marcelo.valtech.vcamp.outlet.shipping;

public class ShippingFactory {

	public static Shipping chooseShipping(double weight) {

		if (weight > 10) {
			return new Road();
		}

		return new Aero();
	}
}
