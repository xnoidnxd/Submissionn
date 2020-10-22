package com.inoid.submission.ui.di

import com.inoid.submission.core.di.CoreComponent
import com.inoid.submission.ui.detail.movie.DetailMovieActivity
import com.inoid.submission.ui.detail.tvshow.DetailTvShowActivity
import com.inoid.submission.ui.movie.airing.MovieAiringFragment
import com.inoid.submission.ui.tvshow.airing.TvShowAiringFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: MovieAiringFragment)
    fun inject(fragment: TvShowAiringFragment)
    fun inject(activity: DetailMovieActivity)
    fun inject(activity: DetailTvShowActivity)
}
/*
* @AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)*/