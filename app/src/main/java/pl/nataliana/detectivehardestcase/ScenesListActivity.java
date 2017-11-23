package pl.nataliana.detectivehardestcase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScenesListActivity extends AppCompatActivity {

    @BindView(R.id.scene_1_title_btn)
    Button scene_1_title_btn;
    @BindView(R.id.scene_2_title_btn)
    Button scene_2_title_btn;
    @BindView(R.id.scene_3_title_btn)
    Button scene_3_title_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_scenes_list);
        ButterKnife.bind(this);

        scene_1_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(ScenesListActivity.this, MurderSceneActivity.class);
                c.putExtras(getIntent().getExtras());
                startActivity(c);
            }
        });

        //TODO open proper activity from here
        scene_2_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(ScenesListActivity.this, MurderSceneActivity.class);
                c.putExtras(getIntent().getExtras());
                startActivity(c);
            }
        });

        //TODO open proper activity from here
        scene_3_title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(ScenesListActivity.this, MurderSceneActivity.class);
                c.putExtras(getIntent().getExtras());
                startActivity(c);
            }
        });
    }


}
