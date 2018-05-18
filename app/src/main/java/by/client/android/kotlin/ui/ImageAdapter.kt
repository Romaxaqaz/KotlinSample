package by.client.android.kotlin.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import by.client.android.kotlin.R
import by.client.android.kotlin.images.api.search.Hit
import com.squareup.picasso.Picasso

/**
 * Created by PanteleevRV on 18.05.2018.
 *
 * @author PRV
 */
class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private var images: List<Hit> = ArrayList()
    private lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return images.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])
    }

    fun setData(items: List<Hit>) {
        images = items
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: OnItemClickListener) {
        this.listener = listener

    }

    class ViewHolder(row: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(row) {

        private var imageItem: ImageView? = null
        private var listener: OnItemClickListener? = null

        init {
            this.imageItem = row.findViewById(R.id.image)
            this.listener = listener
        }

        fun bind(image: Hit) {
            with(image) {
                Picasso.get().load(image.previewURL).into(imageItem)
                itemView.setOnClickListener { listener!!.onItemClick(image) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Hit)
    }
}