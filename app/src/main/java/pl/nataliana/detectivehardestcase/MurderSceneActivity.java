package pl.nataliana.detectivehardestcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MurderSceneActivity extends AppCompatActivity {

    @BindView(R.id.goal_tv)
    TextView goal_tv;
    @BindView(R.id.head_tv)
    TextView head_tv;
    @BindView(R.id.statue_tv)
    TextView statue_tv;
    @BindView(R.id.book_tv)
    TextView book_tv;
    @BindView(R.id.glasses_tv)
    TextView glasses_tv;
    @BindView(R.id.body_tv)
    TextView body_tv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the view on fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Bind the view with a layout
        setContentView(R.layout.activity_chooseplayer);
        ButterKnife.bind(this);

        //This decides about visibility of views
        head_tv.setVisibility(View.INVISIBLE);

    }

}
