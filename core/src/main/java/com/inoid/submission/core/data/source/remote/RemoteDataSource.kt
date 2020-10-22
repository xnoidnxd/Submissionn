package com.inoid.submission.core.data.source.remote

import android.util.Log
import com.inoid.submission.core.BuildConfig.API_KEY
import com.inoid.submission.core.data.source.local.entity.MovieDetailEntity
import com.inoid.submission.core.data.source.remote.network.ApiResponse
import com.inoid.submission.core.data.source.remote.network.ApiService
import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    private val apiKey = API_KEY

    suspend fun getAiringMovie(): Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getMovies(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAiringTvShow(): Flow<ApiResponse<List<TvShowResponse>>> {
        return flow {
            try {
                val response = apiService.getTvShows(apiKey)
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getMovieDetail(movieId: Int): Flow<ApiResponse<MovieResponse>> {
        return flow {
            try {
                Log.d("getMovieDetail", "getMovieDetail: getMovie")
                val response = apiService.getMovieDetail(movieId, apiKey)

                if (response != null) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }

//    suspend fun getMovieDetail1(movieId: Int): Flow<ApiResponse<List<MovieResponse>>> {
//        return flow {
//            try {
//                val response = apiService.getMovieDetail(movieId, apiKey)
//                val dataArray = response
//                if (dataArray != null) {
//                    emit(ApiResponse.Success(response))
//                } else {
//                    emit(ApiResponse.Empty)
//                }
//            } catch (e: Exception) {
//                emit(ApiResponse.Error(e.toString()))
//                Log.e("RemoteDataSource", e.toString() )
//            }
//        }.flowOn(Dispatchers.IO)
//    }

    suspend fun getTvShowDetail(tvShowId: Int): Flow<ApiResponse<TvShowResponse>> {
        return flow {
            try {
                val response = apiService.getTvShowDetail(tvShowId, apiKey)
                val dataArray = response
                if (dataArray != null) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString() )
            }
        }.flowOn(Dispatchers.IO)
    }


    /*
    *
    * suspend fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }*/
}