package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;
    // TODO: Declare as variaveis aqui:
    Story mT1 = new Story(R.string.T1_Story);
    Story mT2 = new Story(R.string.T2_Story);
    Story mT3 = new Story(R.string.T3_Story);
    Story mT4e = new Story(R.string.T4_End);
    Story mT5e = new Story(R.string.T5_End);
    Story mT6e = new Story(R.string.T6_End);
    Answer mT1_ans1 = new Answer(R.string.T1_Ans1);
    Answer mT1_ans2 = new Answer(R.string.T1_Ans2);
    Answer mT2_ans1 = new Answer(R.string.T2_Ans1);
    Answer mT2_ans2 = new Answer(R.string.T2_Ans2);
    Answer mT3_ans1 = new Answer(R.string.T3_Ans1);
    Answer mT3_ans2 = new Answer(R.string.T3_Ans2);

    //indice corrente da historia
    private Story mStorySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO: Faça o link do layout com a activity
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerBottom = findViewById(R.id.buttonBottom);
        mAnswerTop = findViewById(R.id.buttonTop);

        if(savedInstanceState!=null){
        //    mStorySelected = savedInstanceState.getInt("StoryKey");
        }

        //TODO:faça o mapeamento da história
        mT1.setAnswerTop(mT1_ans1);
        mT1.setAnswerBottom(mT1_ans2);
        mT1_ans1.setChildStory(mT3);
        mT3.setAnswerTop(mT3_ans1);
        mT3.setAnswerBottom(mT3_ans2);
        mT3_ans1.setChildStory(mT6e);
        mT3_ans2.setChildStory(mT5e);
        mT1_ans2.setChildStory(mT2);
        mT2.setAnswerTop(mT2_ans1);
        mT2.setAnswerBottom(mT2_ans2);
        mT2_ans1.setChildStory(mT3);
        mT2_ans2.setChildStory(mT4e);

        mStorySelected = mT1;
        mStoryTextView.setText(mStorySelected.getStoryID());
        mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());



        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):
        mAnswerTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mAnswerBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
    //    outState.putAll("StoryKey",mStorySelected);
    }

}
