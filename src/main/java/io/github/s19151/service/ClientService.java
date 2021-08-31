package io.github.s19151.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.s19151.model.Client;
import io.github.s19151.repository.ClientRepository;

@Service
@Transactional
public class ClientService {
	private ClientRepository repository;
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	
	public List<Client> listAll() {
		return (List<Client>) repository.findAll();
	}
	
	public Optional<Client> get(Integer id) {
		return repository.findById(id);
	}
	
	public void save(Client client) {
		repository.save(client);
	}
}
