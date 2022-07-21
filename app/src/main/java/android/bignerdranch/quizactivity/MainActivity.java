package android.bignerdranch.quizactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare your variables that you'll often use
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia,true),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true)};
    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        //Assign your variable by casting them into (Button) first
        mTrueButton = (Button) findViewById(R.id.true_button);
        //Set an event after the true button is clicked
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Call the method
                checkAnswer(true);


            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
             //Set a listener here also
          mFalseButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  //Call the method
                  checkAnswer(false);
              }
          });
          mNextButton = (Button) findViewById(R.id.next_button);
          mNextButton.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;
                  updateQuestion();

              }
          });
          updateQuestion();

    }
    public void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressTrue){
       boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
       int messageResId = 0;
       
       if(userPressTrue){messageResId = R.string.correct_toast;
       } else {
           messageResId = R.string.incorrect_toast;
       }
        Toast.makeText(this, messageResId,
                        Toast.LENGTH_SHORT).show();
    }
    }

