package taufiq.apps.wathcers.adapter

import coil.load
import taufiq.apps.wathcers.R
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.databinding.MovieItemRowBinding
import taufiq.apps.wathcers.utils.BaseAdapter

/**
 * Created By Taufiq on 4/16/2021.
 *
 */
class MovieAdapter : BaseAdapter<DataModel>(R.layout.movie_item_row) {
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val dataModel = data[position]
        val binding = MovieItemRowBinding.bind(holder.itemView)
        with(binding) {
            ivPoster.load(dataModel.image)
            this.root.setOnClickListener { itemClickListener?.invoke(dataModel) }
        }

    }
}