package marcelo.valtech.vcamp.outlet.director;

import java.util.List;

public class BackOffice implements BackOfficeObserver {
	 OrderList orderList = OrderList.getInstance();

	 
@Override
public void renderOrderList(List<Order> orderList) {
	for (Order order : orderList) {  
		System.out.println( order.toString());
	}

}

}
