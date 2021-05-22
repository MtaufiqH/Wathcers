package taufiq.apps.wathcers.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers.IO
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse
import taufiq.apps.wathcers.network.MovieClientRequest
import taufiq.apps.wathcers.network.TmdbResponse
import taufiq.apps.wathcers.utils.Constant.Companion.TMBD_API_KEY
import taufiq.apps.wathcers.utils.EspressoIdlingResource
import javax.inject.Inject

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
class RemoteDataSource @Inject constructor(
    private val service: MovieClientRequest,
) {

    fun getPopularMovies(): LiveData<TmdbResponse<List<MovieResult>>> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getAllPopularMovies(TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(TmdbResponse.success(response.body()!!.results))
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getDetailMovie(id: Int): LiveData<TmdbResponse<DetailMovieResponse>> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getMoviesDetail(id, TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(TmdbResponse.success(response.body()!!))
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getTvShow(): LiveData<TmdbResponse<List<TvShowResult>>> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getAllPopularTvShow(TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(TmdbResponse.success(response.body()!!.results))
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        }
    }

    fun getDetailTv(id: Int): LiveData<TmdbResponse<DetailTvResponse>> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getTvDetail(id, TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(TmdbResponse.success(response.body()!!))
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        }
    }
}
