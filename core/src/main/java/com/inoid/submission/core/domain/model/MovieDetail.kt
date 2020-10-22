package com.inoid.submission.core.domain.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MovieDetail (
    var id: Int?= null,
//    val runtime: Int,
//    val posterPath: String,
//    val originalLanguage: String,
    var title: String?= null
//    val voteAverage: Double,
//    val overview: String,
//    val releaseDate: String,
//    val isFavorite: Boolean = false
)



