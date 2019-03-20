package pl.nataliana.detectivehardestcase.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

import butterknife.ButterKnife
import pl.nataliana.detectivehardestcase.R


class ProofsDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.proof_card)
    }
}
