package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

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
}
