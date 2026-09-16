package com.recipes.domain.user;

public class UserFactory {

    public User createUser(Email email, UserName userName) {
        return new User(email, userName);
    }

    public User createUser (UserId userId, UserName userName) {
        return new User(userId, userName);
    }
}
