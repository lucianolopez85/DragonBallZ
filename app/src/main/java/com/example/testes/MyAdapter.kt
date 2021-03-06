package com.example.testes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val list: ArrayList<data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        myListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from((parent.context)).inflate(R.layout.item,
            parent, false)
        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val image: ShapeableImageView = itemView.findViewById(R.id.avatar)
        val title: TextView = itemView.findViewById(R.id.title)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }
}