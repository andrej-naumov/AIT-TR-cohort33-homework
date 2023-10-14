package lv.naumov.lombook.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lv.naumov.lombook.User;

public class UserIntegrationTest {

    @Test
    public void givenAnnotatedUser_thenHasGettersAndSetters() {
        User user = new User();
        user.setFirstName("Test");
        assertEquals(user.getFirstName(), "Test");
    }

}