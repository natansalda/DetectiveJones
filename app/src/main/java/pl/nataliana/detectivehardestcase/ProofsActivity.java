package pl.nataliana.detectivehardestcase;

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

public class ProofsActivity extends AppCompatActivity {

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

        listView = (ListView) findViewById(R.id.list);

        // Create a list of proofs
        ArrayList<Dialog> proofsData = new ArrayList<Dialog>();
        proofsData.add(new Dialog(R.drawable.fingerprint, "Fingerprint", "Fingerprint found on the statue head."));
        proofsData.add(new Dialog(R.drawable.statue_head, "Destroyed statue", "This is a statue with head detached. It looks suspicious.When you come closer you see something read close to the angel ear. Is it blood?"));
        proofsData.add(new Dialog(R.drawable.notebook, "Notebook", "This is a Katy's notebook. Looks like she has a stalker."));

        adapter = new DialogAdapter(ProofsActivity.this, proofsData);
        listView.setAdapter(adapter);

    }
}
