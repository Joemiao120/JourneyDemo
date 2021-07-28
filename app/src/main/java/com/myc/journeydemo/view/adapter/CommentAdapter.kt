package com.myc.journeydemo.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myc.journeydemo.data.model.CommentData
import com.myc.journeydemo.data.model.PostData
import com.myc.journeydemo.databinding.ListItemCommentBinding
import com.myc.journeydemo.databinding.ListItemPostBinding

class CommentAdapter : ListAdapter<CommentData, CommentAdapter.CommentViewHolder>(CommentDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            ListItemCommentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CommentViewHolder(private val binding: ListItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommentData) {
            binding.apply {
                comment = item
                executePendingBindings()
            }
        }
    }
}


private class CommentDiffCallBack : DiffUtil.ItemCallback<CommentData>() {
    override fun areItemsTheSame(
        oldItem: CommentData,
        newItem: CommentData
    ): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CommentData,
        newItem: CommentData
    ): Boolean {
        return (oldItem == newItem)
    }
}