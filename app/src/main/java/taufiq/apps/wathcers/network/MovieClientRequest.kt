package taufiq.apps.wathcers.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import taufiq.apps.wathcers.data.PopularMovieResult
import taufiq.apps.wathcers.data.PopularTvShowResponse
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieClientRequest {


    @GET("movie/popular")
    suspend fun getAllPopularMovies(@Query("api_key") key: String): Response<PopularMovieResult>


    @GET("tv/popular")
    suspend fun getAllPopularTvShow(@Query("api_key") key: String): Response<PopularTvShowResponse>

    @GET("movie/{movie_id}")
    suspend fun getMoviesDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") key: String
    ): Response<DetailMovieResponse>

    @GET("tv/{tv_id}")
    suspend fun getTvDetail(
        @Path("tv_id") tvId: Int,
        @Query("api_key") key: String
    ): Response<DetailTvResponse>
}