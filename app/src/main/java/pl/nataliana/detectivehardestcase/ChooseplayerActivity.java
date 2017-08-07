package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseplayerActivity extends AppCompatActivity {

    @BindView(R.id.welcome)
    TextView welcome;
    @BindView(R.id.welcome_txt)
    TextView welcome_txt;
    @BindView(R.id.welcome_txt2)
    TextView welcome_txt2;
    @BindView(R.id.ok)
    Button ok;
    @BindView(R.id.configure_txt)
    TextView configure_txt;
    @BindView(R.id.woman_img)
    ImageView woman_img;
    @BindView(R.id.man_img)
    ImageView man_img;
    @BindView(R.id.name)
    EditText nameEdit;
    @BindView(R.id.user_configured)
    Button user_configured;
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
        setContentView(R.layout.activity_chooseplayer);
        ButterKnife.bind(this);

        //This decides about visibility of views
        configure_txt.setVisibility(View.GONE);
        woman_img.setVisibility(View.GONE);
        man_img.setVisibility(View.GONE);
        nameEdit.setVisibility(View.GONE);
        user_configured.setVisibility(View.GONE);

        //this is called when the user chooses the woman face picture
        woman_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woman_img.setImageResource(R.drawable.player_face_f_selected);
                man_img.setImageResource(R.drawable.player_face_m);
                playerFace = 5;
            }
        });

        //this is called when the user chooses the man face picture
        man_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man_img.setImageResource(R.drawable.player_face_m_selected);
                woman_img.setImageResource(R.drawable.player_face_f);
                playerFace = 10;
            }
        });
    }

    //this method is called when the user chooses 1st school
    public void clickSchool1(View view) {
        school = getString(R.string.school1);
        score = 20;

    }

    //this method is called when the user chooses 2nd school
    public void clickSchool2(View view) {
        school = getString(R.string.school2);
        score = 50;

    }

    //this method is called when the user chooses 3rd school
    public void clickSchool3(View view) {
        school = getString(R.string.school3);
        score = 10;

    }

    //this method is called when the user clicks "done" button
    public void startStory(View view) {
        name = nameEdit.getText().toString().trim();
        Intent i = new Intent(ChooseplayerActivity.this, StoryActivity.class);
        Bundle extras = new Bundle();
        extras.putString("name", name);
        extras.putString("school", school);
        extras.putInt("facePic", playerFace);
        extras.putInt("score", score);
        i.putExtras(extras);
        finish();
        startActivity(i);
    }

    //This method is called when the user clicks "ok" button
    public void ok(View view) {
        welcome.setVisibility(View.GONE);
        welcome_txt.setVisibility(View.GONE);
        welcome_txt2.setVisibility(View.GONE);
        ok.setVisibility(View.GONE);
        configure_txt.setVisibility(View.VISIBLE);
        woman_img.setVisibility(View.VISIBLE);
        man_img.setVisibility(View.VISIBLE);
        nameEdit.setVisibility(View.VISIBLE);
        user_configured.setVisibility(View.VISIBLE);
    }
}