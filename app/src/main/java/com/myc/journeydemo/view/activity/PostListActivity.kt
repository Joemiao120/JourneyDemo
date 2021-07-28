package com.myc.journeydemo.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.myc.journeydemo.R
import com.myc.journeydemo.databinding.ActivityMainBinding
import com.myc.journeydemo.view.adapter.PostAdapter
import com.myc.journeydemo.viewModel.InjectorUtils
import com.myc.journeydemo.viewModel.PostViewModel

/**
 * Post List page
 */
class PostListActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val postViewModel: PostViewModel by viewModels {
        InjectorUtils.providePostsViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        initRecyclerView()

        initViewModel()
    }

    private fun initRecyclerView() {
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
    }

    private fun initViewModel() {
        postViewModel.postList.observe(this) {
            postAdapter.submitList(it)
        }

        postViewModel.filterList.observe(this) {
            postAdapter.submitList(it)
        }

        postViewModel.getPostList()
    }


    override fun queryData(newText: String?) {
        super.queryData(newText)
        postViewModel.filterPosts(newText)
    }

    private fun enterCommentActivity(postId: Int) {
        val intent = Intent(this, CommentListActivity::class.java)
        intent.putExtra(CommentListActivity.EXTRA_POST_ID, postId)
        startActivity(intent)
    }
}

