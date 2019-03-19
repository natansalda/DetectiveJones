package pl.nataliana.detectivehardestcase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import butterknife.ButterKnife

class CaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the view on fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //Bind the view with a layout
        setContentView(R.layout.activity_case)
        ButterKnife.bind(this)
    }
}