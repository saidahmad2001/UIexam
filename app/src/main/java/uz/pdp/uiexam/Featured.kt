package uz.pdp.uiexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Featured(private val features: ArrayList<Features>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var clickAll: ((Features) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderFeatured(
            LayoutInflater.from(parent.context).inflate(R.layout.featured_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feature = features[position]
        if (holder is ViewHolderFeatured) {
            holder.apply {
                image.setImageResource(feature.image)
                textView.text = feature.description

                clickAll?.invoke(feature)

            }
        }
    }

    override fun getItemCount(): Int = features.size

}




class ViewHolderFeatured(view: View) : RecyclerView.ViewHolder(view) {
    var image: ImageView = view.findViewById(R.id.imgProduct)
    var textView: TextView = view.findViewById(R.id.tvName)
}