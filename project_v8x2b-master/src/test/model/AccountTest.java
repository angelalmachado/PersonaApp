package model;

import model.Account;
import model.Personality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    private Account testAccount;
    private Personality personality;
    private Personality secondPersonality;

    @BeforeEach
    public void setUp() {
        testAccount = new Account("Mac Miller", "macadelic");
        personality = new Personality("Frank Ocean", "Music taste");
        secondPersonality = new Personality("Tom Misch", "Charisma");
    }

    @Test
    public void testConstructor() {
        assertEquals(testAccount.getName(), "Mac Miller");
        assertEquals(testAccount.getUsername(), "macadelic");
        assertEquals(testAccount.getPersonalityScore().size(), 0);
        assertEquals(testAccount.getSimilarPersonalities().size(), 0);
    }

    // list empty, personality not there
    @Test
    public void testAddPersonalityEmptyList() {
        testAccount.addPersonality(personality);

        assertEquals(1, testAccount.getSimilarPersonalities().size());
        assertTrue(testAccount.getSimilarPersonalities().contains(personality));
        assertEquals("Frank Ocean", testAccount.getSimilarPersonalities().get(0).getName());
        assertEquals("Music taste", testAccount.getSimilarPersonalities().get(0).getTrait());
    }


    // list with one person, personality not there
    @Test
    public void testAddPersonalityNonemptyList() {
        testAccount.addPersonality(personality);
        testAccount.addPersonality(secondPersonality);

        assertEquals(2, testAccount.getSimilarPersonalities().size());
        assertTrue(testAccount.getSimilarPersonalities().contains(personality));
        assertEquals("Frank Ocean", testAccount.getSimilarPersonalities().get(0).getName());
        assertEquals("Music taste", testAccount.getSimilarPersonalities().get(0).getTrait());
        assertTrue(testAccount.getSimilarPersonalities().contains(secondPersonality));
        assertEquals("Tom Misch", testAccount.getSimilarPersonalities().get(1).getName());
        assertEquals("Charisma", testAccount.getSimilarPersonalities().get(1).getTrait());
    }

    // list with one person, personality there
    @Test
    public void testAddPersonalityPersonAlreadyThere() {
        testAccount.addPersonality(personality);
        testAccount.addPersonality(personality);

        assertEquals(1, testAccount.getSimilarPersonalities().size());
        assertTrue(testAccount.getSimilarPersonalities().contains(personality));
        assertEquals("Frank Ocean", testAccount.getSimilarPersonalities().get(0).getName());
        assertEquals("Music taste", testAccount.getSimilarPersonalities().get(0).getTrait());
    }

    // list with one person, personality there with a different trait
    @Test
    public void testAddPersonalityPersonAlreadyThereDifTrait() {
        testAccount.addPersonality(personality);

        Personality personality2 = new Personality("Frank Ocean", "Beauty");
        testAccount.addPersonality(personality2);

        assertEquals(1, testAccount.getSimilarPersonalities().size());
        assertTrue(testAccount.getSimilarPersonalities().contains(personality));
        assertEquals("Frank Ocean", testAccount.getSimilarPersonalities().get(0).getName());
        assertEquals("Music taste", testAccount.getSimilarPersonalities().get(0).getTrait());
    }

    @Test
    public void testGetters() {
        assertEquals("Mac Miller", testAccount.getName());
        assertEquals("macadelic", testAccount.getUsername());

        testAccount.addPersonality(personality);
        assertEquals(1, testAccount.getSimilarPersonalities().size());
        assertTrue(testAccount.getSimilarPersonalities().contains(personality));

        //test personality score
    }

    @Test
    public void testSetters() {
        testAccount.setName("Malcolm");
        assertEquals("Malcolm", testAccount.getName());

        testAccount.setUsername("swimming");
        assertEquals("swimming", testAccount.getUsername());
    }
}
