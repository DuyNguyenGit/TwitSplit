package zalora.assignment.duynguyen.twitsplit.ui

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import zalora.assignment.duynguyen.twitsplit.R
import zalora.assignment.duynguyen.twitsplit.Utils
import zalora.assignment.duynguyen.twitsplit.adapters.MessageListAdapter
import zalora.assignment.duynguyen.twitsplit.model.ChatMessage

class SendMessageView : RelativeLayout {

    private var chatListView: ListView? = null
    private var inputEditText: EditText? = null

    private var mContext: Context? = context
    private var messageListAdapter: MessageListAdapter? = null
    private var floatingActionButton: FloatingActionButton? = null


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        LayoutInflater.from(getContext()).inflate(R.layout.send_msg_view, this, true)
        this.mContext = context
        initializeViews()
        setListAdapter()
        setButtonClickListeners()
    }

    private fun initializeViews() {
        chatListView = findViewById(R.id.msg_list)
        inputEditText = findViewById(R.id.input_edit_text)
        floatingActionButton = findViewById(R.id.sendButton)
    }

    private fun setListAdapter() {
        messageListAdapter = MessageListAdapter(context)
        chatListView!!.adapter = messageListAdapter
    }

    private fun setButtonClickListeners() {
        floatingActionButton!!.setOnClickListener {
            val message = inputEditText!!.text.toString()
            if (!TextUtils.isEmpty(message)) {
                sendMessage(message)
            }
        }
    }

    private fun sendMessage(message: String) {
        if (message.length <= 50) {
            postMessage(message)
        } else {
            val messageList = Utils.splitMessage(message)
            if (messageList.isEmpty()) {
                Toast.makeText(mContext, "Message was wrong !", Toast.LENGTH_LONG).show()
                return
            }
            for (msg in messageList) {
                postMessage(msg)
            }
        }
    }

    private fun postMessage(message: String) {
        // TODO : This maybe post message to server
        val chatMessage = ChatMessage(message)
        messageListAdapter!!.addMessage(chatMessage)
        inputEditText!!.setText("")
    }

}
