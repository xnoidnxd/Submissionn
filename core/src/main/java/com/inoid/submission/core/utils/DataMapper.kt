package com.inoid.submission.core.utils

import com.inoid.submission.core.data.source.local.entity.MovieAiringEntity
import com.inoid.submission.core.data.source.local.entity.MovieDetailEntity
import com.inoid.submission.core.data.source.local.entity.TvShowAiringEntity
import com.inoid.submission.core.data.source.local.entity.TvShowDetailEntity
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.core.domain.model.MovieAiring
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.model.TvShowAiring
import com.inoid.submission.core.domain.model.TvShowDetail

object DataMapper {

    // MovieAiring
    fun mapMAResponseToEntities(input: List<MovieResponse>): List<MovieAiringEntity> {

        val movieAiringList = ArrayList<MovieAiringEntity>()

        input.map {
            val movie = MovieAiringEntity(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview
            )
            movieAiringList.add(movie)
        }
        return movieAiringList
    }

    fun mapMAEntitiesToDomain(input: List<MovieAiringEntity>): List<MovieAiring> =
        input.map {
            MovieAiring(
                id = it.id,
                posterPath = it.posterPath,
                originalLanguage = it.originalLanguage,
                title = it.title,
                voteAverage = it.voteAverage,
                overview = it.overview
            )
        }

    fun mapMADomainToEntity(input: MovieAiring) = MovieAiringEntity(
        id = input.id,
        posterPath = input.posterPath,
        originalLanguage = input.originalLanguage,
        title = input.title,
        voteAverage = input.voteAverage,
        overview = input.overview
    )


    // TvShowAiring
    fun mapTAResponseToEntities(input: List<TvShowResponse>): List<TvShowAiringEntity> {

        val tvShowAiringList = ArrayList<TvShowAiringEntity>()

        input.map {
            val tvShow = TvShowAiringEntity(
                id = it.id,
                name = it.name,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath
            )
            tvShowAiringList.add(tvShow)
        }
        return tvShowAiringList
    }

    fun mapTAEntitiesToDomain(input: List<TvShowAiringEntity>): List<TvShowAiring> =
        input.map {
            TvShowAiring(
                id = it.id,
                name = it.name,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath
            )
        }

    fun mapTADomainToEntity(input: TvShowAiring) = TvShowAiringEntity(
        id = input.id,
        name = input.name,
        originalLanguage = input.originalLanguage,
        voteAverage = input.voteAverage,
        overview = input.overview,
        posterPath = input.posterPath
    )




    // MovieDetail
//    fun mapMDResponseToEntities(input: List<MovieResponse>): List<MovieDetailEntity> {
//
//        val movieDetailList = ArrayList<MovieDetailEntity>()
//
//        input.map {
//            val movie = MovieDetailEntity(
//                id = it.id,
//                runtime = it.runtime,
//                posterPath = it.posterPath,
//                originalLanguage = it.originalLanguage,
//                title = it.title,
//                voteAverage = it.voteAverage,
//                overview = it.overview,
//                releaseDate = it.releaseDate,
//                isFavorite = false
//            )
//            movieDetailList.add(movie)
//        }
//        return movieDetailList
//    }




//    fun mapMDEntitiesToDomain(input: List<MovieDetailEntity>): List<MovieDetail> =
//        input.map {
//            MovieDetail(
//                id = it.id,
//                runtime = it.runtime,
//                posterPath = it.posterPath,
//                originalLanguage = it.originalLanguage,
//                title = it.title,
//                voteAverage = it.voteAverage,
//                overview = it.overview,
//                releaseDate = it.releaseDate,
//                isFavorite = it.isFavorite
//            )
//        }

//    fun mapMDDomainToEntity(input: MovieDetail) = MovieDetailEntity(
//        id = input.id,
//        runtime = input.runtime,
//        posterPath = input.posterPath,
//        originalLanguage = input.originalLanguage,
//        title = input.title,
//        voteAverage = input.voteAverage,
//        overview = input.overview,
//        releaseDate = input.releaseDate,
//        isFavorite = input.isFavorite
//    )




