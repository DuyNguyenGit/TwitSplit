package zalora.assignment.duynguyen.twitsplit.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import zalora.assignment.duynguyen.twitsplit.R

/**
 * Created by DUY on 3/31/2018.
 */

class MessageView : FrameLayout {

    private var messageTextView: TextView? = null

    constructor(context: Context) : super(context) {
        initializeView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initializeView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initializeView(context)
    }

    private fun initializeView(context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.message_item, this)
        this.messageTextView = findViewById<TextView>(R.id.message_text_view)
    }

    fun setMessage(message: String) {
        if (messageTextView == null) {
            messageTextView = findViewById(R.id.message_text_view)
        }
        messageTextView!!.text = message
    }
}
