package com.example.listofgames.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listofgames.R
import com.example.listofgames.const.StringUtils
import com.example.listofgames.data.model.GameModelItem
import com.example.listofgames.databinding.GameItemBinding

class Adapter(private val data: List<GameModelItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GameItemBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(data: GameModelItem) {
            binding.apply {
                name.text = data.title
                developer.text = "Developer :${StringUtils.makeText(data.developer!!)}"
                publisher.text = "Publisher : ${StringUtils.makeText(data.publisher!!)}"
                japanRelease.text = "Japan : ${data.japanRelease}"
                northAmericaRelease.text = "North America : ${data.northAmericaRelease}"
                europeRelease.text = "Europe : ${data.europeRelease}"
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}