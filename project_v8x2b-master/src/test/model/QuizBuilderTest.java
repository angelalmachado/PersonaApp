package model;

import exceptions.QuestionInListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class QuizBuilderTest {
    QuizBuilder test;
    Question q1;
    Question q2;

    @BeforeEach
    public void setUp() {
        test = new QuizBuilder();
        q1 = new Question(1, 0, "Happiness", "Are you happy?");
        q2 = new Question(2, 0, "Sadness", "Are you sad?");
    }

    @Test
    public void testAddQuestionEmptyList() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        assertEquals(1, test.getSize());
        assertEquals("Are you happy?", test.getQuestion(0));
    }

    @Test
    public void testAddQuestionNonEmptyList() {
        try {
            test.addQuestion(q1);
            test.addQuestion(q2);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        assertEquals(2, test.getSize());
        assertEquals("Are you happy?", test.getQuestion(0));
        assertEquals("Are you sad?", test.getQuestion(1));
    }

    @Test
    public void testAddRepeatedQuestion() {
        try {
            test.addQuestion(q1);
            test.addQuestion(q1);
            fail("Should have caught an exception!");
        } catch (QuestionInListException e) {
            // expected
        }

        assertEquals(1, test.getSize());
    }

    @Test
    public void testGetSizeEmpty() {
        assertEquals(0, test.getSize());
    }

    @Test
    public void testGetSizeOneItem() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals(1, test.getSize());
    }

    @Test
    public void testGetSizeTwoItemsEqual() {
        try {
            test.addQuestion(q1);
            test.addQuestion(q1);
            fail("Should have caught an exception!");
        } catch (QuestionInListException e) {
            // expected
        }

        assertEquals(1, test.getSize());
    }

    @Test
    public void testGetSizeTwoItemsDifferent() {
        try {
            test.addQuestion(q1);
            test.addQuestion(q2);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        assertEquals(2, test.getSize());
    }

    @Test
    public void testGetSizeThreeItems() {
        try {
            test.addQuestion(q1);
            test.addQuestion(q2);
            test.addQuestion(q1);
            fail("Should have caught an exception!");
        } catch (QuestionInListException e) {
            // expected
        }

        assertEquals(2, test.getSize());
    }

    @Test
    public void testGetQuestion() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals("Are you happy?", test.getQuestion(0));

        try {
            test.addQuestion(q2);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals("Are you sad?", test.getQuestion(1));
    }

    @Test
    public void testGetId() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals(1, test.getId(0));

        try {
            test.addQuestion(q2);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals(2, test.getId(1));
    }

    @Test
    public void testGetValue() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals(0, test.getValue(0));

        try {
            test.addQuestion(q2);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals(0, test.getValue(1));
    }

    @Test
    public void testSetValueSameValue() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        test.setValue(0, 0);

        assertEquals(0, test.getValue(0));
    }

    @Test
    public void testSetValueDifValue() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        test.setValue(0, 1);

        assertEquals(1, test.getValue(0));
    }

    @Test
    public void testSetValueDifValueTwoQuestions() {
        try {
            test.addQuestion(q1);
            test.addQuestion(q2);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        test.setValue(1, -1);

        assertEquals(0, test.getValue(0));
        assertEquals(-1, test.getValue(1));
    }

    @Test
    public void testResultsOneQuestion() {
        try {
            test.addQuestion(q1);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }
        assertEquals(0, test.results("Happiness"));
    }

    @Test
    public void testResultsMoreQuestions() {
        Question q3 = new Question(3, 1, "Happiness", "Are you really happy?");
        Question q4 = new Question(4, 1, "Happiness", "Are you sure you are happy?");

        try {
            test.addQuestion(q1);
            test.addQuestion(q3);
            test.addQuestion(q4);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        assertEquals(2, test.results("Happiness"));
    }

    @Test
    public void testResultsNegativeValues() {
        Question q3 = new Question(3, -1, "Happiness", "Are you really happy?");
        Question q4 = new Question(4, -1, "Happiness", "Are you sure you are happy?");

        try {
            test.addQuestion(q1);
            test.addQuestion(q3);
            test.addQuestion(q4);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        assertEquals(-2, test.results("Happiness"));
    }

    @Test
    public void testResultsMoreThanOneTraitInQuiz() {
        Question q3 = new Question(3, -1, "Happiness", "Are you really happy?");
        Question q4 = new Question(4, -1, "Happiness", "Are you sure you are happy?");
        Question q5 = new Question(5, 1, "Sadness", "Are you sure you are sad?");

        try {
            test.addQuestion(q1);
            test.addQuestion(q2);
            test.addQuestion(q3);
            test.addQuestion(q4);
            test.addQuestion(q5);
        } catch (QuestionInListException e) {
            fail("Caught an exception when it shouldn't!");
        }

        assertEquals(-2, test.results("Happiness"));
        assertEquals(1, test.results("Sadness"));
    }

}
