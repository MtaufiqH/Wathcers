package taufiq.apps.wathcers.viewmodel

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import taufiq.apps.wathcers.data.dummy.DataModel

/**
 * Created By Taufiq on 4/17/2021.
 */
//class TvViewModelTest {
//
//    private lateinit var viewModel: TvViewModel
//    private lateinit var dataTv: DataModel
//
//    @Before
//    fun init() {
//        viewModel = TvViewModel()
//        dataTv = DataModel(
//            6,
//            "Naruto",
//            "In another world, ninja are the ultimate power, and in the Village Hidden in the Leaves live the stealthiest ninja in the land. Twelve years earlier, the fearsome Nine-Tailed Fox terrorized the village and claimed many lives before it was subdued and its spirit sealed within the body of a baby boy. That boy, Naruto Uzumaki, has grown up to become a ninja-in-training who's more interested in pranks than in studying ninjutsu.. but Naruto is determined to become the greatest ninja ever!",
//            "https://image.tmdb.org/t/p/w500/vauCEnR7CiyBDzRCeElKkCaXIYu.jpg",
//            "2002"
//        )
//    }
//
//    @Test
//    fun testGetAllPopularTvShow() {
//        val tvs = viewModel.allPopularTvShow
//        val expectedTvSize = 10
//        assertNotNull(tvs)
//        assertEquals(expectedTvSize, tvs.size)
//    }
//
//    @Test
//    fun testGetTvById() {
//        val expectedId = dataTv.id
//        val expectedTitle = dataTv.title
//        val expectedDescription = dataTv.description
//        val expectedImageUrl = dataTv.image
//        val expectedDate = dataTv.date
//        assertEquals(expectedId, viewModel.getTvById(6)?.id)
//        assertEquals(expectedTitle, viewModel.getTvById(6)?.title)
//        assertEquals(expectedDescription, viewModel.getTvById(6)?.description)
//        assertEquals(expectedImageUrl, viewModel.getTvById(6)?.image)
//        assertEquals(expectedDate, viewModel.getTvById(6)?.date)
//    }
//}