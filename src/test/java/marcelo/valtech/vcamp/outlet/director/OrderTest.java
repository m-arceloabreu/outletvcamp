package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;

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
	Cart cart;
	private Director director = new Director();
	private ProductBuilderConcrete prodBuilder = new ProductBuilderConcrete();
	private ProductInventory inventory = ProductInventory.getInstance();
	private CartCreator createCart = new CartCreator();
	
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
			
			createCart.produtos = createCart.addItemBySku(1, 3);
			createCart.produtos = createCart.addItemBySku(2, 5);
			createCart.totalQuantity();
			createCart.cartCost();
			createCart.cartWeight();
			createCart.shippingCost();
			cart = createCart.getResultCart();
			order = new Order(cart, "paid");
			
			
	  }	
	
	@Test
	public void shippingTypeTest() {
		//action
		order.shippingType();
		List<Cart> cart1 = new ArrayList<Cart>();
		//verification
		
		error.checkThat(cart.getTotalItens(),CoreMatchers.is(8));
		error.checkThat(cart.getProdutos(),CoreMatchers.is(createCart.produtos));
		error.checkThat(cart.getCartPrice(), CoreMatchers.is(870.0));
		error.checkThat(order.shippingType, CoreMatchers.is("Road"));
	}
	@Test
	public void getCartTest() {
		//action
		order.getCart();
		//verification
		assertEquals(cart, order.getCart());
	}
	@Test
	public void getTotalPriceTest() {
		//action
		order.getTotalPrice();
		//verification
		error.checkThat(order.getTotalPrice(), CoreMatchers.is(cart.getCartPrice()+ cart.getTotalShippingCost()));
	}
	@Test
	public void getStatusTest() {
		order.getStatus();
		//verification
		assertEquals("paid", order.getStatus());
	}
	

}
