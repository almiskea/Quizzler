package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends Activity {

    // TODO: Declare constants here
    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    TextView mScoreTextView;
    private AtomicInteger counter = new AtomicInteger(0);
    private static int count = 0;
    private static int score = 0;
    // TODO: Declare member variables here:


    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mScoreTextView = (TextView) findViewById(R.id.score);
        //mQuestionTextView.setText(getString(mQuestionBank[counter.get()].getQuestionId()));

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = count++;
                if(index < 13){
                    mQuestionTextView.setText(getString(mQuestionBank[++index].getQuestionId()));
                }else{
                    count = 0;
                    index = count;
                    score = 0;
                    mQuestionTextView.setText(getString(mQuestionBank[index].getQuestionId()));
                }
                if(mQuestionBank[index].isMAnswer() == true){
                    mScoreTextView.setText("Score "+(score++)+"/13");
                }
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = count++;
                Toast.makeText(getApplicationContext(), "False Passed for question "+(index+1), Toast.LENGTH_SHORT).show();
                if(index < 13){
                    mQuestionTextView.setText(getString(mQuestionBank[++index].getQuestionId()));
                }else{
                    count = 0;
                    index = count;
                    score = 0;
                    mQuestionTextView.setText(getString(mQuestionBank[index].getQuestionId()));
                }
                if(mQuestionBank[index].isMAnswer() == false){
                    mScoreTextView.setText("Score "+(score++)+"/13");
                }

            }
        });


    }
}
