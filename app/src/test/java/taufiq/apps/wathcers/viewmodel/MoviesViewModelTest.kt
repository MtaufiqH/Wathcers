package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.utils.Constant

/**
 * Created By Taufiq on 5/3/2021.
 */
class MoviesViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var movieViewModel: MoviesViewModel

    @Before
    fun setUp() {
        movieViewModel = MoviesViewModel(Mockito.mock(MovieRepositoryImpl::class.java))
    }


}
