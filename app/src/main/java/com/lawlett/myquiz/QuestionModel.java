package com.lawlett.myquiz;

import java.io.Serializable;

public class QuestionModel implements Serializable {
    String currentLevel;
    String question;
    String firstAnswer;
    String secondAnswer;
    String thirdAnswer;
    String fourAnswer;

    public QuestionModel(String currentLevel, String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourAnswer) {
        this.currentLevel = currentLevel;
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourAnswer = fourAnswer;
    }

    public String getCurrentLevel() {
        return currentLevel;
    }

    public String getQuestion() {
        return question;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public String getFourAnswer() {
        return fourAnswer;
    }
}
