// Code modeled after the JsonSerializationDemo uploaded by Paul Carter on the CPSC 210 repository

package persistence;

import model.Personality;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    // check personalities
    protected void checkPersonality(String name, String trait, Personality p) {
        assertEquals(name, p.getName());
        assertEquals(trait, p.getTrait());
    }
}
