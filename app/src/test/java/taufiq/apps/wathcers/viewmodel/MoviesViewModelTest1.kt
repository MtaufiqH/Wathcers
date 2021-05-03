package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.utils.Constant
import taufiq.apps.wathcers.utils.observeOnce

/**
 * Created By Taufiq on 5/3/2021.
 */
class MoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var movieViewModel : MoviesViewModel

    @Before
    fun setUp() {
        movieViewModel = MoviesViewModel(Mockito.mock(MovieRepositoryImpl::class.java))
    }

    @Test
    fun `testing if movies is exist`() = runBlocking {
        launch {
            movieViewModel.getMovies(Constant.TMBD_API_KEY)
        }
         movieViewModel.movieData.observeOnce { assertNotEquals(0,it.size) }

         }
    }
