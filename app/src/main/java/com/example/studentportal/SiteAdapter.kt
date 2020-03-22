package com.example.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_site.view.*

class SiteAdapter (private val sites: ArrayList<Site>) : RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(site: Site) {
            itemView.siteBtn.text = site.name.plus("\n").plus(site.url)


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_site, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sites.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sites.get(position))
    }


}