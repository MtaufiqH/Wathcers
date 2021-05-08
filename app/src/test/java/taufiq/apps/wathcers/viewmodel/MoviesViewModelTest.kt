package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.repo.RemoteDataSource
import taufiq.apps.wathcers.viewmodel.sample.SampleData

/**
 * Created By Taufiq on 5/3/2021.
 */
class MoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private var movieViewModel: MoviesViewModel? = null
    private var data = Mockito.mock(RemoteDataSource::class.java)

    @Before
    fun setUp() {
        movieViewModel = MoviesViewModel(data)
    }

    @Test
    fun `verify movie popular movie list`() {
        val movies = MutableLiveData<List<MovieResult>>()
        movies.value = SampleData.getSampleOfMovieList()
        `when`(data.getPopularMovies()).thenReturn(movies)
        val observer = Mockito.mock(Observer::class.java)
        movieViewModel?.getMovies()?.observeForever(observer as Observer<List<MovieResult>>)
        verify(data).getPopularMovies()
    }

}
