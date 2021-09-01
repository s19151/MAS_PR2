package io.github.s19151.model.projection;

import java.util.Set;
import java.util.stream.Collectors;

import io.github.s19151.model.Order;

public class ReadOrderClientProductModel extends ReadOrderModel {

	private Set<ReadProductModel> products;
	private ReadClientModel client;

	public ReadOrderClientProductModel(Order source) {
		super(source);
		
		this.products = source.getOrderProducts().stream()
				.map(c -> {
					return new ReadProductModel(c.getProduct(), c.getAmount());
				})
				.collect(Collectors.toSet());
		
		this.client = new ReadClientModel(source.getClient());
	}
	
	public Set<ReadProductModel> getProducts() {
		return products;
	}
	
	public void setProducts(Set<ReadProductModel> newProducts) {
		products = newProducts;
	}
	
	public ReadClientModel getClient() {
		return client;
	}
	
	public void setClient(ReadClientModel newClient) {
		client = newClient;
	}

}
