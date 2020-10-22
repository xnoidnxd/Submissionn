package com.inoid.submission.core.data

import com.inoid.submission.core.data.source.local.LocalDataSource
import com.inoid.submission.core.data.source.remote.RemoteDataSource
import com.inoid.submission.core.data.source.remote.network.ApiResponse
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import com.inoid.submission.core.domain.model.MovieAiring
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.core.domain.model.TvShowAiring
import com.inoid.submission.core.domain.model.TvShowDetail
import com.inoid.submission.core.domain.repository.IMovieRepository
import com.inoid.submission.core.utils.AppExecutors
import com.inoid.submission.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                          private val localDataSource: LocalDataSource,
                                          private val appExecutors: AppExecutors): IMovieRepository {

    override fun getAllMovie(): Flow<Resource<List<MovieAiring>>> =
        object : NetworkBoundResource<List<MovieAiring>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<MovieAiring>> =
                localDataSource.getAllAiringMovie().map { DataMapper.mapMAEntitiesToDomain(it) }

            override fun shouldFetch(data: List<MovieAiring>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAiringMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapMAResponseToEntities(data)
                localDataSource.insertAiringMovie(movieList)
            }
        }.asFlow()



    override fun getAllTvShow(): Flow<Resource<List<TvShowAiring>>> =
        object : NetworkBoundResource<List<TvShowAiring>, List<TvShowResponse>>() {
            override fun loadFromDB(): Flow<List<TvShowAiring>> =
                localDataSource.getAllAiringTvShow().map { DataMapper.mapTAEntitiesToDomain(it) }

            override fun shouldFetch(data: List<TvShowAiring>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAiringTvShow()

            override suspend fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = DataMapper.mapTAResponseToEntities(data)
                localDataSource.insertAiringTvShow(tvShowList)
            }

        }.asFlow()


    override fun getMovieDetail(movieId: Int): Flow<Resource<MovieDetail>> =
        object : NetworkBoundResource<MovieDetail, MovieResponse>() {
            override fun loadFromDB(): Flow<MovieDetail> =
                localDataSource.getMovieById(movieId).map { DataMapper.mapMDEntitiesToDomain1(it) }

            override fun shouldFetch(data: MovieDetail?): Boolean =
                data == null

            override suspend fun createCall(): Flow<ApiResponse<MovieResponse>> =
                remoteDataSource.getMovieDetail(movieId)

            override suspend fun saveCallResult(data: MovieResponse) {
                val movieList = DataMapper.mapMDResponseToEntities1(data)
                localDataSource.insertDetailMovie(movieList)
            }

        }.asFlow()

//    override fun getMovieDetail1(movieId: Int): Flow<Resource<List<MovieDetail>>> =
//        object : NetworkBoundResource<List<MovieDetail>, MovieResponse>() {
//            override fun loadFromDB(): Flow<List<MovieDetail>> =
//                localDataSource.getMovieById(movieId).map { DataMapper.mapMDEntitiesToDomain(it) }
//
//            override fun shouldFetch(data: List<MovieDetail>?): Boolean =
//                data == null
//
//            override suspend fun createCall(): Flow<ApiResponse<MovieResponse>> =
//                remoteDataSource.getMovieDetail(movieId)
//
//            override suspend fun saveCallResult(data: MovieResponse) {
//                val movieList = DataMapper.mapMDResponseToEntities1(data)
//                localDataSource.insertDetailMovie(movieList)
//            }
//
//        }.asFlow()



    override fun getTvShowDetail(tvShowId: Int): Flow<Resource<TvShowDetail>> =
        object : NetworkBoundResource<TvShowDetail, TvShowResponse>() {
            override fun loadFromDB(): Flow<TvShowDetail> =
                localDataSource.getTvShowById(tvShowId).map { DataMapper.mapTDEntitiesToDomain1(it) }

            override fun shouldFetch(data: TvShowDetail?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<TvShowResponse>> =
                remoteDataSource.getTvShowDetail(tvShowId)

            override suspend fun saveCallResult(data: TvShowResponse) {
                val tvShow = DataMapper.mapTDResponseToEntities1(data)
                localDataSource.insertDetailTvShow(tvShow)
            }
        }.asFlow()


//    override fun getFavoriteMovie(): Flow<List<MovieDetail>> =
//        localDataSource.getFavoriteMovie().map { DataMapper.mapMDEntitiesToDomain(it) }
//
//    override fun setFavoriteMovie(movieDetail: MovieDetail, state: Boolean) {
//        val movieAiringEntity = DataMapper.mapMDDomainToEntity(movieDetail)
//        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieAiringEntity, state) }
//    }
//
//    override fun getFavoriteTvShow(): Flow<List<TvShowDetail>> =
//        localDataSource.getFavoriteTvShow().map { DataMapper.mapTDEntitiesToDomain(it) }
//
//    override fun setFavoriteTvShow(tvShowDetail: TvShowDetail, state: Boolean) {
//        val tvShowAiringEntity = DataMapper.mapTDDomainToEntity(tvShowDetail)
//        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShowAiringEntity, state) }
//    }


    /*
    * @Singleton
class TourismRepository @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                                private val localDataSource: LocalDataSource,
                                                private val appExecutors: AppExecutors): ITourismRepository {*/
}