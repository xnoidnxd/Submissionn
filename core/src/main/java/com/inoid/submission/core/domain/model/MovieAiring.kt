package com.inoid.submission.core.domain.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MovieAiring (
    val id: Int,
    val posterPath: String,
    val originalLanguage: String,
    val title: String,
    val voteAverage: Double,
    val overview: String
)