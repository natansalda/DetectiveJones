package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {

    //This variable shows main message in activity and adds a user name
    public String mainMessage;
    //This variable shows current score in the game
    public String currentScore;
    @BindView(R.id.what_to_do_txt)
    TextView what_to_do_txt;
    @BindView(R.id.score)
    TextView score_tv;
    @BindView(R.id.talk_jones)
    ImageView talk_jones;
    @BindView(R.id.talk_witness)
    ImageView talk_witness;
    @BindView(R.id.case_file)
    ImageView case_file;
    @BindView(R.id.see_proofs)
    ImageView see_proofs;
    @BindView(R.id.solve_case)
    ImageView solve_case;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        //Get intents from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name");
        String school = extras.getString("school");
        int playerFace = extras.getInt("playerFace");
        int score = extras.getInt("score");

        //Set text to what_to_do_txt
        mainMessage = getString(R.string.what_to_do) + " " + name + "?";
        what_to_do_txt.setText(mainMessage);

        //Set text to score_tv
        currentScore = getString(R.string.your_score) + score;
        score_tv.setText(currentScore);
    }

    public void talkWithJones (View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    public void talkToWitness (View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    public void seeCaseFile (View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    public void seeProofs (View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    public void solveCase (View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    //This will prevent accidentaly leaving the application
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.back_twice, Toast.LENGTH_SHORT).show();
    }
}
