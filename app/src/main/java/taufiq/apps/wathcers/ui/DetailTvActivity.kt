package taufiq.apps.wathcers.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.databinding.ActivityDetailTvBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.utils.Constant.Companion.IMAGE_PATH
import taufiq.apps.wathcers.viewmodel.TvViewModelDetail

@AndroidEntryPoint
class DetailTvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvBinding
    private val tvViewModel by viewModels<TvViewModelDetail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idTv = intent.getIntExtra(TV_KEY_EXTRA, 0)

        observeDataTv(idTv, Constant.TMBD_API_KEY)
    }

    private fun observeDataTv(id: Int, key: String) {
        tvViewModel.getTvShowDetail(id, key)
        tvViewModel.tvShowDataDetail.observe(this) { tv ->
            binding.apply {
                ivBackdropTv.load(IMAGE_PATH + tv.backdropPath)
                moviePosterTv.load(IMAGE_PATH + tv.posterPath)
                tvMovieTitleTv.text = tv.name

                val genreTv = tv.genres.map {
                    it.name
                }

                movieGenreTv.text = genreTv.joinToString()
                movieRatingTv.rating = tv.voteAverage.toFloat()
                tvMovieOverviewTv.text = tv.overview
                tvDateTv.text = getString(R.string.date_air, tv.firstAirDate, tv.lastAirDate)
                tvReleasedStatusTv.text = tv.status
                btnMoreTv.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tv.homepage))
                    startActivity(intent)
                }
            }

        }
    }


    companion object {
        const val TV_KEY_EXTRA = "TV_KEY_EXTRA"
    }
}