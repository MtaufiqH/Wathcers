package taufiq.apps.wathcers.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import taufiq.apps.wathcers.data.dummy.DataModel
import taufiq.apps.wathcers.databinding.ActivityDetailTvBinding
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.viewmodel.TvViewModel

class DetailTvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvBinding
    private val viewmodel by viewModels<TvViewModel>()
    private val tvId by lazy {
        intent.getIntExtra(Constant.TV_KEY, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
//        viewmodel.getTvById(tvId)?.let { bindData(it) }

    }

    private fun bindData(data: DataModel) {
        binding.apply {
            ivPosterDetailTv.load(data.image)
            tvMovieTitleTv.text = data.title
            tvMovieOverviewTv.text = data.description
            tvYearTv.text = data.date
            btnBookTv.setOnClickListener {
                Toast.makeText(
                    this@DetailTvActivity,
                    "Thank your for booking",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}