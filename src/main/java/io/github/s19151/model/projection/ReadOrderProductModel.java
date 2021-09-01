package io.github.s19151.model.projection;

import java.util.Set;
import java.util.stream.Collectors;

import io.github.s19151.model.Order;

public class ReadOrderProductModel extends ReadOrderModel {

	private Set<ReadProductModel> products;

	public ReadOrderProductModel(Order source) {
		super(source);
		
		this.products = source.getOrderProducts().stream()
				.map(c -> {
					return new ReadProductModel(c.getProduct());
				})
				.collect(Collectors.toSet());
	}
	
	public Set<ReadProductModel> getProducts() {
		return products;
	}
	
	public void setProducts(Set<ReadProductModel> newProducts) {
		products = newProducts;
	}

}
