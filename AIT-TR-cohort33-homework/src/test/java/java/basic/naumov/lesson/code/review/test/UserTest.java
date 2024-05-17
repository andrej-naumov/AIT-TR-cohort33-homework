package java.basic.naumov.lesson.code.review.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import basic.naumov.lesson.code.review.User;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Иван", 30);
    }

    @Test
    void testGetUserName() {
        assertEquals("Иван", user.getUserName());
    }

    @Test
    void testGetAge() {
        assertEquals(30, user.getAge());
    }

    @Test
    void testAddFriend() {
        user.addFriend("Маша");
        user.addFriend("Оля");

        ArrayList<String> expectedFriends = new ArrayList<>();
        expectedFriends.add("Маша");
        expectedFriends.add("Оля");

        assertEquals(expectedFriends, user.getFriends());
    }

    @Test
    void testRemoveFriend() {
        user.addFriend("Саша");
        user.addFriend("Маша");

        user.removeFriend("Саша");

        ArrayList<String> expectedFriends = new ArrayList<>();
        expectedFriends.add("Маша");

        assertEquals(expectedFriends, user.getFriends());
    }
}
