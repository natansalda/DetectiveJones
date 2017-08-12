package pl.nataliana.detectivehardestcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_case);
        ButterKnife.bind(this);
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
