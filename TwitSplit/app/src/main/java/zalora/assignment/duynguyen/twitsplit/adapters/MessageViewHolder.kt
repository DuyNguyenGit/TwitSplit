package zalora.assignment.duynguyen.twitsplit.adapters

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View

import zalora.assignment.duynguyen.twitsplit.ui.MessageView

/**
 * Created by DUY on 3/31/2018.
 */

internal class MessageViewHolder(convertView: View) {

    var context: Context

    private val messageView: MessageView

    init {
        context = convertView.context
        messageView = convertView as MessageView
    }

    fun setMessage(message: String) {
        messageView.setMessage(message)
    }

}
