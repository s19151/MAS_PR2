package io.github.s19151.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "warehouseman")
public class Warehouseman extends Worker {
	//connections
	private List<Order> orders = new ArrayList<>();
	
	public Warehouseman() {};
	
	public Warehouseman(Person person, LocalDate employmentDate, double ratePerHour) {
		super(person, employmentDate, ratePerHour);
	}
	
	public Warehouseman(Person person, LocalDate employmentDate) {
		super(person, employmentDate);
	}
	
	//functional methods
	
	//connections
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		if(!orders.contains(order)) {
			orders.add(order);
			order.setWarehouseman(this);
		}
	}

	public void removeOrder(Order order) {
		if(orders.contains(order)) {
			orders.remove(order);
			order.removeWarehouseman(this);
		}
	}
	
	//getters and setters
}
