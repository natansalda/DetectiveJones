package pl.nataliana.detectivehardestcase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_scenes_list.*

class ScenesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_scenes_list)
        ButterKnife.bind(this)

        scene_1_title_btn.setOnClickListener {
            val c = Intent(this@ScenesListActivity, MurderSceneActivity::class.java)
            c.putExtras(intent.extras!!)
            startActivity(c)
        }

        //TODO open proper activity from here
        scene_2_title_btn.setOnClickListener {
            val c = Intent(this@ScenesListActivity, MurderSceneActivity::class.java)
            c.putExtras(intent.extras!!)
            startActivity(c)
        }

        //TODO open proper activity from here
        scene_3_title_btn.setOnClickListener {
            val c = Intent(this@ScenesListActivity, MurderSceneActivity::class.java)
            c.putExtras(intent.extras!!)
            startActivity(c)
        }
    }
}
