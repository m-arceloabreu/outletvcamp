package marcelo.valtech.vcamp.outlet.director;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
	
	private static volatile OrderList orList;
	
	public static List<Order> orderList = new ArrayList<Order>();
	public ArrayList<BackOfficeObserver> observers = new ArrayList<BackOfficeObserver>();
	
	private OrderList() {}
	
	public static OrderList getInstance() {
		
		synchronized(OrderList.class){
			if(orList ==  null) {
				orList = new OrderList();
				return orList;
			}
			return orList;
		}
	}
	 
	public void addOrder(Order order) {
		orderList.add(order);
		notifyObserver();
	}

	public int i = 0;
	
	public Order getFirst() {
		i = 0;
		return orderList.get(i);
	}
	public Order getNext(){
		Order itemList = orderList.get(i+1);
		return itemList;
	}
	public boolean hasNext() {
		if(i >= orderList.size() || orderList.get(i)== null) {
			return false;
		}else {
			return true;
		}
		
	}
	public void reset() {
		i = 0;
		
	}
	
	public void addObserver(BackOfficeObserver o) {
		if(!observers.contains(o)) {
			observers.add(o);
		}
	}
	public void removeObserver(BackOfficeObserver o){
		observers.remove(o);
	} 
	
	public void notifyObserver(){
		for(BackOfficeObserver o: observers) {
			o.renderOrderList(orderList);
		}
	}	
}
