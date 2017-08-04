package pl.nataliana.detectivehardestcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseplayerActivity extends AppCompatActivity {

    @BindView(R.id.configure_txt)
    TextView configure_txt;
    @BindView(R.id.woman_img)
    ImageView woman_img;
    @BindView(R.id.man_img)
    ImageView man_img;
    @BindView(R.id.name)
    ImageView name;
    @BindView(R.id.user_configured)
    Button user_configured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chooseplayer);
        ButterKnife.bind(this);

        //this is called when the user chooses the woman face picture
        woman_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woman_img.setImageResource(R.drawable.player_face_f_selected);
            }
        });

        //this is called when the user chooses the man face picture
        man_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man_img.setImageResource(R.drawable.player_face_m_selected);
            }
        });
    }
}