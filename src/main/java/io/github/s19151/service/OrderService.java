package io.github.s19151.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.s19151.model.Order;
import io.github.s19151.model.projection.ReadOrderModel;
import io.github.s19151.model.projection.ReadOrderProductModel;
import io.github.s19151.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	private OrderRepository repository;
	
	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}
	
	public List<ReadOrderModel> listAll() {
		return ((List<Order>) repository.findAll()).stream()
				.map(ReadOrderModel::new)
				.collect(Collectors.toList());
	}
	
	public Optional<ReadOrderProductModel> get(Long id) {
		return repository.findById(id).map(ReadOrderProductModel::new);
	}
	
	public void save(Order order) {
		repository.save(order);
	}
}
