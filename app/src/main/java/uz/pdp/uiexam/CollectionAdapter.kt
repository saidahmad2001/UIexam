package uz.pdp.uiexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CollectionAdapter(
    private val context: Context,
    private val collections: ArrayList<Collection>
) :
    RecyclerView.Adapter<CollectionAdapter.CollectionVH>() {

    inner class CollectionVH(private val view: View) : RecyclerView.ViewHolder(view) {

        val ivCollection: ImageView = view.findViewById(R.id.ivCollection)
        val tvCollectionName: TextView = view.findViewById(R.id.tvCollectionName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionVH {
        return CollectionVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_collections, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CollectionVH, position: Int) {
        val collection = collections[position]
        holder.apply {
            Glide.with(context)
                .load(collection.ivCollection)
                .into(holder.ivCollection)
            tvCollectionName.text = collection.collectionName
        }
    }

    override fun getItemCount(): Int = collections.size

}