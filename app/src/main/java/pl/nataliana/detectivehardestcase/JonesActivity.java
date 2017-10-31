package pl.nataliana.detectivehardestcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Stack;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.nataliana.detectivehardestcase.adapters.DialogsAdapter;

import static pl.nataliana.detectivehardestcase.ChooseplayerActivity.NAME;

public class JonesActivity extends AppCompatActivity {

    @BindView(R.id.empty_view)
    View emptyView;

    @BindView(R.id.list)
    RecyclerView recyclerView;

    @BindView(R.id.speak)
    View speakView;

    private DialogsAdapter adapter;
    private String schoolDescription;

    private Stack<Dialog> allDialogs = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.dialog_list);
        ButterKnife.bind(this);

        prepareDialogs();

        //Set on click listener when player clicks on listView
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
                speakView.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);

                // Create a dialog with Jones
                ArrayList<Dialog> talkJonesData = new ArrayList<Dialog>();
                talkJonesData.add(allDialogs.pop());

                // Set up an adapter to a dialog list. There is no dialog yet so it passes in null.
                adapter = new DialogsAdapter(talkJonesData);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            }
        });

        speakView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!allDialogs.isEmpty()) {
                    adapter.addDialog(allDialogs.pop());
                }
            }
        });

    }

    private void prepareDialogs() {
        Bundle extras = getIntent().getExtras();
        final String name = extras.getString(NAME);
        int score = extras.getInt("score");
        final String school = extras.getString("school");
        final int playerFace = extras.getInt("facePic");

        allDialogs.push(new Dialog(playerFace, name, getString(R.string.p2a) + school + getString(R.string.p2b)));
        allDialogs.push(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j2)));
        allDialogs.push(new Dialog(playerFace, name, getString(R.string.p1a) + name + getString(R.string.p1b)));
        allDialogs.push(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j1)));

        //Replicated dialogs for testing purpose
        allDialogs.push(new Dialog(playerFace, name, getString(R.string.p2a) + school + getString(R.string.p2b)));
        allDialogs.push(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j2)));
        allDialogs.push(new Dialog(playerFace, name, getString(R.string.p1a) + name + getString(R.string.p1b)));
        allDialogs.push(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j1)));

        allDialogs.push(new Dialog(playerFace, name, getString(R.string.p2a) + school + getString(R.string.p2b)));
        allDialogs.push(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j2)));
        allDialogs.push(new Dialog(playerFace, name, getString(R.string.p1a) + name + getString(R.string.p1b)));
        allDialogs.push(new Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j1)));
    }
}