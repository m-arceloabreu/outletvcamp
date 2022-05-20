package marcelo.valtech.vcamp.outlet.director;

import java.util.List;
//Interface that serve BackOffice class
public interface BackOfficeObserver {
	
	String renderOrderList(List<Order> orderList);
}
