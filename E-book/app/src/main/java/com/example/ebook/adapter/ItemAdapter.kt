package com.example.ebook.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ebook.MainActivity
import com.example.ebook.MainActivity3
import com.example.ebook.R
import com.example.ebook.model.ebooks

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [ebooks] data object.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<ebooks>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.itemView.setOnClickListener{
            //Toast.makeText(context, item.description, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, MainActivity3:: class.java)
            val ebookDes: IntArray = intArrayOf( item.stringResourceId, item.imageResourceId, item.description)
            intent.putExtra("ebooks", ebookDes)
            context.startActivity(intent)
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}