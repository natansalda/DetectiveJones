package pl.nataliana.detectivehardestcase

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mylocale: Locale

    //This will prevent accidentaly leaving the application
    internal var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        //Set English Language
        english.setOnClickListener {
            Toast.makeText(this@MainActivity, "English Language", Toast.LENGTH_SHORT).show()
            setLanguage("en")
        }

        //Set Polish Language
        polish.setOnClickListener {
            Toast.makeText(this@MainActivity, "Wersja polska już wkrótce!", Toast.LENGTH_SHORT).show()
            setLanguage("pl")
        }
    }

    //Change language Method
    protected fun setLanguage(language: String) {
        mylocale = Locale(language)
        val resources = resources
        val dm = resources.displayMetrics
        val conf = resources.configuration
        conf.locale = mylocale
        resources.updateConfiguration(conf, dm)
        val refreshIntent = Intent(this@MainActivity, MainActivity::class.java)
        finish()
        startActivity(refreshIntent)
    }

    //This method opens ChooseplayerActivity
    fun startGame(view: View) {
        val i = Intent(this, ChooseplayerActivity::class.java)
        startActivity(i)
        finish()
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
