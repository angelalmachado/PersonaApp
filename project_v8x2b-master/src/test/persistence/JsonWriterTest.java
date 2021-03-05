// Code modeled after the JsonSerializationDemo uploaded by Paul Carter on the CPSC 210 repository

package persistence;

import model.Account;
import model.Personality;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonTest;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    // non-existent account
    @Test
    void testWriterInvalidFile() {
        try {
            Account acc = new Account("My account", "myUser");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    // empty account
    @Test
    void testWriterEmptyAccount() {
        try {
            Account acc = new Account("My account", "myUser");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyAccount.json");
            writer.open();
            writer.write(acc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyAccount.json");
            acc = reader.read();
            assertEquals("My account", acc.getName());
            assertEquals("myUser", acc.getUsername());
            assertEquals(0, acc.getSimilarPersonalities().size());
            assertEquals(0, acc.getPersonalityScore().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    // non-empty account
    @Test
    void testWriterGeneralAccount() {
        try {
            Account acc = new Account("My account", "myUser");
            addScoresAndPersonalities(acc);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAccount.json");
            writer.open();
            writer.write(acc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAccount.json");
            acc = reader.read();
            assertEquals("My account", acc.getName());
            assertEquals("myUser", acc.getUsername());
            List<Personality> people = acc.getSimilarPersonalities();
            assertEquals(2, people.size());

            checkPersonality("Mac Miller", "extroversion", people.get(0));
            checkPersonality("Cazuza", "happiness", people.get(1));

            checking(acc);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    private void checking(Account acc) {
        assertEquals(5, acc.getPersonalityScore().size());
        assertTrue(acc.getPersonalityScore().contains(1));
        assertTrue(acc.getPersonalityScore().contains(2));
        assertTrue(acc.getPersonalityScore().contains(3));
        assertTrue(acc.getPersonalityScore().contains(4));
        assertTrue(acc.getPersonalityScore().contains(5));
    }

    private void addScoresAndPersonalities(Account acc) {
        acc.addPersonality(new Personality("Mac Miller", "extroversion"));
        acc.addPersonality(new Personality("Cazuza", "happiness"));

        acc.getPersonalityScore().add(1);
        acc.getPersonalityScore().add(2);
        acc.getPersonalityScore().add(3);
        acc.getPersonalityScore().add(4);
        acc.getPersonalityScore().add(5);
    }
}
