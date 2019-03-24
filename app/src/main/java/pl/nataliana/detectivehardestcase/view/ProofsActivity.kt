package pl.nataliana.detectivehardestcase.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import pl.nataliana.detectivehardestcase.R
import pl.nataliana.detectivehardestcase.model.Dialog
import java.util.*

class ProofsActivity : AppCompatActivity() {

    private var adapter: pl.nataliana.detectivehardestcase.adapters.ProofAdapter? = null
    private var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.proofs_list)
        ButterKnife.bind(this)

        listView = findViewById<View>(R.id.list) as ListView

        // Create a list of proofs
        val proofsData = ArrayList<Dialog>()
        proofsData.add(Dialog(R.drawable.fingerprint, getString(R.string.fingerprint), getString(R.string.fingerprint_title)))
        proofsData.add(Dialog(R.drawable.statue_head, getString(R.string.statue), getString(R.string.statue_title)))
        //"This is a statue with head detached. It looks suspicious.When you come closer you see something read close to the angel ear. Is it blood?"
        proofsData.add(Dialog(R.drawable.notebook, getString(R.string.notebook), getString(R.string.notebook_title)))
        //Looks like she has a stalker.

        adapter = pl.nataliana.detectivehardestcase.adapters.ProofAdapter(this@ProofsActivity, proofsData)
        listView!!.adapter = adapter

        listView!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@ProofsActivity, ProofsDetailsActivity::class.java)
            startActivity(intent)
        }

    }
}