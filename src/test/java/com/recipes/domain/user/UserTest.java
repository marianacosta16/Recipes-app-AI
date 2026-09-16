package com.recipes.domain.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTest {
    @Mock
    private Email emailDouble;

    @Mock
    private UserId userIdDouble;

    @Mock
    private UserName userNameDouble;

    @Test
    void constructorShouldSucceedForValidUser() {
        //Act + SUT
        User user = new User(emailDouble, userNameDouble);

        //Assert
        assertEquals(userNameDouble, user.getUserName());
        assertEquals(emailDouble, user.getEmail());
    }

    @Test
    void constructorShouldThrowExceptionWhenEmailIsNull() {
        //Arrange + Act + Assert + SUT
        assertThrows(UserException.class, () -> new User((Email) null, userNameDouble));
    }

    @Test
    void constructorShouldThrowExceptionWhenUserNameIsNull() {
        //Arrange + Act + Assert + SUT
        assertThrows(UserException.class, () -> new User(emailDouble, null));
    }

    @Test
    void constructorShouldSucceedWithProvidedUserId() {
        //Arrange
        when(userIdDouble.email()).thenReturn(emailDouble);

        //Act + SUT
        User user = new User (userIdDouble, userNameDouble);

        //Assert
        assertEquals(userIdDouble, user.getUserId());
        assertEquals(emailDouble, user.getEmail());
        assertEquals(userNameDouble, user.getUserName());
    }

    @Test
    void constructorShouldThrowExceptionWhenUserIdIsNull() {
        //Arrange + Act + Assert + SUT
        assertThrows(UserException.class, () -> new User((UserId) null, userNameDouble));
    }

    @Test
    void equalsAnsHashCode() {
        //Arrange
        Email emailDouble1 = mock(Email.class);
        UserName userNameDouble1 = mock(UserName.class);
        String u3 = "user123";

        //Act + SUT
        User user = new User(emailDouble, userNameDouble);
        User user1 = new User(emailDouble, userNameDouble1);
        User user2 = new User(emailDouble1, userNameDouble1);

        //Assert
        assertEquals(user, user);
        assertEquals(user.hashCode(), user.hashCode());
        assertEquals(user, user1);
        assertEquals(user.hashCode(), user1.hashCode());

        assertNotEquals(user, user2);
        assertNotEquals(user.hashCode(), user2.hashCode());
        assertNotEquals(user1, user2);
        assertNotEquals(user1.hashCode(), user2.hashCode());
        assertNotEquals(user, null);
        assertNotEquals(user, u3);
    }

    @Test
    void identityShouldReturnUserIdBasedOnEmail() {
        //Arrange
        User user = new User (emailDouble, userNameDouble);

        //Act + SUT
        UserId identity = user.identity();

        //Assert
        assertEquals(emailDouble, identity.email());
    }

    @Test
    void sameAsShouldReturnTrueWhenSameState() {
        //Arrange
        User user = new User (emailDouble, userNameDouble);
        User user1 = new User (emailDouble, userNameDouble);

        //Act + SUT
        boolean result = user.sameAs(user1);

        //Assert
        assertTrue(result);
    }

    @Test
    void sameAsShouldReturnFalseWhenUserNameDiffers() {
        //Arrange
        UserName userNameDouble1 = mock(UserName.class);
        User user = new User (emailDouble, userNameDouble);
        User user1 = new User (emailDouble, userNameDouble1);

        //Act + SUT
        boolean result = user.sameAs(user1);

        //Assert
        assertFalse(result);
    }

    @Test
    void sameAsShouldReturnFalseWhenEmailDiffers() {
        //Arrange
        Email emailDouble1 = mock(Email.class);
        User user = new User (emailDouble, userNameDouble);
        User user1 = new User (emailDouble1, userNameDouble);

        //Act + SUT
        boolean result = user.sameAs(user1);

        //Assert
        assertFalse(result);
    }

    @Test
    void sameAsShouldReturnFalseWhenComparedToNonUser() {
        //Arrange
        User user = new User (emailDouble, userNameDouble);

        //Act + SUT
        boolean result = user.sameAs("not a user");

        //Assert
        assertFalse(result);
    }

}