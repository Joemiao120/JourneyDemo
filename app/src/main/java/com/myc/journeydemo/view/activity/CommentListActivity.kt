package com.myc.journeydemo.view.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.myc.journeydemo.R
import com.myc.journeydemo.databinding.ActivityCommentListBinding
import com.myc.journeydemo.view.adapter.CommentAdapter
import com.myc.journeydemo.viewModel.CommentViewModel
import com.myc.journeydemo.viewModel.InjectorUtils

/**
 * Comment list page
 */
class CommentListActivity : BaseActivity() {

    private lateinit var binding: ActivityCommentListBinding
    private lateinit var commentAdapter: CommentAdapter
    private val commentViewModel: CommentViewModel by viewModels {
        InjectorUtils.provideCommentsViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment_list)

        initToolbar()
        initRecyclerView()
        initViewModel()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
    }

    private fun initViewModel() {
        commentViewModel.commentList.observe(this) {
            commentAdapter.submitList(it)
        }

        commentViewModel.filterList.observe(this) {
            commentAdapter.submitList(it)
        }

        val postId = intent.getIntExtra(EXTRA_POST_ID, -1)
        commentViewModel.getCommentList(postId)
    }

    private fun initRecyclerView() {
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
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun queryData(newText: String?) {
        super.queryData(newText)
        commentViewModel.filterComments(newText)
    }

    companion object {
        const val EXTRA_POST_ID = "extra_post_id"
    }
}