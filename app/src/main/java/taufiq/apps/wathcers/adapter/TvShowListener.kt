package taufiq.apps.wathcers.adapter

import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity

/**
 * Created By Taufiq on 5/10/2021.
 *
 */
interface TvShowListener {
        fun onItemClicked(data: TvShowEntity)
}