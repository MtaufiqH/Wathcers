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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

    }

    private fun bindData(data: DataModel) {
        binding.apply {

        }
    }

    companion object {
        const val TV_KEY_EXTRA = "TV_KEY_EXTRA"
    }
}