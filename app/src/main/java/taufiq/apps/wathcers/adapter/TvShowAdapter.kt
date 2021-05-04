package taufiq.apps.wathcers.adapter

import coil.load
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.databinding.MovieItemRowBinding
import taufiq.apps.wathcers.utils.BaseAdapter
import taufiq.apps.wathcers.utils.Constant

/**
 * Created By Taufiq on 4/16/2021.
 *
 */
class TvShowAdapter : BaseAdapter<TvShowResult>(R.layout.movie_item_row) {
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val tvShow = data[position]
        val binding = MovieItemRowBinding.bind(holder.itemView)
        with(binding) {
            ivPoster.load(Constant.IMAGE_PATH + tvShow.posterPath)
            this.root.setOnClickListener { itemClickListener?.invoke(tvShow) }
        }

    }
}