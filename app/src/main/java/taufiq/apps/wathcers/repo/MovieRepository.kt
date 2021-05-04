package taufiq.apps.wathcers.repo

import androidx.lifecycle.LiveData
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieRepository {
    fun getPopularMovies(): LiveData<List<MovieResult>>
    fun getTvShow(): LiveData<List<TvShowResult>>
    fun getDetailMovie(id: Int): LiveData<DetailMovieResponse>
    fun getDetailTv(id: Int): LiveData<DetailTvResponse>
}