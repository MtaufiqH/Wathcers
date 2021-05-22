package taufiq.apps.wathcers.adapter

import taufiq.apps.wathcers.data.db.movie.MovieEntity

/**
 * Created By Taufiq on 5/10/2021.
 *
 */
interface MovieListener {
        fun onItemClicked(data: MovieEntity)
}