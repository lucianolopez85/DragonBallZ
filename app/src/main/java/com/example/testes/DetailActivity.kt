package com.example.testes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titleView: TextView = findViewById(R.id.textView)
        val detailView: TextView = findViewById(R.id.textView2)
        val imageView: ImageView = findViewById(R.id.imageView)


        val bundle: Bundle? = intent.extras
        val title = bundle!!.getString("listTitle")
        val imageId = bundle.getInt("listImageId")
        val detail = bundle.getString("listData")

        titleView.text = title
        detailView.text = detail
        imageView.setImageResource(imageId)
    }
}