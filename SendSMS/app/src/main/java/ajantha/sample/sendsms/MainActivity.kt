package ajantha.sample.sendsms

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextMobileNo: EditText
    private lateinit var editTextMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNative = findViewById<Button>(R.id.button_native)
        val buttonApi = findViewById<Button>(R.id.button_api)

        editTextMobileNo = findViewById<EditText>(R.id.edit_text_mobile_no)
        editTextMessage = findViewById<EditText>(R.id.edit_text_message)

        buttonNative.setOnClickListener {
            val mobileNo = getMobileNo()
            val message = getMessage()

            val uri = Uri.parse("smsto:$mobileNo")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", message)
            startActivity(intent)
        }

        buttonApi.setOnClickListener {
            val mobileNo = getMobileNo()
            val message = getMessage()

            val smsManager = SmsManager.getDefault() as SmsManager
            smsManager.sendTextMessage(mobileNo, null, message, null, null)
        }

    }

    private fun getMobileNo(): String {
        return editTextMobileNo.text.toString().trim()
    }

    private fun getMessage(): String {
        return editTextMessage.text.toString().trim()
    }

}