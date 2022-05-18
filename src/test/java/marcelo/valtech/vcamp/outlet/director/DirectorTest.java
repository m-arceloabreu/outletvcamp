package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mock;
import org.mockito.Mockito;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilder;
import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jacket;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class DirectorTest {
	Director director = new Director();
	ProductBuilderConcrete prodBuilder = new ProductBuilderConcrete();
	
	ProductBuilder builder;
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void createPantsTest() {
		
		
		//action
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		director.catalog.add(pants);
		//verification
		assertEquals(10, pants.getQuantity());
		assertEquals(1 ,pants.getSku());
		assertEquals(0 ,pants.getQuantityReserved());
		assertEquals("jeans" ,pants.getMaterial());
		assertEquals(44 ,pants.getPantSize());
	}
	@Test
	public void createShoesTest() {

		//action
		director.constructShoes(prodBuilder);
		Shoes shoes = prodBuilder.getResultShoes();
		director.catalog.add(shoes);
		//verification
		assertEquals(shoes.getQuantity(), 10);
		assertEquals(shoes.getSku(), 2);
		assertEquals(shoes.getQuantityReserved(), 0);
		error.checkThat(shoes.getPrice(),CoreMatchers.is(150.00));
		error.checkThat(shoes.getWeight(), CoreMatchers.is(2.50));
		assertEquals(44, shoes.getsSize());
		assertEquals("FootBall",shoes.getSports());
	}
	@Test
	public void createJacketTest() {
		//action
		director.constructJacket(prodBuilder);
		Jacket jacket = prodBuilder.getResultJacket();
		director.catalog.add(jacket);
		//verification
		assertEquals(jacket.getQuantity(), 10);
		assertEquals(jacket.getSku(), 3);
		assertEquals(jacket.getQuantityReserved(), 0);
		error.checkThat(jacket.getPrice(),CoreMatchers.is(250.00));
		error.checkThat(jacket.getWeight(), CoreMatchers.is(3.50));
		assertEquals("GG", jacket.getjSize());
		assertEquals("Winter", jacket.getWeather());
	}
	@Test
	public void createGlassesTest() {
		//action
		director.constructGlasses(prodBuilder);
		Glasses glasses = prodBuilder.getResultGlasses();
		director.catalog.add(glasses);
		//verification
		assertEquals(glasses.getQuantity(), 10);
		assertEquals(glasses.getSku(), 4);
		assertEquals(glasses.getQuantityReserved(), 0);
		error.checkThat(glasses.getPrice(),CoreMatchers.is(350.00));
		error.checkThat(glasses.getWeight(), CoreMatchers.is(0.50));
		assertEquals("Sun lens",glasses.getLensType());
		assertEquals("Aviator",glasses.getModel());
	}
	@Test
	public void getAllTest() {
		//scene
		createPantsTest();
		createShoesTest();
		createJacketTest();
		createGlassesTest();
		//action
		director.getAllProducts();
		//verification
		
		error.checkThat(director.catalog.size(),CoreMatchers.is(4));
	}
	
	

}
