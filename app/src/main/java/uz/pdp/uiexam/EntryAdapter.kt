package uz.pdp.uiexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntryAdapter(private val items: ArrayList<EntryPage>) :
    RecyclerView.Adapter<EntryAdapter.EntryVH>() {

    inner class EntryVH(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
            val page = items[adapterPosition]

            val ivIcon: ImageView = view.findViewById(R.id.ivIcon)
            val tvTitle: TextView = view.findViewById(R.id.tvTitle)
            val tvDescription: TextView = view.findViewById(R.id.tvDescription)

           // ivIcon.setImageResource(page.icon)
            tvTitle.text = page.title
            tvDescription.text = page.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryVH {
        return EntryVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EntryVH, position: Int) = holder.bind()

    override fun getItemCount(): Int = items.size
}