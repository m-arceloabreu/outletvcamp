package marcelo.valtech.vcamp.outlet.director;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import marcelo.valtech.vcamp.outlet.builder.ProductBuilderConcrete;
import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jacket;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public class ProductInventoryTest {
	ProductInventory inventory = ProductInventory.getInstance();
	Director director = new Director();
	ProductBuilderConcrete prodBuilder = new ProductBuilderConcrete();
	@Before
	public void start() {
		inventory.inventory.clear();
	}
	@Test
	public void addToInventoryTest() {
		//scene
		List<Product> inventoryTest = new ArrayList<Product>();
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		inventoryTest.add(pants);
		director.constructShoes(prodBuilder);
		Shoes shoes = prodBuilder.getResultShoes();
		inventoryTest.add(shoes);
		
		//action
		inventory.addToInventory(inventoryTest);
		
		//verification
		assertEquals(inventoryTest.get(0),inventory.inventory.get(0));
		assertEquals(inventoryTest.get(1),inventory.inventory.get(1));
	}
	
	@Test 
	public void getProductBySkuTest() {
		//scene
		//List<Product> inventoryTest = new ArrayList<Product>();
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
		
		int skuu = inventory.inventory.get(0).getSku();
		
		//action
		inventory.getProductBySku(skuu);
		//verification
		assertEquals(inventory.inventory.get(0).toString(), pants.toString());
		assertEquals(inventory.inventory.get(1).toString(), shoes.toString());
		assertEquals(inventory.inventory.get(2).toString(), jacket.toString());
		assertEquals(inventory.inventory.get(3).toString(), glasses.toString());
	}
	@Test
	public void getProductQuantityTest() {
		//scene
		int sku = 1;
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		inventory.inventory.add(pants);
		//action
		inventory.getProductQuantity(sku);
		//verification
		assertEquals(0, inventory.inventory.get(sku-1).getQuantityReserved());
	}
	@Test
	public void changeProductFromStocktoReservedTest() {
		//scene
		int sku = 1 ;
		int qtd = 3;
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		inventory.inventory.add(pants);
		
		//action
		inventory.changeProductFromStocktoReserved(sku, qtd);
		
		//verification
		assertEquals(7,inventory.inventory.get(0).getQuantity());
		assertEquals(3,inventory.inventory.get(0).getQuantityReserved());
	}
	
	@Test
	public void changeProductFromReservedToStockTest() {
		int sku = 1 ;
		int qtd = 3;
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		inventory.inventory.add(pants);
		//action
		inventory.changeProductFromReservedToStock(inventory.inventory);

		//verification
		assertEquals(10, inventory.inventory.get(0).getQuantity());
		assertEquals(0, inventory.inventory.get(0).getQuantityReserved());	
		}

	@Test
	public void removeProductFromStock() {
		//scene
		int sku = 1;
		director.constructPants(prodBuilder);
		Pants pants = prodBuilder.getResultPants();
		pants.setQuantityReserved(3);
		pants.setQuantity(7);
		
		inventory.inventory.add(pants);
		//action
		inventory.removeProductFromStock(1, 3);
		//verification
		assertEquals(0,inventory.inventory.get(0).getQuantityReserved());
		
	}
	}
