package taufiq.apps.wathcers.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import taufiq.apps.wathcers.adapter.MovieAdapter
import taufiq.apps.wathcers.databinding.FragmentMoviesBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.MoviesViewModel

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
class MoviesFragment : Fragment() {

    lateinit var binding: FragmentMoviesBinding

    private val viewmodel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movies = viewmodel.allMovies
        val adapter = MovieAdapter(movies) { id ->
            startActivity(Intent(requireContext(), DetailMoviesActivity::class.java).also {
                it.putExtra(Constant.MOVIE_KEY, id)
            })
        }
        binding.rvMovies.adapter = adapter
        binding.rvMovies.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}
