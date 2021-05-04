package taufiq.apps.wathcers.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import taufiq.apps.wathcers.data.MovieResult
import taufiq.apps.wathcers.data.TvShowResult
import taufiq.apps.wathcers.repo.MovieRepositoryImpl
import taufiq.apps.wathcers.viewmodel.sample.SampleData

/**
 * Created By Taufiq on 4/17/2021.
 */
class TvViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private var tvViewModels: TvViewModel? = null
    private var data = Mockito.mock(MovieRepositoryImpl::class.java)

    @Before
    fun setUp() {
        tvViewModels = TvViewModel(data)
    }

    @Test
    fun `get all tv show list and verify is not null`() {
        val tvs = MutableLiveData<List<TvShowResult>>()
        tvs.value = SampleData.getSampleOfTvList()
        `when`(data.getTvShow()).thenReturn(tvs)
        val observer = Mockito.mock(Observer::class.java)
        tvViewModels?.getTvShows()?.observeForever(observer as Observer<List<TvShowResult>>)
        verify(data).getTvShow()
    }

}