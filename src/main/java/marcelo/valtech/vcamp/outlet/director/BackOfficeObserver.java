package marcelo.valtech.vcamp.outlet.director;

import java.util.List;

public interface BackOfficeObserver {
	
	void renderOrderList(List<Order> orderList);
}
