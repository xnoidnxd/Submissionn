package com.inoid.submission.ui.movie.airing

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.inoid.submission.MyApplication
import com.inoid.submission.R
import com.inoid.submission.core.data.Resource
import com.inoid.submission.ui.movie.MovieAdapter
import com.inoid.submission.ui.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_airing.*
import javax.inject.Inject

class MovieAiringFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MovieAiringViewModel by viewModels {
        factory
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_airing, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAdapter()

            viewModel.movie.observe(viewLifecycleOwner, Observer { movie ->
                if (movie != null) {
                when (movie) {
                    is Resource.Success -> {
                        movieAdapter.setMovie(movie.data)
                    }
                }
            }
            })

            with(rv_movie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }

        /*
        *         if (activity != null) {

            val tourismAdapter = TourismAdapter()
            tourismAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTourismActivity::class.java)
                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }



            homeViewModel.tourism.observe(viewLifecycleOwner, Observer { tourism ->
                if (tourism != null) {
                    when (tourism) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            tourismAdapter.setData(tourism.data)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            view_error.visibility = View.VISIBLE
                            tv_error.text = tourism.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(rv_tourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tourismAdapter
            }*/

    }
}