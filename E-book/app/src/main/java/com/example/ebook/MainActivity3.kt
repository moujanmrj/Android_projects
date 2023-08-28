package com.example.ebook

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val selectedeBook = intent.getIntArrayExtra("ebooks")
        val ebookImage: ImageView = findViewById(R.id.book_image)
        val ebookTitle: TextView = findViewById(R.id.book_title)
        val ebookdescription: TextView = findViewById(R.id.book_des)

        ebookTitle.setText(selectedeBook!![0])
        ebookImage.setImageResource(selectedeBook[1])
        ebookdescription.setText(selectedeBook[2])
    }
}