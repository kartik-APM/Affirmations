package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/*
* Our app needs a way to take the data from Datasource, and format it
* so that each Affirmation can be displayed as an item in the RecyclerView.
* Adapter is a design pattern that adapts the data into something
* that can be used by RecyclerView. In this case, we need an adapter that
* takes an Affirmation instance from the list returned by loadAffirmations(),
* and turns it into a list item view, so that it can be displayed in the RecyclerView.
 */

/*
* This is an adapter class which will adapt an Affirmation object
* instance so that it can be displayed in the RecyclerView.
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    /*
    * RecyclerView doesn't interact directly with
    * item views, but deals with ViewHolders instead.
    * A ViewHolder represents a single list item view
    * in RecyclerView, and can be reused when possible.
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.tvItemTitle)
        val imageView: ImageView = view.findViewById(R.id.ivItemImage)
    }

    /*
    * The onCreateViewHolder()method is called by the layout
    * manager to create new view holders for the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /*
    * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /*
    *The getItemCount() method needs to
    * return the size of your dataset.
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}