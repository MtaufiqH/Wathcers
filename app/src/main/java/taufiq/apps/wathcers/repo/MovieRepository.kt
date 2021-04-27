package taufiq.apps.wathcers.repo

import retrofit2.Response
import taufiq.apps.wathcers.data.response.movies.PopularMovieReponse
import taufiq.apps.wathcers.data.response.movies.tvs.PopularTvShowResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieRepository {
    suspend fun getPopularMovies(key: String): Response<PopularMovieReponse>
    suspend fun getTvShow(key: String): Response<PopularTvShowResponse>
}