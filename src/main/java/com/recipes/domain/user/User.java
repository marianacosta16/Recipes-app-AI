package com.recipes.domain.user;

import com.recipes.domain.shared.AggregateRoot;

import java.util.Objects;

public class User implements AggregateRoot {

    private final UserId userId;
    private final Email email;
    private UserName userName;

    User(UserId userId, Email email, UserName userName) {
        if (userId == null)
            throw new UserException("UserIs is required");

        if (email == null)
            throw new UserException("E-mail is required");

        if (userName == null)
            throw new UserException("UserName is required");

        this.userId = userId;
        this.email = email;
        this.userName = userName;
    }

    User(Email email, UserName userName) {
        this(new UserId(email), email, userName);
    }

    public UserId getUserId() {
        return userId;
    }

    public Email getEmail() {
        return email;
    }

    public UserName getUserName() {
        return userName;
    }

    @Override
    public UserId identity() {return this.userId;}

    @Override
    public boolean sameAs(Object object) {
        if (!(object instanceof User user)) return false;
        return userId.equals(user.userId);
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
