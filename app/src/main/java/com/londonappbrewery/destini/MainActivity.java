package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MAIN_STORY_KEY="mainStory";
    private TextView storyView;
    private Button buttonTop;
    private Button buttonBottom;
    private Story mainStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStories(savedInstanceState);
        storyView = (TextView) findViewById(R.id.storyTextView);
        storyView.setText(mainStory.getId());
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);
        buttonTop.setText(mainStory.getTop().getId());
        buttonBottom.setText(mainStory.getBottom().getId());

        buttonTop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                displayStory(mainStory.getTop());
            }
        });

        buttonBottom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                displayStory(mainStory.getBottom());
            }
        });


    }
    private void displayStory(Answer answer){
        if(answer != null){
            mainStory=answer.getStory();
            storyView.setText(mainStory.getId());
            if(mainStory.getTop() != null){
                buttonTop.setText(mainStory.getTop().getId());
            }
            if(mainStory.getBottom() != null){
                buttonBottom.setText(mainStory.getBottom().getId());
            }
            if(mainStory.getTop() == null && mainStory.getBottom() == null){
                enableFinish();
            }
        }
    }
    private void enableFinish() {
        buttonBottom.setVisibility(View.INVISIBLE);
        buttonTop.setText(R.string.finish);
        buttonTop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setStories(Bundle savedInstanceState){
        mainStory = savedInstanceState == null ? null : (Story) savedInstanceState.get(MAIN_STORY_KEY);
        if(mainStory == null){
            mainStory = new Story(R.string.T1_Story);
            mainStory.setTop(new Answer(R.string.T1_Ans1,new Story(R.string.T3_Story)));
            mainStory.setBottom(new Answer(R.string.T1_Ans2,new Story(R.string.T2_Story)));
            mainStory.getTop().getStory().setTop(new Answer(R.string.T3_Ans1,new Story(R.string.T6_End,null,null)));
            mainStory.getTop().getStory().setBottom(new Answer(R.string.T3_Ans2,new Story(R.string.T5_End,null,null)));
            mainStory.getBottom().getStory().setTop(new Answer(R.string.T2_Ans1,new Story(R.string.T3_Story)));
            mainStory.getBottom().getStory().setBottom(new Answer(R.string.T2_Ans2,new Story(R.string.T4_End,null,null)));
            mainStory.getBottom().getStory().getTop().getStory().setTop(new Answer(R.string.T3_Ans1,new Story(R.string.T6_End,null,null)));
            mainStory.getBottom().getStory().getTop().getStory().setBottom(new Answer(R.string.T3_Ans2,new Story(R.string.T5_End,null,null)));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(MAIN_STORY_KEY,mainStory);
    }
}
