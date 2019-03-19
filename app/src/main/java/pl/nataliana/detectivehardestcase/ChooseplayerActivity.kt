package pl.nataliana.detectivehardestcase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_chooseplayer.*

class ChooseplayerActivity : AppCompatActivity() {

    //This variable will define which image should we use to present player's face
    var playerFace: Int = 0
    //This variable will count the score in the game
    var score: Int = 0
    //This variable will keep player's school
    lateinit var school: String


    //This will prevent accidentaly leaving the application
    internal var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_chooseplayer)
        ButterKnife.bind(this)

        //This decides about visibility of views
        configure_txt.visibility = View.GONE
        woman_img.visibility = View.GONE
        man_img.visibility = View.GONE
        name.visibility = View.GONE
        user_configured.visibility = View.GONE
        choose_school.visibility = View.GONE
        school1.visibility = View.GONE
        school2.visibility = View.GONE
        school3.visibility = View.GONE
        put_name.visibility = View.GONE
        choose_face.visibility = View.GONE

        //this is called when the user chooses the woman face picture
        woman_img!!.setOnClickListener {
            woman_img!!.setImageResource(R.drawable.player_face_f_selected)
            man_img!!.setImageResource(R.drawable.player_face_m)
            playerFace = R.drawable.player_face_f
        }

        //this is called when the user chooses the man face picture
        man_img!!.setOnClickListener {
            man_img!!.setImageResource(R.drawable.player_face_m_selected)
            woman_img!!.setImageResource(R.drawable.player_face_f)
            playerFace = R.drawable.player_face_m
        }
    }

    //this method is called when the user chooses 1st school
    fun clickSchool1(view: View) {
        school = getString(R.string.school1)
    }

    //this method is called when the user chooses 2nd school
    fun clickSchool2(view: View) {
        school = getString(R.string.school2)
    }

    //this method is called when the user chooses 3rd school
    fun clickSchool3(view: View) {
        school = getString(R.string.school3)
    }

    //this method is called when the user clicks "done" button
    fun startStory(view: View) {
        val name = name.text.toString().trim { it <= ' ' }
        val i = Intent(this@ChooseplayerActivity, StoryActivity::class.java)
        val extras = Bundle()
        extras.putString(NAME, name)
        extras.putString("school", school)
        extras.putInt("facePic", playerFace)
        i.putExtras(extras)
        finish()
        startActivity(i)
    }

    //This method is called when the user clicks "ok" button
    fun ok(view: View) {
        welcome!!.visibility = View.GONE
        welcome_txt!!.visibility = View.GONE
        welcome_txt2!!.visibility = View.GONE
        ok!!.visibility = View.GONE
        configure_txt!!.visibility = View.VISIBLE
        woman_img!!.visibility = View.VISIBLE
        man_img!!.visibility = View.VISIBLE
        name.visibility = View.VISIBLE
        user_configured!!.visibility = View.VISIBLE
        choose_school!!.visibility = View.VISIBLE
        school1!!.visibility = View.VISIBLE
        school2!!.visibility = View.VISIBLE
        school3!!.visibility = View.VISIBLE
        put_name!!.visibility = View.VISIBLE
        choose_face!!.visibility = View.VISIBLE
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

    companion object {
        //This variable will keep player's name
        val NAME = "name"
    }
}