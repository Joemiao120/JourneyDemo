package com.myc.journeydemo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.myc.journeydemo.R
import com.myc.journeydemo.databinding.ActivityCommentListBinding
import com.myc.journeydemo.view.adapter.CommentAdapter
import com.myc.journeydemo.viewModel.CommentViewModel

class CommentListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCommentListBinding
    private lateinit var commentAdapter: CommentAdapter
    private val viewModel  = CommentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment_list)

        commentAdapter = CommentAdapter()
        binding.rvCommentList.apply {
            this.adapter = commentAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@CommentListActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewModel.commentList.observe(this){
            commentAdapter.submitList(it.toMutableList())
        }



        val postId = intent.getIntExtra(EXTRA_POST_ID, -1)
        viewModel.getCommentList(postId)
    }

    companion object{
        const val EXTRA_POST_ID = "extra_post_id"
    }
}