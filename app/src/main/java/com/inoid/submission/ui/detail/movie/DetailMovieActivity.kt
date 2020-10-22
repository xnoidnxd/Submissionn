package com.inoid.submission.ui.detail.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.inoid.submission.BuildConfig
import com.inoid.submission.MyApplication
import com.inoid.submission.R
import com.inoid.submission.core.BuildConfig.POSTER_PATH
import com.inoid.submission.core.data.Resource
import com.inoid.submission.core.data.source.local.entity.MovieDetailEntity
import com.inoid.submission.core.domain.model.MovieDetail
import com.inoid.submission.ui.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_movie.*
import java.lang.String.format
import javax.inject.Inject

class DetailMovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: DetailMovieViewModel by viewModels {
        factory
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        (application as MyApplication).appComponent.inject(this)

        val movieId = intent.getIntExtra(EXTRA_DATA, 0)
        viewModel.setSelectedMovie(movieId)
//        viewModel.movie.observe(this, Observer { detailMovie ->

        viewModel.movie.observe(this, Observer { movie->
            if (movie != null) {
                when (movie) {
                    is Resource.Success -> {
                        movie.data?.let { populateDetailMovie(it) }
//                        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Error -> {
                        Toast.makeText(this@DetailMovieActivity, "error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

    }

    private fun populateDetailMovie(movie: MovieDetail?) {
        if (movie != null) {
            tv_detail_movie_item_title.text = movie.title
//            tv_detail_movie_description.text = movie.overview
//            tv_detail_movie_language.text = movie.originalLanguage
//            tv_detail_movie_rating.text = movie.voteAverage.toString()
//            tv_detail_movie_date.text = format("Released: ${movie.releaseDate}")
//            tv_detail_movie_duration.text = movie.runtime.toString()
//
//            Glide.with(applicationContext)
//                .load("${POSTER_PATH}${movie.posterPath}")
//                .into(detail_movie_image_poster)
        }


    }
}