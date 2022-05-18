package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;
import marcelo.valtech.vcamp.outlet.shipping.Shipping;
import marcelo.valtech.vcamp.outlet.shipping.ShippingFactory;

public class CartCreatorTest {
	Director director = new Director();
	ProductInventory inventory = ProductInventory.getInstance();
	ProductBuilderConcrete prodBuilder = new ProductBuilderConcrete();
	CartCreator createCart = new CartCreator();
	Cart cart;
	
	  private List<Product> produtos = new ArrayList<>();
	  double cartValue = 0;
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
			createCart.produtos = createCart.addItemBySku(2, 8);
			
	  }	  
	  @Test
	  public void addItemBySkuTest() {
		  //scene
		  int sku = 1;
		  int qtd = 3;
		  
		  //verification
		  assertEquals(createCart.produtos.get(0), inventory.inventory.get(0));
		  assertEquals(createCart.produtos.get(1), inventory.inventory.get(1)); 
	  }
	  @Test
	  public void cartCostTest() {
		  // Thre items on our cart added in Before
		  //action
		 createCart.cartCost();
		 //verification
		 error.checkThat(createCart.cartValue,CoreMatchers.is(1320.0));
	  }
	  
	  @Test
	  public void totalQuantityTest() {
		  //action
		  createCart.totalQuantity();
		  //verification
		  error.checkThat(createCart.totalItens, CoreMatchers.is(11));
	  }
	  @Test
	  public void cartWeightTest() {
		  //action
		  createCart.cartWeight();
		  //verification
		  error.checkThat(createCart.totalWeight, CoreMatchers.is(24.5));
	  }
	  @Test
	  public void shippingCost(){
		 //scene
		  createCart.cartValue = 1320;
		  createCart.totalItens = 11;
		  createCart.totalWeight = 24.5;
		 //action
		 createCart.shippingCost();
		 
		 error.checkThat(createCart.totalShippingCost,CoreMatchers.is(143.0));
	  }
	  }
