package com.recipes.domain.shared;

public interface DomainEntity <ID extends DomainId> {

    ID identity();
    boolean sameAs(Object object);
}
