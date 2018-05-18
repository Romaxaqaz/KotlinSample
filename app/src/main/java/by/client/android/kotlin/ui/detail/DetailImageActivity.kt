package by.client.android.kotlin.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.client.android.kotlin.R
import by.client.android.kotlin.images.api.search.Hit
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_search_settings.*

class DetailImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_settings)
        setSupportActionBar(toolbar)

        val image = intent.getParcelableExtra(IMAGE_KEY) as Hit
        Picasso.get().load(image.largeImageURL).into(largeImage)
    }

    companion object {
        var IMAGE_KEY: String = "IMAGE_KEY"

        fun start(activity: Activity, image: Hit) {
            val intent = Intent(activity, DetailImageActivity::class.java)
            intent.putExtra(IMAGE_KEY, image)
            activity.startActivity(intent)
        }
    }
}
