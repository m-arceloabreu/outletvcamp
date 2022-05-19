package marcelo.valtech.vcamp.outlet.director;

import java.util.List;

public class BackOffice implements BackOfficeObserver {
	 OrderList orderList = OrderList.getInstance();
	 
	 
 
@Override
public void renderOrderList(List<Order> orderList) {
	for (Order order : orderList) { 
		String status = order.getStatus();
		Double price = order.getTotalPrice();
		String shipingType = order.shippingType();
		Cart cart = order.getCart();
		
		System.out.println( 
				"Status: "+ status+
				"\nTotalPrice: " + price+
				"\n ShyppingType"+ shipingType+
				"\nCart: " + cart+"\n");
	}
	
	
}

}
