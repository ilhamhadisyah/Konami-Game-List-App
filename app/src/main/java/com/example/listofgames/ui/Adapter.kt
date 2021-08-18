package com.example.listofgames.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listofgames.R
import com.example.listofgames.const.UrlBuilder
import com.example.listofgames.data.model.ResponseItem
import com.example.listofgames.databinding.GameItemBinding
import com.squareup.picasso.Picasso

class Adapter(private val data: List<ResponseItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GameItemBinding.bind(itemView)

        fun bind(data : ResponseItem){
            binding.name.text = data.name
            binding.platfrom.text = data.dataPlatform
            Picasso.get().load(UrlBuilder.makeUrl(data.img!!)).into(binding.banner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}