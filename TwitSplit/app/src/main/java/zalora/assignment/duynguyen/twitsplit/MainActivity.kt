package zalora.assignment.duynguyen.twitsplit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import zalora.assignment.duynguyen.twitsplit.ui.SendMessageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendMessageView = findViewById<SendMessageView>(R.id.send_msg_view)
    }
}
