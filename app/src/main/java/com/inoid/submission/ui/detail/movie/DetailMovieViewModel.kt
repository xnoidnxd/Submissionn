package com.inoid.submission.ui.detail.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bumptech.glide.load.engine.Resource
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(movieUseCase: MovieUseCase): ViewModel() {
//class DetailTourismViewModel @Inject constructor(private val tourismUseCase: TourismUseCase) : ViewModel()
    val currentId= MutableStateFlow<Int>(0)

//    fun setSelectedMovie(movieId: Int) {
//        currentId.value = movieId
//    }

    private val _id = MutableStateFlow(0)

    val id: StateFlow<Int> = _id

    fun setSelectedMovie(movieId: Int) {
        this._id.value = movieId
    }

/*
*  private val _countState = MutableStateFlow(0)

    val countState: StateFlow<Int> = _countState
* */
//    private var currentId: Int? = 0
//
//    fun setSelectedMovie(movieId: Int) {
//        this.currentId = movieId
//        currentId = movieId
//    }
    /*
    *    var movie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(currentId) {
        mMovieId -> repository.getDetailMovieDataById(mMovieId)
    }*/

    var movie = movieUseCase.getMovieDetail(337401).asLiveData()



}