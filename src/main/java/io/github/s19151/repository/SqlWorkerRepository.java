package io.github.s19151.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.s19151.model.Worker;

@Repository
public interface SqlWorkerRepository extends WorkerRepository, JpaRepository<Worker, Integer>{

}
