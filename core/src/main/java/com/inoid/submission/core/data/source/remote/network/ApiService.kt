package com.inoid.submission.core.data.source.remote.network

import com.inoid.submission.core.data.source.remote.response.MovieResponse
import com.inoid.submission.core.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    // airing
    @GET("/3/movie/now_playing")
    suspend fun getMovies(@Query("api_key") apiKey: String ): MovieResponse

    @GET("/3/tv/airing_today")
    suspend fun getTvShows (@Query("api_key") apiKey: String): TvShowResponse


    // detail
    @GET("/3/movie/{movieId}")
    suspend fun getMovieDetail (@Path("movieId") movieId: Int,
                                @Query("api_key") apiKey: String): MovieResponse

    @GET("/3/tv/{tvShowId}")
    suspend fun getTvShowDetail (@Path("tvShowId") tvShowId: Int,
                         @Query("api_key") apiKey: String): TvShowResponse


    // Search
    @GET("/3/search/movie")
    suspend fun searchMovie (@Query("api_key") apiKey: String,
                             @Query("query") movieName: String): MovieResponse

    @GET("/3/search/tv")
    suspend fun searchTvShow (@Query("api_key") apiKey: String,
                              @Query("query") tvShowName: String): TvShowResponse
/*
*     @GET("list")
    suspend fun getList(): ListTourismResponse*/

/*    @GET("/3/movie/now_playing")
    fun getMovies(@Query("api_key") apiKey: String ) : Call<MovieResponse>

    @GET("/3/tv/airing_today")
    fun getTvShow (@Query("api_key") apiKey: String) : Call<TvShowResponse>

    @GET("/3/movie/{movieId}")
    fun getMoviesDetail (@Path("movieId") movieId: Int,
                         @Query("api_key") apiKey: String) : Call<MovieResponse>

    @GET("/3/tv/{tvShowId}")
    fun getTvShowDetail (@Path("tvShowId") tvShowId: Int,
                         @Query("api_key") apiKey: String) : Call<TvShowResponse>*/

}