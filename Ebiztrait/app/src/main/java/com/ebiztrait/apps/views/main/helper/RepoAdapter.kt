package com.ebiztrait.apps.views.main.helper

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ebiztrait.apps.data.models.RepoDTO
import com.ebiztrait.apps.views.main.helper.viewholder.RepoViewHolder

class RepoAdapter : RecyclerView.Adapter<RepoViewHolder>(){

    var mItems = mutableListOf<RepoDTO>()

    var onLoadMoreListener : OnLoadMoreListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RepoViewHolder(parent)
    override fun getItemCount() = mItems.size
    override fun onBindViewHolder(holder: RepoViewHolder?, position: Int) {
        holder?.refresh(mItems[position])

        if(position==mItems.size-1)
            onLoadMoreListener?.onLoadMore()
    }


    fun resetItems(newItems : List<RepoDTO>?){
        newItems?.apply {
            mItems.clear()
            mItems.addAll(newItems)
            notifyDataSetChanged()
        }
    }


    fun addItems(newItems : List<RepoDTO>?){
        newItems?.apply {
            mItems.addAll(newItems)
            notifyItemRangeInserted(mItems.size-newItems.size,newItems.size)
        }
    }


    interface OnLoadMoreListener{
        fun onLoadMore()
    }
}