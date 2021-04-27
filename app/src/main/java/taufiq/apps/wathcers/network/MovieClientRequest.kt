package taufiq.apps.wathcers.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import taufiq.apps.wathcers.data.response.movies.PopularMovieReponse
import taufiq.apps.wathcers.data.response.movies.tvs.PopularTvShowResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieClientRequest {

    @GET("movie/popular")
    suspend fun getAllPopularMovies(@Query("api_key") key: String): Response<PopularMovieReponse>

    @GET("tv/popular")
    suspend fun getAllPopularTvShow(@Query("api_key") key: String) : Response<PopularTvShowResponse>

}