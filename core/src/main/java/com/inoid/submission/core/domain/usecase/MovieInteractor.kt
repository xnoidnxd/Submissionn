package com.inoid.submission.core.domain.usecase

import com.inoid.submission.core.data.Resource
import com.inoid.submission.core.domain.model.MovieAiring
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.model.TvShowAiring
import com.inoid.submission.core.domain.model.TvShowDetail
import com.inoid.submission.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovie() = movieRepository.getAllMovie()

    override fun getAllTvShow() = movieRepository.getAllTvShow()

    override fun getMovieDetail(movieId: Int) = movieRepository.getMovieDetail(movieId)

    override fun getTvShowDetail(tvShowId: Int) = movieRepository.getTvShowDetail(tvShowId)

    //override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    //override fun setFavoriteMovie(movieDetail: MovieDetail, state: Boolean) = movieRepository.setFavoriteMovie(movieDetail, state)

    //override fun getFavoriteTvShow() = movieRepository.getFavoriteTvShow()

    //override fun setFavoriteTvShow(tvShowDetail: TvShowDetail, state: Boolean) = movieRepository.setFavoriteTvShow(tvShowDetail, state)


    /*
    * class TourismInteractor(private val tourismRepository: ITourismRepository): TourismUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)
}*/
}