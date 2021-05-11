package taufiq.apps.wathcers.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.adapter.MovieAdapters
import taufiq.apps.wathcers.adapter.MovieListener
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.databinding.FragmentMoviesBinding
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.viewmodel.MoviesViewModel
import taufiq.apps.wathcers.vo.Status

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@AndroidEntryPoint
class MoviesFragment : BaseFragment(), MovieListener {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel by viewModels<MoviesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvMovies.adapter = MovieAdapters(this)
        binding.rvMovies.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun observableInit() {
        viewModel.getMovies().observe(viewLifecycleOwner) { movies ->
            if (movies != null) {
                when (movies.status) {
                    Status.LOADING -> {
                        binding.pbMovies.visibility = View.VISIBLE
                    }
                    Status.SUCCESS -> {
                        binding.pbMovies.visibility = View.GONE
                        binding.rvMovies.adapter?.let { adapter ->
                            when (adapter) {
                                is MovieAdapters -> {
                                    adapter.submitList(movies.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }

                    }
                    Status.ERROR -> {
                        binding.pbMovies.visibility = View.GONE
                        Toast.makeText(
                            requireContext(),
                            getString(R.string.check_internet),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: MovieEntity) {
        startActivity(Intent(context, DetailMoviesActivity::class.java).also {
            it.putExtra(DetailMoviesActivity.MOVIE_KEY_EXTRA, data.movieId)
        })
    }
}
