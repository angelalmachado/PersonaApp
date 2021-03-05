package gui;

import model.Account;
import model.Personality;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class PersonaGUI implements ActionListener {
    private Account myAccount;
    private List<Integer> listOfResults;

    // JSON
    private static final String JSON_STORE = "./data/persona.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // initial page
    private JFrame frame;
    private JPanel panel;
    private JLabel welcomeLabel;
    private JButton logInButton;
    private JButton createAccountButton;
    BufferedImage logo = ImageIO.read(new URL(
            "https://i.ibb.co/zm0nXLS/Persona-Logo.png"));
    BufferedImage fireworks = ImageIO.read(new URL(
            "https://i.ibb.co/dp3WqnX/fireworks.png"));

    // log in page
    private JFrame loginFrame;
    private JPanel loginPanel;
    private JButton logButton;
    private JTextField nameTextFieldLogin;
    private JTextField userTextFieldLogin;
    private String nameInputLogin;
    private String userInputLogin;

    // create account page
    private JFrame createAccFrame;
    private JButton createAccButton;
    private JPanel accPanel;
    private JTextField nameTextFieldCreateAcc;
    private JTextField userTextFieldCreateAcc;
    private String nameInputCreateAcc;
    private String userInputCreateAcc;

    // main menu
    private JFrame mainFrame;
    private JPanel mainPanel = new JPanel();
    private JButton startQuizButton;
    private JButton seePastScoresButton;
    private JButton addNewPersonalityButton;
    private JButton seePastPersonalities;
    private JButton saveInfoButton;
    private JButton quitButton;

    // new quiz
    private JFrame quizFrame;
    private JPanel quizPanel;
    private QuizGUI quiz = new QuizGUI();
    private JButton finishQuizButton;

    // immediate results
    private JFrame immediateResultsFrame;
    private JPanel immediateResultsPanel;
    private JButton backToMenuButtonImmediateResults;
    private JButton saveInfoImmediateResults;

    // display past scores
    private JFrame pastScoresFrame;
    private JPanel pastScoresPanel;
    private JButton backToMenuButtonPastScores;

    // add new personality
    private JFrame newPersonalityFrame;
    private JPanel newPersonalityPanel;
    private JButton addPersonalityButton;
    private JTextField nameTextFieldPersonality;
    private JTextField traitTextFieldPersonality;
    private String personalityName;
    private String personalityTrait;

    // frame after adding personality
    private JFrame addedPFrame;
    private JPanel addedPPanel;
    private JButton addAnotherPersonalityButton;
    private JButton seeFullPersonalityList;
    private JButton saveInfoAddP;
    private JButton backToMenuButtonAddP;

    // display past personalities
    private JFrame pastPersonalitiesFrame;
    private JPanel pastPersonalitiesPanel;
    private JButton backToMenuButtonPastP;
    private JButton addPersonalityPastPButton;

    // EFFECTS: sets up initial frame
    public PersonaGUI() throws IOException {
        frame = new JFrame();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        logInButton = new JButton("Log in");
        logInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logInButton.addActionListener(this);

        createAccountButton = new JButton("Create account");
        createAccountButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createAccountButton.setSize(new Dimension(400, 40));
        createAccountButton.addActionListener(this);

        welcomeLabel = new JLabel("Welcome to the Persona App!");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel = new JPanel();
        initPanels(panel);

        JLabel lbl = new JLabel(new ImageIcon(logo));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lbl);

        panel.add(welcomeLabel);
        panel.add(logInButton);
        panel.add(createAccountButton);

        initFrames(frame, panel, "PersonApp");
    }

    // EFFECTS: sets up login frame
    private void loginFrame() {
        loginPanel = new JPanel();
        initPanels(loginPanel);

        JLabel login = new JLabel("Please add your login information below");
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginPanel.add(login);

        insertLoginButtons();

        logButton = new JButton("Log in");
        logButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        logButton.addActionListener(this);
        loginPanel.add(logButton);

        initFrames(loginFrame, loginPanel, "Log in");
    }

    // EFFECTS: inserts the necessary buttons in the login frame
    private void insertLoginButtons() {
        nameTextFieldLogin = new JTextField("Insert your name here...");
        loginPanel.add(nameTextFieldLogin);

        userTextFieldLogin = new JTextField("Insert your username here...");
        loginPanel.add(userTextFieldLogin);
    }

    // EFFECTS: sets up create account frame
    private void createAccFrame() {
        accPanel = new JPanel();
        initPanels(accPanel);

        JLabel createAcc = new JLabel("Great! Let's create your account.");
        createAcc.setAlignmentX(Component.CENTER_ALIGNMENT);
        accPanel.add(createAcc);

        insertCreateAccButtons();

        createAccButton = new JButton("Create account");
        createAccButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createAccButton.addActionListener(this);
        accPanel.add(createAccButton);

        initFrames(createAccFrame, accPanel, "Create your account");
    }

    // EFFECTS: inserts the necessary buttons in the create account frame
    private void insertCreateAccButtons() {
        nameTextFieldCreateAcc = new JTextField("Insert your name here...");
        accPanel.add(nameTextFieldCreateAcc);

        userTextFieldCreateAcc = new JTextField("Insert your username here...");
        accPanel.add(userTextFieldCreateAcc);
    }

    // EFFECTS: sets up main menu frame
    public void mainMenuFrame() {
        initPanels(mainPanel);

        JLabel menuText = new JLabel("What would you like to do now?");
        menuText.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(menuText);

        addButtonsMainFrame();

        mainFrame.add(mainPanel);
        initFrames(mainFrame, mainPanel, "Main menu");
    }

    // EFFECTS: inserts the necessary buttons in the main frame
    private void addButtonsMainFrame() {
        startQuizButton = new JButton("Start new personality quiz");
        startQuizButton.addActionListener(this);
        startQuizButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(startQuizButton);

        seePastScoresButton = new JButton("See past personality scores");
        seePastScoresButton.addActionListener(this);
        seePastScoresButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(seePastScoresButton);

        addNewPersonalityButton = new JButton("Add a new similar personality");
        addNewPersonalityButton.addActionListener(this);
        addNewPersonalityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(addNewPersonalityButton);

        saveInfoButton = new JButton("Save progress");
        saveInfoButton.addActionListener(this);
        saveInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(saveInfoButton);

        quitButton = new JButton("Quit app");
        quitButton.addActionListener(this);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(quitButton);
    }

    // EFFECTS: sets up personality quiz frame
    private void quizFrame() {
        initQuizPanel();

        JLabel firstQuizText = new JLabel("Check the statements you agree with.");
        firstQuizText.setAlignmentX(Component.CENTER_ALIGNMENT);
        firstQuizText.setForeground(Color.red);
        firstQuizText.setSize(300, 10);
        JLabel quizText = new JLabel(" ");
        quizPanel.add(firstQuizText);
        quizPanel.add(quizText);

        quiz.buildQuiz();
        quiz.displayQuiz();
        quiz.addToPanel(quizPanel);

        finishQuizButton = new JButton("Finish quiz");
        finishQuizButton.addActionListener(this);
        quizPanel.add(finishQuizButton);

        quizFrame.add(quizPanel);
        initFrames(quizFrame, quizPanel, "Personality test");
    }

    // EFFECTS: initializes quiz panel
    private void initQuizPanel() {
        quizPanel = new JPanel();
        quizPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        quizPanel.setLayout(new GridLayout(14, 2));
    }

    // EFFECTS: displays the immediate result's of the user's personality test
    private void immediateResultsFrame() {
        immediateResultsPanel = new JPanel();
        initPanels(immediateResultsPanel);

        addFireworks();

        JLabel resultsText = new JLabel("Yay! Here are your results:");
        resultsText.setAlignmentX(Component.CENTER_ALIGNMENT);
        immediateResultsPanel.add(resultsText);

        JLabel agreeablenessText = new JLabel("Your result for 'agreeableness' is: " + quiz.getScoreA());
        agreeablenessText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel conscientiousnessText = new JLabel("Your result for 'conscientiousness' is: " + quiz.getScoreC());
        conscientiousnessText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel emotionalStabilityText = new JLabel("Your result for 'emotional stability' is: " + quiz.getScoreS());
        emotionalStabilityText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel extraversionText = new JLabel("Your result for 'extraversion' is: " + quiz.getScoreE());
        extraversionText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel intellectText = new JLabel("Your result for 'intellect' is: " + quiz.getScoreI());
        intellectText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel f = new JLabel("     ");

        addResultsToAcc();

        reinitializeScores();

        addLabelsToPanel(agreeablenessText, conscientiousnessText, emotionalStabilityText, extraversionText,
                intellectText, f, immediateResultsPanel);

        addImmResultsButtons();

        initFrames(immediateResultsFrame, immediateResultsPanel, "Results");
    }

    // EFFECTS: inserts firework image to frame
    private void addFireworks() {
        JLabel lbl = new JLabel(new ImageIcon(fireworks));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        immediateResultsPanel.add(lbl);
    }

    // EFFECTS: restarts the user's scores
    private void reinitializeScores() {
        quiz.scoreA = 0;
        quiz.scoreC = 0;
        quiz.scoreS = 0;
        quiz.scoreE = 0;
        quiz.scoreI = 0;
    }

    // EFFECTS: inserts the necessary buttons in the immediate results frame
    private void addImmResultsButtons() {
        saveInfoImmediateResults = new JButton("Save scores");
        saveInfoImmediateResults.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveInfoImmediateResults.addActionListener(this);
        immediateResultsPanel.add(saveInfoImmediateResults);

        backToMenuButtonImmediateResults = new JButton("Back to main menu");
        backToMenuButtonImmediateResults.addActionListener(this);
        backToMenuButtonImmediateResults.setAlignmentX(Component.CENTER_ALIGNMENT);
        immediateResultsPanel.add(backToMenuButtonImmediateResults);
    }

    // EFFECTS: inserts the necessary labels in the immediate results frame
    private void addLabelsToPanel(JLabel a, JLabel c, JLabel s, JLabel e, JLabel i, JLabel f, JPanel panel) {
        panel.add(a);
        panel.add(c);
        panel.add(s);
        panel.add(e);
        panel.add(i);
        panel.add(f);
    }

    // EFFECTS: adds the results of the test to the user's account
    private void addResultsToAcc() {
        listOfResults = myAccount.getPersonalityScore();

        listOfResults.add(quiz.getScoreA());
        listOfResults.add(quiz.getScoreC());
        listOfResults.add(quiz.getScoreS());
        listOfResults.add(quiz.getScoreE());
        listOfResults.add(quiz.getScoreI());
    }


    // EFFECTS: initializes the past scores frame
    private void pastScoresFrame() {
        pastScoresPanel = new JPanel();
        initPanels(pastScoresPanel);

        listOfResults = myAccount.getPersonalityScore();

        if (listOfResults.isEmpty()) {
            JLabel noTestsDone = new JLabel("Looks like you haven't taken any tests yet!");
            pastScoresPanel.add(noTestsDone);

            JButton performTestButton = new JButton("Take personality test");
            performTestButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pastScoresFrame.dispose();
                    quizFrame = new JFrame();
                    quizFrame();
                }
            });

            pastScoresPanel.add(performTestButton);
        } else {
            addScoresToPanel();
        }

        backToMenuButtonPastScores = new JButton("Back to main menu");
        backToMenuButtonPastScores.addActionListener(this);
        pastScoresPanel.add(backToMenuButtonPastScores);

        initFrames(pastScoresFrame, pastScoresPanel, "Past personality scores");
    }

    // EFFECTS: displays the scores in the past scores panel
    private void addScoresToPanel() {
        int b = 1;

        for (int a = 0; a < listOfResults.size(); a = a + 5) {
            JLabel pastScoresIntro = new JLabel("Here are the results of your personality test " + b);
            pastScoresPanel.add(pastScoresIntro);

            JLabel textA = new JLabel("\nYour result for 'agreeableness' is: " + listOfResults.get(a) + "\n");
            JLabel textC = new JLabel("\nYour result for 'conscientiousness' is: " + listOfResults.get(a + 1) + "\n");
            JLabel textS = new JLabel("\nYour result for 'emotional stability' is: " + listOfResults.get(a + 2)
                    + "\n");
            JLabel textE = new JLabel("\nYour result for 'extraversion' is: " + listOfResults.get(a + 3) + "\n");
            JLabel textI = new JLabel("\nYour result for 'intellect' is: " + listOfResults.get(a + 4) + "\n");
            JLabel space = new JLabel("\n ");

            pastScoresPanel.add(textA);
            pastScoresPanel.add(textC);
            pastScoresPanel.add(textS);
            pastScoresPanel.add(textE);
            pastScoresPanel.add(textI);
            pastScoresPanel.add(space);

            b++;
        }
    }

    // EFFECTS: sets up the frame toa dd new similar personalities
    private void newPersonalityFrame() {
        newPersonalityPanel = new JPanel();
        initPanels(newPersonalityPanel);

        JLabel addPersonalityText = new JLabel("Here, you will be able to add famous people who you believe have "
                + "the same personality as you.");
        addPersonalityText.setAlignmentX(Component.CENTER_ALIGNMENT);
        newPersonalityPanel.add(addPersonalityText);

        addPersonalityTextFields();

        addPersonalityButton = new JButton("Add personality");
        addPersonalityButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addPersonalityButton.addActionListener(this);
        newPersonalityPanel.add(addPersonalityButton);

        initFrames(newPersonalityFrame, newPersonalityPanel, "Add similar personality");
    }

    // EFFECTS: inserts the text fields and labels into the add personality frame
    private void addPersonalityTextFields() {
        nameTextFieldPersonality = new JTextField("Insert the person's name here...");
        newPersonalityPanel.add(nameTextFieldPersonality);


        traitTextFieldPersonality = new JTextField("Insert the person's trait here...");
        newPersonalityPanel.add(traitTextFieldPersonality);
    }

    // EFFECTS: sets up the menu to be displayed after a personality has been added
    private void addedPFrame() {
        addedPPanel = new JPanel();
        initPanels(addedPPanel);

        JLabel lbl = new JLabel(new ImageIcon(fireworks));
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        addedPPanel.add(lbl);

        JLabel addedPLabel = new JLabel("Personality added! What would you like to do now?");
        addedPLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addedPPanel.add(addedPLabel);

        insertButtonsPAdded();

        initFrames(addedPFrame, addedPPanel, "Personality added!");
    }

    // EFFECTS: inserts buttons to the past personalities frame
    private void insertButtonsPAdded() {
        saveInfoAddP = new JButton("Save progress");
        saveInfoAddP.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveInfoAddP.addActionListener(this);
        addedPPanel.add(saveInfoAddP);

        addAnotherPersonalityButton = new JButton("Add another person");
        addAnotherPersonalityButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addAnotherPersonalityButton.addActionListener(this);
        addedPPanel.add(addAnotherPersonalityButton);

        seeFullPersonalityList = new JButton("See full list of personalities added");
        seeFullPersonalityList.setAlignmentX(Component.CENTER_ALIGNMENT);
        seeFullPersonalityList.addActionListener(this);
        addedPPanel.add(seeFullPersonalityList);

        backToMenuButtonAddP = new JButton("Back to main menu");
        backToMenuButtonAddP.setAlignmentX(Component.CENTER_ALIGNMENT);
        backToMenuButtonAddP.addActionListener(this);
        addedPPanel.add(backToMenuButtonAddP);
    }

    // EFFECTS: displays the list of all the personalities added
    private void pastPersonalitiesFrame() {
        pastPersonalitiesPanel = new JPanel();
        initPanels(pastPersonalitiesPanel);

        List<Personality> personalities = myAccount.getSimilarPersonalities();

        if (personalities.isEmpty()) {
            emptyPListDisplay();
        } else {
            JLabel pastPLabel = new JLabel("Here are the famous people you have added to the list:");
            pastPLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel emptySpace = new JLabel("\n   ");

            pastPersonalitiesPanel.add(pastPLabel);
            pastPersonalitiesPanel.add(emptySpace);

            for (Personality p : personalities) {
                JLabel showPersonalities = new JLabel(p.getName() + " | " + p.getTrait());
                showPersonalities.setAlignmentX(Component.CENTER_ALIGNMENT);

                pastPersonalitiesPanel.add(showPersonalities);
                pastPersonalitiesPanel.add(emptySpace);
            }
        }

        backToMenuButtonPastP = new JButton("Back to main menu");
        backToMenuButtonPastP.setAlignmentX(Component.CENTER_ALIGNMENT);
        backToMenuButtonPastP.addActionListener(this);
        pastPersonalitiesPanel.add(backToMenuButtonPastP);

        initFrames(pastPersonalitiesFrame, pastPersonalitiesPanel, "Past personalities added");
    }

    // EFFECTS: sets up the display when no personalities have been added to the list yet
    private void emptyPListDisplay() {
        JLabel noP = new JLabel("Looks like you haven't added anyone to the list yet.");
        noP.setAlignmentX(Component.CENTER_ALIGNMENT);
        pastPersonalitiesPanel.add(noP);

        addPersonalityPastPButton = new JButton("Add a personality");
        addPersonalityPastPButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addPersonalityPastPButton.addActionListener(this);
        pastPersonalitiesPanel.add(addPersonalityPastPButton);
    }

    // EFFECTS: initializes given panel
    private void initPanels(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    // EFFECTS: initializes given frame
    private void initFrames(JFrame frame, JPanel panel, String title) {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logInButton) {
            frame.dispose();
            loginFrame = new JFrame();
            loginFrame();
        } else if (e.getSource() == createAccButton) {
            nameInputCreateAcc = nameTextFieldCreateAcc.getText();
            userInputCreateAcc = userTextFieldCreateAcc.getText();

            myAccount = new Account(nameInputCreateAcc, userInputCreateAcc);
            saveAccount();
            createAccFrame.dispose();
            mainFrame = new JFrame();
            mainMenuFrame();
        } else if (e.getSource() == logButton) {
            nameInputLogin = nameTextFieldLogin.getText();
            userInputLogin = userTextFieldLogin.getText();

            myAccount = new Account(nameInputLogin, userInputLogin);
            loadAccount();
            loginFrame.dispose();
            mainFrame = new JFrame();
            mainMenuFrame();
        } else {
            checkMainMenu(e);
        }
    }


    // EFFECTS: checks action events from main menus
    private void checkMainMenu(ActionEvent e) {
        if (e.getSource() == startQuizButton) {
            mainFrame.dispose();
            quizFrame = new JFrame();
            quizFrame();
        } else if (e.getSource() == logButton) {
            nameInputLogin = nameTextFieldLogin.getText();
            userInputLogin = userTextFieldLogin.getText();

            myAccount = new Account(nameInputLogin, userInputLogin);
            loadAccount();
            loginFrame.dispose();
            mainFrame = new JFrame();
            mainMenuFrame();
        } else if (e.getSource() == seePastScoresButton) {
            mainFrame.dispose();
            pastScoresFrame = new JFrame();
            pastScoresFrame();
        } else {
            checkSecondaryActions(e);
        }
    }

    // EFFECTS: checks secondary action events
    private void checkSecondaryActions(ActionEvent e) {
        if (e.getSource() == finishQuizButton) {
            quizFrame.dispose();
            immediateResultsFrame = new JFrame();
            immediateResultsFrame();
        } else if (e.getSource() == backToMenuButtonImmediateResults) {
            immediateResultsFrame.dispose();
            mainFrame.setVisible(true);
        } else if (e.getSource() == saveInfoImmediateResults) {
            saveAccount();
        } else if (e.getSource() == addPersonalityButton) {
            personalityName = nameTextFieldPersonality.getText();
            personalityTrait = traitTextFieldPersonality.getText();

            Personality p = new Personality(personalityName, personalityTrait);
            myAccount.addPersonality(p);

            newPersonalityFrame.dispose();
            addedPFrame = new JFrame();
            addedPFrame();
        } else if (e.getSource() == saveInfoButton) {
            saveAccount();
        } else {
            checkMoreActions(e);
        }
    }

    // EFFECTS: checks secondary action events
    private void checkMoreActions(ActionEvent e) {
        if (e.getSource() == seeFullPersonalityList) {
            addedPFrame.dispose();
            pastPersonalitiesFrame = new JFrame();
            pastPersonalitiesFrame();
        } else if (e.getSource() == addAnotherPersonalityButton) {
            addedPFrame.dispose();
            newPersonalityFrame = new JFrame();
            newPersonalityFrame();
        } else if (e.getSource() == backToMenuButtonAddP) {
            addedPFrame.dispose();
            mainFrame.setVisible(true);
        } else if (e.getSource() == addPersonalityPastPButton) {
            pastPersonalitiesFrame.dispose();
            newPersonalityFrame = new JFrame();  //check
            newPersonalityFrame();
        } else if (e.getSource() == backToMenuButtonPastP) {
            pastPersonalitiesFrame.dispose();
            mainFrame.setVisible(true);
        } else {
            checkAdditionalActions(e);
        }
    }

    private void checkAdditionalActions(ActionEvent e) {
        if (e.getSource() == addNewPersonalityButton) {
            mainFrame.dispose();
            newPersonalityFrame = new JFrame();
            newPersonalityFrame();
        } else if (e.getSource() == seePastPersonalities) {
            mainFrame.dispose();
            pastPersonalitiesFrame = new JFrame();
            pastPersonalitiesFrame();
        } else if (e.getSource() == quitButton) {
            mainFrame.dispose();
        } else if (e.getSource() == backToMenuButtonPastScores) {
            pastScoresFrame.dispose();
            mainFrame.setVisible(true);
        } else if (e.getSource() == createAccountButton) {
            frame.dispose();
            createAccFrame = new JFrame();
            createAccFrame();
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

    public static void main(String[] args) throws IOException {
        new PersonaGUI();
    }

}

