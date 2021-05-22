package taufiq.apps.wathcers.repo

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.network.TmdbResponse
import taufiq.apps.wathcers.vo.Resources
import javax.inject.Inject

/**
 * Created By Taufiq on 5/7/2021.
 *
 */
class TmdbRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataSource {
    override fun getPopularMovies(): LiveData<Resources<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResult>>() {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()

                return LivePagedListBuilder(localDataSource.getListMovies(), config).build()
            }

            override fun createCall(): LiveData<TmdbResponse<List<MovieResult>>> =
                remoteDataSource.getPopularMovies()

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()


            override fun saveCallResult(body: List<MovieResult>) {
                val movieList = ArrayList<MovieEntity>()
                for (item in body) {
                    val movie = MovieEntity(
                        null,
                        item.id,
                        item.title,
                        item.overview,
                        item.posterPath,
                        item.backdropPath,
                        item.voteAverage,
                        item.releaseDate,false
                    )

                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }


    override fun getListFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getListFavoriteMovies(), config).build()
    }

    override fun getMovieDetail(movieId: Int): LiveData<MovieEntity> =
        localDataSource.getDetailMovie(movieId)


    override fun getTvShow(): LiveData<Resources<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResult>>() {

            override fun saveCallResult(body: List<TvShowResult>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (item in body) {
                    val tvShows = TvShowEntity(
                        null,
                        item.id,
                        item.name,
                        item.overview,
                        item.posterPath,
                        item.backdropPath,
                        item.voteAverage,
                        item.firstAirDate,false
                    )
                    tvShowList.add(tvShows)
                }

                localDataSource.insertTvShows(tvShowList)
            }

            override fun createCall(): LiveData<TmdbResponse<List<TvShowResult>>> =
                remoteDataSource.getTvShow()

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListTvShows(), config).build()
            }

        }.asLiveData()
    }


    override fun getListFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getListFavoriteTvShows(), config).build()
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowEntity> =
        localDataSource.getDetailTvShow(tvShowId)

    override fun setFavoriteMovie(movie: MovieEntity) {
        CoroutineScope(IO).launch {
            localDataSource.setFavoriteMovie(movie)
        }
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity) {
        CoroutineScope(IO).launch {
            localDataSource.setFavoriteTvShow(tvShow)
        }
    }

}

