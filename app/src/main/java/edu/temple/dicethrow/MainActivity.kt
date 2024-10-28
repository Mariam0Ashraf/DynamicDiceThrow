package edu.temple.dicethrow

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, ButtonFragment())
                .replace(R.id.container2, DieFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, ButtonFragment())

                .commit()
        }
    }

    override fun buttonClicked() {
        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, DieFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
