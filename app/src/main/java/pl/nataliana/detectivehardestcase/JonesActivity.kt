package pl.nataliana.detectivehardestcase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.WindowManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.dialog_list.*
import pl.nataliana.detectivehardestcase.adapters.DialogsAdapter
import java.util.*

class JonesActivity : AppCompatActivity() {

    private var adapter: DialogsAdapter? = null
    private val schoolDescription: String? = null

    private val allDialogs = Stack<Dialog>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.dialog_list)
        ButterKnife.bind(this)

        prepareDialogs()

        //Set on click listener when player clicks on listView
        empty_view.setOnClickListener {
            list.visibility = View.VISIBLE
            empty_view.visibility = View.VISIBLE
            empty_view.visibility = View.GONE

            // Create a dialog with Jones
            val talkJonesData = ArrayList<Dialog>()
            talkJonesData.add(allDialogs.pop())

            // Set up an adapter to a dialog list. There is no dialog yet so it passes in null.
            adapter = DialogsAdapter(talkJonesData)
            list.adapter = adapter
            list.layoutManager = LinearLayoutManager(baseContext)
        }

        speak.setOnClickListener {
            if (!allDialogs.isEmpty()) {
                adapter!!.addDialog(allDialogs.pop())
            }
        }

    }

    private fun prepareDialogs() {
        val extras = intent.extras
        val name = extras!!.getString(ChooseplayerActivity.NAME)
        val school = extras.getString("school")
        val playerFace = extras.getInt("facePic")

        allDialogs.push(Dialog(playerFace, name, getString(R.string.p3)))
        allDialogs.push(Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j3)))
        allDialogs.push(Dialog(playerFace, name, getString(R.string.p2, school)))
        allDialogs.push(Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j2)))
        allDialogs.push(Dialog(playerFace, name, getString(R.string.p1, name)))
        allDialogs.push(Dialog(R.drawable.detective, getString(R.string.name_Jones), getString(R.string.j1)))
    }
}