package com.inoid.submission.core.domain.usecase

import com.inoid.submission.core.data.Resource
import com.inoid.submission.core.domain.model.MovieAiring
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.model.TvShowAiring
import com.inoid.submission.core.domain.model.TvShowDetail
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {

    fun getAllMovie(): Flow<Resource<List<MovieAiring>>>

    fun getAllTvShow(): Flow<Resource<List<TvShowAiring>>>

    fun getMovieDetail(movieId: Int): Flow<Resource<MovieDetail>>

    fun getTvShowDetail(tvShowId: Int): Flow<Resource<TvShowDetail>>

    //fun getFavoriteMovie(): Flow<List<MovieDetail>>

    //fun setFavoriteMovie(movieDetail: MovieDetail, state: Boolean)

    //fun getFavoriteTvShow(): Flow<List<TvShowDetail>>

    //fun setFavoriteTvShow(tvShowDetail: TvShowDetail, state: Boolean)

}