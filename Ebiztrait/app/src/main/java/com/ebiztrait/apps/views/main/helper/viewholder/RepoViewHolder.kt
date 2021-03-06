package com.ebiztrait.apps.views.main.helper.viewholder

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ebiztrait.apps.R
import com.ebiztrait.apps.data.models.RepoDTO

class RepoViewHolder(vg : ViewGroup)
    : RecyclerView.ViewHolder(LayoutInflater.from(vg.context).inflate(R.layout.template_repo,vg,false)) {

    val ctx = vg.context

    val tvStar = itemView.findViewById<AppCompatTextView>(R.id.tv_star)
    val tvName = itemView.findViewById<AppCompatTextView>(R.id.tv_name)
    val tvDesc = itemView.findViewById<AppCompatTextView>(R.id.tv_desc)

    fun refresh(repoItem : RepoDTO){
        tvStar.text = repoItem.stargazers_count.toString()
        tvName.text = repoItem.fullName
        tvDesc.text = repoItem.description
    }

}