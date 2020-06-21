package com.example.mentalhealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val data: List<LinksFragment.ContactPerson>, var clickListener: onContactClickListener): RecyclerView.Adapter<ListAdapter.ViewHolder> (){

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = data[position]
//        holder.name.text = item.nameOfAssociation
//        holder.image.setImageResource(item.imageOfAssociation)
//        holder.contact.text = item.contactOfAssociation
        holder.initialize(data.get(position), clickListener, holder)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

      val name: TextView = itemView.findViewById(R.id.item_name)
        val contact: TextView = itemView.findViewById(R.id.itemcontact)
        val image: ImageView = itemView.findViewById((R.id.item_image))

        fun initialize(item: LinksFragment.ContactPerson, action:onContactClickListener, holder: ViewHolder){
            name.text = item.nameOfAssociation
            image.setImageResource(item.imageOfAssociation)
            contact.text = item.contactOfAssociation


            itemView.setOnClickListener{
                action.onItemClick(item, holder)
            }
        }


    }



    interface onContactClickListener{
        fun onItemClick(item: LinksFragment.ContactPerson,  holder: ViewHolder)
    }

}