package taufiq.apps.wathcers.repo

import retrofit2.Response
import taufiq.apps.wathcers.data.PopularMovieResult
import taufiq.apps.wathcers.data.PopularTvShowResponse
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse
import taufiq.apps.wathcers.network.MovieClientRequest
import javax.inject.Inject

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
class MovieRepositoryImpl @Inject constructor(private val service: MovieClientRequest) :
    MovieRepository {
    override suspend fun getPopularMovies(key: String): Response<PopularMovieResult> {
        return service.getAllPopularMovies(key)
    }

    override suspend fun getTvShow(key: String): Response<PopularTvShowResponse> {
        return service.getAllPopularTvShow(key)
    }

    override suspend fun getDetailMovie(id: Int, key: String): Response<DetailMovieResponse> =
        service.getMoviesDetail(id, key)

    override suspend fun getDetailTv(id: Int, key: String): Response<DetailTvResponse> =
        service.getTvDetail(id, key)

//    override suspend fun getNowPlaying(key: String): Response<NowPlayingResponse> {
//        return service.getNowPlayingMovies(key)
//    }
}