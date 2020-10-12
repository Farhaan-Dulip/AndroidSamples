package ajantha.sample.showsnakbar

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Do you want to open Settings", Snackbar.LENGTH_LONG)
                    .setAction("Yes") {
                        startActivity(Intent(Settings.ACTION_SETTINGS))
                    }.show()
        }

    }

}