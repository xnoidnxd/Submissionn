package com.inoid.submission.core.data.source.local

import com.inoid.submission.core.data.source.local.entity.MovieAiringEntity
import com.inoid.submission.core.data.source.local.entity.MovieDetailEntity
import com.inoid.submission.core.data.source.local.entity.TvShowAiringEntity
import com.inoid.submission.core.data.source.local.entity.TvShowDetailEntity
import com.inoid.submission.core.data.source.local.room.MovieAiringDao
import com.inoid.submission.core.data.source.local.room.MovieDetailDao
import com.inoid.submission.core.data.source.local.room.TvShowAiringDao
import com.inoid.submission.core.data.source.local.room.TvShowDetailDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieAiringDao: MovieAiringDao,
                                          private val tvShowAiringDao: TvShowAiringDao,
                                          private val movieDetailDao: MovieDetailDao,
                                          private val tvShowDetailDao: TvShowDetailDao) {

    fun getAllAiringMovie(): Flow<List<MovieAiringEntity>> = movieAiringDao.getMovies()

    suspend fun insertAiringMovie(movieList: List<MovieAiringEntity>) = movieAiringDao.insertMovies(movieList)

    fun getAllAiringTvShow(): Flow<List<TvShowAiringEntity>> = tvShowAiringDao.getTvShows()

    suspend fun insertAiringTvShow(tvShowList: List<TvShowAiringEntity>) = tvShowAiringDao.insertTvShows(tvShowList)



    fun getMovieById(movieId: Int): Flow<MovieDetailEntity> = movieDetailDao.getMovieById(movieId)

    suspend fun insertDetailMovie(movie: MovieDetailEntity) = movieDetailDao.insertMovies(movie)

    fun getTvShowById(tvShowId: Int): Flow<TvShowDetailEntity> = tvShowDetailDao.getTvShowById(tvShowId)

    suspend fun insertDetailTvShow(tvShow: TvShowDetailEntity) = tvShowDetailDao.insertTvShows(tvShow)



    // Favorite

//    fun getFavoriteMovie(): Flow<List<MovieDetailEntity>> = movieDetailDao.getFavoriteMovie()
//
//    fun setFavoriteMovie(movie: MovieDetailEntity, newState: Boolean) {
//        movie.isFavorite = newState
//        movieDetailDao.updateFavoriteMovie(movie)
//    }
//
//    fun getFavoriteTvShow(): Flow<List<TvShowDetailEntity>> = tvShowDetailDao.getFavoriteTvShow()
//
//    fun setFavoriteTvShow(tvShow: TvShowDetailEntity, newState: Boolean) {
//        tvShow.isFavorite = newState
//        tvShowDetailDao.updateFavoriteTvShow(tvShow)
//    }

    /*
    * @Singleton
class LocalDataSource @Inject constructor(private val tourismDao: TourismDao)
*
*     fun getAllTourism(): Flow<List<TourismEntity>> = tourismDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<TourismEntity>> = tourismDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
        tourism.isFavorite = newState
        tourismDao.updateFavoriteTourism(tourism)
    }*/
}