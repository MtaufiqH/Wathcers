package taufiq.apps.wathcers.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.adapter.MovieAdapter
import taufiq.apps.wathcers.databinding.FragmentMoviesBinding
import taufiq.apps.wathcers.utils.BaseFragment
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.MoviesViewModel

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
@AndroidEntryPoint
class MoviesFragment : BaseFragment() {

    lateinit var binding: FragmentMoviesBinding
    private val viewModel by viewModels<MoviesViewModel>()
    private val adapter by lazy {
        MovieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvMovies.adapter = adapter
        adapter.itemClickListener = {
            startActivity(Intent(requireContext(), DetailMoviesActivity::class.java).also {
                // TODO: add PutExtra to the detail
            })
        }
    }

    override fun observableInit() {
        viewModel.getMovies(Constant.TMBD_API_KEY)
        viewModel.movieData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}
