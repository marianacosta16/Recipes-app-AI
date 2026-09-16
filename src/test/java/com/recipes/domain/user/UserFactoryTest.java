package com.recipes.domain.user;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockConstruction;

class UserFactoryTest {

    private final Email email = new Email("alice@example.com");
    private final UserId userId = new UserId(email);
    private final UserName userName = new UserName("alice");

    @Test
    void constructorShouldCreateUser() {
        //SUT
        UserFactory factory = new UserFactory();

        //Act
        try (MockedConstruction<User> mockedConstruction = mockConstruction(User.class)) {
            User result = factory.createUser(email, userName);

            //Assert
            assertNotNull(result);
            assertEquals(1, mockedConstruction.constructed().size());
        }
    }

    @Test
    void constructorShouldRebuildUser() {
        //SUT
        UserFactory factory = new UserFactory();

        //Act
        try (MockedConstruction<User> mockedConstruction = mockConstruction(User.class)) {
            User result = factory.createUser(userId, userName);

            //Assert
            assertNotNull(result);
            assertEquals(1, mockedConstruction.constructed().size());
        }
    }
}
