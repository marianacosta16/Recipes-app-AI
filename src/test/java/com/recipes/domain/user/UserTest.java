package com.recipes.domain.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final Email email = new Email("alice@example.com");
    private final UserName userName = new UserName("alice");

    @Test
    void constructorShouldSucceedForValidUser() {
        //Act + SUT
        User user = new User(email, userName);

        //Assert
        assertEquals(userName, user.getUserName());
        assertEquals(email, user.getEmail());
    }

    @Test
    void constructorShouldThrowExceptionWhenEmailIsNull() {
        //Arrange + Act + Assert + SUT
        assertThrows(UserException.class, () -> new User((Email) null, userName));
    }

    @Test
    void constructorShouldThrowExceptionWhenUserNameIsNull() {
        //Arrange + Act + Assert + SUT
        assertThrows(UserException.class, () -> new User(email, null));
    }

    @Test
    void constructorShouldSucceedWithProvidedUserId() {
        //Arrange
        UserId userId = new UserId(email);

        //Act + SUT
        User user = new User(userId, userName);

        //Assert
        assertEquals(userId, user.getUserId());
        assertEquals(email, user.getEmail());
        assertEquals(userName, user.getUserName());
    }

    @Test
    void constructorShouldThrowExceptionWhenUserIdIsNull() {
        //Arrange + Act + Assert + SUT
        assertThrows(UserException.class, () -> new User((UserId) null, userName));
    }

    @Test
    void equalsAnsHashCode() {
        //Arrange
        Email email1 = new Email("bob@example.com");
        UserName userName1 = new UserName("bob");
        String u3 = "user123";

        //Act + SUT
        User user = new User(email, userName);
        User user1 = new User(email, userName1);
        User user2 = new User(email1, userName1);

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
        User user = new User(email, userName);

        //Act + SUT
        UserId identity = user.identity();

        //Assert
        assertEquals(email, identity.email());
    }

    @Test
    void sameAsShouldReturnTrueWhenSameState() {
        //Arrange
        User user = new User(email, userName);
        User user1 = new User(email, userName);

        //Act + SUT
        boolean result = user.sameAs(user1);

        //Assert
        assertTrue(result);
    }

    @Test
    void sameAsShouldReturnFalseWhenUserNameDiffers() {
        //Arrange
        UserName userName1 = new UserName("bob");
        User user = new User(email, userName);
        User user1 = new User(email, userName1);

        //Act + SUT
        boolean result = user.sameAs(user1);

        //Assert
        assertFalse(result);
    }

    @Test
    void sameAsShouldReturnFalseWhenEmailDiffers() {
        //Arrange
        Email email1 = new Email("bob@example.com");
        User user = new User(email, userName);
        User user1 = new User(email1, userName);

        //Act + SUT
        boolean result = user.sameAs(user1);

        //Assert
        assertFalse(result);
    }

    @Test
    void sameAsShouldReturnFalseWhenComparedToNonUser() {
        //Arrange
        User user = new User(email, userName);

        //Act + SUT
        boolean result = user.sameAs("not a user");

        //Assert
        assertFalse(result);
    }

}
