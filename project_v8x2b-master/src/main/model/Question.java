package model;

// represents a question with an ID, a value, the trait it refers to and its label
public class Question {
    private int id;
    private int value;
    private String trait;
    private String label;

    // constructor
    // REQUIRES: value must be either 0 or 1
    //           trait must be one of A (agreeableness), C (conscientiousness),
    //           S (emotional stability), E (extraversion), or I (intellect)
    // EFFECTS: constructs a question that possesses the given value,
    //          a trait it corresponds to,
    //          and its label (which is the question itself)
    public Question(int id, int value, String trait, String label) {
        this.id = id;
        this.value = value;
        this.trait = trait;
        this.label = label;
    }

    // getters & setters

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getTrait() {
        return trait;
    }

    public String getLabel() {
        return label;
    }

    public void setValue(int newValue) {
        value = newValue;
    }
}
