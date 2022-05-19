package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BackOfficeTest {
	BackOffice backOffice = new BackOffice();
	
	@Test
	public void renderOrderListTest() {
		//scene
		OrderList orderList = OrderList.getInstance();
		
		//action
		backOffice.renderOrderList(orderList.orderList);
		
		//verification
		assertEquals(backOffice.renderOrderList(orderList.orderList),
				orderList.orderList.toString());
	}
}
