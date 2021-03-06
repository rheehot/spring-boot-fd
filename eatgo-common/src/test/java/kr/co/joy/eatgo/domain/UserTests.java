package kr.co.joy.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {

    @Test
    public void creation() {
        User user = User.builder()
                .email("tester@example.com")
                .name("tester")
                .level(100L)
                .build();

        assertEquals(user.getEmail(), "tester@example.com");
        assertEquals(user.getName(), "tester");
        assertTrue(user.isAdmin());
        assertTrue(user.isActive());

        user.deactivate();

        assertFalse(user.isActive());
    }

    @Test
    public void restaurantOwner() {
        User user = User.builder().level(1L).build();

        assertFalse(user.isRestaurantOwner());

        user.setRestaurantId(1004L);

        assertTrue(user.isRestaurantOwner());
    }

}