package com.gyrs.avoqr.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gyrs.avoqr.R
import com.gyrs.avoqr.data.AvocadoData
import kotlinx.android.synthetic.main.recycler_item_list.view.*

class AvocadoListAdapter (private val interaction: Interaction? = null)
    : RecyclerView.Adapter<AvocadoListAdapter.AvocadoItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvocadoItemViewHolder {
        return AvocadoItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_item_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: AvocadoItemViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }


    inner class AvocadoItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(item: AvocadoData) = with(itemView){
            itemView.titleRecyclerItem.text = item.title
            itemView.textDescRecyclerItem.text = item.content

            itemView.setOnClickListener {
                interaction?.onItemSelected(
                    adapterPosition,
                    item,
                    itemView.imageRecyclerItem,
                    itemView.textDescRecyclerItem
                )
            }
        }

    }

    private val differCallBack = object : DiffUtil.ItemCallback<AvocadoData>(){
        override fun areItemsTheSame(oldItem: AvocadoData, newItem: AvocadoData): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: AvocadoData, newItem: AvocadoData): Boolean {
            return oldItem == newItem // kotlin does object content and not referential equals so it's ok
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    interface Interaction {
        fun onItemSelected(position: Int, item: AvocadoData, image : ImageView, title : TextView)
    }

}