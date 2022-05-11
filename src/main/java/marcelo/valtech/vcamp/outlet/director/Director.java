package marcelo.valtech.vcamp.outlet.director;

import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jackets;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Product;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

import java.util.ArrayList;
import java.util.List;

import marcelo.valtech.vcamp.outlet.builder.Builder;

public class Director {
	public void buildPants(Builder builder) {
		builder.setSKU(1);
		builder.setPrice(55);
		builder.setWeight(1.5);
		builder.setPants(new Pants(44 ,"jeans"));
	}
	
	public void buildShoes(Builder builder) {
		builder.setSKU(2);
		builder.setPrice(250);
		builder.setWeight(2.0);
		builder.setShoes(new Shoes(40 ,"FootBall"));
	}
	
	public void buildGlasses(Builder builder) {
		builder.setSKU(3);
		builder.setPrice(150);
		builder.setWeight(0.5);
		builder.setGlasses(new Glasses("aviator", "sun-lens"));
	}
	public void buildJackets(Builder builder) {
		builder.setSKU(4);
		builder.setPrice(300);
		builder.setWeight(5.0);
		builder.setJackets(new Jackets("GG", "Black"));
	}

}

