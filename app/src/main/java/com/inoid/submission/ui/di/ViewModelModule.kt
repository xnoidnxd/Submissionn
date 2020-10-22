package com.inoid.submission.ui.di

import androidx.lifecycle.ViewModel
import com.inoid.submission.ui.detail.movie.DetailMovieViewModel
import com.inoid.submission.ui.detail.tvshow.DetailTvShowViewModel
import com.inoid.submission.ui.movie.airing.MovieAiringViewModel
import com.inoid.submission.ui.tvshow.airing.TvShowAiringViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieAiringViewModel::class)
    abstract fun bindMovieAiringViewModel(viewModel: MovieAiringViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvShowAiringViewModel::class)
    abstract fun bindTvShowAiringViewModel(viewModel: TvShowAiringViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    abstract fun bindDetailMovieViewModel(viewModel: DetailMovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailTvShowViewModel::class)
    abstract fun bindDetailTvShowViewModel(viewModel: DetailTvShowViewModel): ViewModel

    /*
    * @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel*/
}