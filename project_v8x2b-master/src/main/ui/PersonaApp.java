// Code partially modeled after the JsonSerializationDemo uploaded by Paul Carter on the CPSC 210 repository

package ui;

import exceptions.QuestionInListException;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Represents the Persona Application
public class PersonaApp {
    private Account myAccount;
    Scanner object = new Scanner(System.in);
    QuizBuilder questions = new QuizBuilder();
    boolean keepGoing = true;
    String name;

    private static final String JSON_STORE = "./data/persona.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the personality test app
    public PersonaApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runPersona();
    }

    // MODIFIES: this
    // EFFECTS: sets up the personality test app
    public void runPersona() {
        String input = null;
        showMenu();

        while (keepGoing) {
            input = object.next();

            if (input.equals("q")) {
                keepGoing = false;
                System.out.println("Sad to see you go!");
            } else {
                checkInput(input);
            }
        }
    }

    // EFFECTS: displays initial menu
    private void showMenu() {
        System.out.println("\nWelcome to the Persona App! Select one of the options below:");
        System.out.println("\t'l' to log into existing account");
        System.out.println("\t'c' to create account");
        System.out.println("\t'q' to quit");
    }

    // EFFECTS: checks the input given to the initial menu
    private void checkInput(String command) {
        if (command.equals("c")) {
            createAccount();
        } else if (command.equals("l")) {
            logIn();
        } else {
            System.out.println("Oops! Invalid input, please try again.");
        }
    }

    // EFFECTS: displays login menu
    private void logIn() {
        System.out.println("Cool! Please enter your name below:");
        object.nextLine();
        name = object.nextLine();

        System.out.println("And your username:");
        String user = object.next();

        myAccount = new Account(name, user);
        loadAccount();
        accountMenu();
    }

    // MODIFIES: myAccount, name
    // EFFECTS: creates an account with given input
    private void createAccount() {
        System.out.println("Alright, let's create your account.");
        System.out.println("What is your name?");
        object.nextLine();
        name = object.nextLine();

        System.out.println("What would you like your username to be?");
        String user = object.next();

        myAccount = new Account(name, user);

        System.out.println("Here is your account information!");
        System.out.println("\tName: " + myAccount.getName());
        System.out.println("\tChosen username: @" + myAccount.getUsername());

        System.out.println("\nGood news, " + name + "! Account created.");
        accountMenu();
    }

    // MODIFIES: this
    // EFFECTS: displays the menu after creating the account
    private void accountMenu() {
        System.out.println("\nNow please select one of the options below:");
        System.out.println("\t's' to start new quiz");
        System.out.println("\t'p' to see past scores");
        System.out.println("\t'a' to add similar personalities");
        System.out.println("\t'l' to load information from file");
        System.out.println("\t'f' to save information to file");


        String command = object.next();
        evaluateInput(command);
    }

    // EFFECTS: evaluates input from account menu
    public void evaluateInput(String command) {
        switch (command) {
            case "s":
                startQuiz();
                break;
            case "p":
                pastScores();
                break;
            case "a":
                similarPersonalities();
                break;
            case "l":
                loadAccount();
                break;
            case "f":
                saveAccount();
                break;
            default:
                System.out.println("Oops! Invalid input, please try again.");
                accountMenu();
                break;
        }
    }

    // EFFECTS: initiates the personality test and displays results
    public void startQuiz() {
        System.out.println("Okay, let's do this!");
        System.out.println("\nHere are the instructions for the quiz:");
        System.out.println("For each statement, please type in either"
                + " 't' (true) if you agree with it, or 'f' (false) if you don't.\n");

        buildQuiz();

        for (int i = 0; i <= questions.getSize() - 1; i++) {
            individualQuestion(i);
        }

        showResults();
    }

    // MODIFIES: this
    // EFFECTS: evaluates input for each individual question
    private void individualQuestion(int i) {
        System.out.println(questions.getQuestion(i));

        String input = object.next();
        if (input.equals("t")) {
            questions.setValue(i, 1);
        } else if (input.equals("f")) {
            questions.setValue(i, 0);
        } else {
            System.out.println("Wrong input! Please try again.");
            individualQuestion(i);
        }
    }

    // EFFECTS: builds the personality test
    public void buildQuiz() {
        sectionOne();
        sectionTwo();
        sectionThree();
        sectionFour();
        sectionFive();
    }

    // EFFECTS: builds section 1 of the test
    private void sectionOne() {
        try {
            questions.addQuestion(QuizBuilder.a1);
            questions.addQuestion(QuizBuilder.c1);
            questions.addQuestion(QuizBuilder.s1);
            questions.addQuestion(QuizBuilder.e1);
            questions.addQuestion(QuizBuilder.i1);
        } catch (QuestionInListException e) {
            System.out.println(e.getMessage());
        }
    }

    // EFFECTS: builds section 2 of the test
    private void sectionTwo() {
        try {
            questions.addQuestion(QuizBuilder.a2);
            questions.addQuestion(QuizBuilder.c2);
            questions.addQuestion(QuizBuilder.s2);
            questions.addQuestion(QuizBuilder.e2);
            questions.addQuestion(QuizBuilder.i2);
        } catch (QuestionInListException e) {
            System.out.println(e.getMessage());
        }
    }

    // EFFECTS: builds section 3 of the test
    private void sectionThree() {
        try {
            questions.addQuestion(QuizBuilder.a3);
            questions.addQuestion(QuizBuilder.c3);
            questions.addQuestion(QuizBuilder.s3);
            questions.addQuestion(QuizBuilder.e3);
            questions.addQuestion(QuizBuilder.i3);
        } catch (QuestionInListException e) {
            System.out.println(e.getMessage());
        }
    }

    // EFFECTS: builds section 4 of the test
    private void sectionFour() {
        try {
            questions.addQuestion(QuizBuilder.a4);
            questions.addQuestion(QuizBuilder.c4);
            questions.addQuestion(QuizBuilder.s4);
            questions.addQuestion(QuizBuilder.e4);
            questions.addQuestion(QuizBuilder.i4);
        } catch (QuestionInListException e) {
            System.out.println(e.getMessage());
        }
    }

    // EFFECTS: builds section 5 of the test
    private void sectionFive() {
        try {
            questions.addQuestion(QuizBuilder.a5);
            questions.addQuestion(QuizBuilder.c5);
            questions.addQuestion(QuizBuilder.s5);
            questions.addQuestion(QuizBuilder.e5);
            questions.addQuestion(QuizBuilder.i5);
        } catch (QuestionInListException e) {
            System.out.println(e.getMessage());
        }
    }

    // EFFECTS: displays results for personality test
    private void showResults() {
        System.out.println("\nHere are your results! Each score is on a scale from 0 to 5:");
        System.out.println("\tYour result for 'agreeableness' is: " + questions.results("A"));
        System.out.println("\tYour result for 'conscientiousness' is: " + questions.results("C"));
        System.out.println("\tYour result for 'emotional stability' is: " + questions.results("S"));
        System.out.println("\tYour result for 'extraversion' is: " + questions.results("E"));
        System.out.println("\tYour result for 'intellect' is: " + questions.results("I"));

        myAccount.getPersonalityScore().add(0, questions.results("A"));
        myAccount.getPersonalityScore().add(1, questions.results("C"));
        myAccount.getPersonalityScore().add(2, questions.results("S"));
        myAccount.getPersonalityScore().add(3, questions.results("E"));
        myAccount.getPersonalityScore().add(4, questions.results("I"));

        endOfFunctionality();
    }

    // MODIFIES: this
    // EFFECTS: displays a menu for when the functionality is over
    //          used for multiple functionalities of the app
    private void endOfFunctionality() {
        System.out.println("\nWhat would you like to do now?");
        System.out.println("\t's' to save information to file");
        System.out.println("\t'b' to go back to main menu");
        System.out.println("\t'q' to quit");
        String input = object.next();

        switch (input) {
            case "b":
                accountMenu();
                break;
            case "q":
                keepGoing = false;
                System.out.println("Bye for now!");
                break;
            case "s":
                saveAccount();
                break;
            default:
                System.out.println("Oops! Invalid input, please try again.");
                endOfFunctionality();
                break;
        }

    }

    // EFFECTS: displays past personality scores
    private void pastScores() {
        if (myAccount.getPersonalityScore().isEmpty()) {
            noTestDoneYet();
        } else {
            for (int a = 0; a < myAccount.getPersonalityScore().size(); a = a + 5) {
                System.out.println("\nHere are the results of you personality test:");
                System.out.println("\tYour result for 'agreeableness' is: " + myAccount.getPersonalityScore().get(a));
                System.out.println("\tYour result for 'conscientiousness' is: "
                        + myAccount.getPersonalityScore().get(a + 1));
                System.out.println("\tYour result for 'emotional stability' is: "
                        + myAccount.getPersonalityScore().get(a + 2));
                System.out.println("\tYour result for 'extraversion' is: "
                        + myAccount.getPersonalityScore().get(a + 3));
                System.out.println("\tYour result for 'intellect' is: " + myAccount.getPersonalityScore().get(a + 4));
            }

            endOfFunctionality();
        }
    }

    // MODIFIES: this
    // EFFECTS: displays a menu for when user tries to see past test scores without having done any
    private void noTestDoneYet() {
        System.out.println("\nLooks like you haven't done any tests yet!");
        System.out.println("\tselect 'b' to go back to main menu, or");
        System.out.println("\tselect 's' to start a new test");

        String input = object.next();

        if (input.equals("b")) {
            accountMenu();
        } else if (input.equals("s")) {
            startQuiz();
        } else {
            System.out.println("Oops! Invalid input, please try again.");
            noTestDoneYet();
        }
    }

    // MODIFIES: this
    // EFFECTS: displays menu for when user wishes to add a similar personality to list
    private void similarPersonalities() {
        System.out.println("\nHere, you will be able to add famous people who you believe have the same personality "
                + "as you.");

        System.out.println("Please select one of the options bellow:");
        System.out.println("\t'a' to add a new person");
        System.out.println("\t'l' to see list of similar personalities");

        String input = object.next();

        if (input.equals("a")) {
            addPersonality();
        } else if (input.equals("l")) {
            showPersonalities();
        } else {
            System.out.println("Oops! Invalid input, please try again.");
            similarPersonalities();
        }
    }

    // EFFECTS: displays previously saved personality list
    private void showPersonalities() {
        if (myAccount.getSimilarPersonalities().size() == 0) {
            noPersonInList();
        } else {
            System.out.println("Here are the famous people you have added to the list:");
            for (int i = 0; i < myAccount.getSimilarPersonalities().size(); i++) {
                System.out.println("\tName: " + myAccount.getSimilarPersonalities().get(i).getName() + " | Trait: "
                        + myAccount.getSimilarPersonalities().get(i).getTrait());
            }

            endOfFunctionality();
        }
    }

    // MODIFIES: this
    // EFFECTS: displays a menu for when user tries to see an empty personality list
    private void noPersonInList() {
        System.out.println("\nYou haven't added anyone to the list yet!");
        System.out.println("\tpress 'a' to add a person, or ");
        System.out.println("\tpress 'b' to go back to main menu");
        String input = object.next();

        switch (input) {
            case "b":
                accountMenu();
                break;
            case "a":
                addPersonality();
                break;
            default:
                System.out.println("Oops! Invalid input, please try again.");
                noPersonInList();
                break;
        }
    }

    // MODIFIES: myAccount
    // EFFECTS: adds a new personality to the list
    private void addPersonality() {
        System.out.println("\nWhat is the name of this famous person?");
        object.nextLine();
        String name = object.nextLine();

        System.out.println("In what trait is this person similar to you?");
        String trait = object.nextLine();

        Personality p = new Personality(name,trait);
        myAccount.addPersonality(p);

        System.out.println("\nFantastic! Here is the person you added:");
        System.out.println("\tName: " + name);
        System.out.println("\tSimilar trait: " + trait);

        personalityListMenu();
    }

    // EFFECTS: displays the menu after adding a person to personality list
    private void personalityListMenu() {
        System.out.println("\nWhat would you like to do now?");
        System.out.println("\t'a' to add another person");
        System.out.println("\t's' to see list of similar personalities");
        System.out.println("\t'b' to go back to main menu");
        System.out.println("\t'f' to save information to file");
        System.out.println("\t'q' to quit");

        String input = object.next();
        personalityListMenuInput(input);
    }

    // MODIFIES: this
    // EFFECTS: evaluates input from the personalityListMenu()
    public void personalityListMenuInput(String input) {
        switch (input) {
            case "b":
                accountMenu();
                break;
            case "a":
                addPersonality();
                break;
            case "s":
                showPersonalities();
                break;
            case "f":
                saveAccount();
                break;
            case "q":
                keepGoing = false;
                System.out.println("Bye for now!");
                break;
            default:
                System.out.println("Oops! Invalid input, please try again.");
                personalityListMenu();
                break;
        }
    }

    // EFFECTS: saves current account to file
    private void saveAccount() {
        try {
            jsonWriter.open();
            jsonWriter.write(myAccount);
            jsonWriter.close();
            System.out.println("Saved " + myAccount.getName() + "'s account to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads account from file
    private void loadAccount() {
        try {
            myAccount = jsonReader.read();
            System.out.println("Loaded " + myAccount.getName() + "'s account from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
