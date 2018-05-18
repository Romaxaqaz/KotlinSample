package by.client.android.kotlin.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import by.client.android.kotlin.R
import by.client.android.kotlin.images.api.PixabayService
import by.client.android.kotlin.images.api.search.Hit
import by.client.android.kotlin.images.api.search.ImageType
import by.client.android.kotlin.images.api.search.SearchRequest
import by.client.android.kotlin.ui.detail.DetailImageActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main page
 *
 * @author RPA
 */
class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private var adapter: ImageAdapter = ImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.setOnClickListener(ImagesListener(this))

        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.itemAnimator = DefaultItemAnimator()

        swipeRefreshLayout.setOnRefreshListener(this)
        button.setOnClickListener { search() }
    }

    override fun onRefresh() {
        search()
    }

    private fun search() {
        swipeRefreshLayout.isRefreshing = true

        val search = SearchRequest()
                .setQ(text.text.toString())
                .setImageType(ImageType.ALL)

        PixabayService.create().search(search.toHashMap())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result ->
                            adapter.setData(result.hits)

                            swipeRefreshLayout.isRefreshing = false
                        },
                        { error ->
                            Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
                        })
    }

    class ImagesListener(private var activity: Activity) : ImageAdapter.OnItemClickListener {

        override fun onItemClick(item: Hit) {
            DetailImageActivity.start(activity, item)
        }
    }
}
