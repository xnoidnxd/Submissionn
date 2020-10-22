package com.inoid.submission.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.inoid.submission.core.domain.usecase.MovieUseCase
import javax.inject.Inject

class DetailTvShowViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel() {

    private var currentId: Int? = 0

    fun setSelectedTvShow(tvShowId: Int) {
        this.currentId = tvShowId
    }
    /*
    *    var movie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(currentId) {
        mMovieId -> repository.getDetailMovieDataById(mMovieId)
    }*/

    val movie = movieUseCase.getTvShowDetail(currentId!!).asLiveData()

}