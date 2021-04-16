package taufiq.apps.wathcers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import taufiq.apps.wathcers.data.DataModel
import taufiq.apps.wathcers.databinding.MovieItemRowBinding
import taufiq.apps.wathcers.utils.Constant.Companion.image_path

/**
 * Created By Taufiq on 4/16/2021.
 *
 */
class MovieAdapter(private val itemData: List<DataModel>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {


    inner class MovieViewHolder(val view: MovieItemRowBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(data: DataModel, listener: (Int) -> Unit) {
            view.apply {
                tvTitle.text = data.title
                tvOverview.text = data.description
                Glide.with(view.context).load(image_path + data.image).into(ivPoster)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            MovieItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(itemData[position], listener)
    }

    override fun getItemCount(): Int = itemData.size
}