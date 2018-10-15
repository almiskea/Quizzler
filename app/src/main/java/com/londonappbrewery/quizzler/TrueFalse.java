package com.londonappbrewery.quizzler;

/**
 * Created by Ali on 2/11/2018.
 */

public class TrueFalse {
    private int mQuestionId;
    private boolean mAnswer;
    TrueFalse(int questionId,boolean mAnswer){
        this.mQuestionId = questionId;
        this.mAnswer = mAnswer;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int question) {
        this.mQuestionId = question;
    }

    public boolean isMAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}

