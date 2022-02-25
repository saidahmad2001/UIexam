package uz.pdp.uiexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MessageAdapter(private val context: Context, private val messages: ArrayList<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageVH>() {

    inner class MessageVH(private val view: View) : RecyclerView.ViewHolder(view) {

        val ivProfile: ShapeableImageView = view.findViewById(R.id.ivProfile)
        val tvFullName: TextView = view.findViewById(R.id.tvFullName)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageVH {
        return MessageVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MessageVH, position: Int) {

        val message = messages[position]

        holder.apply {
            ivProfile.setImageResource(message.ivProfile)
            tvFullName.text = messages[position].fullName
            tvMessage.text = messages[position].messageText
        }
    }

    override fun getItemCount(): Int = messages.size

}