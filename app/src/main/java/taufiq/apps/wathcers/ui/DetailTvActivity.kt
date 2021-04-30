package taufiq.apps.wathcers.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import okhttp3.internal.format
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.databinding.ActivityDetailTvBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.utils.Constant.Companion.IMAGE_PATH
import taufiq.apps.wathcers.viewmodel.TvViewModelDetail
import java.text.Format

class DetailTvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvBinding
    private val tvViewModel by viewModels<TvViewModelDetail>()
    private val idTv by lazy {
        intent.getIntExtra(TV_KEY_EXTRA, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

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
                tvDateTv.text = getString(R.string.date_air,tv.firstAirDate,tv.lastAirDate)
                tvReleasedStatusTv.text = tv.status
                btnMoreTv.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = (Uri.parse(tv.homepage))
                    if (intent.data != null) {
                        Toast.makeText(
                            this@DetailTvActivity,
                            "Url not found",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else
                        startActivity(intent)
                }
            }

        }
    }


    companion object {
        const val TV_KEY_EXTRA = "TV_KEY_EXTRA"
    }
}