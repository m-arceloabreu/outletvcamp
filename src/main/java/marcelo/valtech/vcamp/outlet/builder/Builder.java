package marcelo.valtech.vcamp.outlet.builder;

import marcelo.valtech.vcamp.outlet.entity.Glasses;
import marcelo.valtech.vcamp.outlet.entity.Jackets;
import marcelo.valtech.vcamp.outlet.entity.Pants;
import marcelo.valtech.vcamp.outlet.entity.Shoes;

public interface Builder {
		void setSKU(int sku);
		void setPrice(int price);
		void setWeight(double weight);
		void setPants(Pants pants);
		void setShoes (Shoes shoes);
		void setGlasses(Glasses glasses);
		void setJackets(Jackets jackets);
		
}
