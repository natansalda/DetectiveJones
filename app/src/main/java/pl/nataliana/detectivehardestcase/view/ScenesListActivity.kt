package pl.nataliana.detectivehardestcase.view

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scenes_list.*
import pl.nataliana.detectivehardestcase.R

class ScenesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_scenes_list)

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
