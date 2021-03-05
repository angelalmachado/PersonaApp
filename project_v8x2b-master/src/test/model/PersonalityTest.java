package model;

import model.Personality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalityTest {
    private Personality person;

    @BeforeEach
    public void setUp() {
        person = new Personality("John Mayer", "Loyalty");
    }

    @Test
    public void testConstructor() {
        assertEquals("John Mayer", person.getName());
        assertEquals("Loyalty", person.getTrait());
    }

    @Test
    public void testGetters() {
        assertEquals("John Mayer", person.getName());
        assertEquals("Loyalty", person.getTrait());
    }
}
