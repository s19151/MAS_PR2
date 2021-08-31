package io.github.s19151.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository <T, K>{
	List<T> findAll();

    Optional<T> findById(K k);

    T save(T entity);
}
