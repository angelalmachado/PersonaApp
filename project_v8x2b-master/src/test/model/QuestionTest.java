package model;

import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {
    private Question question;

    @BeforeEach
    public void setUp() {
        question = new Question(10, 0, "Dog lover", "I really like dogs");
    }

    @Test
    public void testConstructor() {
        assertEquals(10, question.getId());
        assertEquals(0, question.getValue());
        assertEquals("Dog lover", question.getTrait());
        assertEquals("I really like dogs", question.getLabel());
    }

    @Test
    public void testSetters() {
        question.setValue(-1);
        assertEquals(-1, question.getValue());
    }
}
