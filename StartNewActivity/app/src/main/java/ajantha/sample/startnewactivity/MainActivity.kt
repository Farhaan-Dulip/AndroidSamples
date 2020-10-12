package ajantha.sample.startnewactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val editTextName = findViewById<EditText>(R.id.edit_text_name)
        val editTextAge = findViewById<EditText>(R.id.edit_text_age)

        button.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val age = editTextAge.text.toString().trim().toInt()

            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra(EXTRA_NAME, name)
            intent.putExtra(EXTRA_AGE, age)
            startActivity(intent)
        }

    }

    companion object {
        const val EXTRA_NAME = "NAME"
        const val EXTRA_AGE = "AGE"
    }

}