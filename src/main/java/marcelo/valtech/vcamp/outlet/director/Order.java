package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	List<Cart> cartOrder = new ArrayList<Cart>();
	
	
	public List<Cart> viewCart() {
		
		return cartOrder;
	}
}
