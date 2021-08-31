package io.github.s19151.model.projection;

import java.time.LocalDate;

import io.github.s19151.model.Order;
import io.github.s19151.model.OrderState;

public class ReadOrderModel {
	private long id;
	private LocalDate orderDate;
	private LocalDate orderCloseDate;
	private OrderState orderState;
	private long fulfillmentTime;
	
	public ReadOrderModel(Order source) {
		this.id = source.getId();
		this.orderDate = source.getOrderDate();
		this.orderCloseDate = source.getOrderCloseDate();
		this.orderState = source.getOrderState();
		this.fulfillmentTime = source.getFulfillmentTime();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long newId) {
		id = newId;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(LocalDate newOrderDate) {
		orderDate = newOrderDate;
	}
	
	public LocalDate getOrderCloseDate() {
		return orderCloseDate;
	}
	
	public void setOrderCloseDate(LocalDate newOrderCloseDate) {
		orderCloseDate = newOrderCloseDate;
	}
	
	public OrderState getOrderState() {
		return orderState;
	}
	
	public void setOrderState(OrderState newOrderState) {
		orderState = newOrderState;
	}
	
	public long getFulfillmentTime() {
		return fulfillmentTime;
	}
	
	public void setFulfillmentTime(long newFulfillmentTime) {
		fulfillmentTime = newFulfillmentTime;
	}
}
