package io.github.s19151.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.s19151.model.Client;
import io.github.s19151.model.projection.ReadClientModel;
import io.github.s19151.model.projection.ReadClientOrderModel;
import io.github.s19151.repository.ClientRepository;

@Service
@Transactional
public class ClientService {
	private ClientRepository repository;
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	
	public List<ReadClientModel> listAll() {
		return ((List<Client>) repository.findAll()).stream()
				.map(ReadClientModel::new)
				.collect(Collectors.toList());
	}
	
	public Optional<ReadClientOrderModel> get(Long id) {
		return repository.findById(id).map(ReadClientOrderModel::new);
	}
	
	public void save(Client client) {
		repository.save(client);
	}
}
