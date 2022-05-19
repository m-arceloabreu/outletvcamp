
package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mockito;

public class OrderListTest {
		OrderList orderList = OrderList.getInstance();
		BackOffice bo = new BackOffice();
		BackOffice bo2 = new BackOffice();
		
	@Rule
		  public ErrorCollector error = new ErrorCollector();
	@Before
	public void start() {
		orderList.observers.clear();
		orderList.orderList.clear();
	}
	@Test
	public void addObserverTest() {
		//action
		orderList.addObserver(bo);
		
		//verification
		assertEquals(1,orderList.observers.size());
	}
	@Test
	public void removeObserverTest() {
		//scene
		orderList.addObserver(bo);
		orderList.addObserver(bo2);
		//action
		orderList.removeObserver(bo2);
		//verification
		assertEquals(1, orderList.observers.size());
	}
	
	@Test
	public void getFirstTest() {
		//scene
		Order order = (Mockito.mock(Order.class));
		Order order2 = (Mockito.mock(Order.class));
		orderList.orderList.add(order);
		orderList.orderList.add(order2);
		//action
		orderList.getFirst();
		//verification
		assertEquals(orderList.getFirst(), orderList.orderList.get(0));
	}
	@Test
	public void getNextTest() {
		//scene
		Order order = (Mockito.mock(Order.class));
		Order order2 = (Mockito.mock(Order.class));
		orderList.orderList.add(order);
		orderList.orderList.add(order2);
		//action
		orderList.getNext();
		//verification
		assertEquals(order2, orderList.getNext());
	}
	@Test
	public void resetTest() {
		//scene
		Order order = (Mockito.mock(Order.class));
		Order order2 = (Mockito.mock(Order.class));
		Order order3 = (Mockito.mock(Order.class));
		orderList.orderList.add(order);
		orderList.orderList.add(order2);
		orderList.orderList.add(order3);
		//action
		orderList.getNext();
		orderList.reset();
		Order orderItem = orderList.getNext();
		//action
		assertEquals(orderItem, orderList.orderList.get(1));
	}
	@Test
	public void hasNextTestToEmptyList() {
		//action to empty list
		orderList.hasNext();
		//verification
		assertFalse(orderList.hasNext());
	}
	@Test
	public void hasNextTestToAListWithItens() {
		//scene
		Order order = (Mockito.mock(Order.class));
		
		orderList.orderList.add(order);
		
		//action
		orderList.hasNext();
		//verification
		assertTrue(orderList.hasNext());
	}
	
	
}
