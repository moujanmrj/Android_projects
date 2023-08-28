package com.example.ebook.data

import com.example.ebook.R
import com.example.ebook.model.ebooks

class Datasource {
    fun loadeBooks(): List<ebooks> {
        return listOf<ebooks>(
            ebooks(R.string.book1, R.drawable.image1, R.string.des1),
            ebooks(R.string.book2, R.drawable.image2, R.string.des2),
            ebooks(R.string.book3, R.drawable.image3, R.string.des3),
            ebooks(R.string.book4, R.drawable.image4, R.string.des4),
            ebooks(R.string.book5, R.drawable.image5, R.string.des5)

        )
    }
}