package org.sang.bean;

import java.util.List;

public class OrderBo {
	private Order order;
	private List<Item> items;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	

}
