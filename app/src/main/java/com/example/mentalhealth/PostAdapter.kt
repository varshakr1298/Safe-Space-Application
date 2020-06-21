package com.example.mentalhealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mentalhealth.database.Post

class PostAdapter(): RecyclerView.Adapter<PostAdapter.ViewHolder> (){

    var data = listOf<Post>()
       set(value) {
           field= value
         notifyDataSetChanged()
       }


    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.postTitle.text = item.post_item_title.toString()
        holder.postContent.text = item.post_item.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.post_item_view, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val postTitle: TextView = itemView.findViewById(R.id.item_title)
        val postContent: TextView = itemView.findViewById(R.id.item_content)

    }



}