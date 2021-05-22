package taufiq.apps.wathcers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.databinding.MovieItemRowBinding
import taufiq.apps.wathcers.utils.Constant

/**
 * Created By Taufiq on 4/16/2021.
 *
 */
class MovieAdapters(private val listener: MovieListener) :
    PagedListAdapter<MovieEntity, MovieAdapters.ViewHolder>(
        DIFF_CALLBACK
    ) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class ViewHolder(private val binding: MovieItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MovieEntity) {
            binding.ivPoster.load("${Constant.IMAGE_PATH}${data.poster}")
            binding.cardView2.setOnClickListener {
                listener.onItemClicked(data)
            }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}