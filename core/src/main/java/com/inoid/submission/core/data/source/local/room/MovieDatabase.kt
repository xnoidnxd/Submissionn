package com.inoid.submission.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inoid.submission.core.data.source.local.entity.MovieAiringEntity
import com.inoid.submission.core.data.source.local.entity.MovieDetailEntity
import com.inoid.submission.core.data.source.local.entity.TvShowAiringEntity
import com.inoid.submission.core.data.source.local.entity.TvShowDetailEntity

@Database(entities = [MovieAiringEntity::class, TvShowAiringEntity::class, MovieDetailEntity::class, TvShowDetailEntity::class],
    version = 1,
    exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieAiringDao(): MovieAiringDao
    abstract fun tvShowAiringDao(): TvShowAiringDao
    abstract fun movieDetailDao(): MovieDetailDao
    abstract fun tvShowDetailDao(): TvShowDetailDao
}