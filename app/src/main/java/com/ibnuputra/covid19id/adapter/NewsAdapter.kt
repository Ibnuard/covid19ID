package com.ibnuputra.covid19id.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ibnuputra.covid19id.NewsViewActivity
import com.ibnuputra.covid19id.R
import com.ibnuputra.covid19id.model.NewsResponse
import com.squareup.picasso.Picasso

class NewsAdapter(
    private val news : List<NewsResponse>?,
    private val context: Context?
    ) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_list_layout, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount() = news!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var title = news?.get(position)?.title
        if (title?.length!! > 100){
            title = title.substring(0,96)+"..."
        }
        holder.tvTitle.text = title
        Picasso.get().load(news?.get(position)?.thumbnail).into(holder.thumbnail)
        holder.holder.setOnClickListener {
            val intent = Intent(context, NewsViewActivity::class.java)
            intent.putExtra("URL", news?.get(position)?.url)
            context?.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val thumbnail : ImageView = itemView.findViewById(R.id.thumbnail)
        val holder: CardView = itemView.findViewById(R.id.newsHolder)
    }

}