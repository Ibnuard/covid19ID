package com.ibnuputra.covid19id.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibnuputra.covid19id.R
import com.ibnuputra.covid19id.model.NewsResponse
import com.squareup.picasso.Picasso

class NewsAdapter(private val news : List<NewsResponse>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_layout, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var title = news[position].title
        if (title?.length!! > 100){
            title = title.substring(0,96)+"..."
        }
        holder?.tvTitle?.text = title
        Picasso.get().load(news[position].thumbnail).into(holder?.thumbnail)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val thumbnail : ImageView = itemView.findViewById(R.id.thumbnail)
        override fun onClick(p0: View?) {

        }
    }

}