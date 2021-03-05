package gui;

import exceptions.QuestionInListException;
import model.QuizBuilder;
import ui.PersonaApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGUI implements ActionListener {
    QuizBuilder questions = new QuizBuilder();
    int scoreA = 0;
    int scoreC = 0;
    int scoreS = 0;
    int scoreE = 0;
    int scoreI = 0;

    // labels
    JLabel a1;
    JLabel c1;
    JLabel s1;
    JLabel e1;
    JLabel i1;

    JLabel a2;
    JLabel c2;
    JLabel s2;
    JLabel e2;
    JLabel i2;

    JLabel a3;
    JLabel c3;
    JLabel s3;
    JLabel e3;
    JLabel i3;

    JLabel a4;
    JLabel c4;
    JLabel s4;
    JLabel e4;
    JLabel i4;

    JLabel a5;
    JLabel c5;
    JLabel s5;
    JLabel e5;
    JLabel i5;

    // checkboxes
    JCheckBox a1checkbox;
    JCheckBox c1checkbox;
    JCheckBox s1checkbox;
    JCheckBox e1checkbox;
    JCheckBox i1checkbox;

    JCheckBox a2checkbox;
    JCheckBox c2checkbox;
    JCheckBox s2checkbox;
    JCheckBox e2checkbox;
    JCheckBox i2checkbox;

    JCheckBox a3checkbox;
    JCheckBox c3checkbox;
    JCheckBox s3checkbox;
    JCheckBox e3checkbox;
    JCheckBox i3checkbox;

    JCheckBox a4checkbox;
    JCheckBox c4checkbox;
    JCheckBox s4checkbox;
    JCheckBox e4checkbox;
    JCheckBox i4checkbox;

    JCheckBox a5checkbox;
    JCheckBox c5checkbox;
    JCheckBox s5checkbox;
    JCheckBox e5checkbox;
    JCheckBox i5checkbox;

    // EFFECTS: adds the checkboxes to the given panel
    public void addToPanel(JPanel panel) {
        addToPanelSection1(panel);
        addToPanelSection2(panel);
        addToPanelSection3(panel);
        addToPanelSection4(panel);
        addToPanelSection5(panel);
    }

    // EFFECTS: adds part of the checkboxes to the given panel
    private void addToPanelSection1(JPanel panel) {
        panel.add(a1);
        a1checkbox = new JCheckBox();
        a1checkbox.addActionListener(this);
        panel.add(a1checkbox);

        panel.add(c1);
        c1checkbox = new JCheckBox();
        c1checkbox.addActionListener(this);
        panel.add(c1checkbox);

        panel.add(s1);
        s1checkbox = new JCheckBox();
        s1checkbox.addActionListener(this);
        panel.add(s1checkbox);

        panel.add(e1);
        e1checkbox = new JCheckBox();
        e1checkbox.addActionListener(this);
        panel.add(e1checkbox);

        panel.add(i1);
        i1checkbox = new JCheckBox();
        i1checkbox.addActionListener(this);
        panel.add(i1checkbox);
    }

    // EFFECTS: adds part of the checkboxes to the given panel
    private void addToPanelSection2(JPanel panel) {
        panel.add(a2);
        a2checkbox = new JCheckBox();
        a2checkbox.addActionListener(this);
        panel.add(a2checkbox);

        panel.add(c2);
        c2checkbox = new JCheckBox();
        c2checkbox.addActionListener(this);
        panel.add(c2checkbox);

        panel.add(s2);
        s2checkbox = new JCheckBox();
        s2checkbox.addActionListener(this);
        panel.add(s2checkbox);

        panel.add(e2);
        e2checkbox = new JCheckBox();
        e2checkbox.addActionListener(this);
        panel.add(e2checkbox);

        panel.add(i2);
        i2checkbox = new JCheckBox();
        i2checkbox.addActionListener(this);
        panel.add(i2checkbox);
    }

    // EFFECTS: adds part of the checkboxes to the given panel
    private void addToPanelSection3(JPanel panel) {
        panel.add(a3);
        a3checkbox = new JCheckBox();
        a3checkbox.addActionListener(this);
        panel.add(a3checkbox);

        panel.add(c3);
        c3checkbox = new JCheckBox();
        c3checkbox.addActionListener(this);
        panel.add(c3checkbox);

        panel.add(s3);
        s3checkbox = new JCheckBox();
        s3checkbox.addActionListener(this);
        panel.add(s3checkbox);

        panel.add(e3);
        e3checkbox = new JCheckBox();
        e3checkbox.addActionListener(this);
        panel.add(e3checkbox);

        panel.add(i3);
        i3checkbox = new JCheckBox();
        i3checkbox.addActionListener(this);
        panel.add(i3checkbox);
    }

    // EFFECTS: adds part of the checkboxes to the given panel
    private void addToPanelSection4(JPanel panel) {
        panel.add(a4);
        a4checkbox = new JCheckBox();
        a4checkbox.addActionListener(this);
        panel.add(a4checkbox);

        panel.add(c4);
        c4checkbox = new JCheckBox();
        c4checkbox.addActionListener(this);
        panel.add(c4checkbox);

        panel.add(s4);
        s4checkbox = new JCheckBox();
        s4checkbox.addActionListener(this);
        panel.add(s4checkbox);

        panel.add(e4);
        e4checkbox = new JCheckBox();
        e4checkbox.addActionListener(this);
        panel.add(e4checkbox);

        panel.add(i4);
        i4checkbox = new JCheckBox();
        i4checkbox.addActionListener(this);
        panel.add(i4checkbox);
    }

    // EFFECTS: adds part of the checkboxes to the given panel
    private void addToPanelSection5(JPanel panel) {
        panel.add(a5);
        a5checkbox = new JCheckBox();
        a5checkbox.addActionListener(this);
        panel.add(a5checkbox);

        panel.add(c5);
        c5checkbox = new JCheckBox();
        c5checkbox.addActionListener(this);
        panel.add(c5checkbox);

        panel.add(s5);
        s5checkbox = new JCheckBox();
        s5checkbox.addActionListener(this);
        panel.add(s5checkbox);

        panel.add(e5);
        e5checkbox = new JCheckBox();
        e5checkbox.addActionListener(this);
        panel.add(e5checkbox);

        panel.add(i5);
        i5checkbox = new JCheckBox();
        i5checkbox.addActionListener(this);
        panel.add(i5checkbox);
    }

    // EFFECTS: displays the personality quiz
    public void displayQuiz() {
        a1 = new JLabel(questions.getQuestion(0));
        c1 = new JLabel(questions.getQuestion(1));
        s1 = new JLabel(questions.getQuestion(2));
        e1 = new JLabel(questions.getQuestion(3));
        i1 = new JLabel(questions.getQuestion(4));

        a2 = new JLabel(questions.getQuestion(5));
        c2 = new JLabel(questions.getQuestion(6));
        s2 = new JLabel(questions.getQuestion(7));
        e2 = new JLabel(questions.getQuestion(8));
        i2 = new JLabel(questions.getQuestion(9));

        a3 = new JLabel(questions.getQuestion(10));
        c3 = new JLabel(questions.getQuestion(11));
        s3 = new JLabel(questions.getQuestion(12));
        e3 = new JLabel(questions.getQuestion(13));
        i3 = new JLabel(questions.getQuestion(14));

        a4 = new JLabel(questions.getQuestion(15));
        c4 = new JLabel(questions.getQuestion(16));
        s4 = new JLabel(questions.getQuestion(17));
        e4 = new JLabel(questions.getQuestion(18));
        i4 = new JLabel(questions.getQuestion(19));

        displayLastSection();
    }

    // EFFECTS: displays the last section of the personality quiz
    private void displayLastSection() {
        a5 = new JLabel(questions.getQuestion(20));
        c5 = new JLabel(questions.getQuestion(21));
        s5 = new JLabel(questions.getQuestion(22));
        e5 = new JLabel(questions.getQuestion(23));
        i5 = new JLabel(questions.getQuestion(24));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == a1checkbox) {
            if (scoreA < 5) {
                scoreA++;
            }
        }
        if (e.getSource() == a2checkbox) {
            if (scoreA < 5) {
                scoreA++;
            }
        }
        if (e.getSource() == a3checkbox) {
            if (scoreA < 5) {
                scoreA++;
            }
        }
        if (e.getSource() == a4checkbox) {
            if (scoreA < 5) {
                scoreA++;
            }
        }
        checkFinal(e);
        checkScoreC(e);
    }

    // EFFECTS: checks additional action events
    private void checkScoreC(ActionEvent e) {
        if (e.getSource() == c1checkbox) {
            if (scoreC < 5) {
                scoreC++;
            }
        }
        if (e.getSource() == c2checkbox) {
            if (scoreC < 5) {
                scoreC++;
            }
        }
        if (e.getSource() == c3checkbox) {
            if (scoreC < 5) {
                scoreC++;
            }
        }
        if (e.getSource() == c4checkbox) {
            if (scoreC < 5) {
                scoreC++;
            }
        }
        checkFinal(e);
        checkScoreS(e);
    }

    // EFFECTS: checks additional action events
    private void checkScoreS(ActionEvent e) {
        if (e.getSource() == s1checkbox) {
            if (scoreS < 5) {
                scoreS++;
            }
        }
        if (e.getSource() == s2checkbox) {
            if (scoreS < 5) {
                scoreS++;
            }
        }
        if (e.getSource() == s3checkbox) {
            if (scoreS < 5) {
                scoreS++;
            }
        }
        if (e.getSource() == s4checkbox) {
            if (scoreS < 5) {
                scoreS++;
            }
        }
        checkFinal(e);
        checkScoreE(e);
    }

    // EFFECTS: checks additional action events
    private void checkScoreE(ActionEvent e) {
        if (e.getSource() == e1checkbox) {
            if (scoreE < 5) {
                scoreE++;
            }
        }
        if (e.getSource() == e2checkbox) {
            if (scoreE < 5) {
                scoreE++;
            }
        }
        if (e.getSource() == e3checkbox) {
            if (scoreE < 5) {
                scoreE++;
            }
        }
        if (e.getSource() == e4checkbox) {
            if (scoreE < 5) {
                scoreE++;
            }
        }
        checkFinal(e);
        checkScoreI(e);
    }

    // EFFECTS: checks additional action events
    private void checkScoreI(ActionEvent e) {
        if (e.getSource() == i1checkbox) {
            if (scoreI < 5) {
                scoreI++;
            }
        }
        if (e.getSource() == i2checkbox) {
            if (scoreI < 5) {
                scoreI++;
            }
        }
        if (e.getSource() == i3checkbox) {
            if (scoreI < 5) {
                scoreI++;
            }
        }
        if (e.getSource() == i4checkbox) {
            if (scoreI < 5) {
                scoreI++;
            }
        }
        checkFinal(e);
    }

    // EFFECTS: checks additional action events
    public void checkFinal(ActionEvent e) {
        if (e.getSource() == i5checkbox) {
            if (scoreI < 5) {
                scoreI++;
            }
        }
        if (e.getSource() == e5checkbox) {
            if (scoreE < 5) {
                scoreE++;
            }
        }
        if (e.getSource() == s5checkbox) {
            if (scoreS < 5) {
                scoreS++;
            }
        }
        if (e.getSource() == c5checkbox) {
            if (scoreC < 5) {
                scoreC++;
            }
        }
        checkLast(e);
    }

    // EFFECTS: checks additional action events
    private void checkLast(ActionEvent e) {
        if (e.getSource() == a5checkbox) {
            if (scoreA < 5) {
                scoreA++;
            }
        }
    }

    // getters
    public int getScoreA() {
        return scoreA;
    }

    public int getScoreE() {
        return scoreE;
    }

    public int getScoreC() {
        return scoreC;
    }

    public int getScoreS() {
        return scoreS;
    }

    public int getScoreI() {
        return scoreI;
    }
}
