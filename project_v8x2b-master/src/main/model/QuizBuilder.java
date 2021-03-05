package model;

import exceptions.QuestionInListException;

import java.util.ArrayList;
import java.util.List;

// represents a personality test
public class QuizBuilder {
    List<Question> questionsDatabase;

    public static Question a1 = new Question(1, 0, "A", "I sympathize with others' feelings.");
    public static Question a2 = new Question(2, 0, "A", "I know how to comfort others.");
    public static Question a3 = new Question(3, 0, "A", "I am on good terms with nearly everyone.");
    public static Question a4 = new Question(4, 0, "A", "I have a good word for everyone.");
    public static Question a5 = new Question(5, 0, "A", "I love to help others.");

    public static Question c1 = new Question(6, 0, "C", "I am always prepared.");
    public static Question c2 = new Question(7, 0, "C", "I am exacting in my work.");
    public static Question c3 = new Question(8, 0, "C", "I do things according to a plan.");
    public static Question c4 = new Question(9, 0, "C", "I am a perfectionist.");
    public static Question c5 = new Question(10, 0, "C", "I love order and regularity.");

    public static Question s1 = new Question(11, 0, "S", "I am relaxed most of the time.");
    public static Question s2 = new Question(12, 0, "S", "I am not easily bothered by things.");
    public static Question s3 = new Question(13, 0, "S", "I seldom get mad.");
    public static Question s4 = new Question(14, 0, "S", "I don't get stressed out easily.");
    public static Question s5 = new Question(15, 0, "S", "My mood is pretty stable.");

    public static Question e1 = new Question(16, 0, "E", "I feel comfortable around people.");
    public static Question e2 = new Question(17, 0, "E", "I start conversations.");
    public static Question e3 = new Question(18, 0, "E", "I don't mind being the center of attention.");
    public static Question e4 = new Question(19, 0, "E", "I make friends easily.");
    public static Question e5 = new Question(20, 0, "E", "I know how to handle social situations.");

    public static Question i1 = new Question(21, 0, "I", "I have excellent ideas.");
    public static Question i2 = new Question(22, 0, "I", "I am quick to understand things.");
    public static Question i3 = new Question(23, 0, "I", "I carry the conversation to a higher level.");
    public static Question i4 = new Question(24, 0, "I", "I can handle a lot of information.");
    public static Question i5 = new Question(25, 0, "I", "I love to think up new ways of doing things.");

    // construct
    // EFFECTS: builds a quiz containing a set of questions
    public QuizBuilder() {
        questionsDatabase = new ArrayList<>();
    }

    // add a question
    // MODIFIES: this
    // EFFECTS: adds the given question to the database of questions
    public void addQuestion(Question q) throws QuestionInListException {
        if (questionsDatabase.contains(q)) {
            throw new QuestionInListException("Question already in the database");
        } else {
            questionsDatabase.add(q);
        }
    }

    // get list size
    // EFFECTS: returns the size of the list of questions
    public int getSize() {
        return questionsDatabase.size();
    }

    // get question
    // EFFECTS: returns the question stored at the given index
    public String getQuestion(int i) {
        return questionsDatabase.get(i).getLabel();
    }

    // get value
    // EFFECTS: returns the question stored at the given index
    public int getValue(int i) {
        return questionsDatabase.get(i).getValue();
    }

    // get ID
    // EFFECTS: returns the id of the question stored at the given index
    public int getId(int i) {
        return questionsDatabase.get(i).getId();
    }

    // set value
    // MODIFIES: this, value
    // EFFECTS: changes the value of the question at the given index
    public void setValue(int index, int value) {
        questionsDatabase.get(index).setValue(value);
    }

    // calculate results
    // EFFECTS: given a trait, calculates the total result for it by summing the values assigned to the questions
    //          that correspond to that trait
    public int results(String trait) {
        int result = 0;

        for (int i = 0; i <= questionsDatabase.size() - 1; i++) {
            if (questionsDatabase.get(i).getTrait().equals(trait)) {
                result += questionsDatabase.get(i).getValue();
            }
        }
        return result;
    }
}
