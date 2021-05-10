package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import taufiq.apps.wathcers.data.db.movie.MovieEntity
import taufiq.apps.wathcers.data.db.tv.TvShowEntity
import taufiq.apps.wathcers.repo.TmdbRepository

/**
 * Created By Taufiq on 5/11/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var favViewModel: FavoriteViewModel

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var observerTvShow: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setup() {
        favViewModel = FavoriteViewModel(tmdbRepository)
    }

    @Test
    fun getListFavoriteMovie() {
        val sampleMovie = moviePagedList
        `when`(sampleMovie.size).thenReturn(5)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = sampleMovie
        `when`(tmdbRepository.getListFavoriteMovies()).thenReturn(movie)
        val movieEntity = favViewModel.getMovieFavorite().value
        Mockito.verify(tmdbRepository).getListFavoriteMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)
        favViewModel.getMovieFavorite().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(sampleMovie)

    }

    @Test
    fun getListFavoriteTvShow() {
        val sampleTvShow = tvShowPagedList
        `when`(sampleTvShow.size).thenReturn(5)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = sampleTvShow
        `when`(tmdbRepository.getListFavoriteTvShows()).thenReturn(tvShow)
        val tvShowEntity = favViewModel.getTvFavorite().value
        Mockito.verify(tmdbRepository).getListFavoriteTvShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)
        favViewModel.getTvFavorite().observeForever(observerTvShow)
        Mockito.verify(observerTvShow).onChanged(sampleTvShow)
    }

}