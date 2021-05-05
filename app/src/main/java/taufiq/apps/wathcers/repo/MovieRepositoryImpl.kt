package taufiq.apps.wathcers.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers.IO
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.detailmovie.DetailMovieResponse
import taufiq.apps.wathcers.data.detailtv.DetailTvResponse
import taufiq.apps.wathcers.network.MovieClientRequest
import taufiq.apps.wathcers.utils.Constant.Companion.TMBD_API_KEY
import taufiq.apps.wathcers.utils.EspressoIdlingResource
import javax.inject.Inject

/**
 * Created By Taufiq on 4/27/2021.
 *
 */
class MovieRepositoryImpl @Inject constructor(
    private val service: MovieClientRequest,
) : MovieRepository {

    override fun getPopularMovies(): LiveData<List<MovieResult>> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getAllPopularMovies(TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(response.body()!!.results)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        } else
            Log.d("GET DATA MOVIE", "getPopularMovies: ${response.message()}")
    }

    override fun getDetailMovie(id: Int): LiveData<DetailMovieResponse> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getMoviesDetail(id, TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            response.body()?.let { emit(it) }

            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        } else
            Log.d("GET DETAIL MOVIE", "getDetailMovie: ${response.message()}")

    }

    override fun getTvShow(): LiveData<List<TvShowResult>> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getAllPopularTvShow(TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(response.body()!!.results)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        } else
            Log.d("GET TV SHOW DATA", "getTvShow: ${response.message()} ")
    }

    override fun getDetailTv(id: Int): LiveData<DetailTvResponse> = liveData(IO) {
        EspressoIdlingResource.increment()
        val response = service.getTvDetail(id, TMBD_API_KEY)
        if (response.isSuccessful && !response.equals(null)) {
            emit(response.body()!!)
            if (!EspressoIdlingResource.getEspressoIdlingResourceForMainActivity().isIdleNow) {
                EspressoIdlingResource.decrement()
            }
        } else
            Log.d("GET DETAIL TV", "getDetailTv: ${response.message()} ")
    }


}