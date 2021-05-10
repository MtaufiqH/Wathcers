package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
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
import taufiq.apps.wathcers.repo.TmdbRepository
import taufiq.apps.wathcers.vo.Resources

/**
 * Created By Taufiq on 5/3/2021.
 */
@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private var movieViewModel: MoviesViewModel? = null

    @Mock
    private lateinit var movieObserver: Observer<Resources<PagedList<MovieEntity>>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Before
    fun setUp() {
        movieViewModel = MoviesViewModel(tmdbRepository)
    }

    @Test
    fun `verify movie popular movie list`() {
        val sampleMovie = Resources.success(moviePagedList)
        `when`(sampleMovie.data?.size).thenReturn(5)
        val movie = MutableLiveData<Resources<PagedList<MovieEntity>>>()
        movie.value = sampleMovie

        `when`(tmdbRepository.getPopularMovies()).thenReturn(movie)
        val movieEntity = movieViewModel?.getMovies()?.value?.data
        verify(tmdbRepository).getPopularMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        movieViewModel?.getMovies()?.observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(sampleMovie)
    }

}
