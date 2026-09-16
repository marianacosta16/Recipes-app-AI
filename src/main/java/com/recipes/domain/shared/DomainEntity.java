package com.recipes.domain.shared;

public interface DomainEntity <ID extends DomainId> {

    // Identity-only value; equals() must compare by this alone, never by other fields.
    ID identity();

    // Full-state comparison (every field), as opposed to equals()'s identity-only comparison.
    boolean sameAs(Object object);
}
