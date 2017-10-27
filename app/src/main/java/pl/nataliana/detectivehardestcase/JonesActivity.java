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

    @BindView(R.id.foto_empty_view)
    ImageView door;

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
        final String name = extras.getString(NAME);
        int score = extras.getInt("score");
        final String school = extras.getString("school");
        final int playerFace = extras.getInt("facePic");

        listView = (ListView) findViewById(R.id.list);

        //Set empty view when dialog list is empty
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        //Set on click listener when player clicks on listView
        door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create a dialog with Jones
                ArrayList<Dialog> talkJonesData = new ArrayList<Dialog>();
                talkJonesData.add(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j1)));
                talkJonesData.add(new Dialog(playerFace, name, getString(R.string.p1a) + name + getString(R.string.p1b)));
                talkJonesData.add(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j2)));
                talkJonesData.add(new Dialog(playerFace, name, getString(R.string.p2a) + school + getString(R.string.p2b)));

                // Set up an adapter to a dialog list. There is no dialog yet so it passes in null.
                adapter = new DialogAdapter(JonesActivity.this, talkJonesData);
                listView.setAdapter(adapter);

            }
        });


    }
}