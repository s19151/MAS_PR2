package io.github.s19151.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.s19151.model.Client;

@Repository
public interface SqlClientRepository extends ClientRepository, JpaRepository<Client, Integer>{
	@Override
	@Query("from Client c join fetch c.orders where c.id=:id")
	public Optional<Client> findById(@Param("id") Integer id);
}
