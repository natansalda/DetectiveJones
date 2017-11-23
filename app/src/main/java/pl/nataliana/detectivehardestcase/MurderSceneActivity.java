package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MurderSceneActivity extends AppCompatActivity {

    @BindView(R.id.goal_tv)
    TextView goal_tv;
    @BindView(R.id.head_btn)
    Button head_btn;
    @BindView(R.id.statue_btn)
    Button statue_btn;
    @BindView(R.id.book_btn)
    Button book_btn;
    @BindView(R.id.glasses_btn)
    Button glasses_btn;
    @BindView(R.id.body_btn)
    Button body_btn;
    private int valueOfItemsFound = 0;
    //This will prevent finding same evidence twice
    boolean headBTNClickedAlready = false;
    //This will prevent finding same evidence twice
    boolean statueBTNClickedAlready = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_murder_scene);
        ButterKnife.bind(this);

        goal_tv.setText(getString(R.string.found_items, valueOfItemsFound));

        head_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (headBTNClickedAlready) {
                    Toast.makeText(MurderSceneActivity.this, R.string.clicked_twice, Toast.LENGTH_SHORT).show();
                } else {
                    valueOfItemsFound++;
                    goal_tv.setText(getString(R.string.found_items, valueOfItemsFound));
                    Toast.makeText(MurderSceneActivity.this, R.string.new_evidence, Toast.LENGTH_LONG).show();
                    headBTNClickedAlready = true;
                }
            }
        });

        statue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (statueBTNClickedAlready){
                    Toast.makeText(MurderSceneActivity.this, R.string.clicked_twice, Toast.LENGTH_SHORT).show();
                }
                valueOfItemsFound++;
                goal_tv.setText(getString(R.string.found_items, valueOfItemsFound));
                Toast.makeText(MurderSceneActivity.this, R.string.new_evidence, Toast.LENGTH_LONG).show();
                statueBTNClickedAlready = true;
            }
        });

        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MurderSceneActivity.this, R.string.books, Toast.LENGTH_LONG).show();
            }
        });

        glasses_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MurderSceneActivity.this, R.string.glasses, Toast.LENGTH_LONG).show();
            }
        });

        body_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MurderSceneActivity.this, R.string.body, Toast.LENGTH_LONG).show();
            }
        });
    }
}
