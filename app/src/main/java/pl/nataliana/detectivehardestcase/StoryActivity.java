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

import static pl.nataliana.detectivehardestcase.ChooseplayerActivity.NAME;

public class StoryActivity extends AppCompatActivity {

    //This variable shows main message in activity and adds a user name
    public String mainMessage;
    //This variable shows current score in the game
    public String currentScore;
    @BindView(R.id.what_to_do_txt)
    TextView what_to_do_txt;
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
        String name = extras.getString(NAME);
        String school = extras.getString("school");
        int playerFace = extras.getInt("facePic");

        //Set text to what_to_do_txt
        mainMessage = getString(R.string.what_to_do) + " " + name + "?";
        what_to_do_txt.setText(mainMessage);

    }

    public void talkWithJones(View view) {
        Intent c = new Intent(StoryActivity.this, JonesActivity.class);
        c.putExtras(getIntent().getExtras());
        startActivity(c);
    }

    public void talkToWitness(View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    public void seeCaseFile(View view) {
        Intent c = new Intent(StoryActivity.this, CaseActivity.class);
        c.putExtras(getIntent().getExtras());
        startActivity(c);
    }

    public void seeProofs(View view) {
        Intent c = new Intent(StoryActivity.this, ProofsActivity.class);
        c.putExtras(getIntent().getExtras());
        startActivity(c);
    }

    public void searchArea(View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    public void solveCase(View view) {
        Toast.makeText(StoryActivity.this, R.string.soon, Toast.LENGTH_SHORT).show();
        //TODO: open new activity
    }

    //This will prevent accidentaly leaving the application
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, R.string.back_twice, Toast.LENGTH_SHORT).show();
    }

}