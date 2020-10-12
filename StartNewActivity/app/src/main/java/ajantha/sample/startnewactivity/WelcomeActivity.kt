package ajantha.sample.startnewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val textView = findViewById<TextView>(R.id.text_view)

        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        val age = intent.getIntExtra(MainActivity.EXTRA_AGE, 0)

        textView.text = "Hi $name!, You're $age years old."
    }

}