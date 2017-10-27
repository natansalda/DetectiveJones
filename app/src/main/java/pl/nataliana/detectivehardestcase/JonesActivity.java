package pl.nataliana.detectivehardestcase;

import android.content.ContentUris;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;

import static pl.nataliana.detectivehardestcase.ChooseplayerActivity.NAME;

public class JonesActivity extends AppCompatActivity {

    private DialogAdapter adapter;
    private ListView listView;
    private String schoolDescription;

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

        //set empty view when dialog list is empty
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

//        // Set up an adapter to create a dialog list. There is no dialog yet so it passes in null.
//        adapter = new DialogAdapter(JonesActivity.this, null);
//        listView.setAdapter(adapter);

//        // Create a dialog with Jones
//        ArrayList<Dialog> talkJonesData = new ArrayList<Dialog>();
//        talkJonesData.add(new Dialog(R.drawable.detective, getString(R.string.name_Jones), "Ugh, did no one teach you to knock? What do you want?"));
//        talkJonesData.add(new Dialog(playerFace, name, "Good morning Detective Jones...Well, my name is " + name + " and I am your new partner at work. They say you are the best so I hope to learn a lot from you."));
//        talkJonesData.add(new Dialog(R.drawable.detective, getString(R.string.name_Jones), "Of course I am the best! I just wonder why in return I need to work with kids from kindergarten! Did you at least study something?"));
//        talkJonesData.add(new Dialog(playerFace, name, "Well actually I just finished " + school + ", so I believe I can be a valuable addition to you resources."));

    }
}