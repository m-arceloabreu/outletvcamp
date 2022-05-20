package marcelo.valtech.vcamp.outlet.director;

import java.util.List;
/// Observer Class that recieve atualizations of Order

public class BackOffice implements BackOfficeObserver {
	OrderList orderList = OrderList.getInstance();
//When a new Order is setted renderOrderList is updated
	@Override
	public String renderOrderList(List<Order> orderList) {
		for (Order order : orderList) {
			System.out.println(order.toString());
		}
		return orderList.toString();

	}

}
