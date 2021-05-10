package taufiq.apps.wathcers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.databinding.MovieItemRowBinding
import taufiq.apps.wathcers.utils.Constant

/**
 * Created By Taufiq on 4/16/2021.
 *
 */
class TvShowAdapters(private val listener: TvShowListener) :
    PagedListAdapter<TvShowEntity, TvShowAdapters.ViewHolders>(
        DIFF_CALLBACK
    ) {

    inner class ViewHolders(private val binding: MovieItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TvShowEntity) {
            binding.ivPoster.load("${Constant.IMAGE_PATH}${data.poster}")
            binding.cardView2.setOnClickListener {
                listener.onItemClicked(data)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvId == newItem.tvId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolders, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolders {
        return ViewHolders(
            MovieItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

}