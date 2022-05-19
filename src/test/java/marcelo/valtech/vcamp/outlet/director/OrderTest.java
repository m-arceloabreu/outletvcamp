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
			
			cart.addItem(1, 3);
			cart.addItem(2, 3);
			order = new Order(cart, "paid");
			
	  }	

	

}
