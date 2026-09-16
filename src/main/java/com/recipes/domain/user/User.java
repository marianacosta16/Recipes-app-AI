package com.recipes.domain.user;

import com.recipes.domain.shared.AggregateRoot;

import java.util.Objects;

public class User implements AggregateRoot<UserId> {

    private final UserId userId;
    private UserName userName;

    User(UserId userId, UserName userName) {
        if (userId == null)
            throw new UserException("UserId is required");

        if (userName == null)
            throw new UserException("UserName is required");

        this.userId = userId;
        this.userName = userName;
    }

    User(Email email, UserName userName) {
        this(new UserId(email), userName);
    }

    public UserId getUserId() {
        return userId;
    }

    public Email getEmail() {
        return userId.email();
    }

    public UserName getUserName() {
        return userName;
    }

    @Override
    public UserId identity() {return this.userId;}

    @Override
    public boolean sameAs(Object object) {
        if (object instanceof User) {
            User other = (User) object;

            if (Objects.equals(this.userId, other.userId) &&
                    Objects.equals(this.userName, other.userName))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.userId.equals(user.userId);
    }

    @Override
    public int hashCode() {return this.userId.hashCode();}
}
