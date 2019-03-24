package pl.nataliana.detectivehardestcase.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_story.*
import pl.nataliana.detectivehardestcase.R

class StoryActivity : AppCompatActivity() {

    //This variable shows main message in activity and adds a user name
    lateinit var mainMessage: String
    //This variable shows current score in the game
    var currentScore: String? = null

    //This will prevent accidentaly leaving the application
    internal var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_story)

        //Get intents from previous activity
        val intent = intent
        val extras = intent.extras
        val name = extras!!.getString(ChooseplayerActivity.NAME)
        val school = extras.getString("school")
        val playerFace = extras.getInt("facePic")

        //Set text to what_to_do_txt
        mainMessage = getString(R.string.what_to_do) + " " + name + "?"
        what_to_do_txt.text = mainMessage

    }

    fun talkWithJones(view: View) {
        val c = Intent(this@StoryActivity, JonesActivity::class.java)
        c.putExtras(intent.extras!!)
        startActivity(c)
    }

    fun talkToWitness(view: View) {
        Toast.makeText(this@StoryActivity, R.string.soon, Toast.LENGTH_SHORT).show()
        //TODO: open new activity
    }

    fun seeCaseFile(view: View) {
        val c = Intent(this@StoryActivity, CaseActivity::class.java)
        c.putExtras(intent.extras!!)
        startActivity(c)
    }

    fun seeProofs(view: View) {
        val c = Intent(this@StoryActivity, ProofsActivity::class.java)
        c.putExtras(intent.extras!!)
        startActivity(c)
    }

    fun searchArea(view: View) {
        val c = Intent(this@StoryActivity, ScenesListActivity::class.java)
        c.putExtras(intent.extras!!)
        startActivity(c)
    }

    fun solveCase(view: View) {
        Toast.makeText(this@StoryActivity, R.string.no_suspects, Toast.LENGTH_SHORT).show()
        //TODO: open new activity
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, R.string.back_twice, Toast.LENGTH_SHORT).show()
    }

}