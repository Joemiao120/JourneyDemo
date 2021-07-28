package com.myc.journeydemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myc.journeydemo.data.model.PostData
import com.myc.journeydemo.databinding.ListItemPostBinding

class PostAdapter(private val callBack: ((Int) -> Unit)) : ListAdapter<PostData, PostAdapter.PostViewHolder>(PostDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ListItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(private val binding: ListItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostData) {
            binding.apply {
                post = item
                executePendingBindings()
            }

            binding.root.setOnClickListener {
                callBack(item.id)
            }
        }
    }
}


private class PostDiffCallBack : DiffUtil.ItemCallback<PostData>() {
    override fun areItemsTheSame(
        oldItem: PostData,
        newItem: PostData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: PostData,
        newItem: PostData
    ): Boolean {
        return (oldItem == newItem)
    }
}