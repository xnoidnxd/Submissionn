package com.inoid.submission.core.domain.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class TvShowDetail (

    val id: Int,
    val lastAirDate: String,
    val name: String,
    val popularity: Double,
    val firstAirDate: String,
    val originalLanguage: String,
    val voteAverage: Double,
    val overview: String,
    val posterPath: String,
    val isFavorite :Boolean = false

)