package taufiq.apps.wathcers.repo

import retrofit2.Response
import taufiq.apps.wathcers.data.PopularMovieResult
import taufiq.apps.wathcers.data.PopularTvShowResponse
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieRepository {
    suspend fun getPopularMovies(key: String): Response<PopularMovieResult>
    suspend fun getTvShow(key: String): Response<PopularTvShowResponse>
    suspend fun getDetailMovie(id: Int, key: String) : Response<DetailMovieResponse>
    suspend fun getDetailTv(id: Int, key: String) : Response<DetailTvResponse>
}