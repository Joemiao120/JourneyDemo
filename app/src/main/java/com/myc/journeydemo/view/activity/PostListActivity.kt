package com.myc.journeydemo.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.myc.journeydemo.R
import com.myc.journeydemo.databinding.ActivityMainBinding
import com.myc.journeydemo.view.adapter.PostAdapter
import com.myc.journeydemo.viewModel.PostViewModel

class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val viewModel = PostViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        postAdapter = PostAdapter {
            enterCommentActivity(it)
        }
        binding.rvPostList.apply {
            this.adapter = postAdapter
            addItemDecoration(
                DividerItemDecoration(
                    this@PostListActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        viewModel.postList.observe(this) {
            postAdapter.submitList(it.toMutableList())
        }

        viewModel.getPostList()
    }

    private fun enterCommentActivity(postId: Int) {
        val intent = Intent(this, CommentListActivity::class.java)
        intent.putExtra(CommentListActivity.EXTRA_POST_ID, postId)
        startActivity(intent)
    }
}

