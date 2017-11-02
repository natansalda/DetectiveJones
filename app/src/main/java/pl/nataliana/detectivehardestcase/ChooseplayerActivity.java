package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.choose_school)
    TextView choose_school;
    @BindView(R.id.school1)
    RadioButton school1;
    @BindView(R.id.school2)
    RadioButton school2;
    @BindView(R.id.school3)
    RadioButton school3;
    @BindView(R.id.put_name)
    TextView put_name;
    @BindView(R.id.choose_face)
    TextView choose_face;
    //This variable will define which image should we use to present player's face
    public int playerFace;
    //This variable will count the score in the game
    public int score;
    //This variable will keep player's name
    public static final String NAME = "name";
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
        choose_school.setVisibility(View.GONE);
        school1.setVisibility(View.GONE);
        school2.setVisibility(View.GONE);
        school3.setVisibility(View.GONE);
        put_name.setVisibility(View.GONE);
        choose_face.setVisibility(View.GONE);

        //this is called when the user chooses the woman face picture
        woman_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woman_img.setImageResource(R.drawable.player_face_f_selected);
                man_img.setImageResource(R.drawable.player_face_m);
                playerFace = R.drawable.player_face_f;
            }
        });

        //this is called when the user chooses the man face picture
        man_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man_img.setImageResource(R.drawable.player_face_m_selected);
                woman_img.setImageResource(R.drawable.player_face_f);
                playerFace = R.drawable.player_face_m;
            }
        });
    }

    //this method is called when the user chooses 1st school
    public void clickSchool1(View view) {
        school = getString(R.string.school1);
    }

    //this method is called when the user chooses 2nd school
    public void clickSchool2(View view) {
        school = getString(R.string.school2);
    }

    //this method is called when the user chooses 3rd school
    public void clickSchool3(View view) {
        school = getString(R.string.school3);
    }

    //this method is called when the user clicks "done" button
    public void startStory(View view) {
        String name = nameEdit.getText().toString().trim();
        Intent i = new Intent(ChooseplayerActivity.this, StoryActivity.class);
        Bundle extras = new Bundle();
        extras.putString(NAME, name);
        extras.putString("school", school);
        extras.putInt("facePic", playerFace);
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
        choose_school.setVisibility(View.VISIBLE);
        school1.setVisibility(View.VISIBLE);
        school2.setVisibility(View.VISIBLE);
        school3.setVisibility(View.VISIBLE);
        put_name.setVisibility(View.VISIBLE);
        choose_face.setVisibility(View.VISIBLE);
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