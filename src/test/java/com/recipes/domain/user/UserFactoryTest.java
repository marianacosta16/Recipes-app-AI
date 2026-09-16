package com.recipes.domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockConstruction;

@ExtendWith(MockitoExtension.class)
class UserFactoryTest {

    @Mock
    private Email emailDouble;

    @Mock
    private UserId userIdDouble;

    @Mock
    private UserName userNameDouble;

    @Test
    void constructorShouldCreateUser() {
        //SUT
        UserFactory factory = new UserFactory();

        //Act
        try (MockedConstruction<User> mockedConstruction = mockConstruction(User.class)) {
            User result = factory.createUser(emailDouble, userNameDouble);

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
            User result = factory.createUser(userIdDouble, userNameDouble);

            //Assert
            assertNotNull(result);
            assertEquals(1, mockedConstruction.constructed().size());
        }
    }
}