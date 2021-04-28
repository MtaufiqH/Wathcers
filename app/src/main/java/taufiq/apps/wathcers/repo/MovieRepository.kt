package taufiq.apps.wathcers.repo

import retrofit2.Response
import taufiq.apps.wathcers.data.PopularMovieResult
import taufiq.apps.wathcers.data.PopularTvShowResponse

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
interface MovieRepository {
    suspend fun getPopularMovies(key: String): Response<PopularMovieResult>
    suspend fun getTvShow(key: String): Response<PopularTvShowResponse>
//    suspend fun getNowPlaying(key: String)  : Response <NowPlayingResponse>
}