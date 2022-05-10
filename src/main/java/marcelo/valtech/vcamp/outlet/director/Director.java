package marcelo.valtech.vcamp.outlet.director;

import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Shoes;
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
}

