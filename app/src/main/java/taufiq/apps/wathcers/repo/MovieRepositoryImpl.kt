package taufiq.apps.wathcers.repo

import retrofit2.Response
import taufiq.apps.wathcers.data.response.movies.PopularMovieReponse
import taufiq.apps.wathcers.data.response.movies.tvs.PopularTvShowResponse
import taufiq.apps.wathcers.network.MovieClientRequest
import javax.inject.Inject

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
class MovieRepositoryImpl @Inject constructor(private val service: MovieClientRequest) :
    MovieRepository {
    override suspend fun getPopularMovies(key: String): Response<PopularMovieReponse> {
        return service.getAllPopularMovies(key)
    }

    override suspend fun getTvShow(key: String): Response<PopularTvShowResponse> {
        return service.getAllPopularTvShow(key)
    }
}