    // TvShowDetail
    fun mapTDResponseToEntities(input: List<TvShowResponse>): List<TvShowDetailEntity> {

        val tvShowDetailList = ArrayList<TvShowDetailEntity>()

        input.map {
            val tvShow = TvShowDetailEntity(
                id = it.id,
                lastAirDate = it.lastAirDate,
                name = it.name,
                popularity = it.popularity,
                firstAirDate = it.firstAirDate,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath,
                isFavorite = false
            )
            tvShowDetailList.add(tvShow)
        }
        return tvShowDetailList
    }

    fun mapTDEntitiesToDomain(input: List<TvShowDetailEntity>): List<TvShowDetail> =
        input.map {
            TvShowDetail(
                id = it.id,
                lastAirDate = it.lastAirDate,
                name = it.name,
                popularity = it.popularity,
                firstAirDate = it.firstAirDate,
                originalLanguage = it.originalLanguage,
                voteAverage = it.voteAverage,
                overview = it.overview,
                posterPath = it.posterPath,
                isFavorite = it.isFavorite
            )
        }

    fun mapTDDomainToEntity(input: TvShowDetail) = TvShowDetailEntity(
        id = input.id,
        lastAirDate = input.lastAirDate,
        name = input.name,
        popularity = input.popularity,
        firstAirDate = input.firstAirDate,
        originalLanguage = input.originalLanguage,
        voteAverage = input.voteAverage,
        overview = input.overview,
        posterPath = input.posterPath,
        isFavorite = input.isFavorite
    )









    // MD TRY
    fun mapMDResponseToEntities1(input: MovieResponse) =
        MovieDetailEntity(
            id = input.id,
//            runtime = input.runtime,
//            posterPath = input.posterPath,
//            originalLanguage = input.originalLanguage,
            title = input.title
//            voteAverage = input.voteAverage,
//            overview = input.overview,
//            releaseDate = input.releaseDate,
//            isFavorite = false
        )


    fun mapMDEntitiesToDomain1(input: MovieDetailEntity?) =
        MovieDetail(
            id = input?.id,
//            runtime = input.runtime,
//            posterPath = input.posterPath,
//            originalLanguage = input.originalLanguage,
            title = input?.title
//            voteAverage = input.voteAverage,
//            overview = input.overview,
//            releaseDate = input.releaseDate,
//            isFavorite = input.isFavorite
        )

//        input.map {
//            MovieDetail(
//                id = it.id,
//                runtime = it.runtime,
//                posterPath = it.posterPath,
//                originalLanguage = it.originalLanguage,
//                title = it.title,
//                voteAverage = it.voteAverage,
//                overview = it.overview,
//                releaseDate = it.releaseDate,
//                isFavorite = it.isFavorite
//            )
//        }







    // TD TRY

    fun mapTDResponseToEntities1(input: TvShowResponse): TvShowDetailEntity =
        TvShowDetailEntity(
            id = input.id,
            lastAirDate = input.lastAirDate,
            name = input.name,
            popularity = input.popularity,
            firstAirDate = input.firstAirDate,
            originalLanguage = input.originalLanguage,
            voteAverage = input.voteAverage,
            overview = input.overview,
            posterPath = input.posterPath,
            isFavorite = false
            )

    fun mapTDEntitiesToDomain1(input: TvShowDetailEntity) =
        TvShowDetail(
            id = input.id,
            lastAirDate = input.lastAirDate,
            name = input.name,
            popularity = input.popularity,
            firstAirDate = input.firstAirDate,
            originalLanguage = input.originalLanguage,
            voteAverage = input.voteAverage,
            overview = input.overview,
            posterPath = input.posterPath,
            isFavorite = input.isFavorite
        )


    fun mapTDDomainToEntity1(input: TvShowDetail) = TvShowDetailEntity(
        id = input.id,
        lastAirDate = input.lastAirDate,
        name = input.name,
        popularity = input.popularity,
        firstAirDate = input.firstAirDate,
        originalLanguage = input.originalLanguage,
        voteAverage = input.voteAverage,
        overview = input.overview,
        posterPath = input.posterPath,
        isFavorite = input.isFavorite
    )

}