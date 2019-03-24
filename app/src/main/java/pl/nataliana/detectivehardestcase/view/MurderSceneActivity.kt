package pl.nataliana.detectivehardestcase.view

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_murder_scene.*
import pl.nataliana.detectivehardestcase.R

class MurderSceneActivity : AppCompatActivity() {

    private var valueOfItemsFound = 0
    //This will prevent finding same evidence twice
    internal var headBTNClickedAlready = false
    //This will prevent finding same evidence twice
    internal var statueBTNClickedAlready = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_murder_scene)

        goal_tv.text = getString(R.string.found_items, valueOfItemsFound)

        //Find an item, but only once
        head_btn.setOnClickListener {
            if (headBTNClickedAlready) {
                Toast.makeText(this@MurderSceneActivity, R.string.clicked_twice, Toast.LENGTH_SHORT).show()
            } else {
                valueOfItemsFound++
                goal_tv!!.text = getString(R.string.found_items, valueOfItemsFound)
                Toast.makeText(this@MurderSceneActivity, R.string.new_evidence, Toast.LENGTH_LONG).show()
                headBTNClickedAlready = true
            }
        }

        //Find an item, but only once
        statue_btn.setOnClickListener {
            if (statueBTNClickedAlready) {
                Toast.makeText(this@MurderSceneActivity, R.string.clicked_twice, Toast.LENGTH_SHORT).show()
            } else {
                valueOfItemsFound++
                goal_tv!!.text = getString(R.string.found_items, valueOfItemsFound)
                Toast.makeText(this@MurderSceneActivity, R.string.new_evidence, Toast.LENGTH_LONG).show()
                statueBTNClickedAlready = true
            }
        }

        //No relevant item
        book_btn.setOnClickListener { Toast.makeText(this@MurderSceneActivity, R.string.books, Toast.LENGTH_LONG).show() }

        //No relevant item
        glasses_btn.setOnClickListener { Toast.makeText(this@MurderSceneActivity, R.string.glasses, Toast.LENGTH_LONG).show() }

        //No relevant item
        body_btn.setOnClickListener { Toast.makeText(this@MurderSceneActivity, R.string.body, Toast.LENGTH_LONG).show() }
    }
}
