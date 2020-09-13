package com.example.staggeredlayout

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var staggeredAdapter: StaggeredAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        supportActionBar?.subtitle = "Pinterest"
        supportActionBar?.elevation = 0F

        val names = arrayListOf(
            "Tomohiro",
            "Ariana",
            "Esther",
            "Kevin Hart",
            "Ramsay",
            "Dilraba",
            "Mr Bean",
            "Bohemian",
            "Scandinavian",
            "Tomohiro Yamashita"
        )

        val images = arrayListOf(
            R.drawable.tomohiroandfriends,
            R.drawable.ariana,
            R.drawable.esther,
            R.drawable.kevinhart,
            R.drawable.ramsay,
            R.drawable.dilraba,
            R.drawable.bean,
            R.drawable.bohemian,
            R.drawable.scandinavian,
            R.drawable.tomohiro
        )

        staggeredAdapter = StaggeredAdapter(this@MainActivity, names, images)
        rvStaggered.apply {
            val staggeredGridLayoutManager =
                StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            layoutManager = staggeredGridLayoutManager
            adapter = staggeredAdapter

            addOnScrollListener(scrollListener)
        }
    }

    fun up(view: View) {
        val mLayoutManager = rvStaggered.layoutManager
        mLayoutManager?.smoothScrollToPosition(rvStaggered, null, 0)
    }

    val scrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dy > 0 || dy < 0 && fab.isShown) {
                fab.hide()
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == RecyclerView.SCROLL_STATE_IDLE) fab.show()
        }
    }
}