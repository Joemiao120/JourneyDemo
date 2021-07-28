package com.myc.journeydemo.view.activity

import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.myc.journeydemo.R

/**
 * Base Activity
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem: MenuItem? = menu?.findItem(R.id.action_search)
        val searchView: SearchView? = searchItem?.actionView as SearchView
        searchView?.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    queryData(null)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    queryData(newText)
                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * Open function for filter list
     *
     * @param newText the filter text
     */
    open fun queryData(newText: String?){ }
}