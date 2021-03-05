// Code modeled after the JsonSerializationDemo uploaded by Paul Carter on the CPSC 210 repository

package persistence;

import model.Account;
import model.Personality;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    // nonexistent file
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noFileHere.json");
        try {
            Account acc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // expected
        }
    }

    // empty account
    @Test
    void testReaderEmptyAccount() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyAccount.json");
        try {
            Account acc = reader.read();
            assertEquals("My account", acc.getName());
            assertEquals("myUser", acc.getUsername());
            assertTrue(acc.getSimilarPersonalities().isEmpty());
            assertTrue(acc.getPersonalityScore().isEmpty());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // non-empty account
    @Test
    void testReaderGeneralAccount() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralAccount.json");
        try {
            Account acc = reader.read();
            assertEquals("My account", acc.getName());
            assertEquals("myUser", acc.getUsername());
            List<Personality> people = acc.getSimilarPersonalities();
            assertEquals(2, people.size());
            checkPersonality("Mac Miller", "extroversion", people.get(0));
            checkPersonality("Cazuza", "happiness", people.get(1));

            assertEquals(5, acc.getPersonalityScore().size());
            assertTrue(acc.getPersonalityScore().contains(1));
            assertTrue(acc.getPersonalityScore().contains(2));
            assertTrue(acc.getPersonalityScore().contains(3));
            assertTrue(acc.getPersonalityScore().contains(4));
            assertTrue(acc.getPersonalityScore().contains(5));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
