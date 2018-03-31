package zalora.assignment.duynguyen.twitsplit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import java.util.ArrayList

import zalora.assignment.duynguyen.twitsplit.model.ChatMessage
import zalora.assignment.duynguyen.twitsplit.ui.MessageView

/**
 * Created by DUY on 3/31/2018.
 */

class MessageListAdapter(internal var context: Context) : BaseAdapter() {
    internal var chatMessages: ArrayList<ChatMessage>
    internal var inflater: LayoutInflater

    init {
        this.chatMessages = ArrayList()
        this.inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return chatMessages.size
    }

    override fun getItem(position: Int): Any {
        return chatMessages[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: MessageViewHolder
        if (convertView == null) {
            convertView = MessageView(context)

            holder = MessageViewHolder(convertView)
            convertView.tag = holder
        } else {
            holder = convertView.tag as MessageViewHolder
        }

        holder.setMessage(chatMessages[position].message!!)

        return convertView
    }

    fun addMessage(message: ChatMessage) {
        chatMessages.add(message)
        notifyDataSetChanged()
    }

    fun addMessages(chatMessages: ArrayList<ChatMessage>) {
        this.chatMessages.addAll(chatMessages)
        notifyDataSetChanged()
    }


}
