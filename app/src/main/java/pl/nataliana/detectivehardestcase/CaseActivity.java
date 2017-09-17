package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CaseActivity extends AppCompatActivity {

    @BindView(R.id.case_file_title)
    TextView case_file_title;
    @BindView(R.id.victim_name_title)
    TextView victim_name_title;
    @BindView(R.id.victim_name)
    TextView victim_name;
    @BindView(R.id.victim_age_title)
    TextView victim_age_title;
    @BindView(R.id.victim_age)
    TextView victim_age;
    @BindView(R.id.victim_work_title)
    TextView victim_work_title;
    @BindView(R.id.victim_work)
    TextView victim_work;
    @BindView(R.id.couse_death_title)
    TextView couse_death_title;
    @BindView(R.id.couse_death)
    TextView couse_death;
    @BindView(R.id.murder_weapon_title)
    TextView murder_weapon_title;
    @BindView(R.id.murder_weapon)
    TextView murder_weapon;
    @BindView(R.id.motive_title)
    TextView motive_title;
    @BindView(R.id.motive)
    TextView motive;
    @BindView(R.id.murderer_name_title)
    TextView murderer_name_title;
    @BindView(R.id.murderer_name)
    TextView murderer_name;
    @BindView(R.id.back_to_story)
    TextView back_to_story;
    //This variable will define which image should we use to present player's face
    public int playerFace;
    //This variable will count the score in the game
    public int score;
    //This variable will keep player's name
    public String name;
    //This variable will keep player's school
    public String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_case);
        ButterKnife.bind(this);

        //Get intents from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name");
        String school = extras.getString("school");
        int playerFace = extras.getInt("playerFace");
        int score = extras.getInt("score");
    }

    @OnClick(R.id.back_to_story)
    public void backToStory(View view) {
        Intent s = new Intent(CaseActivity.this, StoryActivity.class);
        Bundle extras = new Bundle();
        extras.putString("name", name);
        extras.putString("school", school);
        extras.putInt("facePic", playerFace);
        extras.putInt("score", score);
        s.putExtras(extras);
        startActivity(s);
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