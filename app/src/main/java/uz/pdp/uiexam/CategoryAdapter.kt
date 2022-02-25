package uz.pdp.uiexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.pdp.uiexam.Category
import uz.pdp.uiexam.R

class CategoryAdapter(private val context: Context, private val items: ArrayList<Category>) :
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
            Glide.with(context)
                .load(items[position].image)
                .into(holder.ivCategoryPhoto)
            tvCategory.text = items[position].name
        }
    }

    override fun getItemCount(): Int = items.size

}