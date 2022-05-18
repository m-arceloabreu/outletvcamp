package marcelo.valtech.vcamp.outlet.shipping;

import marcelo.valtech.vcamp.outlet.director.Cart;

public class Road implements Shipping{
	public double shippingCost = 0;
	
	@Override
	public Double deliver(double preco, int qtd) {
		
		if(preco <= 799) {
			shippingCost = 7.99;
		}
		else {
		shippingCost = (preco * 0.1) + (qtd);
		}
		return shippingCost;
	}
	
	@Override
	public String description() {
		
		return "Road";
	}
	
	
	
}
