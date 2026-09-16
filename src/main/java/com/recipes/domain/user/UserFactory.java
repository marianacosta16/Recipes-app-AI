package com.recipes.domain.user;

/**
 * Sole public entry point for creating and rehydrating a {@link User} — its constructors are
 * package-private by design.
 */
public class UserFactory {

    public User createUser(Email email, UserName userName) {
        return new User(email, userName);
    }

    public User rehydrateUser(UserId userId, UserName userName) {
        return new User(userId, userName);
    }
}
