package uz.pdp.uiexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SearchAdapter(private val context: Context, private val results: ArrayList<Search>) :
    RecyclerView.Adapter<SearchAdapter.SearchVH>() {

    inner class SearchVH(private val view: View) : RecyclerView.ViewHolder(view) {

        val ivPhoto: ImageView = view.findViewById(R.id.ivPhoto)
        val tvName: TextView = view.findViewById(R.id.tvSearchName)
        val tvLocation: TextView = view.findViewById(R.id.tvSearchLocation)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchVH {
        return SearchVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchVH, position: Int) {

        val result = results[position]

        holder.apply {
            Glide.with(context)
                .load(result.photo)
                .into(holder.ivPhoto)

            tvName.text = result.name
            tvLocation.text = result.location
        }
    }

    override fun getItemCount(): Int = results.size
}