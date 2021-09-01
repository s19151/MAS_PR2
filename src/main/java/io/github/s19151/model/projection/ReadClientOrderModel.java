package io.github.s19151.model.projection;

import java.util.Set;
import java.util.stream.Collectors;

import io.github.s19151.model.Client;

public class ReadClientOrderModel extends ReadClientModel {
	
	private Set<ReadOrderModel> orders;

	public ReadClientOrderModel(Client source) {
		super(source);
		
		this.orders = source.getOrders().stream()
				.map(ReadOrderModel::new)
				.collect(Collectors.toSet());
	}
	
	public Set<ReadOrderModel> getOrders() {
		return orders;
	}
	
	public void setOrders(Set<ReadOrderModel> newOrders) {
		orders = newOrders;
	}

}
