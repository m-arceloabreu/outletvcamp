package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jacket;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class CartTest {

	private Cart cart;
	Director director = new Director();
	ProductBuilderConcrete prodBuilder = new ProductBuilderConcrete();
	ProductInventory inventory = ProductInventory.getInstance();

	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Before
	public void start() {
		ShippingFactory shipFactory = new ShippingFactory();
		inventory.inventory.clear();
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		director.constructShoes(prodBuilder);
		Shoes shoes = prodBuilder.getResultShoes();
		director.constructJacket(prodBuilder);
		Jacket jacket = prodBuilder.getResultJacket();
		director.constructGlasses(prodBuilder);
		Glasses glasses = prodBuilder.getResultGlasses();
		inventory.inventory.add(pants);
		inventory.inventory.add(shoes);
		inventory.inventory.add(jacket);
		inventory.inventory.add(glasses);
		cart = new Cart();
	}

	@Test
	public void addItemTest() {
		// action
		cart.addItem(1, 3);
		// verification
		assertEquals(inventory.inventory.get(0), cart.getProducts().get(0));
		assertEquals(3, cart.getProducts().get(0).getQuantityReserved());
		assertEquals(1, cart.getProducts().get(0).getSku());
	}

	@Test
	public void addItemTestWithoutQuantity() {
		// action
		cart.addItem(1, 12);
	}

	@Test
	public void addItemWithoutSkuRegistred() {
		// action
		cart.addItem(5, 11);
		// verification
	}

	@Test
	public void removeItemTest() {
		// scene
		cart.addItem(1, 10);
		cart.addItem(2, 5);
		// action
		// cart.removeItem(1, 10);
		cart.removeItem(1, 7);
		cart.removeItem(2, 5);
		// verification
		assertEquals(1, cart.getProducts().size());
		assertEquals(1, cart.getProducts().get(0).getSku());
		assertEquals(3, cart.getProducts().get(0).getQuantityReserved());
		assertEquals(7, cart.getProducts().get(0).getQuantity());
	}

	@Test
	public void removeItemsTestWithoutEnoughItems() {
		// scene
		cart.addItem(1, 3);
		// action
		cart.removeItem(1, 4);
		// verification
	}

	@Test
	public void getTotalTest() {
		// scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		System.out.println(cart.getProducts());
		// action
		cart.getTotal();
		// verification
		error.checkThat(cart.getTotal(), CoreMatchers.is(570.0));
		assertEquals(2, cart.getProducts().size());
	}

	@Test
	public void totalQuantityTest() {
		// scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		// action
		cart.totalQuantity();
		// verification
		assertEquals(6, cart.totalQuantity());
	}

	@Test
	public void getWeightTest() {
		// scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		// action
		cart.getWeight();
		// verification
		error.checkThat(cart.getWeight(), CoreMatchers.is(12.0));
	}

	@Test
	public void shippingCostTestMiniMum() {
		// scene
		cart.addItem(1, 3);
		cart.addItem(2, 3);
		// action
		cart.shippingCost();
		// verification
		error.checkThat(cart.shippingCost(), CoreMatchers.is(7.99));
	}

	@Test
	public void shippingCostTestElse() {
		cart.addItem(4, 7);
		cart.addItem(3, 6);
		// action
		cart.shippingCost();
		// verification
		error.checkThat(cart.shippingCost(), CoreMatchers.is(408.00));
	}

	@Test
	public void toStringTest() {
		cart.addItem(1, 3);
		// action
		cart.toString();
		System.out.println(cart.toString());
		// verification
		assertEquals(
				"Cart [products=[Pants [SKU: 1 |Quantity: 7 |QuantityReserved: 3, |Price=40.0, |Weight=1.5 |PantSize=44, |material=jeans]\n]]",
				cart.toString());
	}

}
