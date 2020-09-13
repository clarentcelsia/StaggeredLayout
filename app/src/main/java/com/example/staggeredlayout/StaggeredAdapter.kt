package com.example.staggeredlayout

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class StaggeredAdapter(
    val contexts: Context,
    val names: ArrayList<String>,
    val images: ArrayList<Int>
) : RecyclerView.Adapter<StaggeredAdapter.StaggeredViewHolder>() {

    inner class StaggeredViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StaggeredAdapter.StaggeredViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return StaggeredViewHolder(view)
    }

    override fun getItemCount(): Int = names.size

    override fun onBindViewHolder(holder: StaggeredAdapter.StaggeredViewHolder, position: Int) {
        holder.itemView.apply {
            image.setImageResource(images[position])
            name.text = names[position]
            setOnClickListener{
                contexts.startActivity(
                    Intent(contexts, secondActivity::class.java)
                    .putExtra("Images", images[position])
                )
            }
        }
    }
}