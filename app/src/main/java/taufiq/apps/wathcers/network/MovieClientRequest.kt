package taufiq.apps.wathcers.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import taufiq.apps.wathcers.data.PopularMovieResult
import taufiq.apps.wathcers.data.PopularTvShowResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieClientRequest {

    @GET("movie/popular")
    suspend fun getAllPopularMovies(@Query("api_key") key: String): Response<PopularMovieResult>

    @GET("tv/popular")
    suspend fun getAllPopularTvShow(@Query("api_key") key: String): Response<PopularTvShowResponse>

//    @GET("movie/now_playing")
//    suspend fun getNowPlayingMovies(@Query("api_key") apiKey: String): Response<NowPlayingResponse>

}