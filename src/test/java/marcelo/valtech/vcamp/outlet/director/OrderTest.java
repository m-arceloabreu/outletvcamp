package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mockito;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class OrderTest {
	Order order;
	private Director director = new Director();
	private ProductBuilderConcrete prodBuilder = new ProductBuilderConcrete();
	private ProductInventory inventory = ProductInventory.getInstance();
	private Cart cart = new Cart();
	
	@Rule
	  public ErrorCollector error = new ErrorCollector();
		
	@Before
	public void start()
	  {		//scene
		  	director.constructPants(prodBuilder);
		  	Pants pants = prodBuilder.getResultPants();
			inventory.inventory.add(pants);
			director.constructShoes(prodBuilder);
			Shoes shoes = prodBuilder.getResultShoes();
			inventory.inventory.add(shoes);
	  }	
	@Test
	public void getCartTest() {
		//scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		Order order = new Order(cart, "paid");
		//action
		
		order.getCart();
		//verification
		assertEquals(order.getCart(), cart);
	}
	@Test
	public void getStatusTest() {
		//scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		Order order = new Order(cart, "paid");
		//action
		order.getStatus();
		//verification
		assertEquals("paid",order.getStatus());
	}
	@Test
	public void getTotalPrice() {
		//scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
				Order order = new Order(cart, "paid");
		//action
				order.getTotalPrice();
	    //verification
			  error.checkThat(order.getTotalPrice(), CoreMatchers.is(577.99));
	}
	
	@Test
	public void shippingTypeTest() {
		//scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		Order order = new Order(cart, "paid");
		//action
		order.shippingType();
		//verification
		assertEquals("Road", order.shippingType());
	}
	@Test
	public void setStatusTestPending() {
		//scene
		Order order = new Order();
		int op = 1;
		//action
		order.setStatus(op, cart);
		//verification
		assertEquals("pending", order.status);
	}
	@Test
	public void setStatusTestPaid() {
		//scene
		Order order = new Order();
		int op = 2;
		//action
		order.setStatus(op, cart);
		//verification
		assertEquals("paid", order.status);
	}
	@Test
	public void setStatusTestShipped() {
		//scene
		Order order = new Order();
		int op = 3;
		//action
		order.setStatus(op, cart);
		//verification
		assertEquals("shipped", order.status);
	}
	@Test
	public void setStatusTestCompleted() {
		//scene
		Order order = new Order();
		int op = 4;
		//action
		order.setStatus(op, cart);
		//verification
		assertEquals("completed", order.status);
	}
	@Test
	public void setStatusTestCancelled() {
		//scene
		Order order = new Order();
		int op = 5;
		//action
		order.setStatus(op, cart);
		//verification
		assertEquals("cancelled", order.status);
	}
	@Test
	public void setStatusTestElse() {
		//scene
		Order order = new Order();
		int op = 7;
		//action
		order.setStatus(op, cart);
		//verification
		assertEquals(order.getStatus(),order.setStatus(op, cart));
	}
	@Test
	public void toStringTest(){
			Order order = new Order();
			Order order2= new Order();
			//action
			order.toString();
			order2.toString();
			//verification
			error.checkThat(order.toString(), CoreMatchers.is(order2.toString()));
	
	}
}
