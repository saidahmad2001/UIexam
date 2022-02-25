package uz.pdp.uiexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CategoryAdapter(private val items: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {

    inner class CategoryVH(private val view: View) : RecyclerView.ViewHolder(view) {

        val ivCategoryPhoto: ImageView = view.findViewById(R.id.ivCategoryPhoto)
        val tvCategory: TextView = view.findViewById(R.id.tvCategory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        return CategoryVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        holder.apply {
            ivCategoryPhoto.setImageResource(items[position].image)
            tvCategory.text = items[position].name
        }
    }

    override fun getItemCount(): Int = items.size

}