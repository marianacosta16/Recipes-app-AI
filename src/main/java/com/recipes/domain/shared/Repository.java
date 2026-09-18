package com.recipes.domain.shared;

import java.util.Optional;

public interface Repository <ID extends DomainId, T extends AggregateRoot<ID>> {

    T save(T entity);

    Optional<T> findById(ID id);

}
