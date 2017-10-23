package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static pl.nataliana.detectivehardestcase.ChooseplayerActivity.NAME;

public class JonesActivity extends AppCompatActivity {

    private DialogAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.dialog_list);
        ButterKnife.bind(this);

        //Get intents from previous activity
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString(NAME);
        int score = extras.getInt("score");
        String school = extras.getString("school");
        int playerFace = extras.getInt("facePic");

        listView = (ListView) findViewById(R.id.list);

        // Create a dialog with Jones
        ArrayList<Dialog> talkJonesData = new ArrayList<Dialog>();
        talkJonesData.add(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.fingerprint_title)));
        talkJonesData.add(new Dialog(playerFace, name, getString(R.string.statue_title)));
        talkJonesData.add(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.notebook_title)));
        talkJonesData.add(new Dialog(playerFace, name, getString(R.string.statue_title)));

        adapter = new DialogAdapter(JonesActivity.this, talkJonesData);
        listView.setAdapter(adapter);


    }
}

