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
import taufiq.apps.wathcers.databinding.FragmentTvBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.TvViewModel

/**
 * Created By Taufiq on 4/15/2021.
 *
 */
class TvFragment : Fragment() {
    lateinit var binding: FragmentTvBinding
    private val viewmodel by viewModels<TvViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = viewmodel.allPopularTvShow
        val adapter = MovieAdapter(data) { tvId ->
            startActivity(Intent(requireContext(), DetailTvActivity::class.java).also {
                it.putExtra(Constant.TV_KEY,tvId)
            })
        }
        binding.rvTvShow.adapter = adapter
        binding.rvTvShow.layoutManager = GridLayoutManager(requireContext(),2)
    }

}