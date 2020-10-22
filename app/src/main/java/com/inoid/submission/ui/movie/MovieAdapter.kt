package com.inoid.submission.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.inoid.submission.BuildConfig
import com.inoid.submission.R
import com.inoid.submission.core.BuildConfig.POSTER_PATH
import com.inoid.submission.core.domain.model.MovieAiring
import com.inoid.submission.ui.detail.movie.DetailMovieActivity
import com.inoid.submission.ui.detail.movie.DetailMovieActivity.Companion.EXTRA_DATA
import kotlinx.android.synthetic.main.items_movie.view.*

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listMovie: ArrayList<MovieAiring> = ArrayList()

    fun setMovie(listMovie: List<MovieAiring>?) {
        if (listMovie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(listMovie)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = listMovie[position]
        holder.bind(movieItem)
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieAiring) {
            with(itemView) {
                tv_item_title.text = movie.title
                tv_item_description.text = movie.overview
                tv_item_vote_average.text = movie.voteAverage.toString()
                tv_item_language.text = movie.originalLanguage

                Glide.with(itemView.context)
                    .load("${POSTER_PATH}${movie.posterPath}")
                    .into(img_poster)

                setOnClickListener {
                    val intent = Intent(context, DetailMovieActivity::class.java)
                    intent.putExtra(EXTRA_DATA, movie.id)
                    context.startActivity(intent)
                }
            }
        }
    }

}