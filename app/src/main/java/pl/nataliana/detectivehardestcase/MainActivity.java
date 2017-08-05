package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public Locale mylocale;
    @BindView(R.id.english)
    TextView english;
    @BindView(R.id.polish)
    TextView polish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Set English Language
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "English Language", Toast.LENGTH_SHORT).show();
                setLanguage("en");
            }
        });

        //Set Polish Language
        polish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Wersja polska już wkrótce!", Toast.LENGTH_SHORT).show();
                setLanguage("pl");
            }
        });
    }

    //Change language Method
    protected void setLanguage(String language) {
        mylocale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration conf = resources.getConfiguration();
        conf.locale = mylocale;
        resources.updateConfiguration(conf, dm);
        Intent refreshIntent = new Intent(MainActivity.this, MainActivity.class);
        finish();
        startActivity(refreshIntent);
    }

    //This method opens ChooseplayerActivity
    public void startGame(View view) {
        Intent i = new Intent(this, ChooseplayerActivity.class);
        startActivity(i);
        finish();
    }

    public void onBackPressed() {
        //  super.onBackPressed();
        moveTaskToBack(true);

    }
}
