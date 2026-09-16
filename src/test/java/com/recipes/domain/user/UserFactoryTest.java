package com.recipes.domain.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    private final Email email = new Email("alice@example.com");
    private final UserId userId = new UserId(email);
    private final UserName userName = new UserName("alice");

    @Test
    void createUserShouldBuildUserFromEmailAndUserName() {
        //SUT
        UserFactory factory = new UserFactory();

        //Act
        User result = factory.createUser(email, userName);

        //Assert
        assertEquals(userId, result.getUserId());
        assertEquals(email, result.getEmail());
        assertEquals(userName, result.getUserName());
    }

    @Test
    void rehydrateUserShouldRebuildUserFromUserIdAndUserName() {
        //SUT
        UserFactory factory = new UserFactory();

        //Act
        User result = factory.rehydrateUser(userId, userName);

        //Assert
        assertEquals(userId, result.getUserId());
        assertEquals(email, result.getEmail());
        assertEquals(userName, result.getUserName());
    }
}
