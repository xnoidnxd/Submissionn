package com.inoid.submission.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.inoid.submission.core.data.source.remote.response.MovieResponse
@Entity(tableName = "table_movie_detail")
data class MovieDetailEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

//    @ColumnInfo(name = "runtime")
//    var runtime: Int,
//
//    @ColumnInfo(name = "posterPath")
//    var posterPath: String,
//
//    @ColumnInfo(name = "originalLanguage")
//    var originalLanguage: String,

    @ColumnInfo(name = "title")
    var title: String

//    @ColumnInfo(name = "voteAverage")
//    var voteAverage: Double,
//
//    @ColumnInfo(name = "overview")
//    var overview: String,
//
//    @ColumnInfo(name = "releaseDate")
//    var releaseDate: String,
//
//    @ColumnInfo(name = "isFavorite")
//    var isFavorite: Boolean = false

)