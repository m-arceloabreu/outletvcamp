package marcelo.valtech.vcamp.outlet.shipping;



public interface Shipping {

	Double deliver(double preco, int qtd);
	String description();
}
