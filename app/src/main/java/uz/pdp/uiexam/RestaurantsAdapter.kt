package uz.pdp.uiexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestaurantsAdapter(
    private val context: Context,
    private val restaurants: ArrayList<Restaurant>
) :
    RecyclerView.Adapter<RestaurantsAdapter.RestaurantVH>() {

    inner class RestaurantVH(private val view: View) : RecyclerView.ViewHolder(view) {

        val ivHomeRestaurant: ImageView = view.findViewById(R.id.ivHomeRestaurant)
        val ivFavourite: ImageView = view.findViewById(R.id.ivFavourite)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvLocation: TextView = view.findViewById(R.id.tvLocation)
        val rbRestaurant: AppCompatRatingBar = view.findViewById(R.id.rbRestaurant)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantVH {
        return RestaurantVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home_restaurant, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RestaurantVH, position: Int) {
        val restaurant = restaurants[position]
        holder.apply {
            Glide.with(context)
                .load(restaurant.image)
                .into(holder.ivHomeRestaurant)
            tvName.text = restaurant.name
            tvLocation.text = restaurant.location
            rbRestaurant.rating = restaurant.rating
            ivFavourite.setImageResource(R.drawable.baseline_favorite_24)

            ivFavourite.setOnClickListener {
                if (restaurant.isFavourite) {
                    ivFavourite.setImageResource(R.drawable.baseline_favorite_24)
                    restaurant.isFavourite = false
                } else {
                    ivFavourite.setImageResource(R.drawable.baseline_favorite_24_red)
                    restaurant.isFavourite = true
                }
            }
        }
    }

    override fun getItemCount(): Int = restaurants.size

}